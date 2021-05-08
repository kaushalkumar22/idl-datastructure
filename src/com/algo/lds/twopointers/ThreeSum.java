package com.algo.lds.twopointers;

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
		System.out.println(threeSum(arr));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		int target=-1;
		List<List<Integer>> res = new ArrayList<>();
		kSum(res,nums, target, 0, 3);
		return res;
	}
	public static List<List<Integer>> kSum(List<List<Integer>> res,int[] nums, int target, int start, int k) {
		
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
			List<List<Integer>> var = kSum(res,nums, target - nums[i], i + 1, k - 1);
			for (List<Integer> list : var) {
				list.add(nums[i]);
				//res.add(new ArrayList<>(Arrays.asList(nums[i])));
		    //res.get(res.size() - 1).add(nums[i]);
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