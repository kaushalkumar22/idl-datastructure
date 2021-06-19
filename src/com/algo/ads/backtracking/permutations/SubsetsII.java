package com.algo.ads.backtracking.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Subsets II 
 * 
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Input: [1,2,2] Output: [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 *
 * 
 */
public class SubsetsII {

	public static void main(String[] args) {
		System.out.println(subsets(new int[] {1,2,2}));
	}
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(nums,res, new ArrayList<>(),  0);
		return res;
	}

	private static void backtrack(int[] nums,List<List<Integer>> res, List<Integer> subRes, int start) {
		
		res.add(new ArrayList<>(subRes));
		
		for(int i = start; i < nums.length; i++){
			if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
			subRes.add(nums[i]);
			backtrack(nums,res, subRes,  i + 1);
			subRes.remove(subRes.size() - 1);
		}
	} 


}
