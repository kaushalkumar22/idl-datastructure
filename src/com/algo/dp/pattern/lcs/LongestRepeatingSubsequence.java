package com.algo.dp.pattern.lcs;
//AABEBCDD //ABD twice
public class LongestRepeatingSubsequence {
	public static void main(String[] args) {
		String s ="AABEBCDD";
		System.out.println(longestRepeatingSubsequence( s));
	}
	static int longestRepeatingSubsequence(String s) {
		
		String s1=s;
		String s2=s;
		int m=s1.length();
		int[][] T = new int[m+1][m+1];
		
		for(int i=1;i<m+1;i++) {
			for(int j=1;j<m+1;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)&&i!=j) {
					T[i][j]=1+T[i-1][j-1];
				}else {
					T[i][j]= Math.max(T[i-1][j], T[i][j-1]);
				}
			}
		}
		return T[m][m];
		
	}
}

