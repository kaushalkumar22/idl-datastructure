package com.algo.dynamicprogramming;

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {

		// int arr[] = { 5,6,2,3,4,1,9,1,2,3,4,5,4,7,8,9,8,9,5,7,8,11};
		int arr[] = { 5, 6, 2, -3, 4, -1, 6, 8, 11, 7, 21 };
		int n = arr.length;
		int length = LIS(arr, n);
		System.out.println("Length of LCS is:" + length);
	}

	public static int LIS(int A[], int n) {

		int[] LIS = new int[n + 1];
		int max = 0;
		for (int i = 0; i < n; i++) {
			LIS[i] = 1;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (A[i] > A[j] && LIS[i] < LIS[j] + 1) {
					LIS[i] = LIS[j] + 1;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (max < LIS[i]) {
				max = LIS[i];
			}

		}
		return max;
	}

	/*
	 * tails is an array storing the smallest tail of all increasing
	 * subsequences with length i+1 in tails[i]. For example, say we have nums =
	 * [4,5,6,3], then all the available increasing subsequences are:
	 * 
	 * len = 1 : [4], [5], [6], [3] => tails[0] = 3 len = 2 : [4, 5], [5, 6] =>
	 * tails[1] = 5 len = 3 : [4, 5, 6] => tails[2] = 6 We can easily prove that
	 * tails is a increasing array. Therefore it is possible to do a binary
	 * search in tails array to find the one needs update.
	 * 
	 * Each time we only do one of the two:
	 * 
	 * (1) if x is larger than all tails, append it, increase the size by 1 (2)
	 * if tails[i-1] < x <= tails[i], update tails[i] Doing so will maintain the
	 * tails invariant. The the final answer is just the size.
	 * 
	 */

	public int lengthOfLIS(int[] nums) {
		int[] tails = new int[nums.length];
		int size = 0;
		for (int x : nums) {
			int i = 0, j = size;
			while (i != j) {
				int m = (i + j) / 2;
				if (tails[m] < x)
					i = m + 1;
				else
					j = m;
			}
			tails[i] = x;
			if (i == size)
				++size;
		}
		return size;
	}
	// Runtime: 2 ms
}
