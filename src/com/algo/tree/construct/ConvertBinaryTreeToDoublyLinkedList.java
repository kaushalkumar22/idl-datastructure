package com.algo.tree.construct;

import java.util.Stack;

import com.algo.tree.common.TreeNode;

/*
Given a binary tree, convert it into a doubly linked list as described:
1. We do not have to create a new linked list data structure. We have to convert the tree to a doubly linked list.
2. The doubly linked list should be created such that nodes follow inorder traversal of the binary tree.
3. Left node of the binary tree should be converted to the previous node of the doubly linked list.
4. Right node of the binary tree should be converted to the next node of the doubly linked list.
5. Left most node of the binary tree should be the head of the linked list.
 */
public class ConvertBinaryTreeToDoublyLinkedList {

	public TreeNode treeToDoublyList(TreeNode root) {
		if (root == null)
			return root;
		if (root.left == null && root.right == null) {
			root.left = root;
			root.right = root;
			return root;
		}
		TreeNode head = root, tail = root;
		while (head.left != null)
			head = head.left;
		while (tail.right != null)
			tail = tail.right;
		inorderTraversal(root);
		head.left = tail;
		tail.right = head;
		return head;
	}

	public void inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		TreeNode prevNode = null;
		while (!stack.isEmpty() || node != null) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			TreeNode visitNode = stack.pop();
			visitNode.left = prevNode;
			if (prevNode != null)
				prevNode.right = visitNode;
			node = visitNode.right;
			prevNode = visitNode;
		}
	}

}