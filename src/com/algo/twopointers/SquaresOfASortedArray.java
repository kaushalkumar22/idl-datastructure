package com.algo.twopointers;

/**
 * Given an array of integers A sorted in non-decreasing order, return an array
 * of the squares of each number, also in sorted non-decreasing order.
 * Input: [-4,-1,0,3,10] Output: [0,1,9,16,100]
 * 
 * @author I339640
 *
 */
public class SquaresOfASortedArray {
	 public int[] sortedSquares(int[] A) {
	        int n = A.length;
	        int[] result = new int[n];
	        int i = 0, j = n - 1;
	        for (int p = n - 1; p >= 0; p--) {
	            if (Math.abs(A[i]) > Math.abs(A[j])) {
	                result[p] = A[i] * A[i];
	                i++;
	            } else {
	                result[p] = A[j] * A[j];
	                j--;
	            }
	        }
	        return result;
	    }
}
