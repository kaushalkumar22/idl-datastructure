package com.algo.dp.lcs;

/**
 * 
 * Given two integer arrays A and B, return the maximum length of an subarray
 * that appears in both arrays.
 * 
 * Example 1:
 * 
 * Input: A: [1,2,3,2,1] B: [3,2,1,4,7] Output: 3 Explanation: The repeated
 * subarray with maximum length is [3, 2, 1].
 *
 */
public class MaximumLengthOfRepeatedSubarray {

	public static void main(String[] args) {
		int[] A= {1,2,3,2,1}, B= {3,2,1,4,7};
		System.out.println(findLength(A,B));
	}
	public static int findLength(int[] A, int[] B) {
		if(A == null||B == null) return 0;
		int m = A.length;
		int n = B.length;
		int max = 0;
		int[][] dp = new int[m + 1][n + 1];
		for(int i = 1;i <= m;i++){
			for(int j = 1;j <= n;j++){
				if(A[i - 1] == B[j - 1]){
					dp[i][j] = 1 + dp[i - 1][j - 1];
					max = Math.max(max,dp[i][j]);
				}
			}
		}
	return max;
}
}
