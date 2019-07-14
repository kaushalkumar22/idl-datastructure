package com.ds.advance;
/**
 * Given a string, find the length of the longest substring without repeating characters.
Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcdbb"));
	}

	public static int lengthOfLongestSubstring(String s) {
		int result = 0;
		int[] cache = new int[26];	
		int j = 0;
		for (int i = 0; i < s.length(); i++) {		
			j = cache[s.charAt(i)-'a'] > 0 ? Math.max(j, cache[s.charAt(i)-'a']) : j;
			cache[s.charAt(i)-'a'] = i + 1;
			result = Math.max(result, i - j + 1);
		}
		return result;
	}
}
