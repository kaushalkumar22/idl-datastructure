package com.algo.binarysearch.rotatedsortedarray;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
 * 
 * Input: [1,3,5] Output: 1
 * 
 * Input: [2,2,2,0,1] Output: 0
 * 
 *
 */
public class FindMinimumInRotatedSortedArrayII {
	public static void main(String[] args) {
		int array[] = {2,2,2,1,1,2};		
		System.out.println( findMin(array));    
	}
	// O(log n) solution - Binary Search
	public static int findMin(int[] A) {

		int low = 0;
		int high = A.length - 1;
		int mid = 0;

		while(low <= high) {
			mid = low + (high - low) / 2;

			if (A[mid] > A[high]) {
				low = mid + 1;
			}else if (A[mid] < A[high]) {
				high = mid;
			}else { // when num[mid] and num[hi] are same
				high--;
			}
		}
		return A[mid];
	}

}
