package com.algo.lds.twopointers;

import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place
 * so that objects of the same color are adjacent, with the colors in the order
 * red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Input: [2,0,2,1,1,0] Output: [0,0,1,1,2,2]
 * 
 * Follow up:
 * 
 * A rather straight forward solution is a two-pass algorithm using counting
 * sort. First, iterate the array counting number of 0's, 1's, and 2's, then
 * overwrite array with total number of 0's, then 1's and followed by 2's. Could
 * you come up with a one-pass algorithm using only constant space?
 *
 * 
 * 
 */
public class SortColors {

	public static void main(String[] args) {
		int[] nums = {2,0,2,1,1,0};
		sortColors( nums);
		System.out.println(Arrays.toString(nums));
	}
	public static void sortColors(int[] nums) {
       int i=0;
       int j=0;
       int k = nums.length-1;
       while(i<=k) {
    	   
    	   if(nums[i]==2) {
    		   if(nums[k]!=2) {
    			   swap(nums,i,k);
    		   }
    		   k--;
    	   }else if(nums[i]==0) {
    		   swap(nums,i,j);
    		   j++;
    		   i++;
    	   }else {
    		   i++;
    	   }
       }
	}
	static void swap(int[] nums,int i,int j) {
		int c = nums[i];
		nums[i]=nums[j];
		nums[j]=c;
	}
}
