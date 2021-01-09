package com.algo.lds.sort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {

		int nums[] = {5,3,8,2,9,12,76,13,1,7,23};
		System.out.println(Arrays.toString(nums));
		quickSort(nums, 0,nums.length-1);
		System.out.println(Arrays.toString(nums));	
	}
	static void quickSort(int[] nums, int low,int high){

		if(low>high) return;
		int pIndex = partition( nums,low,high);
		quickSort(nums,low,pIndex-1);
		quickSort(nums,pIndex+1,high);

	}
	public static int partition(int[] nums,int low,int high) {

		int pIndex =low;
		int pivot = nums[high];
		for(int i=low;i<=high;i++){
			if(nums[i]<pivot){
				swap(nums,i,pIndex);
				pIndex++;
			}
		}
		swap(nums,pIndex,high);
		return pIndex;

	}
	public static void swap(int[] nums,int index,int pIndex){

		int temp =nums[index];
		nums[index]=nums[pIndex];
		nums[pIndex]= temp;
	}
}



