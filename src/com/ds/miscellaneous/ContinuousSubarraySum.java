package com.ds.miscellaneous;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a list of non-negative numbers and a target integer k, write a function
 * to check if the array has a continuous subarray of size at least 2 that sums
 * up to a multiple of k, that is, sums up to n*k where n is also an integer.
 * 
 * Input: [23, 2, 4, 6, 7], k=6 Output: True Explanation: Because [2,
 * 4] is a continuous subarray of size 2 and sums up to 6. 
 * Input:[23, 2, 6, 4, 7], k=6 Output: True Explanation: Because [23, 2, 6, 4, 7] is
 * an continuous subarray of size 5 and sums up to 42.
 *
 */
public class ContinuousSubarraySum {
	
	/*
	 * We iterate through the input array exactly once, keeping track of the running
	 * sum mod k of the elements in the process. If we find that a running sum value
	 * at index j has been previously seen before in some earlier index i in the
	 * array, then we know that the sub-array (i,j] contains a desired sum.
	 */
	public boolean checkSubarraySum(int[] nums, int k) {
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{put(0,-1);}};;
	    int runningSum = 0;
	    for (int i=0;i<nums.length;i++) {
	        runningSum += nums[i];
	        if (k != 0) runningSum %= k; 
	        Integer prev = map.get(runningSum);
	        if (prev != null) {
	            if (i - prev > 1) return true;
	        }
	        else map.put(runningSum, i);
	    }
	    return false;
	}

}
