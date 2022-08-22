package com.algo.array1;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given an array nums of n integers where n > 1, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Input: [1,2,3,4] Output: [24,12,8,6] Constraint: It's guaranteed that the
 * product of the elements of any prefix or suffix of the array (including the
 * whole array) fits in a 32 bit integer.
 * 
 * Note: Please solve it without division and in O(n).
 * 
 * Follow up: Could you solve it with constant space complexity? (The output
 * array does not count as extra space for the purpose of space complexity
 * analysis.)
 *
 */
public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		System.out.println(Arrays.toString(productExceptSelf(nums)));

	}

	/*
	 * first from lest side do the product and add in res[] array except self res[i]
	 * = res[i - 1] * nums[i - 1]; from right side store the a[i+1] into right and
	 * to the multiplication with a[i]*right
	 */
	public static int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		res[0] = 1;
		for (int i = 1; i < n; i++) {
			res[i] = res[i - 1] * nums[i - 1];
		}
		int right = 1;
		for (int i = n - 2; i >= 0; i--) {
			right *= nums[i + 1];
			res[i] = res[i]*right;

		}
		return res;
	}
}
