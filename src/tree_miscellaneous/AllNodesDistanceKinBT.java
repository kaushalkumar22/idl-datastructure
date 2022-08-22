package tree_miscellaneous;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * We are given a binary tree (with root node root), a target node, and an
 * integer value K. Return a list of the values of all nodes that have a
 * distance K from the target node. The answer can be returned in any order.
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2 
 * 
 *           3
 *         /   \
 *        5     1
 *      /  \   / \
 *     6   2   0  8
 *        / \
 *       7   4
 *       
 * Output:[7,4,1]  
 */
public class AllNodesDistanceKinBT {
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println(distanceK(root, root.left, 2));
	}

	public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		List<Integer> res = new LinkedList<>();
		if (K == 0) {
			res.add(target.val);
		} else {
			dfs(res, root, target.val, K, 0);
		}
		return res;
	}

	private static int dfs(List<Integer> res, TreeNode node, int target, int K, int depth) {
		if (node == null)
			return 0;

		if (depth == K) {
			res.add(node.val);
			return 0;
		}

		int left, right;
		if (node.val == target || depth > 0) {
			left = dfs(res, node.left, target, K, depth + 1);
			right = dfs(res, node.right, target, K, depth + 1);
		} else {
			left = dfs(res, node.left, target, K, depth);
			right = dfs(res, node.right, target, K, depth);
		}

		if (node.val == target)
			return 1;

		if (left == K || right == K) {
			res.add(node.val);
			return 0;
		}

		if (left > 0) {
			dfs(res, node.right, target, K, left + 1);
			return left + 1;
		}

		if (right > 0) {
			dfs(res, node.left, target, K, right + 1);
			return right + 1;
		}

		return 0;
	}
	Map<TreeNode, Integer> map = new HashMap<>();

	public List<Integer> distanceK1(TreeNode root, TreeNode target, int K) {
		List<Integer> res = new LinkedList<>();
		find(root, target);
		dfs(root, target, K, map.get(root), res);
		return res;
	}

	// find target node first and store the distance in that path that we could use it later directly
	private int find(TreeNode root, TreeNode target) {
		if (root == null) return -1;
		if (root == target) {
			map.put(root, 0);
			return 0;
		}
		int left = find(root.left, target);
		if (left >= 0) {
			map.put(root, left + 1);
			return left + 1;
		}
		int right = find(root.right, target);
		if (right >= 0) {
			map.put(root, right + 1);
			return right + 1;
		}
		return -1;
	}

	private void dfs(TreeNode root, TreeNode target, int K, int length, List<Integer> res) {
		if (root == null) return;
		if (map.containsKey(root)) length = map.get(root);
		if (length == K) res.add(root.val);
		dfs(root.left, target, K, length + 1, res);
		dfs(root.right, target, K, length + 1, res);
	}

}
