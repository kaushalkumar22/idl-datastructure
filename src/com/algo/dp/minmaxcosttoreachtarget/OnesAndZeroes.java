package com.algo.dp.minmaxcosttoreachtarget;

/**
 * Given an array, strs, with strings consisting of only 0s and 1s. Also two
 * integers m and n.
 * 
 * Now your task is to find the maximum number of strings that you can form with
 * given m 0s and n 1s. Each 0 and 1 can be used at most once.
 * 
 * Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3 Output: 4
 * Explanation: This are totally 4 strings can be formed by the using of 5 0s
 * and 3 1s, which are "10","0001","1","0".
 * 
 * Example 2:
 * 
 * Input: strs = ["10","0","1"], m = 1, n = 1 Output: 2 Explanation: You could
 * form "10", but then you'd have nothing left. Better form "0" and "1".
 * 
 *
 */
public class OnesAndZeroes {
	public static void main(String[] args) {

	}
	public int findMaxForm(String[] strs, int m, int n) {
		int[][] dp = new int[m+1][n+1];

		for (String s: strs) {
			int ones=0;
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)=='1')
					ones++;
			}
			int zeros= s.length()-ones;
			for (int i=m; i>=zeros; i--) 
				for (int j=n; j>=ones; j--)
					dp[i][j] = Math.max(dp[i][j], dp[i-zeros][j-ones]+1);
		}
		return dp[m][n];
	}
}

