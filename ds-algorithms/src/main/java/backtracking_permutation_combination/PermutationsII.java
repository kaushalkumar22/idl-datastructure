package backtracking_permutation_combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
		System.out.println(new PermutationsII().permuteUnique1(new int[] { 1, 1, 2 }));
	}
	public List<List<Integer>> permuteUnique1(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();

		// count the occurrence of each number
		HashMap<Integer, Integer> count = new HashMap<>();
		for (int num : nums) {
			count.put(num, count.getOrDefault(num, 0)+1);
		}
		this.backtrack2(count,nums.length,new ArrayList<>(), results);
		return results;
	}

	private void backtrack2(HashMap<Integer, Integer> map, int n, List<Integer> subRes,
			List<List<Integer>> res) {
		if(subRes.size()==n) {
			res.add(new ArrayList<>(subRes));
			return;
		}
		for (Integer num : map.keySet()) {			
			if ( map.get(num) == 0) continue;
			subRes.add(num);
			map.put(num,map.get(num)-1);
			backtrack2(map, n,  subRes, res) ;
			map.put(num,map.get(num)+1);
			subRes.remove(num);
		}

	}
	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);

		backtrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
		return res;
	}

	private static void backtrack(List<List<Integer>> res, List<Integer> subRes,int[] nums,  boolean[] used) {

		if (subRes.size() == nums.length) {
			res.add(new ArrayList<>(subRes));
			return;
		} 

		for (int i = 0; i < nums.length; i++) {
			if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
			used[i] = true;
			subRes.add(nums[i]);
			backtrack( res, subRes,nums, used);
			used[i] = false;
			subRes.remove(subRes.size() - 1);
		}
	}
}
