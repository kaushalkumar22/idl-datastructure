package com.algo.lds.mustdo.binarysearch;

public class FirstAndLastOccurrenceOfAnElement {

	public static void main(String[] args) {
		int[] nums = {1,2,2,3,3,3,3,3,3,3,3,4,5,6,7,8,9};
		int target=11;
		System.out.println("First index of number 3 is "+firstIndex(nums, target));
		System.out.println("First index of number 3 is "+lastIndex(nums,target));

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

