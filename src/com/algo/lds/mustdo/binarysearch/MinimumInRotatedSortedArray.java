package com.algo.lds.mustdo.binarysearch;

public class MinimumInRotatedSortedArray {

	/**
	 * Find Minimum in Rotated Sorted Array
	 * 
	 * Suppose an array ,assume no duplicate exists in the array, sorted in
	 * ascending order is rotated at some pivot unknown to you beforehand.(i.e.,
	 * [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
	 * 
	 * Input: [3,4,5,1,2] Output: 1
	 * 
	 * Input: [4,5,6,7,0,1,2] Output: 0
	 * 
	 */
public static void main(String[] args) {
	int[] nums = {1,2,3,3,3,7,6,5,4};
	System.out.println(findMin(nums));
	System.out.println(findMax(nums));
	System.out.println(findMin2(nums));
	System.out.println(findmax2(nums));
}
	/*
	 * Looking at subarray with index [start,end]. We can find out that if the
	 * first member is less than the last member, there's no rotation in the
	 * array. So we could directly return the first element in this subarray.
	 * 
	 * If the first element is larger than the last one, then we compute the
	 * element in the middle, and compare it with the first element. If value of
	 * the element in the middle is larger than the first element, we know the
	 * rotation is at the second half of this array. Else, it is in the first
	 * half in the array.
	 */

	private static int findMin(int[] num) {
		int start = 0, end = num.length - 1;

		while (start < end) {
			if (num[start] < num[end])
				return num[start];

			int mid = (start + end) / 2;

			if (num[mid] >= num[start]) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}

		return num[start];
	}
	private static int findMax(int[] num) {
		int start = 0, end = num.length - 1;

		while (start < end) {
			if (num[start] < num[end])
				return start==0?num[end]:num[start-1];

			int mid = (start + end) / 2;

			if (num[mid] >= num[start]) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}

		return start==0?num[end]:num[start-1];
	}
	/**
	 * Find Minimum in Rotated Sorted Array II 
	 * 
	 * Suppose an array ,may contain duplicates,sorted in ascending order is
	 * rotated at some pivot unknown to you beforehand. (i.e., [0,1,2,4,5,6,7]
	 * might become [4,5,6,7,0,1,2]).
	 * 
	 * Input: [1,3,5] Output: 1 Input: [2,2,2,0,1] Output: 0
	 * 
	 */
	private static int findMin2(int[] num) {
		int lo = 0;
		int hi = num.length - 1;
		int mid = 0;

		while (lo < hi) {
			mid = (lo + hi)  / 2;

			if (num[mid] > num[hi]) {
				lo = mid + 1;
			} else if (num[mid] < num[hi]) {
				hi = mid;
			} else { // when num[mid] and num[hi] are same
				hi--;
			}
		}
		return num[lo];
	}
	private static int findmax2(int[] num) {
		int lo = 0;
		int hi = num.length - 1;
		int mid = 0;

		while (lo < hi) {
			mid = (lo + hi) / 2;

			if (num[mid] > num[hi]) {
				lo = mid + 1;
			} else if (num[mid] < num[hi]) {
				hi = mid;
			} else { // when num[mid] and num[hi] are same
				hi--;
			}
		}
		return lo==0?num[hi]:num[lo-1];
	}
}
