package com.algo.dp.numbers;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		int arr[] = { 5, 6, 2, -3, 4, -1, 6, 8, 11, 7, 21 };
		int n = arr.length;
		int length = LIS(arr, n);
		System.out.println("Length of LCS is:" + length);
	}
	public int lengthOfLIS(int[] nums) {            
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
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
					max=Math.max(max, LIS[i]);
				}
			}
		}
		
		return max;
	}

}
