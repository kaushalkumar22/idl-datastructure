package com.algo.lds.twopointers;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, you need to find the total
 * number of continuous subarrays whose sum equals to k.
 * 
 * Example 1: Input:nums = [1,1,1], k = 2 Output: 2
 * 
 * @author I339640
 *
 */
public class SubarraySumEqualsK {
	public static void main(String[] args) {
		int nums[] = {1,1,1}, k = 2;
		System.out.println(subarraySum(nums,k) );
	}
	/*
	 * we know the key to solve this problem is SUM[i, j]. So if we know SUM[0, i - 1] 
	 * and SUM[0, j], then we can easily get SUM[i, j]. To achieve this, we just need 
	 * to go through the array, calculate the current sum and save number of all 
	 * seen PreSum to a HashMap. Time complexity O(n), Space complexity O(n).
	 */

	public static int subarraySum(int[] nums, int k) {
		int sum = 0, result = 0;
		Map<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0, 1);

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (preSum.containsKey(sum - 2)) {
				result += preSum.get(sum - k);
			}
			preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
		}

		return result;
	}
}

