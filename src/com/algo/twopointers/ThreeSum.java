package com.algo.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum
 * of zero.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 *  
 * Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]]
 *  
 * Input: nums = [] Output: []
 * 
 * Input: nums = [0] Output: []
 * 
 * Constraints:
 * 
 * 0 <= nums.length <= 3000 
 * -10^5 <= nums[i] <= 10^5
 * 
 */
public class ThreeSum {
	public static void main(String[] args) {
		int arr[] = { -4,-1,-1, 0, 1, 2 };
		//System.out.println(threeSum(arr));
		System.out.println(new ThreeSum().threeSum(arr));
	}

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		return kSum(nums, 0, 0, 3);
	}

	public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
		List<List<Integer>> res = new ArrayList<>();

		// If we have run out of numbers to add, return res.
		if (start == nums.length) {
			return res;
		}

		// There are k remaining values to add to the sum. The 
		// average of these values is at least target / k.
		int average_value = target / k;

		// We cannot obtain a sum of target if the smallest value
		// in nums is greater than target / k or if the largest 
		// value in nums is smaller than target / k.
		if  (nums[start] > average_value || average_value > nums[nums.length - 1]) {
			return res;
		}

		if (k == 2) {
			return twoSum(nums, target, start);
		}

		for (int i = start; i < nums.length; ++i) {
			if (i == start || nums[i - 1] != nums[i]) {
				for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
					res.add(new ArrayList<>(Arrays.asList(nums[i])));
					res.get(res.size() - 1).addAll(subset);
				}
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
	public static List<List<Integer>> threeSum2(int[] nums) {
		Arrays.sort(nums);
		int target=0;
		List<List<Integer>> res = new ArrayList<>();

		for(int i=0;i<nums.length-2;i++){
			if(i>0&&nums[i-1]==nums[i]) continue;
			int low =i+1,high = nums.length-1;
			while(low<high){
				int sum = nums[i]+nums[low]+nums[high];
				if(sum==target){
					res.add(Arrays.asList(nums[i],nums[low],nums[high]));

					while(low<high&&nums[low]==nums[low+1])low++;
					while(low<high&&nums[high]==nums[high-1])high--;
					low++;
					high--;
				}else if(sum<target){
					low++;
				}else{
					high--;
				}
			}
		}
		return res;
	}
}