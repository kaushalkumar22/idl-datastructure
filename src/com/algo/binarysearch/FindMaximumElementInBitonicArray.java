package com.algo.binarysearch;

public class FindMaximumElementInBitonicArray {
	
	public static void main(String[] args) {
		int[] nums = {1,3,7,8,12,6,4,1};
		System.out.println(findMax(nums));
	}

	private static int findMax(int[] nums) {
		int start =0;
		int end=nums.length-1;
		while(start<=end) {
			int mid =start+(end-start)/2;
			if(nums[mid-1]<nums[mid]&&nums[mid]>nums[mid+1]) {
				return nums[mid];
			}else if(nums[mid]<nums[mid+1]) {
				start=mid+1;
			}else {
				end=mid-1;
			}
		}
		return nums[start];
	}
}

