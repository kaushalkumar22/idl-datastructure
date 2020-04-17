package com.ds.miscellaneous;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that: Only one letter can be changed at a time. Each transformed word
 * must exist in the word list. Note that beginWord is not a transformed word.
 * Note: Return 0 if there is no such transformation sequence. All words have
 * the same length. All words contain only lowercase alphabetic characters. You
 * may assume no duplicates in the word list. You may assume beginWord and
 * endWord are non-empty and are not the same. Example 1: Input: beginWord =
 * "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * Output: 5
 * 
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" ->
 * "dog" -> "cog", return its length 5. Example 2: Input: beginWord = "hit"
 * endWord = "cog" wordList = ["hot","dot","dog","lot","log"]
 * 
 * Output: 0
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible
 * transformation.
 *
 */
public class WordLadder {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList), vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        for (int len = 1; !q.isEmpty(); len++) {
            for (int i = q.size(); i > 0; i--) {
                String w = q.poll();
                if (w.equals(endWord)) return len;

                for (int j = 0; j < w.length(); j++) {
                    char[] ch = w.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == w.charAt(j)) continue;
                        ch[j] = c;
                        String nb = String.valueOf(ch);
                        if (dict.contains(nb) && vis.add(nb)) q.offer(nb);
                    }
                }
            }
        }
        return 0;
    }
}
