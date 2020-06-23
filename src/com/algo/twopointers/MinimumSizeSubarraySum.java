package com.algo.twopointers;

/**
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a contiguous subarray of which the sum >= s. If there isn't
 * one, return 0 instead.
 * 
 * Example:
 * 
 * Input: s = 7, nums = [2,3,1,2,4,3] Output: 2 Explanation: the subarray [4,3]
 * has the minimal length under the problem constraint.
 * 
 * @author I339640
 *
 */
public class MinimumSizeSubarraySum {

	public int minSubArrayLen(int s, int[] a) {
		if (a == null || a.length == 0)
			return 0;

		int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

		while (j < a.length) {
			sum += a[j++];

			while (sum >= s) {
				min = Math.min(min, j - i);
				sum -= a[i++];
			}
		}

		return min == Integer.MAX_VALUE ? 0 : min;
	}

	/**
	solution step: first move the right till sum>=s then we remove most left one and 
	check whether sum>=s or not if its greater then update the minimal and check if its still sum>=s then do the same and update the minimal
	 sum =2,3,1,2>=7 minimal=4 
	 new sum =3,1,2<7 and minimal=4
	 3, 1,2,4>=7  =>1,2,4>=7 minimal=3; 2,4<=7 minimal=3
	 2,4,3>=7  =>4,3 minimal=2; 3<=7 minimal=2
	*/

		public static int minSubArrayLen1(int s, int[] nums) {

			if (nums == null || nums.length == 0) return 0;
			int right=0;
			int left = 0; 
			int sum = 0; 
			int minimal = Integer.MAX_VALUE;

			for(right=0;right<nums.length;right++){
				sum += nums[right];		
				while (sum >= s) {
					minimal = Math.min(minimal, right-left+1);
					sum -= nums[left];
					left++;
				}
			}
			return minimal == Integer.MAX_VALUE ? 0 : minimal;
		}
}