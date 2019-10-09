package com.ds.binarytree.construct;

public class ConvertBinaryTreeIntoMirror {

	private Node root;
	
	private void mirror(Node node) {
		if (node == null) {
			return;
		} 

		mirror(node.left);
		mirror(node.right);

		/* swap the objects/values in this node */
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
	}

	private void inOrder(Node node) {
		if (node == null) {
			return;
		}

		inOrder(node.left);
		System.out.print(node.data);
		inOrder(node.right);
	}

	public static void main(String args[]) {

		ConvertBinaryTreeIntoMirror tree = new ConvertBinaryTreeIntoMirror();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		/* print inorder traversal of the input tree */
		System.out.println("Inorder traversal of input tree is :");
		tree.inOrder(tree.root);
		System.out.println("");

		/* convert tree to its mirror */
		tree.mirror(tree.root);

		/* print inorder traversal of the minor tree */
		System.out.println("Inorder traversal of binary tree is : ");
		tree.inOrder(tree.root);

	}
	static class Node {

		int data;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}
}