package com.algo.tree.construct;

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

	private TreeNode root;
	private TreeNode head;
	private TreeNode curr;

	private void convertBST2DLL(TreeNode root) {

		if(root==null)
			return;
		if(root.left==null && root.right==null) {
			if(head==null) {
				head=root;
				curr=head;
				return;
			}else {
				curr.right=root;
				root.left=curr;
				curr=curr.right;
				return;
			}
		}

		convertBST2DLL(root.left);

		if(head==null) {
			head = root;
			curr = root;
		}else {
			curr.right=root;
			root.left=curr;
			curr=curr.right;
		}	
		convertBST2DLL(root.right);
	}

	private void printList(TreeNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.right;
		}
	}
	private TreeNode prev = null;
	public void flatten(TreeNode root) {
		if (root == null)
			return;
		flatten(root.right);
		flatten(root.left);
		root.right = prev;
		root.left = null;
		prev = root;
	}
	public static void main(String[] args) {

		ConvertBinaryTreeToDoublyLinkedList tree = new ConvertBinaryTreeToDoublyLinkedList();
		tree.root = new TreeNode(10);
		tree.root.left = new TreeNode(12);
		tree.root.right = new TreeNode(15);
		tree.root.left.left = new TreeNode(25);
		tree.root.left.right = new TreeNode(30);
		tree.root.right.left = new TreeNode(36);
		tree.root.right.right = new TreeNode(40);

		tree.convertBST2DLL(tree.root);
		tree.printList(tree.head);//25 12 30 10 36 15 40
		tree.flatten(tree.root);
		tree.printList(tree.prev);//10 12 25 30 15 36 40 
	}
	
}