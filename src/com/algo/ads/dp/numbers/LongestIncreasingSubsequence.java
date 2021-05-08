package com.algo.ads.dp.numbers;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		int arr[] = { 5, 6, 2, -3, 4, -1, 6, 8, 11, 7, 21 };
		int n = arr.length;
		System.out.println("Length of LCS is:" + lengthOfLIS(arr));
		System.out.println("Length of LCS is:" + LIS(arr, n));
	}
	//nlogn
	public static int lengthOfLIS(int[] nums) {   
		if(nums.length<2) return nums.length;
		int[] dp = new int[nums.length];
		int count=1;
		dp[0]=nums[0];
		for(int i=1;i<nums.length;i++) {
			if(dp[count-1]<nums[i]) {
				dp[count++]=nums[i];
			}else {
				int index = binarySearch(dp,0, count, nums[i]);
				dp[index] = nums[i];
			}
		}
		return count;
	}
	static int binarySearch(int[] A,int low, int high,int target) {
		while (low <high) {
			int mid = (low+high) / 2;
			if (A[mid] < target)
				low = mid + 1;
			else
				high = mid;
		}
		return low;
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
