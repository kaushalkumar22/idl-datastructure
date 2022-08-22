package com.algo.tree.preorder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.algo.tree.common.TreeNode;
import com.algo.tree.common.TreeUtil;

/**
 * 
Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9

Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
 *
 */
public class InvertBinaryTree {
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(4, 2, 7, 1,3,6,9);
		TreeNode root = TreeUtil.createTree(nums);
		InvertBinaryTree tree = new InvertBinaryTree();
		tree .invertTreeRec( root);
		TreeUtil.inorder(root);
	}
	public TreeNode invertTreeRec(TreeNode root) {
		if(root==null) return null;

		TreeNode left = root.left;
		root.left = root.right;
		root.right=left;

		invertTree(root.left);
		invertTree(root.right);
		return root;
	}
	//level order 9 7 6 4 3 2 1 
	public TreeNode invertTree(TreeNode root) {

		if (root == null) {
			return null;
		}

		final Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while(!queue.isEmpty()) {
			final TreeNode node = queue.poll();
			final TreeNode left = node.left;
			node.left = node.right;
			node.right = left;

			if(node.left != null) {
				queue.offer(node.left);
			}
			if(node.right != null) {
				queue.offer(node.right);
			}
		}
		return root;
	}
}

