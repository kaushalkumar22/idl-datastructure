package com.algo.ads.backtracking.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Subsets Medium
 * 
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * Input: nums = [1,2,3] Output: [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2],
 * [] ]
 *
 * 
 */
public class Subsets{
	public static void main(String[] args) {
		System.out.println(subsets(new int[] {1,2,3}));

	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		backtrack( nums,res, new ArrayList<>(), 0);
		return res;
	}

	private static void backtrack(int[] nums,List<List<Integer>> res, List<Integer> subRes, int start) {

		res.add(new ArrayList<>(subRes));

		for (int i = start; i < nums.length; i++) {
			subRes.add(nums[i]);
			backtrack( nums,res, subRes, i + 1);
			subRes.remove(subRes.size() - 1);
		}
	}
}
