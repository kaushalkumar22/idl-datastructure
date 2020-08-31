package com.algo.dp.pattern.minmaxcosttoreachtarget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * Input: n = 12 Output: 3 Explanation: 12 = 4 + 4 + 4.
 * 
 * Input: n = 13 Output: 2 Explanation: 13 = 4 + 9.
 *
 */
public class PerfectSquares {
	public static void main(String[] args) {
		System.out.println(numSquares(12));
	}
	public static int numSquares(int n) {
		int[] dp = new int[n+1];
		for (int i=0;i<dp.length;i++) {
			dp[i]=i;
		}
		for(int i = 1; i <= n; i++){
			for(int j = 1; j * j <= i; j++){
				dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
			}
		}
		return dp[n];
	}
}
