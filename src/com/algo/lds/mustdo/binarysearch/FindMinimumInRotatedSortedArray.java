package com.algo.lds.mustdo.binarysearch;
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
 * Input: [3,4,5,1,2] Output: 1
 * Input: [4,5,6,7,0,1,2] Output: 0
 *
 * 
 */
public class FindMinimumInRotatedSortedArray {
	public static void main(String[] args) {

		//int array[] = {5,6,7,8,1,2,3,4};
		int array[] = {8,7,0,1,2,3,4,5};
		System.out.println( findMin(array));    
	}
	// O(log n) solution - Binary Search
	public static int findMin(int[] num) {

		int start = 0;
		int end = num.length - 1;
		int mid = 0;

		while(start <= end) {
			mid = start + (end - start) / 2;

			if (num[mid] >= num[end]) {
				start = mid + 1;
			}else 
				end = mid;
			//}
		}
		return num[mid];
	}

}

