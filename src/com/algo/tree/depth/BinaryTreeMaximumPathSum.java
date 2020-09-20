package com.algo.tree.depth;

import java.util.Arrays;
import java.util.List;

import com.algo.tree.common.TreeNode;
import com.algo.tree.common.TreeUtil;

/**
 * 
 * Given a non-empty binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections. The
 * path must contain at least one node and does not need to go through the root.
 * 
 * Example 1:
 *Input: [1,2,3]

       1
      / \
     2   3

Output: 6

Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
 * 
 * 
 * 
 * 
 */
public class BinaryTreeMaximumPathSum {
	public static void main(String args[]) {
		BinaryTreeMaximumPathSum tree = new BinaryTreeMaximumPathSum();
		List<Integer> nums = (List<Integer>) Arrays.asList(-10,9,20,null,null,15,7);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println(tree.maxPathSum(root));
	}

	int max = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		maxSum(root);
		return max;
	}

	private int maxSum(TreeNode root) {
		if (root == null) return 0;
		
		int left  = Math.max(0, maxSum(root.left));
		int right = Math.max(0, maxSum(root.right));
		max = Math.max(max, left + right + root.val);
		
		return Math.max(left, right) + root.val;
		
	}

}
