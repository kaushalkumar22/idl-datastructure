package com.ds.binarytree.common;

public class BinaryTreeMaximumPathSum {
	int maxValue;
	TreeNode root;
	public int maxPathSum(TreeNode root) {
		 maxValue = Integer.MIN_VALUE;
		maxPathDown(root);
		return maxValue;
	}

	private int maxPathDown(TreeNode node) {
		if (node == null) return 0;
		int left = Math.max(0, maxPathDown(node.left));
		int right = Math.max(0, maxPathDown(node.right));
		maxValue = Math.max(maxValue, left + right + node.val);
		return Math.max(left, right) + node.val;
	}
	
	public static void main(String args[]) {
		BinaryTreeMaximumPathSum tree = new BinaryTreeMaximumPathSum();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		/*tree.root.left.left = new Node(-8);
		tree.root.left.left.left = new Node(2);
		tree.root.left.left.right = new Node(6);
		tree.root.right.left = new Node(3);
		tree.root.right.right = new Node(9);
		tree.root.right.right.right = new Node(0);
		tree.root.right.right.right.left = new Node(4);
		tree.root.right.right.right.right = new Node(-1);
		tree.root.right.right.right.right.left = new Node(10);*/
		System.out.println("Max pathSum of the given binary tree is "
				+ tree.maxPathSum(tree.root));
	}
}
