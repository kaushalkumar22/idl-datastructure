package com.algo.lds.mustdo.binarysearch;

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
		int array[] = {10,1,10,10,10};		
		System.out.println( findMin(array));    
	}
	// O(log n) solution - Binary Search
	public static int findMin(int[] num) {

		int start = 0;
		int end = num.length - 1;
		int mid = 0;

		while(start <= end) {
			mid = start + (end - start) / 2;

			if (num[mid] > num[end]) {
				start = mid + 1;
			}else if (num[mid] < num[end]) {
				end = mid;
			}else { // when num[mid] and num[hi] are same
				end--;
			}
		}
		return num[mid];
	}

}
