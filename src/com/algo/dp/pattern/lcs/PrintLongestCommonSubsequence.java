package com.algo.dp.pattern.lcs;
/**
 * /**
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence.
 * 
 * A subsequence of a string is a new string generated from the original string
 * with some characters(can be none) deleted without changing the relative order
 * of the remaining characters. (eg, "ace" is a subsequence of "abcde" while
 * "aec" is not). A common subsequence of two strings is a subsequence that is
 * common to both strings.
 * If there is no common subsequence, return "".
 * 
 * Input: text1 = "abcde", text2 = "ace" Output: ace Explanation: The longest
 * common subsequence is "ace"
 * 
 * Input: text1 = "abc", text2 = "abc" Output: abc Explanation: The longest common
 * subsequence is "abc"
 * 
 * Input: text1 = "abc", text2 = "def" Output: 0 Explanation: There is no such
 * common subsequence, so the result is "".
 *
 */

public class PrintLongestCommonSubsequence {
	public static void main(String[] args) {
		String s1 = "abcde";
		String s2 = "ace";
		System.out.println( LCS( s1,  s2));
	}
	public static String LCS(String s1, String s2) {
		int m =s1.length();
		int n =s2.length();

		String[][] T= new String[m+1][n+1];
		for(int i=0;i<m+1;i++) {
			for(int j=0;j<n+1;j++) {
				T[i][j]="";
			}
		}
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

