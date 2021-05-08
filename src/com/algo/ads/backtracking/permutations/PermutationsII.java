package com.algo.ads.backtracking.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Permutations II 
 * Given a collection of numbers, nums, that might contain
 * duplicates, return all possible unique permutations in any order.
 * 
 * Input: nums = [1,1,2] Output: [[1,1,2], [1,2,1], [2,1,1]]
 * 
 * Input: nums = [1,2,3] Output:
 * [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *  
 * Constraints:
 * 
 * 1 <= nums.length <= 8 
 * -10 <= nums[i] <= 10
 * 
 */
public class PermutationsII {
	public static void main(String[] args) {
		System.out.println(permuteUnique(new int[] { 1, 1, 2 }));
	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
		return list;
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
		if (tempList.size() == nums.length) {
			list.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]))
					continue;
				used[i] = true;
				tempList.add(nums[i]);
				backtrack(list, tempList, nums, used);
				used[i] = false;
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
