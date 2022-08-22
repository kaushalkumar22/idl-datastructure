package com.algo.slidingwindow;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * Input: "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length of 3.
 * 
 * Input: "bbbbb" Output: 1 Explanation: The answer is "b", with the length of 1.

 * Input: "pwwkew" Output: 3 Explanation: The answer is "wke", with the length of 3. 
 * 
 * Note that the answer must be a substring, "pwke" is a subsequence and
 * not a substring.
 * 
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcdbb"));
		System.out.println(lengthOfLongestSubstring2("abcabcdbb"));
		System.out.println(lengthOfLongestSubstring1("abcabcdbb"));
	}

	public static int lengthOfLongestSubstring1(String s) {
		int[] map = new int[128];
		int left = 0, maxLength = 0, count = 0;
		for(int right=0;right<s.length();right++) {
			char c = s.charAt(right);
			if (map[c] >=1) count++;
			map[c]++;
			while (count > 0) {
				char c2 = s.charAt(left);
				if (map[c2] > 1) count--;
				map[c2]--;
				left++;
			}
			maxLength = Math.max(maxLength, right - left+1);
		}
		return maxLength;
	}
	public static int lengthOfLongestSubstring(String s) {
		int[] map = new int[128];
		int left = 0, right = 0, maxLength = 0, count = 0;
		while (right < s.length()) {
			char c = s.charAt(right);
			if (map[c] > 0) count++;
			map[c]++;
			right++;

			while (count > 0) {
				char c2 = s.charAt(left);
				if (map[c2] > 1) count--;
				map[c2]--;
				left++;
			}
			maxLength = Math.max(maxLength, right - left);
		}
		return maxLength;
	}
	public static String lengthOfLongestSubstring2(String s) {
		int[] map = new int[128];
		int left = 0, right = 0, maxLength = 0, count = 0,startIndex=0;
		while (right < s.length()) {
			char c = s.charAt(right);
			if (map[c] > 0) count++;
			map[c]++;
			right++;

			while (count > 0) {
				if(maxLength<right-left) {
					maxLength=right-left;
					startIndex=left;
				}
				char c2 = s.charAt(left);
				if (map[c2] > 1) count--;
				map[c2]--;
				left++;
			}
			//maxLength = Math.max(maxLength, right - left);
		}
		return s.substring(startIndex,startIndex+maxLength-1);
	}
}
