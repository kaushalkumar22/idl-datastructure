package com.algo.ads.backtracking.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen
 * numbers sum to target. You may return the combinations in any order.
 * 
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen
 * numbers is different.
 * 
 * It is guaranteed that the number of unique combinations that sum up to target
 * is less than 150 combinations for the given input.
 * 
 * Input: candidates = [2,3,6,7], target = 7 Output: [[2,2,3],[7]] Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple
 * times. 7 is a candidate, and 7 = 7. These are the only two combinations.
 * 
 * Input: candidates = [2,3,5], target = 8 Output: [[2,2,2,2],[2,3,3],[3,5]]
 * 
 * Input: candidates = [2], target = 1 Output: []
 * 
 * Input: candidates = [1], target = 1 Output: [[1]]
 *  
 * Input: candidates = [1], target = 2 Output: [[1,1]]
 * 
 * Constraints:
 * 
 * 1 <= candidates.length <= 30 
 * 1 <= candidates[i] <= 200 
 * All elements of candidates are distinct. 
 * 1 <= target <= 500
 * 
 * 
 */
public class CombinationSum {

	public static void main(String[] args) {
		int[] candidates = {2,3,6,7}; int target=7;
		System.out.println(combinationSum(candidates, target));
	}
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		dfs(res, new ArrayList<Integer>(), candidates, target, 0);   
		return res;
	}

	static void dfs(List<List<Integer>> res, List<Integer> temp, int A[], int target, int start){
		if(target == 0 ){
			res.add(new ArrayList<Integer>(temp));
			return;
		}
		for(int i = start; i < A.length; i++){
			if(target >= A[i]) {
				temp.add(A[i]);
				dfs(res, temp, A, target - A[i], i);
				temp.remove(temp.size() - 1);
			}
		}
	} 	 
}

