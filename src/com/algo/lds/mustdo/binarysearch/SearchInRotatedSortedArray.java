package com.algo.lds.mustdo.binarysearch;

/**
 * Search in Rotated Sorted Array
 * 
 * Given an integer array nums sorted in ascending order no duplicate, and an integer target.
 * 
 * Suppose that nums is rotated at some pivot unknown to you beforehand (i.e.,
 * [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * You should search for target in nums and if you found return its index,
 * otherwise return -1.
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 0 Output: 4
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 3 Output: -1
 * 
 * Input: nums = [1], target = 0 Output: -1
 */
public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		 int[] nums = { 2,5,6,0,1,2 };
		System.out.println(search(nums, 1));
	}
	//this code will work only if there is no duplicate 
	//SearchInRotatedSortedArrayII will work for both cases
	private static int search(int[] nums, int target) {
		int low=0;
		int high =nums.length-1;
		while(low<=high) {
			int mid =low+(high-low)/2;
			if(nums[mid]==target) {
				return mid;
			}
			if(nums[low]<nums[mid]) {// nums[start.......mid] is sorted
				if(nums[low]<=target&&target<nums[mid]) {// need to check target lies between array[start...mid]
					high=mid-1;
				}else {
					low=mid+1;
				}
			}else {// nums[mid.......end] is sorted
				if(target<=nums[high]&&target>nums[mid]) {//need to check target lies between array[mid...end]
					low=mid+1;
				}else {
					high=mid-1;
				}
			}
		}
		return -1;
	}
}
