package com.algo.slidingwindow;

/**
 * Given an array of integers nums and an integer k. A subarray is called nice
 * if there are k odd numbers on it.
 * 
 * Return the number of nice sub-arrays.
 * 
 * Input: nums = [1,1,2,1,1], k = 3 Output: 2 Explanation: The only sub-arrays
 * with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
 * 
 * Input: nums = [2,4,6], k = 1 Output: 0 Explanation: There is no odd numbers
 * in the array.
 * 
 * Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2 Output: 16
 */
public class CountNumberOfNiceSubarrays {

	public static void main(String[] args) {
		int[] nums = {1,1,2,1,1};
		int k = 3;
		System.out.println(numberOfSubarrays(nums,k));

	}
	//Time O(N) for one pass
	//Space O(1)

	public static int numberOfSubarrays(int[] A, int k) {
		int res = 0, i = 0, count = 0, n = A.length;
		for (int j = 0; j < n; j++) {
			if (A[j] % 2 == 1) {//if (A[j] % 2 == 0) {for k even numbers 
				--k;
				count = 0;
			}
			while (k == 0) {
				k += A[i++] %2==1?1:0;//// A[i++] %2==0?1:0; for k even numbers
				++count;
			}
			res += count;
		}
		return res;
	}



}
