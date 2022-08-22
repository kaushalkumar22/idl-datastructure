package tree_inorder;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import tree_miscellaneous.TreeNode;
import tree_miscellaneous.TreeUtil;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's
 * key. The right subtree of a node contains only nodes with keys greater than
 * the node's key. Both the left and right subtrees must also be binary search
 * trees.
 Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true

Example 2:

    5
   / \
  1   4
     / \
    3   6
 * Input: [5,1,4,null,null,3,6] Output: false Explanation: The root node's value
 * is 5 but its right child's value is 4.
 * 
 * 
 */
public class ValidateBinarySearchTree {

	public static void main(String args[]) {

		ValidateBinarySearchTree tree = new ValidateBinarySearchTree();
		List<Integer> nums = Arrays.asList(1, 2, 3);
		TreeNode root = TreeUtil.createTree(nums);

		System.out.println(tree.isBST(root, Long.MIN_VALUE, Long.MAX_VALUE));
		System.out.println(tree.isValidBST(root));

	}

	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (pre != null && root.val <= pre.val)
				return false;
			pre = root;
			root = root.right;
		}
		return true;
	}

	boolean isBST(TreeNode node, long min, long max) {
		/* an empty tree is BST */
		if (node == null)
			return true;

		/* false if this node violates the min/max constraints */
		if (node.val <= min || node.val >= max)
			return false;

		/*
		 * otherwise check the subtrees recursively tightening the min/max constraints
		 */
		return (isBST(node.left, min, node.val) && isBST(node.right, node.val, max));
	}
}