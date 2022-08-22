package com.algo.backtracking.permutations;

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
		backtrack(res, new ArrayList<>(),nums);
		return res;
	}

	private static void backtrack(List<List<Integer>> res, List<Integer> subRes ,int [] A){

		if(subRes.size() == A.length){
			res.add(new ArrayList<>(subRes));
			return;
		} 
		for(int i = 0; i < A.length; i++){ 
			if(subRes.contains(A[i])) continue; // element already exists, skip
			subRes.add(A[i]);
			backtrack(res, subRes,A);
			subRes.remove(subRes.size() - 1);
		}
	} 
}
