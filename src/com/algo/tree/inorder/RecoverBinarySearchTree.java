package com.algo.tree.inorder;

import java.util.Arrays;
import java.util.List;

import com.algo.tree.common.TreeNode;
import com.algo.tree.common.TreeUtil;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Example 1:
 * 
 * Input: [1,3,null,null,2]
 * 
 *    1 
 *   / 
 *  3
 *  \ 
 *   2
 * 
 * Output: [3,1,null,null,2]
 * 
 *   3 
 *  / 
 * 1 
 * \ 
 *  2
 * 
 * Example 2:
 * 
 * Input: [3,1,4,null,null,2]
 * 
 *    3
 *   / \ 
 *  1   4 
 *     /
 *    2
 * 
 * Output: [2,1,4,null,null,3]
 * 
 *    2 
 *   / \
 *  1   4 
 *      / 
 *     3
 * 
 * Follow up:
 * 
 * A solution using O(n) space is pretty straight forward. Could you devise a
 * constant space solution?
 *
 */
public class RecoverBinarySearchTree {

	public static void main(String[] args) {
		RecoverBinarySearchTree tree = new RecoverBinarySearchTree();
		List<Integer> nums = (List<Integer>) Arrays.asList(3,1,4,null,null,2);
		TreeNode root = TreeUtil.createTree(nums);
		TreeUtil.inorder(root);
		System.out.println();
		tree.recoverTree(root);
		TreeUtil.inorder(root);
	}

	/*
	 * private void traverse (TreeNode root) { if (root == null) return;
	 * traverse(root.left); // Do some business traverse(root.right); }
	 */
	private TreeNode first;
	private TreeNode second;
	private TreeNode pre;

	public void recoverTree(TreeNode root) {
		if (root == null)
			return;
		first = null;
		second = null;
		pre = null;
		// In order traversal to find the two elements
		inorder(root);
		// Swap the values of the two nodes
		int temp = first.val;
		first.val = second.val;
		second.val = temp;
	}

	private void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);

		// Start of "do some business",
		// If first element has not been found, assign it to prevElement (refer to 6 in
		// the example above)
		if (first == null && (pre == null || pre.val >= root.val)) {
			first = pre;
		}
		// If first element is found, assign the second element to the root (refer to 2
		// in the example above)
		if (first != null && pre.val >= root.val) {
			second = root;
		}
		pre = root;
		
		inorder(root.right);
	}

}
