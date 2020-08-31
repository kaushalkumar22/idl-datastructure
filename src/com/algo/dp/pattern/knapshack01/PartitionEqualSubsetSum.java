package com.algo.dp.pattern.knapshack01;

import java.util.Arrays;

/**
 * 
 * Given a non-empty array containing only positive integers, find if the array
 * can be partitioned into two subsets such that the sum of elements in both
 * subsets is equal.
 * 
 * Note: Each of the array element will not exceed 100. The array size will not exceed 200.
 * 
 * Input: [1, 5, 11, 5]
 * 
 * Output: true
 * 
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * 
 * Input: [1, 2, 3, 5]
 * 
 * Output: false
 * 
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 */
public class PartitionEqualSubsetSum {

	public static void main(String[] args) {
		int[] nums= {1, 2, 5};
		System.out.println(canPartition(nums));
	}
	public static boolean canPartition(int[] nums) {
		int n=nums.length;
		
		if(n<=1) {
			return false;
		}
		int sum = Arrays.stream(nums).sum();
		System.out.println(sum);
		if(sum%2!=0) {
			return false;
		}
		int s =sum/2;
		boolean[][] T= new boolean[n+1][s+1];
		for(int i=0;i<n;i++) 
			T[i][0] = true;
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<s+1;j++) {
				if(nums[i-1]<=j) {
					T[i][j]=T[i-1][j-nums[i-1]]||T[i-1][j];
				}else
					T[i][j]=T[i-1][j];
			}
		}
		return T[n][s];

	}
	public boolean canPartition2(int[] nums) {
	    int sum = 0;
	    
	    for (int num : nums) {
	        sum += num;
	    }
	    
	    if ((sum & 1) == 1) {
	        return false;
	    }
	    sum /= 2;
	    
	    int n = nums.length;
	    boolean[] dp = new boolean[sum+1];
	    Arrays.fill(dp, false);
	    dp[0] = true;
	    
	    for (int num : nums) {
	        for (int i = sum; i > 0; i--) {
	            if (i >= num) {
	                dp[i] = dp[i] || dp[i-num];
	            }
	        }
	    }
	    
	    return dp[sum];
	}
}
