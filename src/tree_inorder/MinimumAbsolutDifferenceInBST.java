package tree_inorder;

import java.util.Arrays;

import tree_levelorder.FindLargestValueInEachTreeRow;
import tree_miscellaneous.TreeNode;
import tree_miscellaneous.TreeUtil;

/**
 * 
 * Given a binary search tree with non-negative values, find the minimum
 * absolute difference between values of any two nodes.
 * 
 * Example:
 * 
 * Input:
 * 1
    \
     3
    /
   2

 * 
 * Output: 1
 * 
 * Explanation: The minimum absolute difference is 1, which is the difference
 * between 2 and 1 (or between 2 and 3).
 *
 * 
 */
public class MinimumAbsolutDifferenceInBST {
	public static void main(String[] args) {

		MinimumAbsolutDifferenceInBST tree = new MinimumAbsolutDifferenceInBST();
		TreeNode root = TreeUtil.createTree(Arrays.asList(1,3,2,5,3,null,9));
		//System.out.println(tree.largestValues( root));
		System.out.println(tree.minDiffInBST( root));
	}
	int minDiff = Integer.MAX_VALUE;
	TreeNode prev;

	public int minDiffInBST(TreeNode root) {
		inorder(root);
		return minDiff;
	}

	public void inorder(TreeNode root) {
		if (root == null) return;
		inorder(root.left);
		if (prev != null) minDiff = Math.min(minDiff, root.val - prev.val);
		prev = root;
		inorder(root.right);
	}
}
