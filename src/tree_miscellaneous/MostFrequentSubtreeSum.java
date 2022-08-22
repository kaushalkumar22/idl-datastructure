package tree_miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given the root of a tree, you are asked to find the most frequent subtree
 * sum. The subtree sum of a node is defined as the sum of all the node values
 * formed by the subtree rooted at that node (including the node itself). So
 * what is the most frequent subtree sum value? If there is a tie, return all
 * the values with the highest frequency in any order.
 * 
 *   5 
 *  / \ 
 * 2  -3
 * 
 * return [2, -3, 4], since all the values happen only once, return all of them
 * in any order.
 * 
 *   5 
 *  / \
 *  2 -5
 * 
 * return [2], since 2 happens twice, however -5 only occur once.
 *
 */
public class MostFrequentSubtreeSum {

	Map<Integer, Integer> count = new HashMap<Integer, Integer>();
	int maxCount = 0;

	public int[] findFrequentTreeSum(TreeNode root) {
		dfs(root);
		List<Integer> res = new ArrayList<>();
		for (int s : count.keySet()) {
			if (count.get(s) == maxCount)
				res.add(s);
		}
		return res.stream().mapToInt(i -> i).toArray();
	}

	private int dfs(TreeNode root) {
		if (root == null)
			return 0;
		int s = dfs(root.left) + dfs(root.right) + root.val;
		count.put(s, count.getOrDefault(s, 0) + 1);
		maxCount = Math.max(maxCount, count.get(s));
		return s;
	}
}
