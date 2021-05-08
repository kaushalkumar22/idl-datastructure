package com.algo.ads.dp.ads.decisionmaking;

/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * 
 * Input: nums = [1,2,3,1] Output: 4 Explanation: Rob house 1 (money = 1) and
 * then rob house 3 (money = 3). Total amount you can rob = 1 + 3 = 4.
 * 
 * Example 2:
 * 
 * Input: nums = [2,7,9,3,1] Output: 12 Explanation: Rob house 1 (money = 2),
 * rob house 3 (money = 9) and rob house 5 (money = 1). Total amount you can rob
 * = 2 + 9 + 1 = 12.
 * 
 * Constraints:
 * 
 * 0 <= nums.length <= 100 0 <= nums[i] <= 400
 *
 */
public class HouseRobber {
	public static void main(String[] args) {
		int[] nums = {2,7,9,3,1};
		System.out.println(rob(nums));
		System.out.println(robOpt(nums));
	}
	 public static int robOpt(int[] nums) {
	        int n = nums.length;
			if(n==0) return 0;
			int prev1=0;
	        int prev=nums[0];
	        int max=nums[0];
			for(int i=2;i<=n;i++) {
				max= Math.max(prev,prev1+nums[i-1]);
	            prev1=prev;
	            prev=max;
			}
			return max;
	    }
	public static int rob(int[] nums) {
		int n = nums.length;
		if(n==0) return 0;
		int[] dp = new int[n+1];
		dp[0]=0;
		dp[1]=nums[0];
		for(int i=2;i<=n;i++) {
			dp[i]=Math.max(dp[i-1], dp[i-2]+nums[i-1]);
		}
		return dp[n];
	}
}
