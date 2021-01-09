package com.algo.nlds.tree.common;

import java.util.List;

public class TreeUtil {
	static TreeNode root;
	/*public static void main(String[] args) {
		List<Integer> nums = (List<Integer>) Arrays.asList(1,2,2,3,3,null,null,4,4);
		System.out.println(nums);
		root=insertLevelOrder(nums, root, 0);
		printInorder(root);
		//t2.root = t2.insertLevelOrder(arr, t2.root, 0); 
	}*/
	public static TreeNode createTree(List<Integer> nums){
		root=null;
		return insertLevelOrder(nums,root,0);
	}
	// Function to insert nodes in level order 
	private static TreeNode insertLevelOrder(List<Integer> nums, TreeNode root, int i) { 
		// Base case for recursion 
		if (i < nums.size()) { 
			TreeNode newNode=null;
			if(nums.get(i)!=null){
				newNode = new TreeNode(nums.get(i));
			}
			root = newNode; 
			// insert left child
			if(root!=null){
				root.left = insertLevelOrder(nums, root.left, 2 * i + 1); 
				// insert right child 
				root.right = insertLevelOrder(nums, root.right,  2 * i + 2); 
			}
		} 
		return root; 
	} 
	public static void inorder(TreeNode node) {
		if (node == null) 
			return;
		inorder(node.left);
		System.out.print(node.val + " ");
		inorder(node.right);
	}
	public static void postorder(TreeNode node) {
		if (node == null) 
			return;
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.val + " ");
	}
	public static void preorder(TreeNode node) {
		if (node == null) 
			return;
		System.out.print(node.val + " ");
		preorder(node.left);
		preorder(node.right);
	}
}
