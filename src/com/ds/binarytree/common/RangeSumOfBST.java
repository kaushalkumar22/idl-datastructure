package com.ds.binarytree.common;
/**
Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
The binary search tree is guaranteed to have unique values.
Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
Output: 32

Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
Output: 23

 *
 */
public class RangeSumOfBST {

	
	 public int rangeSumBST(TreeNode root, int L, int R) {
	        if (root == null) return 0; // base case.
	        if (root.val < L) return rangeSumBST(root.right, L, R); // left branch excluded.
	        if (root.val > R) return rangeSumBST(root.left, L, R); // right branch excluded.
	        return root.val + rangeSumBST(root.right, L, R) + rangeSumBST(root.left, L, R); // count in both children.
	    }
}
