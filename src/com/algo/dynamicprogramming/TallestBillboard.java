package com.algo.dynamicprogramming;

/**
 * You are installing a billboard and want it to have the largest height. The
 * billboard will have two steel supports, one on each side. Each steel support
 * must be an equal height. You have a collection of rods which can be welded
 * together. For example, if you have rods of lengths 1, 2, and 3, you can weld
 * them together to make a support of length 6. Return the largest possible
 * height of your billboard installation. If you cannot support the billboard,
 * return 0.
 * 
 * Example 1: Input: [1,2,3,6] Output: 6 Explanation: We have two disjoint
 * subsets {1,2,3} and {6}, which have the same sum = 6. 
 * Example 2: Input:[1,2,3,4,5,6] Output: 10 Explanation: We have two disjoint subsets {2,3,5}
 * and {4,6}, which have the same sum = 10. 
 * Example 3: Input: [1,2] Output: 0 Explanation: The billboard cannot be supported, so we return 0.
 * 
 * @author IBM
 *
 */
public class TallestBillboard {
	/*
	 * dp[d] mean the maximum pair of sum we can get with pair difference d
	 * 
	 * If have a pair of sum (a, b) with a > b, then dp[a - b] = b
	 * 
	 * If we have dp[diff] = a, it means we have a pair of sum (a, a + diff). And
	 * this is the biggest pair with difference diff
	 * 
	 * Example
	 * 
	 * dp is initializes with dp[0] = 0;
	 * 
	 * Assume we have an init state like this ------- y ------|----- d -----|
	 * ------- y ------|
	 * 
	 * case 1 If put x to tall side ------- y ------|----- d -----|----- x -----|
	 * ------- y ------|
	 * 
	 * We update dp[d + x] = max(dp[d + x], y )
	 * 
	 * case 2.1 Put x to low side and d >= x: -------y------|----- d -----|
	 * -------y------|--- x ---|
	 * 
	 * We update dp[d-x] = max(dp[d - x], y + x)
	 * 
	 * case 2.2 Put x to low side and d < x: ------- y ------|----- d -----| -------
	 * y ------|------- x -------| We update dp[x - d] = max(dp[x - d], y + d)
	 * 
	 * case 2.1 and case2.2 can merge into dp[abs(x - d)] = max(dp[abs(x - d)], y +
	 * min(d, x))
	 * 
	 * 
	 * Time Complexity
	 * 
	 * O(NM), where we have N = rod.length <= 20 S = sum(rods) <= 5000 M = all
	 * possible sum = min(3^N, S)
	 * 
	 * There are 3 ways to arrange a number: in the first group, in the second, not
	 * used. The number of difference will be less than 3^N. The only case to reach
	 * 3^N is when rod = [1,3,9,27,81...]
	 * 
	 * 
	 * Java, O(SN) using array, just for better reading:
	 */
	    public int tallestBillboard(int[] rods) {
	        int[] dp = new int[5001];
	        for (int d = 1; d < 5001; d++) dp[d] = -10000;
	        for (int x : rods) {
	            int[] cur = dp.clone();
	            for (int d = 0; d + x < 5001; d++) {
	                dp[d + x] = Math.max(dp[d + x], cur[d]);
	                dp[Math.abs(d - x)] = Math.max(dp[Math.abs(d - x)], cur[d] + Math.min(d, x));
	            }
	        }
	        return dp[0];
	    }
}
