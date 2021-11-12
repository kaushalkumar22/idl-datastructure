package com.algo.dp.numbers;
/*Kadane’s Algorithm:

Initialize:
    max_so_far = 0
    max_ending_here = 0

Loop for each element of the array
  (a) max_ending_here = max_ending_here + a[i]
  (b) if(max_ending_here < 0)
            max_ending_here = 0
  (c) if(max_so_far < max_ending_here)
            max_so_far = max_ending_here
return max_so_far
*/
public class MaxSubarraySum {
	  public static int findMaxSubarraySum(int[] input) {
	        int curSum = 0;
	        int maxSum = 0;
	        boolean hasAllNegativeNumbers = true;
	        int maxNegativeSum = Integer.MIN_VALUE;
	        for(int i = 0; i < input.length; i++) {
	            if(hasAllNegativeNumbers && input[i] >= 0) {
	                hasAllNegativeNumbers = false;
	            } else if(hasAllNegativeNumbers && maxNegativeSum < input[i]) {
	                maxNegativeSum = input[i];
	            }
	             
	            curSum += input[i];
	            if(curSum < 0) {
	                curSum = 0;
	            }
	            if(maxSum < curSum) {
	                maxSum = curSum;
	            }
	        }
	        return hasAllNegativeNumbers ? maxNegativeSum : maxSum;
	    }
	     
	  public static void main(String[] args) {
    int[] input = {2, -9, 5, 1, -4, 6, 0, -7, 8};
    System.out.println("Maximum subarray sum is " + findMaxSubarraySum(input));
}
}