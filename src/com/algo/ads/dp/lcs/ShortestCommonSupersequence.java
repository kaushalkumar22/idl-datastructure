package com.algo.ads.dp.lcs;

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
	public static String shortestCommonSupersequence(String s1, String s2) {
		int i = 0, j = 0;
		String res = "";
		for (char c : LCS(s1, s2).toCharArray()) {
			while (s1.charAt(i) != c)
				res += s1.charAt(i++);
			while (s2.charAt(j) != c)
				res += s2.charAt(j++);
			res += c; 
			i++;
			j++;
		}
		return res + s1.substring(i) + s2.substring(j);

	}
	public static String LCS(String s1, String s2) {
		int m =s1.length();
		int n =s2.length();

		String[][] T= new String[m+1][n+1];
		for (int i = 0; i < T.length; i++) 
		      Arrays.fill(T[i], "");
		for(int i=1;i<m+1;i++) {
			for(int j=1;j<n+1;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					T[i][j]=T[i-1][j-1]+s1.charAt(i-1);
				}else {
					T[i][j]=T[i-1][j].length()>T[i][j-1].length()?T[i-1][j]:T[i][j-1];
				}
			}
		}
		return T[m][n];
	}
}
