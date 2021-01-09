package com.algo.lds.slidingwindow;

/**
 * 'Given a string s that consists of only uppercase English letters, you can
 * perform at most k operations on that string.
 * 
 * In one operation, you can choose any character of the string and change it to
 * any other uppercase English character.
 * 
 * Find the length of the longest sub-string containing all repeating letters
 * you can get after performing the above operations.
 * 
 * Note: Both the string's length and k will not exceed 104.
 * 
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 * 
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 *
 */
public class LongestRepeatingCharacterReplacement {
	public static void main(String[] args) {
		String s = "AABABBC";
		int k = 2;
		System.out.println(characterReplacement( s,  k));
	}
	/*
	 * Intuition
	 * need to find longest window which hang max repeating chars and k number of 
	 * non repeating chars i.e maxCount + k<right - left+1
	 * 
	 * left: left boundary of window
	 * right: right boundary of window
	 * maxCount: 'maxCount' to track max repeating chars in out window
	 * cCount[]: to keep track how many times each chars appears in our window
	 * 
	 * need to find a window which greater than 'maxCount + k'
	 * Complexity Analysis
	 * 
	 * Time Complexity: O(n) Space Complexity: O(n).
	 * 
	 */
	public static int characterReplacement(String s, int k) {
		int[] cCount = new int[26];
		int left = 0; 
		int maxCount = 0; 
		int maxLength = 0;
		for (int right = 0; right < s.length(); right++) {
			maxCount = Math.max(maxCount, ++cCount[s.charAt(right) - 'A']);
			if (maxCount + k<right - left+1) {
				cCount[s.charAt(left++)-'A']--;
			}
			maxLength = Math.max(maxLength, right - left + 1);
		}
		return maxLength;
	}
}
