package com.algo.binarysearch;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * If target is not found in the array, return [-1, -1].
 * 
 * Follow up: Could you write an algorithm with O(log n) runtime complexity?
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4]
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1]
 *  
 * Input: nums = [], target = 0 Output: [-1,-1]
 * 
 */


public class FindFirstAndLastPositionOfElementInSortedArray {
	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		System.out.println(Arrays.toString(searchRange(nums,6)));
	}
	public static int[] searchRange(int[] nums, int target) {

		int leftIdx = search(nums, target,0, true);

		// assert that `leftIdx` is within the array bounds and that `target`
		// is actually in `nums`.
		if (leftIdx == nums.length || nums[leftIdx] != target) {
			return new int[] {-1,-1};
		}
		int rightIdx = search(nums, target, leftIdx,false);

		return new int[]{leftIdx,rightIdx-1};
	}
	// returns leftmost (or rightmost) index at which `target` should be
	// inserted in sorted array `nums` via binary search.
	private static int search(int[] nums, int target, int low,boolean left) {
		int high = nums.length;
		while (low < high) {
			int mid = (low + high) / 2;
			if (nums[mid] > target || (left && target == nums[mid])) {
				high = mid;
			}
			else {
				low = mid+1;
			}
		}

		return low;
	}
}
