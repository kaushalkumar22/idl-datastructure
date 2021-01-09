package com.algo.ads.dp.common;

/**
 * Given an integer array A, you partition the array into (contiguous) subarrays
 * of length at most K. After partitioning, each subarray has their values
 * changed to become the maximum value of that subarray.
 * 
 * Return the largest sum of the given array after partitioning.

 * Input: A = [1,15,7,9,2,5,10], K = 3 Output: 84 Explanation: A becomes
 * [15,15,15,9,10,10,10]
 * 
 * @author I339640
 *
 */
public class PartitionArrayForMaximumSum {

	/*
	 * Explanation dp[i] record the maximum sum we can get considering A[0] ~
	 * A[i] To get dp[i], we will try to change k last numbers separately to the
	 * maximum of them, where k = 1 to k = K.
	 * 
	 * Complexity Time O(NK), Space O(N)
	 */

	public int maxSumAfterPartitioning(int[] A, int K) {
		int N = A.length, dp[] = new int[N];
		for (int i = 0; i < N; ++i) {
			int curMax = 0;
			for (int k = 1; k <= K && i - k + 1 >= 0; ++k) {
				curMax = Math.max(curMax, A[i - k + 1]);
				dp[i] = Math.max(dp[i], (i >= k ? dp[i - k] : 0) + curMax * k);
			}
		}
		return dp[N - 1];
	}
}
