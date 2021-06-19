package com.algo.ads.backtracking.permutations;

import java.util.Arrays;

/**
 * 
 * Given an array of integers nums and a positive integer k, find whether it's
 * possible to divide this array into k non-empty subsets whose sums are all
 * equal.
 * 
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4 Output: True Explanation: It's
 * possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal
 * sums.
 *
 */
public class PartitionToKEqualSumSubsets {

	public static void main(String[] args) {
		int nums[] = {4, 3, 2, 3, 5, 2, 1}, k = 4;
		System.out.println(canPartitionKSubsets(nums,k));
	}	   
	
	public static boolean canPartitionKSubsets(int[] A, int k) {
		if (k > A.length) return false;
		int sum = 0;
		for (int num : A) sum += num;
		if (sum % k != 0) return false;
		Arrays.sort(A);
		return backtrack(A, 0, A.length - 1, new boolean[A.length], sum / k, k);
	}

	public static boolean backtrack(int[] A, int sum, int st, boolean[] visited, int target, int round) {
	
		if (round == 0||sum == target && backtrack(A, 0, A.length - 1, visited, target, round - 1))
			return true;
		for (int i = st; i >= 0; --i) {
			if (!visited[i] && sum + A[i] <= target) {
				visited[i] = true;
				if (backtrack(A, sum + A[i], i - 1, visited, target, round))
					return true;
				visited[i] = false;
			}
		}
		return false;
	}
}
