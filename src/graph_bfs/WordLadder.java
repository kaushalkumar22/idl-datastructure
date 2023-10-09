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
 *A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of
 * words beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 *     Every adjacent pair of words differs by a single letter.
 *     Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 *     sk == endWord
 *
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation
 * sequence from beginWord to endWord, or 0 if no such sequence exists.
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
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
		Set<String> wordSet = new HashSet<>(wordList);// check the word in dic in O(1)
		Set<String> visited = new HashSet<>();// avoid duplicate
		Queue<String> que = new LinkedList<>();
		que.add(beginWord);
		int count=0;
		while(!que.isEmpty()){
			int size = que.size();
			for (int i=0;i<size;i++){//this for loop used to check all value at same layer
				String word = que.poll();
				if(word.equals(endWord)) {//if word is same as end word return the count +1
					return count+1;
				}
				for(int j=0;j<word.length();j++){
					for(char c ='a';c<='z';c++){
						char[] ch = word.toCharArray();
						if(ch[j]==c) continue; // if both are same char means same word
						ch[j]=c; // distinct char replace in char array
						String next = new String(ch);
						//if its in dictionary and not in visited set need to traverse for next
						if(wordSet.contains(next)&&!visited.contains(next)){
							visited.add(next);
							que.add(next);
						}
					}
				}
			}
			count++;
		}
		return 0;
	}
}

