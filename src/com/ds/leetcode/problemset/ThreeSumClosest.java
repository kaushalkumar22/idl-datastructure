package com.ds.leetcode.problemset;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is 
 * closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 */
public class ThreeSumClosest {

	public static void main (String[] args) { 
		int arr[] = {-1, 2, 1, -4}; 
		int target = 1;
		System.out.println(threeSumClosest(arr,target)); 
	} 
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int sum = nums[0] + nums[1] + nums[2];
		int closestSum = sum;

		for(int i = 0; i < nums.length - 2; i++){

			if(i!=0 && nums[i]==nums[i-1]) continue;
			
			int left  = i + 1;
			int right = nums.length - 1;
			
			while(left < right){
				sum = nums[left] + nums[right] + nums[i];
				if(sum < target){
					//move closer to target sum.
					while(left<right && nums[left] == nums[left+1]) left++;	
					left++;
				}else if(sum > target){
					//move closer to target sum.
					while(left<right && nums[right] == nums[right-1]) right--;		
					right--;
				}else{
					return sum;
				}
				//update the closest sum if needed.
				if(Math.abs(target - sum) < Math.abs(target - closestSum)){
					closestSum = sum;
				}
			}
		}
		return closestSum;
	}
}
