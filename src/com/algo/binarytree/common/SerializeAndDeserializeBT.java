package com.algo.binarytree.common;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple solution is to store both Inorder and Preorder traversals. This
 * solution requires requires space twice the size of Binary Tree.
 * 
 * We can save space by storing Preorder traversal and a marker for NULL
 * pointers.
 */
public class SerializeAndDeserializeBT {
	private Node root;
	private static List<String> list = new ArrayList<String>();
	private static int index = 0;

	// Encodes a tree to a single list.
	public static void serialize(Node root) {

		if (root == null) {
			list.add("#");
			return;
		}

		list.add(String.valueOf(root.data));
		serialize(root.left);
		serialize(root.right);
	}

	// Decodes your encoded list to tree.
	public static Node deserialize() {

		if (index >= list.size() || list.get(index).equals("#")) {
			index++;
			return null;
		}
		Node root = new Node(Integer.valueOf(list.get(index)));
		index++;
		root.left = deserialize();
		root.right = deserialize();

		return root;
	}

	private void inorderTraversal(Node node) {

		if (node == null)
			return;

		inorderTraversal(node.left);
		System.out.print(node.data + " ");
		inorderTraversal(node.right);
	}

	public static void main(String args[]) {

		SerializeAndDeserializeBT tree = new SerializeAndDeserializeBT();

		/*
		 * tree.root = new Node(1); tree.root.left = new Node(2); tree.root.right = new
		 * Node(3); tree.root.left.left = new Node(4); tree.root.left.right = new
		 * Node(5); tree.root.right.left = new Node(6); tree.root.right.right = new
		 * Node(7); tree.root.right.left.right = new Node(8);
		 * tree.root.right.left.right.left = new Node(11); tree.root.right.right.right =
		 * new Node(9);
		 * 
		 */
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.left.right.right = new Node(5);
		tree.root.left.right.right.right = new Node(9);
		tree.root.left.right.right.right.left = new Node(7);
		tree.root.left.right.right.right.right = new Node(11);

		tree.inorderTraversal(tree.root);
		System.out.println();
		serialize(tree.root);
		Node ret = deserialize();
		tree.inorderTraversal(ret);
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