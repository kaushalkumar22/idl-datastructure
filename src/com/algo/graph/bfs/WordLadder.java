package com.algo.graph.bfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

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

