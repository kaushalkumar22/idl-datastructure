package com.algo.lds.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

Example 1:

Input:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 * @author I339640
 *
 */
public class SubstringWithConcatenatingAllWords {

	public static void main(String[] args) {
		String s = "barfoothefoobarman";
		String words[] = {"foo","bar"};
		System.out.println(findSubstring( s, words));
	}
	static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> indexes = new ArrayList<>();
		if(words.length==0 ||words[0].length()==0) {
			return indexes; 
		}
		Map<String, Integer> wcountMap = new HashMap<>();	

		int slen = s.length();
		int wcount = words.length; 
		int wlen = words[0].length();

		for (String word : words) {
			wcountMap.put(word, wcountMap.getOrDefault(word, 0) + 1);
		}
		for (int i = 0; i < slen - wcount * wlen + 1; i++) {
			Map<String, Integer> seen = new HashMap<>();
			int j = 0;
			while (j < wcount) {
				String word = s.substring(i + j * wlen, i + (j + 1) * wlen);
				if (wcountMap.containsKey(word)) {
					seen.put(word, seen.getOrDefault(word, 0) + 1);
					if (seen.get(word) > wcountMap.getOrDefault(word, 0)) {
						break;
					}
				} else {
					break;
				}
				j++;
			}
			if (j == wcount) {
				indexes.add(i);
			}
		}
		return indexes;
	}
}

