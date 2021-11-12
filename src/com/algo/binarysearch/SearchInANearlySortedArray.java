package com.algo.binarysearch;

public class SearchInANearlySortedArray {

	public static void main(String[] args) {
		int[] nums= {5,10,30,20,50};
		int target =5;
		System.out.println(search(nums,target));
	}

	private static int search(int[] nums, int target) {
		int start=0;
		int end = nums.length;
		while(start<=end) {
			int mid= start+(end-start)/2;

			if(nums[mid]==target) {
				return mid;
			}
			if(mid-1>=start&&nums[mid-1]==target) {
				return mid-1;
			}
			if(mid+1<=end&&nums[mid+1]==target) {
				return mid+1;
			}
			if(nums[mid]>target) {
				end=mid-2;
			}else {
				start=mid+2;
			}
		}
		return -1;
	}
}

