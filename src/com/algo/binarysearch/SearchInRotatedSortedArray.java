package com.algo.binarysearch;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		//int nums[] = { 56, 58, 67, 76, 21, 32, 37, 40, 45, 49 };
		System.out.println(search(nums, 0));
		System.out.println(searchUsingBinarySearch(nums, 0));
		System.out.println(search2(nums, 0));
	}

	/**
	 * Suppose an array sorted in ascending order is rotated at some pivot
	 * unknown to you beforehand. (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
	 * 
	 * You are given a target value to search. If found in the array return its
	 * index, otherwise return -1.
	 * 
	 * You may assume no duplicate exists in the array.
	 * 
	 * Your algorithm's runtime complexity must be in the order of O(log n).
	 * 
	 * Input: nums = [4,5,6,7,0,1,2], target = 0 Output: 4
	 *
	 */
	private static int search(int[] nums, int target) {
		int lo = 0, hi = nums.length;
		while (lo < hi) {
			int mid = (lo + hi) / 2;

			double num = (nums[mid] < nums[0]) == (target < nums[0]) ? nums[mid]
					: target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;

			if (num < target)
				lo = mid + 1;
			else if (num > target)
				hi = mid;
			else
				return mid;
		}
		return -1;
	}
	 public static int searchUsingBinarySearch(int[] nums, int target) {
	        if(nums == null || nums.length == 0) {
	            return -1;
	        }
	         
	        int start = 0;
	        int end = nums.length-1;
	         
	        while(start <= end) {
	             
	            int mid = (start + end)/2;
	            if(target == nums[mid]) {
	                return mid;
	            } 
	             
	            if(nums[start] <= nums[mid]) {  // array[start...mid] is sorted
	 
	                if(nums[start] <= target && target <= nums[mid]) { // num lies between array[start...mid]
	                    end = mid-1;
	                } else {
	                    start = mid+1;
	                }
	            } else {   // array[mid...end] is sorted
	                 
	                if(nums[mid] <= target && target <= nums[end]) { // num lies between array[mid...end]
	                    start = mid+1;
	                } else {
	                    end = mid-1;
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

	/**
	 * Suppose an array sorted in ascending order is rotated at some pivot
	 * unknown to you beforehand.
	 * 
	 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
	 * 
	 * You are given a target value to search. If found in the array return
	 * true, otherwise return false.
	 * 
	 * Input: nums = [2,5,6,0,0,1,2], target = 0 Output: true
	 */
	/*
	 * 1) everytime check if targe == nums[mid], if so, we find it.
	 * 
	 * 2) otherwise, we check if the first half is in order (i.e.
	 * nums[left]<=nums[mid]) and if so, go to step 3), otherwise, the second
	 * half is in order, go to step 4)
	 * 
	 * 3) check if target in the range of [left, mid-1] (i.e. nums[left]<=target
	 * < nums[mid]), if so, do search in the first half, i.e. right = mid-1;
	 * otherwise, search in the second half left = mid+1;
	 * 
	 * 4) check if target in the range of [mid+1, right] (i.e. nums[mid]<target
	 * <= nums[right]), if so, do search in the second half, i.e. left = mid+1;
	 * otherwise search in the first half right = mid-1;
	 * 
	 * The only difference is that due to the existence of duplicates, we can
	 * have nums[left] == nums[mid] and in that case, the first half could be
	 * out of order (i.e. NOT in the ascending order, e.g. [3 1 2 3 3 3 3]) and
	 * we have to deal this case separately. In that case, it is guaranteed that
	 * nums[right] also equals to nums[mid], so what we can do is to check if
	 * nums[mid]== nums[left] == nums[right] before the original logic, and if
	 * so, we can move left and right both towards the middle by 1. and repeat.
	 * 
	 */

	boolean searchII(int[] nums, int target) {
		int left = 0, right = nums.length - 1, mid;

		while (left <= right) {
			mid = (left + right) >> 1;
			if (nums[mid] == target)
				return true;

			// the only difference from the first one, trickly case, just update
			// left and right
			if ((nums[left] == nums[mid]) && (nums[right] == nums[mid])) {
				++left;
				--right;
			}

			else if (nums[left] <= nums[mid]) {
				if ((nums[left] <= target) && (nums[mid] > target))
					right = mid - 1;
				else
					left = mid + 1;
			} else {
				if ((nums[mid] < target) && (nums[right] >= target))
					left = mid + 1;
				else
					right = mid - 1;
			}
		}
		return false;
	}

}
