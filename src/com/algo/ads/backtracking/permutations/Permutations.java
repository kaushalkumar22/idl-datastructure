package com.algo.ads.backtracking.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutations
 * 
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Input: [1,2,3] Output: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]
 * ]
 * 
 *
 */
public class Permutations {
	public static void main(String[] args) {
		System.out.println(permute(new int[] {1,2,3}));
	}
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		// Arrays.sort(nums); // not necessary
		backtrack(nums ,res, new ArrayList<>());
		return res;
	}

	private static void backtrack(int [] nums,List<List<Integer>> res, List<Integer> subRes ){
		
		if(subRes.size() == nums.length){
			res.add(new ArrayList<>(subRes));
			return;
		} 
		for(int i = 0; i < nums.length; i++){ 
			if(subRes.contains(nums[i])) continue; // element already exists, skip
			subRes.add(nums[i]);
			backtrack(nums,res, subRes);
			subRes.remove(subRes.size() - 1);

		}
	} 
}
