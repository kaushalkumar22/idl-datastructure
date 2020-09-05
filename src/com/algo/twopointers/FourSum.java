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
		int nums[] = {1, 0, -1, 0, -2, 2}, target = 0;
		System.out.println( fourSum(nums,target));
	}
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if(nums == null || nums.length < 4){ 
			return res;
		}
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 3; i++){
			if(i > 0 && nums[i - 1] == nums[i]){   //avoid duplicated
				continue;
			}
			for(int j = i + 1; j < nums.length - 2; j++){
				if(j > i + 1 && nums[j] == nums[j - 1]){   //avoid duplicated
					continue;
				}
				int left = j + 1, right = nums.length - 1;
				while(left < right){
					int curr = nums[i] + nums[j] + nums[left] + nums[right];
					if(curr == target){
						List<Integer> t = helper(nums, i, j, left, right);
						res.add(new ArrayList<Integer>(t));
						left++; right--;
						while(left < right && nums[left] == nums[left - 1]){
							left++;
						}
						while(left < right && nums[right] == nums[right + 1]){
							right--;
						}
					}else if(curr > target){
						right--;
					}else{
						left++;
					}
				}
			}
		}
		return res;
	}
	private static List<Integer> helper(int[] nums, int i, int j, int k, int l){
		List<Integer> t = new ArrayList<>();
		t.add(nums[i]); t.add(nums[j]); t.add(nums[k]); t.add(nums[l]);
		return t;
	}
}
