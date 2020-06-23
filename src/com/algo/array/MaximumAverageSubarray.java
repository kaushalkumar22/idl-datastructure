package com.algo.array;

/**
 * Given an array consisting of n integers, find the contiguous subarray of
 * given length k that has the maximum average value. And you need to output the
 * maximum average value.
 *
 * Input: [1,12,-5,-6,50,3], k = 4 Output: 12.75 
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 * 
 *
 */
public class MaximumAverageSubarray {

	public static double findMaxAverage(int[] nums, int k) {
        int i, N = nums.length;
        int sum = 0, max = Integer.MIN_VALUE;
        for(i = 0; i < k; i++){
            sum += nums[i];
        }
        
        max = sum;
        for(; i < N; i++){
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }
        
        return (double)max / (double)k;
    }
     
	private static int getMaxAvgSubarrayStartIndex(int input[], int k) {
		int n = input.length;
		if (k > n)
			throw new IllegalArgumentException("k should be less than or equal to n");

		if (k == n) {
			return 0; // whole array is the solution
		}

		// Sum of first k elements
		int sum = input[0];
		for (int i = 1; i < k; i++)
			sum += input[i];

		// Initialized to first k elements sum
		int maxSum = sum;
		int maxSumIndex = 0;

		// Sum of remaining sub arrays
		for (int i = k; i < n; i++) {
			// Remove first element of the current window and add next element
			// to the window
			sum = sum - input[i - k] + input[i];
			if (sum > maxSum) {
				maxSum = sum;
				maxSumIndex = i - k;
			}
		}

		// Return starting index of max avg sub array
		return maxSumIndex + 1;
	}

	public static void printMaxAvgSubarray(int[] input, int k) {
		System.out.print("Maximum average subarray of length " + k + " is:  ");
		int index = getMaxAvgSubarrayStartIndex(input, k);
		for (int i = 0; i < k; i++) {
			System.out.println(input[index++] + " ");
		}
	}

	public static void main(String[] args) {
		int[] nums = { 11, -8, 16, -7, 24, -2, 3 };
		int k = 3;
		printMaxAvgSubarray(nums, k);
		System.out.println(findMaxAverage(nums,  k));
		
	}
}