package com.ds.binarysearch;
/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

 * @author IBM
 *
 */
public class SearchInRotatedSortedArray {
	
	public static void main(String[] args) {
		int[] nums = {5,6,7,0,1,2,3,4};
				System.out.println(search(nums,2));
	}
	static int search(int[] nums, int target) {
	    int low = 0, high = nums.length;
	    while (low < high) {
	        int mid = (low + high) / 2;
	        
	        int num = ((nums[mid] < nums[0])==(target < nums[0])) ? nums[mid]
	                   : target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
	                   
	        if (num < target)
	            low = mid + 1;
	        else if (num > target)
	            high = mid;
	        else
	            return mid;
	    }
	    return -1;
	}
}
