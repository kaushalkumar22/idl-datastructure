package com.algo.dynamicprogramming;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * Example 1:
 * 
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac" Output: true
 * 
 * Example 2:
 * 
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc" Output: false
 * 
 *
 */
public class InterleavingString {
	public static void main(String[] args) {
		String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
		//String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
		System.out.println(isInterleave( s1,  s2,  s3));
	}
	static boolean isInterleave(String s1, String s2, String s3) {
		int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
		if (l1 > l2) return isInterleave(s2, s1, s3);
		if (l3 != l1 + l2) return false;
		boolean[] dp = new boolean[l1 + 1];
		dp[0] = true;
		for (int i = 1; i <= l1; i++)
			dp[i] = dp[i - 1] && s3.charAt(i - 1) == s1.charAt(i - 1);
		for (int j = 1; j <= l2; j++) {
			dp[0] = dp[0] && s3.charAt(j - 1) == s2.charAt(j - 1);
			for (int i = 1; i <= l1; i++)
				dp[i] = (dp[i - 1] && s3.charAt(i + j - 1) == s1.charAt(i - 1))  
				|| (dp[i] && s3.charAt(i + j - 1) == s2.charAt(j - 1));
		}
		return dp[l1];
	}
}
