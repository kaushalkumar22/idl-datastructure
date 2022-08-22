package com.algo.slidingwindow;

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
	public static int characterReplacement(String s, int k) {
		int[] seen = new int[26];
		int left = 0; 
		int mostFreq = 0; 
		int maxLength = 0;
		for(int right=0;right < s.length();right++) {
			char c =s.charAt(right);
			seen[c - 'A']++;
			mostFreq = Math.max(mostFreq, seen[c - 'A']);
			if ((right - left+1)-mostFreq>k) {
				char c1 =s.charAt(left);              
				seen[c1-'A']--;
				left++;
			}
			maxLength = Math.max(maxLength, right - left + 1);
		}
		return maxLength;
	}
}
