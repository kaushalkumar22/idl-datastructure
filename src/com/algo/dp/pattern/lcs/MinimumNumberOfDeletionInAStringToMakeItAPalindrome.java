package com.algo.dp.pattern.lcs;
//this question is same of Minimum number of insertion in a string to make it a palindrome
public class MinimumNumberOfDeletionInAStringToMakeItAPalindrome {
	public static void main(String args[]) {
		String s = "agbdba";
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
		return m-T[m][m];

	}
}

