package com.algo.array.pii;

/**
 * Given an array consisting of n integers, find the contiguous subarray of
 * given length k that has the maximum average value. And you need to output the
 * maximum average value.
 *
 * Input: [1,12,-5,-6,50,3], k = 4 Output: 12.75 
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 * 
 * Time complexity O(n)
 */
public class MaximumAverageSubarray {

	public static void main(String[] args) {
		int[] nums = { 1,12,-5,-6,50,3 };
		int k = 4;
		System.out.println(findMaxAverage(nums,  k));	
	}
	
	public static double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0, max;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
        
        max = sum;
        int i=k;
        while(i<n) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
            i++;
        }
        return (double)max/(double)k;
    }
   
	
}