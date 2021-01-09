package com.algo.ads.backtracking.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Combination Sum Medium
 * 
 * Given a set of candidate numbers (candidates) (without duplicates) and a
 * target number (target), find all unique combinations in candidates where the
 * candidate numbers sums to target.
 * 
 * The same repeated number may be chosen from candidates unlimited number of
 * times.
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers. The solution set
 * must not contain duplicate combinations.
 * 
 * Example 1:
 * 
 * Input: candidates = [2,3,6,7], target = 7, A solution set is: [ [7], [2,2,3]
 * ]
 * 
 * Example 2:
 * 
 * Input: candidates = [2,3,5], target = 8, A solution set is: [ [2,2,2,2],
 * [2,3,3], [3,5] ]
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= candidates.length <= 30 1 <= candidates[i] <= 200 Each element of
 * candidate is unique. 1 <= target <= 500
 * 
 * 
 */
public class CombinationSum {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> ans = new ArrayList<>();
		combination(ans, new ArrayList<Integer>(), k, 1, n);
		return ans;
	}

	private void combination(List<List<Integer>> ans, List<Integer> comb, int k, int start, int n) {
		if (comb.size() == k && n == 0) {
			List<Integer> li = new ArrayList<Integer>(comb);
			ans.add(li);
			return;
		}
		for (int i = start; i <= 9; i++) {
			comb.add(i);
			combination(ans, comb, k, i + 1, n - i);
			comb.remove(comb.size() - 1);
		}
	}
}
