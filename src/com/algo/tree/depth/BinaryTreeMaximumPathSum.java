package com.algo.tree.depth;

import java.util.Arrays;
import java.util.List;

import com.algo.tree.common.TreeNode;
import com.algo.tree.common.TreeUtil;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections. The
 * path must contain at least one node and does not need to go through the root.

Input: [1,2,3]

       1
      / \
     2   3

Output: 6

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
 */
public class BinaryTreeMaximumPathSum {
	public static void main(String args[]) {
		BinaryTreeMaximumPathSum tree = new BinaryTreeMaximumPathSum();
		List<Integer> nums = (List<Integer>) Arrays.asList(-10,9,20,null,null,15,7);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println(tree.maxPathSum(root));

	}
	public int maxPathSum(TreeNode root) {
		if (root==null) return 0;
		int[] max = {root.val};
		dfs(root,max);
		return max[0];
	}
	private int dfs(TreeNode root,int[] max){
		if (root==null) return 0;
		int left  = dfs(root.left,max);
		int right = dfs(root.right,max);
		int localMax = Math.max(root.val,Math.max(left,right)+root.val);
		int currMax  = Math.max(localMax, left+right+root.val);
		max[0] = Math.max(currMax, max[0]);
		return localMax;
	}
}

