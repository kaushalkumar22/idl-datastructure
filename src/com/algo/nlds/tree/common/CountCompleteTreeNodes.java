package com.algo.nlds.tree.common;

import java.util.Arrays;
import java.util.List;

/**
 * Given a complete binary tree, count the number of nodes.
 * 
 * Definition of a complete binary tree from Wikipedia: In a complete binary
 * tree every level, except possibly the last, is completely filled, and all
 * nodes in the last level are as far left as possible. It can have between 1
 * and 2h nodes inclusive at the last level h.
 *
 Input: 
    1
   / \
  2   3
 / \  /
4  5 6
 * 
 * 
 */
public class CountCompleteTreeNodes {

	public static void main(String[] args) {
		CountCompleteTreeNodes tree = new CountCompleteTreeNodes();
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println(tree.countNodes(root));
		System.out.println(tree.countNodesRec(root));
	}
	public int countNodesRec(TreeNode root) {
		if(root==null) return 0;
		
		return 1+countNodesRec( root.left)+countNodesRec( root.right);

	}
	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		TreeNode left = root, right = root;
		int height = 0;
		while (right != null) {
			left = left.left;
			right = right.right;
			height++;
		}
		if (left == null)
			return (1 << height) - 1;
		return 1 + countNodes(root.left) + countNodes(root.right);
	}

}
