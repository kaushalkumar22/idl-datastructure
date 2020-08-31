package com.algo.binarytree.validate;

import java.util.Arrays;
import java.util.List;

import com.algo.binarytree.common.TreeNode;
import com.algo.binarytree.common.TreeUtil;

/**
 * Check if a given Binary Tree is SumTree( Complexity O(n))
 * 
 * A SumTree is a Binary Tree where the value of a node is equal to sum of the
 * nodes present in its left subtree and right subtree. An empty tree is SumTree
 * and sum of an empty tree can be considered as 0. A leaf node is also
 * considered as SumTree.
 * 
 * The Method uses following rules to get the sum directly. 1) If the node is a
 * leaf node then sum of subtree rooted with this node is equal to value of this
 * node. 2) If the node is not a leaf node then sum of subtree rooted with this
 * node is twice the value of this node (Assuming that the tree rooted with this
 * node is SumTree).
 * 
 *          26
           /  \
          10   3
         /  \   \
        4    6   3
 * 
 */

public class ValidateSumTree {

	public static void main(String args[]) {

		ValidateSumTree tree = new ValidateSumTree();
		List<Integer> nums = Arrays.asList(26, 10, 3, 4, 6, null, 3);
		TreeNode root = TreeUtil.createTree(nums);

		if (tree.isSumTree(root)) {
			System.out.println("The given tree is a sum tree");

		} else {
			System.out.println("The given tree is not a sum tree");
		}
	}

	// returns 1 if SumTree property holds for the given tree
	private boolean isSumTree(TreeNode node) {
		int lSubSum; // for sum of nodes in left subtree
		int rSubSum; // for sum of nodes in right subtree
		/* If node is NULL or it's a leaf node then return true */
		if (node == null || isLeafNode(node)) {
			return true;
		}

		if (isSumTree(node.left) && isSumTree(node.right)) {

			// Get the sum of nodes in left subtree
			if (node.left == null) {
				lSubSum = 0;
			} else if (isLeafNode(node.left)) {
				lSubSum = node.left.val;
			} else {
				lSubSum = 2 * (node.left.val);
			}

			// Get the sum of nodes in right subtree
			if (node.right == null) {
				rSubSum = 0;
			} else if (isLeafNode(node.right)) {
				rSubSum = node.right.val;
			} else {
				rSubSum = 2 * (node.right.val);
			}

			/*
			 * If root's data is equal to sum of nodes in left and right subtrees then
			 * return 1 else return 0
			 */
			if ((node.val == rSubSum + lSubSum)) {
				return true;
			}
		}
		return false;
	}

	private boolean isLeafNode(TreeNode node) {
		if (node == null) {
			return false;
		}
		if (node.left == null && node.right == null) {
			return true;
		}
		return false;
	}

}
