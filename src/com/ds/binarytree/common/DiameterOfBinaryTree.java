package com.ds.binarytree.common;

import java.util.Arrays;
import java.util.List;

/**
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree 
is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Given a binary tree
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * @author I339640
 *
 */
public class DiameterOfBinaryTree {

	private  int maxDiameter;
	int max = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		maxDepth(root);
		return max;
	}

	private int maxDepth(TreeNode root) {
		if (root == null) return 0;

		int left = maxDepth(root.left);
		int right = maxDepth(root.right);

		max = Math.max(max, left + right);

		return Math.max(left, right) + 1;
	}
	

	public  int[] getDiameterOptimized(TreeNode root) {

		//0th element is diameter and 1st element is height
		int[] result = new int[]{0,0};        

		if (root == null)  
			return result;

		int[] leftResult = getDiameterOptimized(root.left);
		int[] rightResult = getDiameterOptimized(root.right);
		int height = Math.max(leftResult[1], rightResult[1]) + 1;

		int rootDiameter = leftResult[1] + rightResult[1] + 1;
		int leftDiameter = leftResult[0];
		int rightDiameter = rightResult[0];

		result[0] = Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
		result[1] = height;

		return result;
	}

	public static void main(String args[]){
		DiameterOfBinaryTree tree = new DiameterOfBinaryTree();
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
		TreeNode root =TreeUtil.createTree(nums);
		System.out.println(tree.getDiameterOptimized(root)[0]);
		System.out.println(tree.diameterOfBinaryTree( root));
	}

}