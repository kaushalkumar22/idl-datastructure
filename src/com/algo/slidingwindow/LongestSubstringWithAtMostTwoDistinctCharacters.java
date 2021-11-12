package com.algo.slidingwindow;

/**
 * 
 * Given a string, find the length of the longest substring T that contains at
 * most 2 distinct characters.
 * 
 * Input: “eceba” Output: 3 Explanation: T is "ece" which its length is 3.
 * 
 * Input: “aaa” Output: 3
 *
 * 
 * 
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {

	public static void main(String[] args) {
		String s = "WORLDL";
		System.out.println(lenOfLongestSubstring(s));
	}

	public static int lenOfLongestSubstring(String s) {
		int[] map = new int[128];

		int start = 0, end = 0, maxLen = Integer.MIN_VALUE, counter = 0;

		while (end < s.length()) {
			final char c1 = s.charAt(end);
			if (map[c1] == 0) {
				counter++;
			}
			map[c1]++;
			end++;

			while (counter > 2) {
				char c2 = s.charAt(start);
				if (map[c2] == 1) {

					counter--;
				}
				map[c2]--;
				start++;
			}
			if (counter == 2)
				maxLen = Math.max(maxLen, end - start);
		}

		return maxLen;
	}
}
