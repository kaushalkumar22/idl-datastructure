package com.algo.dp.lcs;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubstring {

	public static void main(String args[]) {
		String s1="abccc";
		String s2="bcca";
		System.out.println(longestCommonSubstring( s1,  s2));
		System.out.println(longestCommonSubstring2( s1,  s2));

	}
	public static int longestCommonSubstring(String s1, String s2) {

		int m= s1.length();
		int n =s2.length();
		int[][] dp = new int[m+1][n+1];
		int max = Integer.MIN_VALUE;
		for(int i=1;i<m+1;i++) {
			for(int j=1;j<n+1;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					dp[i][j] = 1+dp[i-1][j-1];
					max= Math.max(max, dp[i][j]);
				}
			}
		}
		return max;
	}
	public static int longestCommonSubstring2(String s1, String s2) {

		int m= s1.length();
		int n =s2.length();
		if (m < n) {
			return longestCommonSubstring2(s2, s1);
		}

		int[] dp = new int[n+1];
		int max = Integer.MIN_VALUE;
		int prev=0;
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {			
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					dp[j] = 1+prev;
					max= Math.max(max, dp[j]);
				}
				prev=dp[j];
			}
		}
		return max;
	}

}
