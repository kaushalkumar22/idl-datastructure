package backtracking_permutation_combination;

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
		System.out.println(combine(5,3));
	}

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		backtrack(res, new ArrayList<Integer>(), n, k,1);
		return res;
	}
	public static void backtrack(List<List<Integer>> res, List<Integer> subRes, int n, int k,int start) {
		if(k==0) {
			res.add(new ArrayList<Integer>(subRes));
			return;
		}
		for(int i=start;i<=n;i++) {
			subRes.add(i);
			backtrack(res, subRes,n, k-1,i+1);
			subRes.remove(subRes.size()-1);
		}
	}
}
