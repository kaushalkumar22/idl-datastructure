package com.algo.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target, are there elements
 * a, b, c, and d in nums such that a + b + c + d = target? Find all unique
 * quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate quadruplets.
 * 
 * Example:
 * 
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is: [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
 * 
 */
public class FourSum {
	public static void main(String[] args) {
		int nums[] = {-2,0,0,2,2}, target = 0;
		System.out.println( new FourSum().fourSum(nums,target));
	}
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		return kSum(nums, target, 0, 3);
	}
	public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
		List<List<Integer>> res = new ArrayList<>();
		//base case
		if (start == nums.length || nums[start] * k > target || target > nums[nums.length - 1] * k) {
			return res;
		}
		//base case2 to break the recursion
		if (k == 2) {
			return twoSum(nums, target, start);
		}
			
		for (int i = start; i < nums.length; ++i) {
			if(i != start && nums[i] == nums[i-1]) {
				continue;//skip the duplicate
			}
			List<List<Integer>> var = kSum(nums, target - nums[i], i + 1, k - 1);
			for (List<Integer> list : var) {
				res.add(new ArrayList<>(Arrays.asList(nums[i])));
				res.get(res.size() - 1).addAll(list);
			}
		}
		return res;
	}
	public List<List<Integer>> twoSum(int[] nums, int target, int low) {
		List<List<Integer>> res = new ArrayList<>();
		int high=nums.length-1; 				
		while(low<high){	
           int sum = nums[low]+nums[high];
			if(sum==target){
				res.add(Arrays.asList(nums[low],nums[high]));			
				////if there are duplicate need to skip and forward 
				while(low<high&&nums[low]==nums[low+1]) low++;
				//if there are duplicate need to skip and backward 
				while(low<high&&nums[high]==nums[high-1]) high--;

				low++;
				high--;
			}else if(sum<target) {
				low++;
			}else {
				high--;
			}				
		}                    
		return res;
	}
}