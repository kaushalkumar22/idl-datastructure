package com.algo.ads.backtracking.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Combination Sum II Medium
 * 
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sums to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers. The solution set
 * must not contain duplicate combinations.
 * 
 * Example 1:
 * 
 * Input: candidates = [10,1,2,7,6,1,5], target = 8, A solution set is: [ [1,
 * 7], [1, 2, 5], [2, 6], [1, 1, 6] ]
 * 
 * Example 2:
 * 
 * Input: candidates = [2,5,2,1,2], target = 5, A solution set is: [ [1,2,2],
 * [5] ]
 * 
 * 
 */
public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		   List<List<Integer>> list = new LinkedList<List<Integer>>();
		   Arrays.sort(candidates);
		   backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
		   return list;
		}

		private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] cand, int remain, int start) {
		   
		   if(remain < 0) return; /** no solution */
		   else if(remain == 0) list.add(new ArrayList<>(tempList));
		   else{
		      for (int i = start; i < cand.length; i++) {
		         if(i > start && cand[i] == cand[i-1]) continue; /** skip duplicates */
		         tempList.add(cand[i]);
		         backtrack(list, tempList, cand, remain - cand[i], i+1);
		         tempList.remove(tempList.size() - 1);
		      }
		   }
		}
}
