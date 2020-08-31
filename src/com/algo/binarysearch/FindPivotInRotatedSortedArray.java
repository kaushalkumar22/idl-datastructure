package com.algo.binarysearch;
/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Input: [3,4,5,1,2] Output: 3
 * Input: [4,5,6,7,0,1,2] Output:4
 *
 * 
 */
public class FindPivotInRotatedSortedArray {

	public static void main(String[] args) {

		int array[] = {4,5,6,7,0,1,2};
		System.out.println( findPivotBinarySearch(array));    
	}
	// O(log n) solution - Binary Search
	public static int findPivotBinarySearch(int[] num) {

		int start = 0;
		int end = num.length - 1;
		int mid = 0;

		while(start < end) {
			mid = start + (end - start) / 2;

			if (num[mid] > num[end]) {
				start = mid + 1;
			}else if (num[mid] < num[end]) {
				end = mid;
			}else { // when num[mid] and num[hi] are same
				end--;
			}
		}
		return start;
	}

}

