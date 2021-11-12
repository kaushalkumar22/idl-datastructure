package com.algo.binarysearch;

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
		int array[] = {2,5,6,0,0,1,2 };
		System.out.println(search(array, 1));
	}

	// O(log n) solution - Binary Search
	public static boolean search(int[] nums, int target) {

		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (target == nums[mid]) {
				return true;
			}
			if (nums[low] == nums[mid]) {//low and mid are duplicate
				low++;
			} else if (nums[high] == nums[mid]) {//high and mid are duplicate
				high--;
			} else if (nums[low] < nums[mid]) {// nums[start.......mid] is sorted
				if (target >= nums[low] && target < nums[mid]) {// need to check target lies between array[start...mid]
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {// nums[mid.......end] is sorted
				if (target > nums[mid] && target <= nums[high]) {//need to check target lies between array[mid...end]
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return false;
	}

}
