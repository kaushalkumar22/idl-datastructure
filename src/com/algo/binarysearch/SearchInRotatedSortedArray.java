package com.algo.binarysearch;

/**
 * 33. Search in Rotated Sorted Array
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
 *
 * 
 */
public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums = { 3,1 };

		// int[] nums = { 2,5,6,0,0,1,2 };
		//int[] nums = { 1, 3, 1, 1 };
		// int[] nums = { 2,5,6,0,0,1,2};
		// int[] nums = { 3};
		// int nums[] = { 56, 58, 67, 76, 21, 32, 37, 40, 45, 49 };
		System.out.println(search(nums, 1));
		System.out.println(search2(nums, 1));
	}
    //this code will work only if there is no duplicate 
	//SearchInRotatedSortedArrayII will work for both cases
	private static int search(int[] nums, int target) {
	 int start=0;
	 int end =nums.length-1;
	 while(start<=end) {
		 int mid =start+(end-start)/2;
		 if(nums[mid]==target) {
			 return mid;
		 }
		 if(nums[start]<=nums[mid]) {// nums[start.......mid] is sorted
			 if(nums[start]<=target&&target<nums[mid]) {// need to check target lies between array[start...mid]
				 end=mid-1;
			 }else {
				 start=mid+1;
			 }
		 }else {// nums[mid.......end] is sorted
			 if(target<=nums[end]&&target>nums[mid]) {//need to check target lies between array[mid...end]
				 start=mid+1;
			 }else {
				 end=mid-1;
			 }
		 }
	 }
	return -1;
	}

	

	public static int search2(int[] nums, int target) {
		int minIdx = findMinIdx(nums);
		if (target == nums[minIdx])
			return minIdx;
		int m = nums.length;
		int start = (target <= nums[m - 1]) ? minIdx : 0;
		int end = (target > nums[m - 1]) ? minIdx : m - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target)
				return mid;
			else if (target > nums[mid])
				start = mid + 1;
			else
				end = mid - 1;
		}
		return -1;
	}

	public static int findMinIdx(int[] nums) {
		int start = 0, end = nums.length - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] > nums[end])
				start = mid + 1;
			else
				end = mid;
		}
		return start;
	}
}
