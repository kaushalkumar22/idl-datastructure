package tree_validate;

import java.util.Arrays;

import tree_miscellaneous.TreeNode;
import tree_miscellaneous.TreeUtil;

/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly
 * the same structure and node values with a subtree of s. A subtree of s is a
 * tree consists of a node in s and all of this node's descendants. The tree s
 * could also be considered as a subtree of itself.
 *
 * Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2

Given tree t:

   4 
  / \
 1   2

 * Return true, because t has the same structure and node values with a subtree of s.

Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0

 * 
 * Given tree t:
 * 
 *   4 
 *  / \ 
 * 1   2
 * 
 * Return false.
 */
public class SubtreeOfAnotherTree {

	public static void main(String args[]) {

		SubtreeOfAnotherTree tree = new SubtreeOfAnotherTree();
		TreeNode root1 = TreeUtil.createTree(Arrays.asList(26, 10, 3, 4, 6, null, 3, null, 30));
		TreeNode root2 = TreeUtil.createTree(Arrays.asList(10, 4, 6, null, 30));
		System.out.println(tree.isSubtree(root1, root2));
	}

	/* This function returns true if S is a subtree of T, otherwise false */
	private boolean isSubtree(TreeNode s, TreeNode t) {

		if (t == null) return true;
		if (s == null) return false;

		/* Check the tree with root as current node */
		if (isSameTree(s, t)) return true;

		/*
		 * If the tree with root as current node doesn't match then try left and right
		 * subtrees one by one
		 */
		return isSubtree(s.left, t) || isSubtree(s.right, t);
	}
	boolean isSameTree(TreeNode p, TreeNode q) {

		if (p == null && q == null) return true;

		if (p == null || q == null) return false;

		if(p.val == q.val)
			return isSameTree(p.left, q.left)&& isSameTree(p.right, q.right);
		return false;
	}

}
