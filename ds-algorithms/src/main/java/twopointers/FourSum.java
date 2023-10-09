package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target, are there elements
 * a, b, c, and d in nums such that a + b + c + d = target?
 *<p>
 * Find all unique quadruplets in the array which gives the sum of target.
 *<p>
 * Note:
 *<p>
 * The solution set must not contain duplicate quadruplets.
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *<p>
 * A solution set is: [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
 *
 */
public class FourSum {
	public static void main(String[] args) {
		int nums[] = {1, 0, -1, 0, -2, 2}, target = 0;
		System.out.println( new FourSum().fourSum2(nums,target));
	}
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		return kSum(nums, target, 0, 4);
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

	public List<List<Integer>> fourSum2(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 4) {
			return res;
		}

		Arrays.sort(nums);
		int n = nums.length;

		for (int i = 0; i < n - 3; ++i) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < n - 2; ++j) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}

				int low =j+1,high=n-1;
				while(low<high){
					int sum =nums[i]+nums[j]+ nums[low]+nums[high];
					if(sum==target){
						res.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
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
			}
		}
		return res;
	}
}