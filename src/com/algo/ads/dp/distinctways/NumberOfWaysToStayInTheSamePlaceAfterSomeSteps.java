package com.algo.ads.dp.distinctways;

/**
 * 
 * You have a pointer at index 0 in an array of size arrLen. At each step, you
 * can move 1 position to the left, 1 position to the right in the array or stay
 * in the same place (The pointer should not be placed outside the array at any
 * time).
 * 
 * Given two integers steps and arrLen, return the number of ways such that your
 * pointer still at index 0 after exactly steps steps.
 * 
 * Since the answer may be too large, return it modulo 10^9 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: steps = 3, arrLen = 2 Output: 4 Explanation: There are 4 differents
 * ways to stay at index 0 after 3 steps.
 *  Right, Left, Stay 
 *  Stay, Right, Left
 * Right, Stay, Left 
 * Stay, Stay, Stay
 * 
 * Example 2:
 * 
 * Input: steps = 2, arrLen = 4 Output: 2 Explanation: There are 2 differents
 * ways to stay at index 0 after 2 steps 
 * Right, Left 
 * Stay, Stay
 * 
 * Example 3:
 * 
 * Input: steps = 4, arrLen = 2 Output: 8
 *
 * 
 */
public class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps {
	public static void main(String[] args) {
		System.out.println(numWays(4,2));
	}
	/*
	 * If we choose our dp state as dp[steps][position], from this state we can
	 * either:
	 * 
	 * Stay. Then we consume one step and stay at the same position =>
	 * dp[steps-1][position] Go right. Then we consume one step and go right =>
	 * dp[steps-1][position+1] Go left (if not at position zero). Then we consume
	 * one step and go left => if position > 0 then dp[steps-1][position-1]
	 * 
	 * Then our state can be calculated as: dp[steps][position] =
	 * dp[steps-1][position] + dp[steps-1][position+1] + dp[steps-1][position-1].
	 * 
	 * We can use the case when we have only one step as base case. Those cases are:
	 * 
	 * We are at position zero and with only one step, then there is only one way
	 * (stay) => dp[1][0] = 1 We are at position one and with only one step, then
	 * there is only one way (go left) => dp[1][1] = 1
	 * 
	 * Notice that we can only go right as far as many steps we have. For example,
	 * for 500 steps, we can only go as far as the position 500th, doesn't matter if
	 * the arrLen is 99999999. So we use this to avoid memory/time limit.
	 * min(steps,arrLen)
	 */
	    public static int numWays(int steps, int arrLen) {
	        int maxPos = Math.min(steps,arrLen);
	        long[][] dp = new long[steps+1][maxPos+1];
	        
	        dp[1][0]=1;
	        dp[1][1]=1;
	        for(int i = 2; i <= steps; i++) {
	            for(int j = 0; j < maxPos; j++) {
	                dp[i][j] = (dp[i-1][j] + dp[i-1][j+1] + (j>0?dp[i-1][j-1]:0))%1000000007;
	            }
	        }
	        
	        return (int)dp[steps][0];
	    }
	}


