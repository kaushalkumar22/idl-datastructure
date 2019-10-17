package com.ds.binarytree.verify;

import java.util.Arrays;
import java.util.List;

import com.ds.binarytree.common.TreeNode;
import com.ds.binarytree.common.TreeUtil;

/*
A full binary tree is defined as a binary tree in which all nodes have either zero or two child nodes. 
Conversely, there is no node in a full binary tree, which has one child node. 
 */
public class ValidateFullBinaryTree {

	public static void main(String args[]) {
		ValidateFullBinaryTree tree = new ValidateFullBinaryTree();
		List<Integer> nums = Arrays.asList(10,20,30,50,40,60,70);
		TreeNode root =TreeUtil.createTree(nums);
		if(tree.isFullTree(root))
			System.out.print("The binary tree is full");
		else
			System.out.print("The binary tree is not full"); 
	}
	/* this function checks if a binary tree is full or not */
	boolean isFullTree(TreeNode node)  {
		// if empty tree
		if(node == null)  return true;

		// if leaf node
		if(node.left == null && node.right == null )
			return true;

		// if both left and right subtrees are not null the are full
		if((node.left!=null) && (node.right!=null))
			return isFullTree(node.left) && isFullTree(node.right);

		// if none work
		return false;
	}
}