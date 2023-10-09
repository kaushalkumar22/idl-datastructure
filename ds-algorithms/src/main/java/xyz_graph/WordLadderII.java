package xyz_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 *     Every adjacent pair of words differs by a single letter.
 *     Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 *     sk == endWord
 *
 * Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].
 *
 *
 *
 * Example 1:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
 * Explanation: There are 2 shortest transformation sequences:
 * "hit" -> "hot" -> "dot" -> "dog" -> "cog"
 * "hit" -> "hot" -> "lot" -> "log" -> "cog"
 *
 * Example 2:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: []
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 *
 *
 *
 * Constraints:
 *
 *     1 <= beginWord.length <= 5
 *     endWord.length == beginWord.length
 *     1 <= wordList.length <= 500
 *     wordList[i].length == beginWord.length
 *     beginWord, endWord, and wordList[i] consist of lowercase English letters.
 *     beginWord != endWord
 *     All the words in wordList are unique.
 *     The sum of all shortest transformation sequences does not exceed 105.
 */
public class WordLadderII {
	public static void main(String[] args) {

	}

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		Set<String> dict = new HashSet<>(wordList);
		List<List<String>> res = new ArrayList<>();
		if (!dict.contains(endWord)) {
			return res;
		}
		Map<String, List<String>> map = getChildren(beginWord, endWord, dict);
		List<String> path = new ArrayList<>();
		path.add(beginWord);
		findLadders(beginWord, endWord, map, res, path);
		return res;

	}

	public void findLadders(String beginWord, String endWord, Map<String, List<String>> map, List<List<String>> res, List<String> path) {
		if (beginWord.equals(endWord)) {
			res.add(new ArrayList<>(path));
		}
		if (!map.containsKey(beginWord)) {
			return;
		}
		for (String next : map.get(beginWord)) {
			path.add(next);
			findLadders(next, endWord, map, res, path);
			path.remove(path.size() - 1);
		}
	}

	public Map<String, List<String>> getChildren(String beginWord, String endWord, Set<String> dict) {
		Map<String, List<String>> map = new HashMap<>();
		Set<String> start = new HashSet<>();
		start.add(beginWord);
		Set<String> end = new HashSet<>();
		Set<String> visited = new HashSet<>();
		end.add(endWord);
		boolean found = false;
		boolean isBackward = false;
		while (!start.isEmpty() && !found) {
			if (start.size() > end.size()) {
				Set<String> tem = start;
				start = end;
				end = tem;
				isBackward = !isBackward;
			}
			Set<String> set = new HashSet<>();
			for (String cur : start) {
				visited.add(cur);
				for (String next : getNext(cur, dict)) {
					if (visited.contains(next) || start.contains(next)) {
						continue;
					}
					if (end.contains(next)) {
						found = true;
					}
					set.add(next);
					String parent = isBackward ? next : cur;
					String child = isBackward ? cur : next;
					if (!map.containsKey(parent)) {
						map.put(parent, new ArrayList<>());
					}
					map.get(parent).add(child);

				}
			}
			start = set;
		}
		return map;

	}
	private List<String> getNext(String cur, Set<String> dict) {
		List<String> res = new ArrayList<>();
		char[] chars = cur.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char old = chars[i];
			for (char c = 'a'; c <= 'z'; c++) {
				if (c == old) {
					continue;
				}
				chars[i] = c;
				String next = new String(chars);
				if (dict.contains(next)) {
					res.add(next);
				}
			}
			chars[i] = old;
		}
		return res;
	}
}

