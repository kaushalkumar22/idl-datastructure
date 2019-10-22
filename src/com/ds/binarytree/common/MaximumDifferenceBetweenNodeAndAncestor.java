package com.ds.binarytree.common;

import java.util.Arrays;
import java.util.List;

/**
 * Given the root of a binary tree, find the maximum value V for which there exists different nodes A and B where V = |A.val - B.val| 
 * and A is an ancestor of B.
(A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an ancestor of B.)
Input: [8,3,10,1,6,null,14,null,null,4,7,13]
Output: 7
Explanation: 
We have various ancestor-node differences, some of which are given below :
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.

 */
public class MaximumDifferenceBetweenNodeAndAncestor{

	public int maxAncestorDiff(TreeNode root) {
		return dfs(root, root.val, root.val);
	}
	public int dfs(TreeNode root, int mn, int mx) {
		if (root == null) return mx - mn;
		mx = Math.max(mx, root.val);
		mn = Math.min(mn, root.val);
		return Math.max(dfs(root.left, mn, mx), dfs(root.right, mn, mx));
	}
	public static void main(String args[]) {
		MaximumDifferenceBetweenNodeAndAncestor tree = new MaximumDifferenceBetweenNodeAndAncestor();
		List<Integer> nums = (List<Integer>) Arrays.asList(8,3,10,1,6,null,14,null,null,4,7,13);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println("Maximum Difference Between Node and Ancestor  : " + tree.maxAncestorDiff(root));

		/*	root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);
		root.right.right.right = new Node(9);
		root.right.right.right.right = new Node(8);
		 */
	}
}