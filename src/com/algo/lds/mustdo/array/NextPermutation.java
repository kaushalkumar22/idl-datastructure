package com.algo.lds.mustdo.array;

import java.util.Arrays;

/**
 * 
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such an arrangement is not possible, it must rearrange it as the lowest
 * possible order (i.e., sorted in ascending order).
 * 
 * The replacement must be in place and use only constant extra memory.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3] Output: [1,3,2]
 * 
 * Example 2:
 * 
 * Input: nums = [3,2,1] Output: [1,2,3]
 * 
 * Example 3:
 * 
 * Input: nums = [1,1,5] Output: [1,5,1]
 * 
 * Example 4:
 * 
 * Input: nums = [1] Output: [1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 100 0 <= nums[i] <= 100
 *
 * 
 * 
 */
public class NextPermutation {
	public static void main(String[] args) {
		
	}
	public void nextPermutation(int[] nums) {
	        if(nums ==  null) {
	            return ;
	        }
	      
	        for(int i= nums.length-1; i>0; i--){
	            if(nums[i]>nums[i-1]) {
	                int swapIdx = i;
	                int j = i+1;
	                for(j=i+1; j<nums.length; j++) {
	                    if(nums[j]>nums[i-1]) {
	                        swapIdx = j;
	                    }
	                }
	                replace(nums, i-1, swapIdx);
	                reverse(i, nums);
	                return;
	            }
	        }
	        reverse(0, nums);
	    }
	    private void reverse(int start, int[] nums) {
	        for(int i=start, j=nums.length-1; i<j ; i++, j--) {
	            replace(nums,i, j);
	        }
	    }
	    private void replace(int[] nums, int i1, int i2) {
	        int temp = nums[i1];
	        nums[i1] = nums[i2];
	        nums[i2] = temp;
	    }
}
