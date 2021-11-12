package com.algo.string.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings strs, group the anagrams together. You can return
 * the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output:[["bat"],["nat","tan"],["ate","eat","tea"]]
 * 
 * Input: strs = [""] Output: [[""]]
 * 
 * Input: strs = ["aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
 * "aaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaa"] Output:
 * [[aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa],
 * [aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa]]
 * 
 * Input: strs = ["a"] Output: [["a"]]
 * 
 * Constraints:
 * 
 * 1 <= strs.length <= 104 0 <= strs[i].length <= 100 strs[i] consists of
 * lower-case English letters.
 *
 * Complexity Analysis
 * 
 * Time Complexity: O(NK), where NNN is the length of strs, and K is
 * the maximum length of a string in strs. Counting each string is linear in the
 * size of the string, and we count every string.
 * 
 * Space Complexity: O(NK), the total information content stored in ans.
 * 
 */
public class GroupAnagrams {

	public static void main(String[] args) {
		 String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		//String[] strs = { "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" };

		System.out.println(groupAnagrams(strs));
		System.out.println(groupAnagrams2(strs));

	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43,
				47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,103 };

		HashMap<Long, List<String>> map = new HashMap<>();
		for (String s : strs) {
			long key = 1;
			for (Character c : s.toCharArray()) {
				key *= prime[c - 'a'];
			}
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}
			map.get(key).add(s);
		}
		return new ArrayList<>(map.values());
	}

	public static List<List<String>> groupAnagrams2(String[] strs) {
		if (strs == null || strs.length == 0)
			return new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			char[] ca = new char[26];
			for (char c : s.toCharArray())
				ca[c - 'a']++;
			String keyStr = String.valueOf(ca);
			if (!map.containsKey(keyStr))
				map.put(keyStr, new ArrayList<>());
			map.get(keyStr).add(s);
		}
		return new ArrayList<>(map.values());
	}
}
