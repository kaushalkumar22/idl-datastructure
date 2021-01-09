package com.algo.nlds.tree.validate;

import java.util.Arrays;
import java.util.List;

import com.algo.nlds.tree.common.TreeNode;
import com.algo.nlds.tree.common.TreeUtil;

/**
 * Given two binary trees, write a function to check if they are the same or
 * not.
 * 
 * Two binary trees are considered the same if they are structurally identical
 * and the nodes have the same value.
 * 
 * Example 1:
 * Input: 
 *         1         1
          / \       / \
         2   3     2   3
 * 
 * [1,2,3], [1,2,3]
 * 
 * Output: true
 * 
 * Example 2:
 * Input: 
 *         1         1
          /           \
         2             2

        [1,2],     [1,null,2]
 * Output: false
 * 
 * Example 3:
 * Input:
 *         1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

 * Output: false
 * 
 * 
 */

public class SameTree {
	public static void main(String[] args) {

		SameTree tree = new SameTree();
		List<Integer> nums = Arrays.asList(1, 2);
		TreeNode root1 = TreeUtil.createTree(nums);
		List<Integer> nums1 = Arrays.asList(1, null, 2);
		TreeNode root2 = TreeUtil.createTree(nums1);
		System.out.println(tree.isSameTree(root1, root2));
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {

		if (p == null && q == null) return true;

		if (p == null || q == null) return false;

		if(p.val == q.val)
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		return false;
	}

}