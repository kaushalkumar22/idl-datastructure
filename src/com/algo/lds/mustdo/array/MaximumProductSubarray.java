package com.algo.lds.mustdo.array;

/**
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 * 
 * Input: [2,3,-2,4] Output: 6 Explanation: [2,3] has the largest product 6.
 * 
 * Input: [-2,0,-1] Output: 0 Explanation: The result cannot be 2, because
 * [-2,-1] is not a subarray.
 
 */
public class MaximumProductSubarray {

	public static void main(String[] args) {
		int[] nums = {2,3,-2,4};
		System.out.println( maxProduct(nums));
	}

	public static int maxProduct(int[] A) {
        int n = A.length, res = A[0], l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            l =  (l == 0 ? 1 : l) * A[i];
            r =  (r == 0 ? 1 : r) * A[n - 1 - i];
            res = Math.max(res, Math.max(l, r));
        }
        return res;
    }
}
