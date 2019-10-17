package com.ds.binarytree.verify;

import java.util.Arrays;
import java.util.List;

import com.ds.binarytree.common.TreeNode;
import com.ds.binarytree.common.TreeUtil;

/**
 * 
Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
1. If both trees are empty then return true.
2. Else If both trees are non -empty
     (a) Check data of the root nodes (tree1.data ==  tree2.data)
     (b) Check left subtrees recursively  i.e., 
	     call sameTree(tree1.left, tree2.left)
     (c) Check right subtrees recursively  i.e., 
	     call sameTree(tree1.right_subtree, tree2.right_subtree)
     (d) If a,b and c are true then return 1.
3  Else return false (one is empty and other is not)

 */

public class IdenticalTree {

	// Given two trees, return true if they are structurally identical 
	private boolean identicalTrees(TreeNode tree1, TreeNode tree2) {

		if (tree1 == null && tree2 == null) return true;

		if (tree1 == null || tree2 == null) return false;

		
			return (tree1.val == tree2.val
					&& identicalTrees(tree1.left, tree2.left)
					&& identicalTrees(tree1.right, tree2.right));
	}

	public static void main(String[] args) {

		IdenticalTree tree = new IdenticalTree();
		//List<Integer> nums = Arrays.asList(1,2,3,4,5);
		List<Integer> nums = Arrays.asList(1,2);
		TreeNode root1 =TreeUtil.createTree(nums);
		//List<Integer> nums1 = Arrays.asList(1,2,3,4,6);
		List<Integer> nums1 = Arrays.asList(1,null,2);
		TreeNode root2 =TreeUtil.createTree(nums1);

		if (tree.identicalTrees(root1,root2)) {
			System.out.println("Both trees are identical");
		} else {
			System.out.println("Trees are not identical");
		}

	}
}