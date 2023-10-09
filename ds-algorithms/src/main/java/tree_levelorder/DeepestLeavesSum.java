package tree_levelorder;

import java.util.LinkedList;

import tree_miscellaneous.TreeNode;

/**
 * Given a binary tree, return the sum of values of its deepest leaves.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8] Output: 15
 * 
 * @author IBM
 *
 */
public class DeepestLeavesSum {

	private int maxLevel = 0;
	private int sum = 0;

	public int deepestLeavesSumRec(TreeNode root) {
		if (root == null) return 0;
		calculateSumAtLevel(root, 0);
		return sum;
	}
	private void calculateSumAtLevel(TreeNode root, int level) {

		if (root == null) return;
		if (level > maxLevel) {
			sum = 0;
			maxLevel = level;
		}
		if (level == maxLevel) {
			sum = sum + root.val;
		}
		calculateSumAtLevel(root.left, level + 1);
		calculateSumAtLevel(root.right, level + 1);
	}

	public int deepestLeavesSum(TreeNode root) {
		int res = 0, i;
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			for (i = q.size() - 1, res = 0; i >= 0; --i) {
				TreeNode node = q.poll();
				res += node.val;
				if (node.right != null)
					q.add(node.right);
				if (node.left != null)
					q.add(node.left);
			}
		}
		return res;
	}
}
