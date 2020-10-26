package com.algo.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = k? 
 * Find all unique triplets in the array which gives the sum of k.
 * The solution set must not contain duplicate triplets.
 * Given array nums = [-1,0,1,2,-1,4], and target = 3.
 * output[[-1, 0, 4], [0, 1, 2]]
 */
public class ThreeSum {
	public static void main (String[] args) { 
		int arr[] = {-1,0,1,2,-1,-4}; 
		System.out.println(threeSum(arr)); 
	} 
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		return threeSum(nums,0);
	}
	public static List<List<Integer>> threeSum(int[] nums,int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for(int i = 0; i<nums.length; i++){
			//if there are duplicate nums[i] then need to skip
			if(i != 0 && nums[i] == nums[i-1]) continue;
			List<List<Integer>> var = twoSum(nums,target-nums[i],i + 1);
			for (List<Integer> list : var) {
				res.add(new ArrayList<>(Arrays.asList(nums[i])));
				res.get(res.size() - 1).addAll(list);
			}
		}
		return res;
	}
	public static List<List<Integer>> twoSum(int[] nums, int target, int low) {
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

