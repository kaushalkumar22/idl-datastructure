package com.algo.lds.mustdo.binarysearch;

/**
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array nums, where nums[i] != nums[i+1], find a peak element
 * and return its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 * 
 * You may imagine that nums[-1] = nums[n] = -9999999999999999.
 * 
 * 
 * Input: nums = [1,2,3,1] Output: 2 Explanation: 3 is a peak element and your
 * function should return the index number 2.
 * 
 * Input: nums = [1,2,1,3,5,6,4] Output: 1 or 5 Explanation: Your function can
 * return either index number 1 where the peak element is 2, or index number 5
 * where the peak element is 6.
 *
 */
public class PeakElement {
	public static void main(String[] args) {
		int[] array = {2,1 };	
		System.out.println("Peak Element is "+findPeakElement(array));
	}

	static int findPeakElement(int[] num) {
		int start = 0;
		int end = num.length - 1;

		while (start < end) {
			int mid = (start + end) / 2;

			if(mid>start&&num[mid] > num[mid-1]&&num[mid] > num[mid+1]) {
				return mid;
			}else if (num[mid] < num[mid+1])
				start = mid+1;
			else
				end = mid-1;
		}
		return start;
	}

}