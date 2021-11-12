package com.algo.tree.postorder;

import com.algo.tree.common.TreeNode;

/**
 * 
 * Given a binary tree, find the length of the longest path where each node in
 * the path has the same value. This path may or may not pass through the root.
 * 
 * The length of path between two nodes is represented by the number of edges
 * between them.
 * 
Input:

              5
             / \
            4   5
           / \   \
          1   1   5

Output: 2

Input:

              1
             / \
            4   5
           / \   \
          4   4   5

Output: 2

 * Note: The given binary tree has not more than 10000 nodes. The height of the
 * tree is not more than 1000.
 *
 * 
 */
public class LongestUnivaluePath {
	 int len = 0; // global variable
	 public int longestUnivaluePath(TreeNode root) {
	     if (root == null) return 0;
	     len = 0;
	     postorder(root, root.val);
	     return len;
	 }

	 private int postorder(TreeNode node, int val) {
	     if (node == null) return 0;
	     int left = postorder(node.left, node.val);
	     int right = postorder(node.right, node.val);
	     len = Math.max(len, left + right);
	     if (val == node.val)  return Math.max(left, right) + 1;
	     return 0;
	 }
}
