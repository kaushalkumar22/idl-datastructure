package com.algo.greedy;

/**
 * Jump Game II
 * 
 * Given an array of non-negative integers nums, you are initially positioned at
 * the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * You can assume that you can always reach the last index.
 * 
 * Input: nums = [2,3,1,1,4] Output: 2 Explanation: The minimum number of jumps
 * to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to
 * the last index.
 * 
 * Input: nums = [2,3,0,1,4] Output: 2
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 1000 
 * 0 <= nums[i] <= 10^5
 *
 */
public class JumpGameII {

	public static void main(String[] args) {
		int[] nums= {2,3,0,1,4};
		System.out.println(jump(nums));
	}

	public static int jump(int[] nums) {
		int jumps = 0, curEnd = 0, curFarthest = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			curFarthest = Math.max(curFarthest, i + nums[i]);
			if (i == curEnd) {
				jumps++;
				curEnd = curFarthest;
			}
		}
		return jumps;
	}
}
