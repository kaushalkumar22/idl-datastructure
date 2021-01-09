package com.algo.nlds.tree.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.algo.nlds.tree.validate.BalancedBinaryTree;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 *
 *     5
      / \
     4   8
    /   / \
   11  13  4
  /  \      \
 7    2      1

 * 
 */
public class PathSum {

	public static void main(String[] args) {
		PathSum tree=new PathSum();
		List<Integer> nums = (List<Integer>) Arrays.asList(5,4,8,11,null,13,4,7,2,null,null,null,1);
		System.out.println(nums);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println(tree.hasPathSum(root,22));
	}
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root==null) return false;
		//this check to verify the leaf node with sum 
		if(root.left==null&&root.right==null&&(sum - root.val == 0)) return true;
		return hasPathSum( root.left, sum-root.val)||hasPathSum( root.right,sum-root.val);
	}
}
