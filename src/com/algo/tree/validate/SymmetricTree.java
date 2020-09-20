package com.algo.tree.validate;

import java.util.Arrays;
import java.util.List;

import com.algo.tree.common.TreeNode;
import com.algo.tree.common.TreeUtil;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center). For example, this binary tree [1,2,2,3,4,4,3] is
 * symmetric:
 *
 *   1
   / \
  2   2
 / \ / \
3  4 4  3

 *But the following [1,2,2,null,3,null,3] is not:
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
		// List<Integer> nums = Arrays.asList(1,2,2,3,4,4,3);
		List<Integer> nums = Arrays.asList(1, 2, 2, null, 3, null, 3);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println(tree.isSymentric(root, root));

	}
	public boolean isSymmetric(TreeNode root) {
		if(root==null)return true;
		return isSymentric( root.left, root.right);

	}
	private boolean isSymentric(TreeNode p, TreeNode q) {

		if (p == null && q == null)
			return true;

		if (p == null || q == null)
			return false;

		if(p.val == q.val)
			return isSymentric(p.left, q.right) && isSymentric(p.right, q.left);
		
		return false;
	}

}
