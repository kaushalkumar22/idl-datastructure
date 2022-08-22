package backtracking_permutation_combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Combination Sum II
 * 
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sum to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * Note: The solution set must not contain duplicate combinations.
 * 
 * Input: candidates = [10,1,2,7,6,1,5], target = 8 Output: [ [1,1,6], [1,2,5],
 * [1,7], [2,6] ]
 * 
 * Input: candidates = [2,5,2,1,2], target = 5 Output: [ [1,2,2], [5] ]
 * 
 * Constraints: 1 <= candidates.length <= 100 
 * 1 <= candidates[i] <= 50 
 * 1 <=target <= 30
 * 
 * Complexity Analysis
 * 
 * Let NNN be the size of the input array.
 * 
 * Time Complexity: O(2^N)
 * 
 * In the worst case, our algorithm will exhaust all possible combinations sfrom
 * the input array, which in total amounts to 2N2^N2N as we discussed before.
 * 
 * The sorting will take O(Nlogâ?¡N)\mathcal{O}(N \log N)O(NlogN).
 * 
 * To sum up, the overall time complexity of the algorithm is dominated by the
 * backtracking process, which is O(2N)\mathcal{O}(2^N)O(2N).
 * 
 * Space Complexity: O(N)\mathcal{O}(N)O(N)
 * 
 * We use the variable comb to keep track of the current combination we build,
 * which requires O(N)\mathcal{O}(N)O(N) space.
 * 
 * In addition, we apply recursion in the algorithm, which will incur additional
 * memory consumption in the function call stack. In the worst case, the stack
 * will pile up to O(N)\mathcal{O}(N)O(N) space.
 * 
 * To sum up, the overall space complexity of the algorithm is
 * O(N)+O(N)=O(N)\mathcal{O}(N) + \mathcal{O}(N) = \mathcal{O}(N)O(N)+O(N)=O(N).
 * 
 * Note: we did not take into account the space needed to hold the final results
 * of combination in the above analysis.
 * 
 */
public class CombinationSumII {

	public static void main(String[] args) {
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		System.out.println(combinationSum(candidates, target));
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		backtrack(res, new ArrayList<Integer>(), candidates, target, 0);   
		return res;
	}

	static void backtrack(List<List<Integer>> res, List<Integer> subRes, int A[],int target, int start){
		if(target == 0 ){
			res.add(new ArrayList<Integer>(subRes));
			return;
		}
		for(int i = start; i < A.length; i++){
			if (target < A[i]||i > start && A[i] == A[i - 1]) continue; /** skip duplicates */
			subRes.add(A[i]);
			backtrack(res, subRes, A,target - A[i], i+1);
			subRes.remove(subRes.size() - 1);
		}
	}
}
