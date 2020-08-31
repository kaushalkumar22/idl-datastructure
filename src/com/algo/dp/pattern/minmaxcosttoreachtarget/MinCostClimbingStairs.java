package com.algo.dp.pattern.minmaxcosttoreachtarget;

/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0indexed).
 * 
 * Once you pay the cost, you can either climb one or two steps. You need to
 * find minimum cost to reach the top of the floor, and you can either start
 * from the step with index 0, or the step with index 1.
 * 
 * Input: cost = [10, 15, 20] Output: 15 
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * 
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1] Output: 6 
 * Explanation:Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 * 
 * Complexity analysis 
 * Time complexity O(n)
 * Space complexity(n) (NOTE :with constant time complexity this can be done using two variable)
 */
public class MinCostClimbingStairs {

	public static void main(String[] args) {
		int[] cost= {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		System.out.println(minCostClimbingStairs(cost));
	}
	/* Complexity analysis 
	 * Time complexity O(n)
	 * Space complexity(n)
	 */
	public static int minCostClimbingStairs(int[] cost) {
		int n =cost.length;
		int[] dp = new int[n];
		dp[0]=cost[0];
		dp[1]=cost[1];
		for (int i = 2; i <n; ++i) {
			dp[i] = Math.min(dp[i-1], dp[i-2]) +  cost[i];
		}
		return Math.min(dp[n-1],dp[n-2]);//either from one step back or from last index top can be reached so so min of both is result
	}
	/* 
	 * Complexity analysis 
	 * Time complexity O(n)
	 * Space complexity(1) 
	 */
	public int minCostClimbingStairs2(int[] cost) {
		int twoStepBefore = cost[0];
		int oneStepBefore = cost[1];
		int curr = 0;
		for(int i = 2;i< cost.length;i++){
			curr = Math.min(twoStepBefore,oneStepBefore) + cost[i];
			twoStepBefore = oneStepBefore;
			oneStepBefore = curr;
		}
		return Math.min(oneStepBefore,twoStepBefore);
	}
}
