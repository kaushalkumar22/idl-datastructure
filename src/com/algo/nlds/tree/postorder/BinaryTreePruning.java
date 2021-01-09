package com.algo.nlds.tree.postorder;

import java.util.Arrays;
import java.util.List;

import com.algo.nlds.tree.common.TreeNode;
import com.algo.nlds.tree.common.TreeUtil;

/**
 * We are given the head node root of a binary tree, where additionally every
 * node's value is either a 0 or a 1. Return the same tree where every subtree
 * (of the given tree) not containing a 1 has been removed. (Recall that the
 * subtree of a node X is X, plus every node that is a descendant of X.) Input:
 * [1,null,0,0,1] Output: [1,null,0,null,1]
 * 
 * Only the red nodes satisfy the property "every subtree not containing a 1".
 * The diagram on the right represents the answer.
 * 
 * Input: [1,0,1,0,0,0,1] Output: [1,null,1,null,1]
 * 
 * Input: [1,1,0,1,1,0,1,0] Output: [1,1,0,1,1,null,1]
 *
 */
public class BinaryTreePruning {

	public static void main(String[] args) {
		BinaryTreePruning tree = new BinaryTreePruning();
		List<Integer> nums = Arrays.asList(1, 0, 1, 0, 0, 0, 1);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println(tree.pruneTree(root));
	}

	public TreeNode pruneTree(TreeNode root) {
		if (root == null)
			return null;
		root.left = pruneTree(root.left);
		root.right = pruneTree(root.right);
		if (root.left == null && root.right == null && root.val == 0)
			return null;
		return root;
	}
}
