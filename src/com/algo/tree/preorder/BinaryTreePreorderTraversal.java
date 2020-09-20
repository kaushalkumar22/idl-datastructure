package com.algo.tree.preorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import com.algo.tree.common.TreeNode;
import com.algo.tree.common.TreeUtil;

/**
 * 
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * Input: [1,null,2,3]
 * 1
    \
     2
    /
   3
 
 * Output: [1,2,3]
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 * 
 */
public class BinaryTreePreorderTraversal {

	public static void main(String args[]) {

		BinaryTreePreorderTraversal tree = new BinaryTreePreorderTraversal();
		TreeNode root = TreeUtil.createTree(Arrays.asList(1, null, 2,null,null, 3));
		TreeUtil.inorder(root);
		System.out.println(tree.preorderTraversal(root));
		System.out.println(tree.preorderTraversalRec(root));
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> preOrder = new ArrayList<Integer>();
		if (root == null)
			return preOrder;
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(root);
		while (!st.isEmpty()) {
			TreeNode node = st.pop();
			preOrder.add(node.val);

			if (node.left != null) {
				st.push(node.left);
			}
			if (node.right != null) {
				st.push(node.right);
			}
		}
		return preOrder;

	}

	private List<Integer> preorderTraversalRec(TreeNode root) {
		List<Integer> preOrder = new ArrayList<Integer>();
		helper(root, preOrder);
		return preOrder;
	}

	private void helper(TreeNode root, List<Integer> list) {

		if (root == null)
			return;
		list.add(root.val);
		helper(root.left, list);
		helper(root.right, list);

	}

}
