package com.algo.ads.dp.lcs;

public class MinimumNumberOfInsertionAndDeletionToConvertStringAtoB {
	
	public static void main(String[] args) {
		String s1="heap";
		String s2="pea";
		System.out.println(convertStringAtoB( s1,  s2));
	}
	public static int convertStringAtoB(String s1, String s2) {
		return s1.length()+s2.length()-2*LCS( s1,  s2);
	}
	public static int LCS(String s1, String s2) {

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

