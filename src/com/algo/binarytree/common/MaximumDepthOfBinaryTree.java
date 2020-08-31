package com.algo.binarytree.common;

import java.util.Arrays;
import java.util.List;

/**
 * Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
Note: A leaf is a node with no children.

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
 
 *
 */
public class MaximumDepthOfBinaryTree {

	/* Compute the "maxDepth" of a tree -- the number of nodes along the 
	 * longest path from the root node down to the farthest leaf node.*/
	private  int maxDepth(TreeNode node) {

		if (node == null) return 0;

		int lDepth = maxDepth(node.left);
		int rDepth = maxDepth(node.right);

		if (lDepth > rDepth) {
			return (lDepth + 1);
		} else {
			return (rDepth + 1);
		}
	}

	public static void main(String[] args) {

		MaximumDepthOfBinaryTree tree = new MaximumDepthOfBinaryTree();
		List<Integer> nums = (List<Integer>) Arrays.asList(1,2,3,4,5);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println("Height of tree is : " + tree.maxDepth(root));
	}
}