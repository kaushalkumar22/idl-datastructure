package com.algo.tree.preorder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.algo.tree.common.TreeNode;
import com.algo.tree.common.TreeUtil;

/**
 * 
 * Find the sum of all left leaves in a given binary tree.
 * 
 * Example:
 * 
 *  3
   / \
  9  20
    /  \
   15   7
 * 
 * There are two left leaves in the binary tree, with values 9 and 15
 * respectively. Return 24.
 *
 * 
 */
public class SumOfLeftLeaves {
	public static void main(String[] args) {
		TreeNode root = TreeUtil.createTree(Arrays.asList(3,9,20,null,null,15,7));
		SumOfLeftLeaves tree = new SumOfLeftLeaves();
		System.out.println(tree.sumOfLeftLeavesRec( root));
		System.out.println(tree.sumOfLeftLeaves( root));
	}
	public int sumOfLeftLeavesRec(TreeNode root) {
		return helper(root, false);
	}

	private int helper(TreeNode root, boolean isLeft) {
		if (root == null) return 0;
		if (root.left == null && root.right == null && isLeft) {
			return root.val;
		}
		return helper(root.left, true) + helper(root.right, false);
	}

	public int sumOfLeftLeaves(TreeNode root) {
		if(root == null || root.left == null && root.right == null) return 0;

		int res = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while(!queue.isEmpty()) {
			TreeNode curr = queue.poll();

			if(curr.left != null && curr.left.left == null && curr.left.right == null) {
				res += curr.left.val;
			}
			if(curr.left != null) queue.offer(curr.left);
			if(curr.right != null) queue.offer(curr.right);
		}
		return res;
	}
}
