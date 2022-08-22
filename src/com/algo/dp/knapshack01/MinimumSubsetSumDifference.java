package com.algo.dp.knapshack01;

import java.util.Arrays;

/**
 * Given a non-empty array containing only positive integers, partition the
 * array into two subsets such that the sum of elements in both subsets
 * difference is minimal .
 * 
 * Input: [1, 6, 11, 5] Output: 1
 * 
 * Explanation: The array can be partitioned as [1, 6, 5] and [11], so
 * difference is 1.
 * 
 * Input: [1,2,7] Output: 4
 */
public class MinimumSubsetSumDifference {
	public static void main(String[] args) {
		int nums[] = { 1,6,11,5 };
		System.out.println(minSubsetSumDifference(nums));
		System.out.println(lastStoneWeightII(nums));
	}

	public static int lastStoneWeightII(int[] stones) {
		int n = stones.length;
		int sum = Arrays.stream(stones).sum();
		int s = sum/2;
		int[] dp = new int[s+1];
		for(int i=1;i<=n;i++){
			for(int j=s;j>=stones[i-1];j--){
				dp[j]= Math.max(stones[i-1]+dp[j-stones[i-1]],dp[j]);
			}
		}
		return sum- 2*dp[s];
	}
	public static int minSubsetSumDifference(int[] nums) {

		int n= nums.length;
		int sum = Arrays.stream(nums).sum();
		boolean[][] T= new boolean[n+1][sum+1];
		for(int i=0;i<n;i++) {
			T[i][0]=true;
		}
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				if(nums[i-1]<=j) {
					T[i][j]=T[i-1][j-nums[i-1]]||T[i-1][j];
				}else {
					T[i][j]=T[i-1][j];
				}
			}
		}
		int minDiff = Integer.MAX_VALUE;
		for(int i=0;i<=sum/2;i++) {
			if(T[n][i]==true) {
				minDiff= Math.min(minDiff, sum-2*i);
			}
		}
		return minDiff;

	}
}