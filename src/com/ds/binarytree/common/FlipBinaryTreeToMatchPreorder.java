package com.ds.binarytree.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
Given a binary tree with N nodes, each node has a different value from {1, ..., N}.
A node in this binary tree can be flipped by swapping the left child and the right child of that node.
Consider the sequence of N values reported by a preorder traversal starting from the root.  Call such a sequence of N values the voyage of the tree.
(Recall that a preorder traversal of a node means we report the current node's value, then preorder-traverse the left child, then preorder-traverse the right child.)
Our goal is to flip the least number of nodes in the tree so that the voyage of the tree matches the voyage we are given.
If we can do so, then return a list of the values of all nodes flipped.  You may return the answer in any order.
If we cannot do so, then return the list [-1].
   1
  /
 2
Input: root = [1,2], voyage = [2,1]
Output: [-1]
   1
  / \
 2   3

Input: root = [1,2,3], voyage = [1,3,2]
Output: [1]
   1
  / \
 2   3

Input: root = [1,2,3], voyage = [1,2,3]
Output: []

Global integer i indicates next index in voyage v.
If current node == null, it's fine, we return true
If current node.val != v[i], doesn't match wanted value, return false
If left child exist but don't have wanted value, flip it with right child.
 *
 */
public class FlipBinaryTreeToMatchPreorder {
	public static void main(String[] args) {
		List<Integer> nums = (List<Integer>) Arrays.asList(1,2,3);
		TreeNode root = TreeUtil.createTree(nums);
		int[] v ={1,3,2};
		System.out.println(flipMatchVoyage( root,v));
	}
	static List<Integer> res = new ArrayList<>();
	static int i = 0;
	public static List<Integer> flipMatchVoyage(TreeNode root, int[] v) {
		return dfs(root, v) ? res : Arrays.asList(-1);
	}

	public static Boolean dfs(TreeNode node, int[] v) {
		if (node == null) return true;
		if (node.val != v[i++]) return false;
		if (node.left != null && node.left.val != v[i]) {
			res.add(node.val);
			return dfs(node.right, v) && dfs(node.left, v);
		}
		return dfs(node.left, v) && dfs(node.right, v);
	}
}
