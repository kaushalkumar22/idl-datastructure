package com.ds.binarytree.validate;

import java.util.Arrays;
import java.util.List;

import com.ds.binarytree.common.TreeNode;
import com.ds.binarytree.common.TreeUtil;

/**
 Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as:
a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
 * @author I339640
 *
 */
public class ValidateBalancedBinaryTree {
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(3,9,20,null,null,15,7);
		TreeNode root =TreeUtil.createTree(nums);
		ValidateBalancedBinaryTree tree = new ValidateBalancedBinaryTree();
		System.out.println(tree.isBalanced(root));
	}
	int depth (TreeNode root) {
        if (root == null) return 0;
        return Math.max (depth(root.left), depth (root.right)) + 1;
    }

    boolean isBalanced (TreeNode root) {
        if (root == null) return true;
        
        int left=depth(root.left);
        int right=depth(root.right);
        
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
}
