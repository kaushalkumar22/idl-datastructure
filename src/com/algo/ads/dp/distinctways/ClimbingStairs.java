package com.algo.ads.dp.distinctways;

/**
 * you are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Input: 2 Output: 2 Explanation: There are two ways to climb to the top. 
 * 1. 1 step + 1 step 
 * 2. 2 steps
 * 
 * Input: 3 Output: 3 Explanation: There are three ways to climb to the top. 1.
 * 1 step + 1 step + 1 step 2. 1 step + 2 steps 3. 2 steps + 1 step
 * Constraints:
 * 
 * 1 <= n <= 45
 * 
 *
 */
public class ClimbingStairs {

	public static void main(String[] args) {

		System.out.println(climbStairs(5));
	}
	/*
	 * this problem is a fibonacci series, because current state is depends on the previous two states
	 * 
	 * if n=1 then 1
	 * if n=2 then 2 => 1,1 and 2
	 * if n=3 then 3 => n1+n2
	 * if n=4 then 5 => n2+n3
	 * 
	 * Complexity Analysis 
	 * 
	 * Time O(n)
	 * Space O(n)
	 */
	public static int climbStairs(int n) {

		int[] dp = new int[n + 1];
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i - 2];
		}
		return dp[n];
	}
	/*
	 * this problem is a fibonacci series, because current state is depends on the previous two states
	 * 
	 * if n=1 then 1
	 * if n=2 then 2 => 1,1 and 2
	 * if n=3 then 3 => n1+n2
	 * if n=4 then 5 => n2+n3
	 * 
	 * Complexity Analysis 
	 * 
	 * Time O(n)
	 * Space O(1)
	 */
	public int climbStairs2(int n) {
		// base cases
		if(n <= 0) return 0;
		if(n == 1) return 1;
		if(n == 2) return 2;

		int one_step_before = 2;
		int two_steps_before = 1;
		int all_ways = 0;

		for(int i=2; i<n; i++){
			all_ways = one_step_before + two_steps_before;
			two_steps_before = one_step_before;
			one_step_before = all_ways;
		}
		return all_ways;
	}
}
