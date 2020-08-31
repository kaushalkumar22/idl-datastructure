package com.algo.binarytree.validate;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.algo.binarytree.common.TreeNode;
import com.algo.binarytree.common.TreeUtil;

/** 
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
    2
   / \
  1   3

Input: [2,1,3]
Output: true

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 * 
 * Keep track min, max for every node. Initial min and max is very small and very larger
 * number for root. Check if root.data is in this range. When you go left pass min and root.data and 
 * for right pass root.data and max.
 */
public class ValidateBinarySearchTree{

	public static void main(String args[]){

		ValidateBinarySearchTree tree = new ValidateBinarySearchTree();
		List<Integer> nums = Arrays.asList(5,1,4,null,null,3,6);
		TreeNode root =TreeUtil.createTree(nums);

		if (tree.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
			System.out.println("Tree is Binary Search Tree");
		else
			System.out.println("Tree is not Binary Search Tree");

		if (tree.isBSTIterative(root))
			System.out.println("Iterative Tree is Binary Search Tree ");
		else
			System.out.println("Iterative Tree is not Binary Search Tree");
	}
	boolean isBST(TreeNode node,int min,int max)  {
		/* an empty tree is BST */
		if (node == null) return true;

		/* false if this node violates the min/max constraints */
		if (node.val < min || node.val > max) return false;

		/* otherwise check the subtrees recursively tightening the min/max constraints */
		return (isBST(node.left, min, node.val) && isBST(node.right, node.val, max));
	}

	public boolean isBSTIterative(TreeNode root) {

		if (root == null) return true;

		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode node = root;
		int prev = Integer.MIN_VALUE;
		int current;
		while ( true ) {
			if (node != null) {
				stack.addFirst(node);
				node = node.left;
			} else {
				if (stack.isEmpty()) {
					break;
				}
				node = stack.pollFirst();
				current = node.val;
				if (current < prev) {
					return false;
				}
				prev = current;
				node = node.right;
			}
		}
		return true;
	}


}