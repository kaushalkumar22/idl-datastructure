package com.algo.lds.mustdo.binarysearch;

/**
 * Search in Rotated Sorted Array II
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return true,
 * otherwise return false.
 * 
 * Input: nums = [2,5,6,0,0,1,2], target = 0 Output: true
 * 
 * Input: nums = [2,5,6,0,0,1,2], target = 3 Output: false
 * 
 * Follow up:
 * 
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may
 * contain duplicates.
 *
 */
public class SearchInRotatedSortedArrayII {
	public static void main(String[] args) {
		// int array[] = {10,1,10,10,10};
		int array[] = { 10, 1, 10, 10, 10 };

		int target = 1;
		System.out.println(findMin(array, target));
	}

	// O(log n) solution - Binary Search
	public static boolean findMin(int[] nums, int target) {

		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (target == nums[mid]) {
				return true;
			}
			if (nums[left] < nums[mid]) {
				if (target >= nums[left] && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else if (nums[left] == nums[mid]) {
				left++;
			} else {
				if (target > nums[mid] && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return false;
	}

}
