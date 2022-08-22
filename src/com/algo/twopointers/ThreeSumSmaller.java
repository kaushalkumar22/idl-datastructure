package com.algo.twopointers;

import java.util.Arrays;

/**
 * 
 * Given an array of n integers nums and a target, find the number of index
 * triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] +
 * nums[j] + nums[k] < target. Example
 *  
 * Input: nums = [-2,0,1,3], target = 2 Output: 2 Explanation: Because there are
 * two triplets which sums are less than 2: [-2, 0, 1] [-2, 0, 3]
 * 
 * Input: nums = [-2,0,-1,3], target = 2 Output: 3 
 * Explanation: Because there
 * are three triplets which sums are less than 2: [-2, 0, 1] [-2, 0, 3] [-2, -1, 3]
 * 
 * 
 */
public class ThreeSumSmaller {
	public static void main(String[] args) {
       System.out.println(threeSumSmaller(new int[] {-2,0,1,3}, 2));
	}
	public static int threeSumSmaller(int[] nums, int target) {
		if(nums==null||nums.length<3) return 0;
		Arrays.sort(nums);
		int count=0;
		for(int i=0;i<nums.length-2;i++){

			int left =i+1;
			int right =nums.length-1;
			while(left<right){
				int sum =nums[i]+nums[left]+nums[right];
				if(sum<target){
					//right - left because all elements are less than right
					count=count+right-left;
					left++;

				}else{
					right--;
				}
			}  
		}
		return count;
	}
}
