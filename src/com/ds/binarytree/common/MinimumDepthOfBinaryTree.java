package com.ds.binarytree.common;

import java.util.Arrays;
import java.util.List;

/**
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
Note: A leaf is a node with no children.
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.
 *
 */
public class MinimumDepthOfBinaryTree {

	public static void main(String[] args) {
		MinimumDepthOfBinaryTree tree = new MinimumDepthOfBinaryTree();
		List<Integer> nums = (List<Integer>) Arrays.asList(3,9,20,null,null,15,7);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println("Minimum Depth is : " + tree.minDepth(root));

	}
	 public int minDepth(TreeNode root) {
	        if(root == null) return 0;
	        int left = minDepth(root.left);
	        int right = minDepth(root.right);
	        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
	       
	    }
}
