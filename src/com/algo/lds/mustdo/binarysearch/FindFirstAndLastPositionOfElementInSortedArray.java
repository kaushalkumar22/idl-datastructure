package com.algo.lds.mustdo.binarysearch;

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
         System.out.println(Arrays.toString(searchRange(new int[] {5,7,7,8,8,10}, 6)));
	}
	public static int[] searchRange(int[] nums, int target) {

		if(nums.length==0) return new int[] {-1,-1};
		return new int[] {firstIndex( nums,  target),lastIndex( nums,  target)};
	}
	private static int firstIndex(int[] nums, int target) {
		int start =0;
		int end = nums.length-1;
		int fstIndex =Integer.MAX_VALUE;
		while(start<=end) {
			int mid =start+(end-start)/2;
			if(nums[mid]==target) {
				fstIndex=Math.min(fstIndex, mid);
				end =mid-1;
			}else if(nums[mid]<target) {
				start=mid+1;
			}else {
				end =mid-1;
			}

		}
		return fstIndex ==Integer.MAX_VALUE?-1:fstIndex;
	}

	private static int lastIndex(int[] nums, int target) {

		int start =0;
		int end = nums.length-1;
		int lastIndex =Integer.MIN_VALUE;
		while(start<=end) {
			int mid =start+(end-start)/2;
			if(nums[mid]==target) {
				lastIndex=Math.max(lastIndex, mid);
				start =mid+1;
			}else if(nums[mid]<target) {
				start=mid+1;
			}else {
				end =mid-1;
			}

		}
		return lastIndex ==Integer.MIN_VALUE?-1:lastIndex;
	}
}
