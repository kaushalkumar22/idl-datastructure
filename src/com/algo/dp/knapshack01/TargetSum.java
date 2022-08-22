package com.algo.dp.knapshack01;

/**
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target,
 * S. Now you have 2 symbols + and -. For each integer, you should choose one
 * from + and - as its new symbol. Find out how many ways to assign symbols to
 * make sum of integers equal to target S. Example 1: Input: nums is [1, 1, 1,
 * 1, 1], S is 3. Output: 5 Explanation:
 * 
 * -1+1+1+1+1 = 3 
 * +1-1+1+1+1 = 3 
 * +1+1-1+1+1 = 3 
 * +1+1+1-1+1 = 3 
 * +1+1+1+1-1 = 3
 * 
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 *
 */
public class TargetSum {

	public int findTargetSumWays(int[] nums, int t) {
		int sum = 0;
		int n =nums.length;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}        
		if(n==1&&sum!=Math.abs(t)) return 0;

		if(t > sum || (sum + t) % 2 == 1)   return 0;
		return subsetSum(nums, (sum + t) / 2);
	}

	private int subsetSum(int[] nums, int s){
		int n = nums.length;
		int[] dp = new int[s + 1];
		dp[0] = 1;
		for (int i = 1; i <=n; i++) {
			for (int j = s; j >= nums[i-1]; j--) {
				dp[j] = dp[j]+dp[j - nums[i-1]];
			}
		}
		return dp[s];
	}


}
