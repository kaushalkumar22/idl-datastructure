package com.algo.dp.pattern.knapsackunbounded;

/**
 * Given an integer array with all positive numbers and no duplicates, find the
 * number of possible combinations that add up to a positive integer target.
 * 
 * Example:
 * 
 * nums = [1, 2, 3] target = 4
 * 
 * The possible combination ways are: (1, 1, 1, 1) (1, 1, 2) (1, 2, 1) (1, 3)
 * (2, 1, 1) (2, 2) (3, 1)
 * 
 * Note that different sequences are counted as different combinations.
 * 
 * Therefore the output is 7.
 * 
 * @author IBM
 *
 */
public class CombinationSumIV {

	public static void main(String[] args) {
		int nums[] = {1, 2, 3}, target = 4;
		System.out.println(combinationSum4(nums,target));
	}
	public static int combinationSum4(int[] nums, int target) {
		 int[] comb = new int[target + 1];
		    comb[0] = 1;
		    for (int i = 1; i < comb.length; i++) {
		        for (int j = 0; j < nums.length; j++) {
		            if (i - nums[j] >= 0) {
		                comb[i] += comb[i - nums[j]];
		            }
		        }
		    }
		    return comb[target];
	}
}
