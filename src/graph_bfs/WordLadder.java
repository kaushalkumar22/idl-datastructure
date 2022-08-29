package graph_bfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 *     Every adjacent pair of words differs by a single letter.
 *     Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 *     sk == endWord
 *
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 *
 *
 *
 * Example 1:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 *
 * Example 2:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 *
 *
 *
 * Constraints:
 *
 *     1 <= beginWord.length <= 10
 *     endWord.length == beginWord.length
 *     1 <= wordList.length <= 5000
 *     wordList[i].length == beginWord.length
 *     beginWord, endWord, and wordList[i] consist of lowercase English letters.
 *     beginWord != endWord
 *     All the words in wordList are unique.
 */
public class WordLadder {
	public static void main(String[] args) {
		String beginWord = "hit", endWord = "cog", words[] = {"hot","dot","dog","lot","log","cog"};
		List<String> wordList =Arrays.asList(words);
		System.out.println(ladderLength( beginWord,  endWord,  wordList));
	}
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> dictinory = new HashSet<>(wordList);
		Set<String> visit = new HashSet<>();
		Queue<String> que = new LinkedList<>();
		que.offer(beginWord);
		int res=1;
		while (!que.isEmpty()) {
			for (int i = que.size(); i > 0; i--) {
				String word = que.poll();
				if (word.equals(endWord)) {
					return res;
				}
				for (int j = 0; j < word.length(); j++) {
					char[] ch = word.toCharArray();
					for (char c = 'a'; c <= 'z'; c++) {
						if (c == ch[j]) continue;
						ch[j] = c;
						String nb = String.valueOf(ch);
						if (dictinory.contains(nb)&&!visit.contains(nb)) {
							visit.add(nb);
							que.offer(nb);
						}
					}
				}
			}
			res++;
		}
		return 0;
	}
}

