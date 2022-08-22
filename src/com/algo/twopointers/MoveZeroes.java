package com.algo.twopointers;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * Input: [0,1,0,3,12] Output: [1,3,12,0,0]
 * 
 * Note:
 * 
 * You must do this in-place without making a copy of the array. Minimize the
 * total number of operations.
 *
 * 
 */
public class MoveZeroes {

	public static void main(String[] args) {
		int[] nums = {0,1,0,3,12};
		moveZeroesBigning(nums);
		System.out.println(Arrays.toString(nums));
		moveZeroesEnd(nums);
		System.out.println(Arrays.toString(nums));
	}
	public void moveZeroes(int[] nums) {
		int i=0,j=0;
		int n =nums.length;
		while(i<n&&j<n){
			if(nums[i]!=0){
				int temp=nums[i];
				nums[i]=nums[j];
				nums[j]=temp;
				i++;
				j++;
			}else{
				i++;
			}
		}
	}
	public static void moveZeroesBigning(int[] nums) {
		int j=0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == 0) {
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
				j++;
			}
		}
	}
	public static void moveZeroesEnd(int[] nums) {
		int j=0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != 0) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				j++;
			}
		}
	}
}
