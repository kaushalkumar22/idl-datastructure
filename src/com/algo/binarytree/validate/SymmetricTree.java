package com.algo.binarytree.validate;

import java.util.Arrays;
import java.util.List;

import com.algo.binarytree.common.TreeNode;
import com.algo.binarytree.common.TreeUtil;
/**
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
 *
 */
public class SymmetricTree {

	public static void main(String[] args) {

		SymmetricTree tree = new SymmetricTree();
		//List<Integer> nums = Arrays.asList(1,2,2,3,4,4,3);
		List<Integer> nums = Arrays.asList(1,2,2,null,3,null,3);
		TreeNode root =TreeUtil.createTree(nums);

		if (tree.isSymentric(root, root)) {
			System.out.println("Tree is Symentric");
		} else {
			System.out.println("Trees is not Symentric");
		}

	}
	// Given two trees, return true if they are structurally identical 
	private boolean isSymentric(TreeNode tree1, TreeNode tree2) {

		if (tree1 == null && tree2 == null) return true;

		if (tree1 == null || tree2 == null) return false;

		return (tree1.val == tree2.val
				&& isSymentric(tree1.left, tree2.right)
				&& isSymentric(tree1.right, tree2.left));
	}


}
