package com.algo.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums of integers, you can perform operations on the array. In
 * each operation, you pick any nums[i] and delete it to earn nums[i] points.
 * After, you must delete every element equal to nums[i] - 1 or nums[i] + 1. You
 * start with 0 points. Return the maximum number of points you can earn by
 * applying such operations.
 * 
 * Example 1: Input: nums = [3, 4, 2] Output: 6 Explanation: Delete 4 to earn 4
 * points, consequently 3 is also deleted. Then, delete 2 to earn 2 points. 6
 * total points are earned.
 * 
 * Example 2: Input: nums = [2, 2, 3, 3, 3, 4] Output: 9 Explanation: Delete 3
 * to earn 3 points, deleting both 2's and the 4. Then, delete 3 again to earn 3
 * points, and 3 again to earn 3 points. 9 total points are earned.
 */
public class DeleteAndEarn {

	public static void main(String[] args) {
		
		int[] nums ={2, 2, 3, 3, 3, 4};
		System.out.println(deleteAndEarn(nums));
		System.out.println(deleteAndEarnII(nums));
	}
	/*
	 * If we sort all the numbers into buckets indexed by these numbers, this is
	 * essentially asking you to repetitively take an bucket while giving up the 2
	 * buckets next to it. (the range of these numbers is [1, 10000])
	 * 
	 * 
	 * The optimal final result can be derived by keep updating 2 variables skip_i,
	 * take_i, which stands for: skip_i : the best result for sub-problem of first
	 * (i+1) buckets from 0 to i, while you skip the ith bucket. take_i : the best
	 * result for sub-problem of first (i+1) buckets from 0 to i, while you take the
	 * ith bucket.
	 * 
	 * 
	 * DP formula: take[i] = skip[i-1] + values[i]; skip[i] = Math.max(skip[i-1],
	 * take[i-1]); take[i] can only be derived from: if you skipped the [i-1]th
	 * bucket, and you take bucket[i]. skip[i] through, can be derived from either
	 * take[i-1] or skip[i-1], whatever the bigger; 
	 * 
	 * for numbers from [1 - 10000],
	 * each has a total sum sums[i]; if you earn sums[i], you cannot earn sums[i-1]
	 * and sums[i+1] kind of like house robbing. you cannot rob 2 connected houses.
	 */
	
	public static int deleteAndEarn(int[] nums) {
        final int[] values = new int[10001];
        for (int num : nums) {
            values[num] += num;
        }
        int take = 0, skip = 0;
        for (final int value : values) {
            final int temp = Math.max(skip + value, take);
            skip = take;
            take = temp;
        }
        return take;
    }
	
	 public static  int deleteAndEarnII(int[] nums) {
	        final Map<Integer, Integer> values = new HashMap<>();
	        for (final int num : nums) {
	            values.put(num, values.getOrDefault(num, 0) + num);
	        }
	        int pre = 0, cur = 0;
	        for (final int num : values.keySet()) {
	            if (!values.containsKey(num - 1)) {
	                pre = cur;
	                cur += values.get(num);
	            } else {
	                final int temp = Math.max(pre + values.get(num), cur);
	                pre = cur;
	                cur = temp;
	            }
	        }
	        return cur;
	    }
}
