package com.algo.dp.pattern.lcs;

/**
 * Given a string s, find the longest palindromic subsequence's length in s. You
 * may assume that the maximum length of s is 1000.
 * 
 * Input:"bbbab" Output: 4  One possible longest palindromic subsequence is "bbbb".
 * Input: "cbbd" Output: 2
 * 
 *
 */
public class LongestPalindromicSubsequence {
	public static void main(String args[]) {
		String s = "agbdba";
		System.out.println(longestPalindromeSubseq( s));
		System.out.println(LPS( s));
	}
	//based on LCS just need to reverse the string and treat this string as s2 and find LCS
	public static int LPS(String s) {
		int m=s.length();
		int[][] T = new int[m+1][m+1];
		for (int i = 1; i <m+1; i++) {
			for (int j = 1; j <m+1; j++) {
				if(s.charAt(i-1)==s.charAt(m-j)) {
					T[i][j]=1+T[i-1][j-1];
				}else {
					T[i][j]=Math.max(T[i-1][j],T[i][j-1]);
				}
			}
		}
		return T[m][m];

	}
	/*
	 * dp[i][j]: the longest palindromic subsequence's length of substring(i,
	 * j), here i, j represent left, right indexes in the string State
	 * transition: dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j)
	 * otherwise, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]) Initialization:
	 * dp[i][i] = 1
	 */
	public static int longestPalindromeSubseq(String s) {
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
}