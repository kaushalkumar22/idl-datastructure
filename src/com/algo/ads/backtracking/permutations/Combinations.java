package com.algo.ads.backtracking.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 * 
 * You may return the answer in any order.
 * 
 * Input: n = 4, k = 2 Output: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 * 
 * Input: n = 1, k = 1 Output: [[1]]
 * 
 * Constraints:
 * 
 * 1 <= n <= 20 1 <= k <= n
 *
 * 
 */
public class Combinations {
	public static void main(String[] args) {
		System.out.println(combine(4,2));
	}

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		combine(res, new ArrayList<Integer>(), 1, n, k);
		return res;
	}
	public static void combine(List<List<Integer>> res, List<Integer> subRes, int start, int n, int k) {
		if(k==0) {
			res.add(new ArrayList<Integer>(subRes));
			return;
		}
		for(int i=start;i<=n;i++) {
			subRes.add(i);
			combine(res, subRes, i+1, n, k-1);
			subRes.remove(subRes.size()-1);
		}
	}
}
