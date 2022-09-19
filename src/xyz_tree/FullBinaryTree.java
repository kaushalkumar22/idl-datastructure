package xyz_tree;

import java.util.Arrays;
import java.util.List;

import tree_miscellaneous.TreeNode;
import tree_miscellaneous.TreeUtil;

/*
A full binary tree is defined as a binary tree in which all nodes have either zero or two child nodes. 
Conversely, there is no node in a full binary tree, which has one child node. 
 */
public class FullBinaryTree {

	public static void main(String args[]) {
		FullBinaryTree tree = new FullBinaryTree();
		List<Integer> nums = Arrays.asList(10,20,30,50,40,60,70);
		TreeNode root =TreeUtil.createTree(nums);
		System.out.println(tree.isFullTree(root));

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