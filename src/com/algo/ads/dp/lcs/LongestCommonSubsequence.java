package com.algo.ads.dp.lcs;

/**
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence.
 * 
 * A subsequence of a string is a new string generated from the original string
 * with some characters(can be none) deleted without changing the relative order
 * of the remaining characters. (eg, "ace" is a subsequence of "abcde" while
 * "aec" is not). A common subsequence of two strings is a subsequence that is
 * common to both strings.
 * If there is no common subsequence, return 0.
 * 
 * Input: text1 = "abcde", text2 = "ace" Output: 3 Explanation: The longest
 * common subsequence is "ace" and its length is 3.
 * 
 * Input: text1 = "abc", text2 = "abc" Output: 3 Explanation: The longest common
 * subsequence is "abc" and its length is 3.
 * 
 * Input: text1 = "abc", text2 = "def" Output: 0 Explanation: There is no such
 * common subsequence, so the result is 0.
 *
 */
public class LongestCommonSubsequence {

	public static void main(String[] args) {

		String x = "AGGTABCZA";
		String y = "GXTXAYBCAZ";
		int m = x.length();
		int n = y.length();
		System.out.println("Length of LCS is:" + LCSRecurcive(x, y, m, n));
		System.out.println("Length of LCS is:" + LCSDP(x, y));

	}

	public static int LCSRecurcive(String s1, String s2, int m, int n) {

		if (m == 0 || n == 0) {
			return 0;
		}
		if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
			return 1 + LCSRecurcive(s1, s2, m - 1, n - 1);
		} else {
			return Math.max(LCSRecurcive(s1, s2, m - 1, n), LCSRecurcive(s1, s2, m, n - 1));
		}

	}

	public static int LCSDP(String s1, String s2) {

		int m = s1.length();
        int n= s2.length();
		int[][] T = new int[m + 1][n + 1];
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					T[i][j] = 1 + T[i - 1][j - 1];
				} else {
					T[i][j] = Math.max(T[i][j - 1], T[i - 1][j]);
				}
			}
		}
		return T[m][n];
	}
}
