package com.algo.greedy;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern
 * matching with support for '?' and '*'.
 * 
 * '?' Matches any single character. '*' Matches any sequence of characters
 * (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * Note:
 * 
 * s could be empty and contains only lowercase letters a-z. p could be empty
 * and contains only lowercase letters a-z, and characters like ? or *.
 * 
 * Example 1:
 * 
 * Input: s = "aa" p = "a" Output: false Explanation: "a" does not match the
 * entire string "aa".
 * 
 * Example 2:
 * 
 * Input: s = "aa" p = "*" Output: true Explanation: '*' matches any sequence.
 * 
 * Example 3:
 * 
 * Input: s = "cb" p = "?a" Output: false Explanation: '?' matches 'c', but the
 * second letter is 'a', which does not match 'b'.
 * 
 * Example 4:
 * 
 * Input: s = "adceb" p = "*a*b" Output: true Explanation: The first '*' matches
 * the empty sequence, while the second '*' matches the substring "dce".
 * 
 * Example 5:
 * 
 * Input: s = "acdcb" p = "a*c?b" Output: false
 * 
 * 
 */
public class WildcardMatching {

	public static void main(String[] args) {

		String str = "acdcb";
		String pattern = "a*c?b";
		System.out.println(wildcardMatchingLinearLime(str, pattern));
		// System.out.println(wildcardMatchingDynamicPrograming( str, pattern));
	}

	private static boolean wildcardMatchingLinearLime(String str, String pattern) {

		int sIndex = 0;
		int pIndex = 0;
		int match = 0;
		int starIdx = -1;
		// String s="acdcb";
		// String p="a*c?b";
		while (sIndex < str.length()) {
			if (pIndex < pattern.length()
					&& (pattern.charAt(pIndex) == '?' || str.charAt(sIndex) == pattern.charAt(pIndex))) {// advancing
																											// both
																											// pointers
				sIndex++;
				pIndex++;
			} else if (pIndex < pattern.length() && pattern.charAt(pIndex) == '*') {// * found, only advancing pattern
																					// pointer
				starIdx = pIndex;
				match = sIndex;
				pIndex++;
			} else if (starIdx != -1) {// last pattern pointer was *, advancing string pointer
				pIndex = starIdx + 1;
				match++;
				sIndex = match;
			} else // current pattern pointer is not star, last patter pointer was not * characters
					// do not match
				return false;
		}

		while (pIndex < pattern.length() && pattern.charAt(pIndex) == '*')// check for remaining characters in pattern
			pIndex++;

		return pIndex == pattern.length();
	}

	private static boolean wildcardMatchingDynamicPrograming(String str, String pattern) {
		boolean[][] match = new boolean[str.length() + 1][pattern.length() + 1];
		match[str.length()][pattern.length()] = true;
		for (int i = pattern.length() - 1; i >= 0; i--) {
			if (pattern.charAt(i) != '*')
				break;
			else
				match[str.length()][i] = true;
		}
		for (int i = str.length() - 1; i >= 0; i--) {
			for (int j = pattern.length() - 1; j >= 0; j--) {
				if (str.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?')
					match[i][j] = match[i + 1][j + 1];
				else if (pattern.charAt(j) == '*')
					match[i][j] = match[i + 1][j] || match[i][j + 1];
				else
					match[i][j] = false;
			}
		}
		return match[0][0];
	}
}