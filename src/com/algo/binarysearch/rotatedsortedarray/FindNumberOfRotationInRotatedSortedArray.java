package com.algo.binarysearch.rotatedsortedarray;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * 
 * You may assume duplicate exists in the array.
 * 
 * Input: [3,4,5,1,2] Output: 3
 * Input: [4,5,6,7,0,1,2] Output:4
 *
 * 
 */
public class FindNumberOfRotationInRotatedSortedArray {

	public static void main(String[] args) {

		int array[] = {4,4,5,6,6,7,0,1,2};
		System.out.println( findPivotBinarySearch(array));    
	}
	// O(log n) solution - Binary Search
	public static int findPivotBinarySearch(int[] A) {

		int low = 0;
		int high = A.length - 1;
		int mid = 0;

		while(low < high) {
			mid = low + (high - low) / 2;

			if (A[mid] > A[high]) {//if no duplicate A[mid] >= A[high]
				low = mid + 1;
			}else if (A[mid] < A[high]) {
				high = mid;
			}else { // when num[mid] and num[hi] are same
				high--;
			}
		}
		return low;
	}
}