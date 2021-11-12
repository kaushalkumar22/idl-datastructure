package com.algo.tree.depth;

import java.util.Arrays;
import java.util.List;

import com.algo.tree.common.TreeNode;
import com.algo.tree.common.TreeUtil;

/**
 * Given a binary tree, you need to compute the length of the diameter of the
 * tree. The diameter of a binary tree is the length of the longest path between
 * any two nodes in a tree. This path may or may not pass through the root.
 * 
 * Given a binary tree
 *        1
         / \
        2   3
       / \     
      4   5    
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * 
 */
public class DiameterOfBinaryTree {
	public static void main(String args[]) {
		DiameterOfBinaryTree tree = new DiameterOfBinaryTree();
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println(tree.diameterOfBinaryTree(root));
		System.out.println(tree.diameterOfBinaryTree1(root));
	}
	public int diameterOfBinaryTree(TreeNode root) {
		return dfs(root)[1];
	}
	public int[] dfs(TreeNode root) {

		// 0th element is height and 1st element is diameter
		int[] result = new int[2];

		if (root == null) return result;

		int[] left  = dfs(root.left);
		int[] right = dfs(root.right);

		result[0] =  1+ Math.max(left[0], right[0]);
		// Diameter = Max ( leftHeight + rightHeight, Max (leftDiameter, rightDiameter) )
		result[1] =  Math.max(left[0] + right[0], Math.max(left[1], right[1]));


		return result;
	}

	int max = 0;



	public int diameterOfBinaryTree1(TreeNode root) {
		maxDepth(root);
		return max;
	}

	private int maxDepth(TreeNode root) {
		if (root == null)
			return 0;

		int left = maxDepth(root.left);
		int right = maxDepth(root.right);

		max = Math.max(max, left + right);

		return Math.max(left, right) + 1;
	}
}