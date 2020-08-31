package com.algo.binarysearch;

/**
 * You are given a sorted array consisting of only integers where every element
 * appears exactly twice, except for one element which appears exactly once.
 * Find this single element that appears only once.
 * 
 * Input: [1,1,2,3,3,4,4,8,8] Output: 2
 * Input: [3,3,7,7,10,11,11] Output: 10 
 * 
 * Note:should run in O(log n) time and O(1) space.
 * 
 */
public class SingleElementInASortedArray {

	public static void main(String[] args) {
		int[] nums= {1,1,2,3,3,4,4,8,8};
		System.out.println(singleNonDuplicate(nums));
	}
	/*
	 * If all elements in pair of left side of middle,then first element of the middle pair,
	 * which should be at an even index .

	 * If We didn't find mid and mid+1 as a pair,the single element must be on the left. 
	 * 
	 * Index: 0 1 2 3 4 5 6
	 * Array: 1 1 3 3 4 8 8
	 *            ^
	 *if We found mid and mid+1 as a pair,the single element must be on the right.
	 * 0 1 1 3 3 6 6
	 *     ^ ^
	 * 'start' should always be at the beginning of a pair. 
	 * When 'start > end', start must be the single element.
	 */
	public static int singleNonDuplicate(int[] nums) {
		int start = 0, end = nums.length - 1;

		while (start < end) {

			int mid = (start + end) / 2;
			if (mid % 2 == 1) {
				mid--;
			}
			if (nums[mid] != nums[mid + 1]) {
				end = mid;
			}else {
				start = mid + 2;
			}	
		}
		return nums[start];
	}
}
