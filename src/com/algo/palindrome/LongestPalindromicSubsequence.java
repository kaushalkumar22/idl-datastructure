package com.algo.palindrome;

/**
 * Given a string s, find the longest palindromic subsequence's length in s. You
 * may assume that the maximum length of s is 1000.
 * 
 * Example 1: Input:
 * 
 * "bbbab" Output: 4 One possible longest palindromic subsequence is "bbbb".
 * Example 2: Input:
 * 
 * "cbbd" Output: 2
 * 
 * @author I339640
 *
 */
public class LongestPalindromicSubsequence {

	/*
	 * dp[i][j]: the longest palindromic subsequence's length of substring(i,
	 * j), here i, j represent left, right indexes in the string State
	 * transition: dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j)
	 * otherwise, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]) Initialization:
	 * dp[i][i] = 1
	 */
	public int longestPalindromeSubseq(String s) {
		int[][] dp = new int[s.length()][s.length()];

		for (int i = s.length() - 1; i >= 0; i--) {
			dp[i][i] = 1;
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[0][s.length() - 1];
	}

	public int calculate1(char[] str) {
		int T[][] = new int[str.length][str.length];
		for (int i = 0; i < str.length; i++) {
			T[i][i] = 1;
		}
		for (int l = 2; l <= str.length; l++) {
			for (int i = 0; i < str.length - l + 1; i++) {
				int j = i + l - 1;
				if (l == 2 && str[i] == str[j]) {
					T[i][j] = 2;
				} else if (str[i] == str[j]) {
					T[i][j] = T[i + 1][j - 1] + 2;
				} else {
					T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
				}
			}
		}
		return T[0][str.length - 1];
	}

	public int calculateRecursive(char str[], int start, int len) {
		if (len == 1) {
			return 1;
		}
		if (len == 0) {
			return 0;
		}
		if (str[start] == str[start + len - 1]) {
			return 2 + calculateRecursive(str, start + 1, len - 2);
		} else {
			return Math.max(calculateRecursive(str, start + 1, len - 1), calculateRecursive(str, start, len - 1));
		}
	}

	public static void main(String args[]) {
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
		String str = "agbdba";
		int r1 = lps.calculateRecursive(str.toCharArray(), 0, str.length());
		int r2 = lps.calculate1(str.toCharArray());
		System.out.print(r1 + " " + r2);
	}

}