package com.ds.binarytree;
/*
Given a binary tree, convert it into a doubly linked list as described:
1. We do not have to create a new linked list data structure. We have to convert the tree to a doubly linked list.
2. The doubly linked list should be created such that nodes follow inorder traversal of the binary tree.
3. Left node of the binary tree should be converted to the previous node of the doubly linked list.
4. Right node of the binary tree should be converted to the next node of the doubly linked list.
5. Left most node of the binary tree should be the head of the linked list.
 */
public class ConstructBT2DLList {

	private Node root;
	private Node head;
	private Node curr;

	private void convertBST2DLL(Node root) {

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

	private void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.right;
		}
	}

	public static void main(String[] args) {

		ConstructBT2DLList tree = new ConstructBT2DLList();
		tree.root = new Node(10);
		tree.root.left = new Node(12);
		tree.root.right = new Node(15);
		tree.root.left.left = new Node(25);
		tree.root.left.right = new Node(30);
		tree.root.right.left = new Node(36);
		tree.root.right.right = new Node(40);

		tree.convertBST2DLL(tree.root);
		tree.printList(tree.head);
	}
	private static class Node {

		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}
}