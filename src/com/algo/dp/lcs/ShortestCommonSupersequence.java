package com.algo.dp.lcs;

import java.util.Arrays;

/**
 * Given two strings str1 and str2, return the shortest string that has both
 * str1 and str2 as subsequences. If multiple answers exist, you may return any
 * of them.
 * 
 * (A string S is a subsequence of string T if deleting some number of
 * characters from T (possibly 0, and the characters are chosen anywhere from T)
 * results in the string S.)
 * 
 * Input: str1 = "abac", str2 = "cab" Output: "cabac" Explanation: str1 = "abac"
 * is a subsequence of "cabac" because we can delete the first "c". str2 = "cab"
 * is a subsequence of "cabac" because we can delete the last "ac". The answer
 * provided is the shortest such string that satisfies these properties.
 *
 * 
 */
public class ShortestCommonSupersequence {
	public static void main(String[] args) {
		String s1="abac";
		String s2="cab";
		System.out.println(shortestCommonSupersequenceLength( s1,  s2) );
		System.out.println(shortestCommonSupersequence( s1,  s2));
	}
	public static int shortestCommonSupersequenceLength(String s1, String s2) {
		int m =s1.length();
		int n =s2.length();
		int[][] T= new int[m+1][n+1];

		for(int i=1;i<m+1;i++) {
			for(int j=1;j<n+1;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					T[i][j]=1+T[i-1][j-1];
				}else {
					T[i][j]=Math.max(T[i-1][j],T[i][j-1]);
				}
			}
		}
		return m+n-T[m][n];

	}
	//public static String shortestCommonSupersequence(String s1, String s2) {
	public static String shortestCommonSupersequence(String s1, String s2) {
		//Part1 fill the longest common sequence table
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		for(int i = 0;i<s1.length();i++){
			for(int j = 0;j<s2.length();j++){
				if(s1.charAt(i) == s2.charAt(j)){
					dp[i+1][j+1] = dp[i][j] + 1;
				}else {
					dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
				}
			}
		}
		//Part2: use the table to get the ans
		StringBuilder sb = new StringBuilder();
		for(int i = s1.length()-1,j = s2.length()-1;i>=0 || j>=0;){
			//Case 1: either there is no char in str1 or str2, append char directly
			if(i < 0){
				sb.append(s2.charAt(j));
				j--;
				continue;
			}else if(j < 0){
				sb.append(s1.charAt(i));
				i--;
				continue;
			}
			//Case 2: if the value is the same compared with left or uppper cell, append corresponding char in str1 or str2
			// in longest common sequence, this means the char should be deleted, but in this problem, we need to append
			int val = dp[i+1][j+1];
			if(val == dp[i][j+1]){
				sb.append(s1.charAt(i));
				i--;
			}else if(val == dp[i+1][j]){
				sb.append(s2.charAt(j));
				j--;
				//Case 3 if the value is not the same compared with left or upper cell, append char and i--,j--
				//in longest common sequence, this means we find the common char
			}else {
				sb.append(s1.charAt(i));
				i--;
				j--;
			}
		}
		return sb.reverse().toString();
	}
}
