package com.ds.advance;
/**
 * Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3

Example 2:

Input: [3,4,-1,1]
Output: 2
algorithm should run in O(n) time and uses constant extra space.
https://leetcode.com/problems/first-missing-positive
 * @author I339640
 *
 */
public class FirstMissingPositiveInteger {

	public static void main(String[] args) {
		int[] nums ={3,4,-1,1};
		System.out.println(firstMissingPositive(nums));
	}
	public static int firstMissingPositive(int[] nums) {
		int n = nums.length;
		for(int i = 0; i < n; i++) {
			while(nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1])
				swap(nums, i, nums[i] - 1);
		}
		for(int i = 0; i < n; i++)
			if(nums[i] != i + 1)
				return i + 1;
		return n + 1;
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
	}
}
