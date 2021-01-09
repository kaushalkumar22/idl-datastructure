package com.algo.lds.slidingwindow;

/**
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a contiguous subarray of which the sum >= s. If there isn't
 * one, return 0 instead. Input: s = 7, nums = [2,3,1,2,4,3] Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem
 * constraint.
 *
 */
public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		System.out.println(minSubArrayLen(7, nums));
	}

	/*
	 *  left: left boundary of window 
	 *  right: right boundary of window 
	 *  sum: sum of sub array 
	 *  min: length of sub array
	 * 
	 * 1. first move the right until sum>=s. 
	 * 2. update the min value
	 * 3. remove most left one and update the sum, 
	 * 4. check whether sum>=s or not, if sum>=s then repeat the step 2,3 until sum<s
	 * 5 start from step 1   
	 *
	 * sum =2,3,1,2>=7  min=4 new sum =3,1,2<7 and min=4 3, 1,2,4>=7 =>1,2,4>=7 min=3;
	 * 2,4<=7 min=3 2,4,3>=7 =>4,3 min=2; 3<=7 min=2
	 * 
	 * time complexity O(n)
	 * space complexity O(1)
	 */
	public static int minSubArrayLen(int s, int[] a) {

		int left = 0; 
		int right; 
		int sum = 0;
		int min = Integer.MAX_VALUE;

		for (right = 0; right < a.length; right++) {
			sum += a[right];
			while (sum >= s) {
				min = Math.min(min, right - left + 1);
				sum -= a[left++];
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}

}
