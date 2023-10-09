package backtracking_permutation_combination;

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
		backtrack(res, new ArrayList<>(),nums,  0);
		return res;
	}

	private static void backtrack(List<List<Integer>> res, List<Integer> subRes,int[] A, int start) {
		
		res.add(new ArrayList<>(subRes));
		
		for(int i = start; i < A.length; i++){
			if(i > start && A[i] == A[i-1]) continue; // skip duplicates
			subRes.add(A[i]);
			backtrack(res, subRes, A, i + 1);
			subRes.remove(subRes.size() - 1);
		}
	} 


}
