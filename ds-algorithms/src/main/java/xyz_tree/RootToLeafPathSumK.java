package xyz_tree;

import java.util.Arrays;
import java.util.List;

import tree_miscellaneous.TreeNode;
import tree_miscellaneous.TreeUtil;
/**
 * Constructed binary tree is
          10
         /  \
        8     2
       / \   /
      3   5 2
 * 
 * Given a tree and a sum, return true if there is a path from the root down to
 * a leaf, such that adding up all the values along the path equals the given
 * sum.
 * 
 * Strategy: subtract the node value from the sum when recurring down, and check
 * to see if the sum is 0 when you run out of tree.
 */
public class RootToLeafPathSumK {

	public static void main(String args[]) {
		RootToLeafPathSumK tree = new RootToLeafPathSumK();
		List<Integer> nums = Arrays.asList(10, 8, 2, 3, 5, 2);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println(tree.haspathSum(root, 21));

	}
	boolean haspathSum(TreeNode node, int sum) {
		if (node == null) return (sum == 0);

		boolean hasSum = false;
		int subsum = sum - node.val;
		if (subsum == 0 && node.left == null && node.right == null)
			return true;
		if (node.left != null)
			hasSum = hasSum || haspathSum(node.left, subsum);
		if (node.right != null)
			hasSum = hasSum || haspathSum(node.right, subsum);
		return hasSum;
	}
}