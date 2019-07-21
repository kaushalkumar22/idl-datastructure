package com.ds.binarytree;

public class CheckBTisSymentric {
	private Node root1, root2;

	// Given two trees, return true if they are structurally identical 
	private boolean isSymentric(Node tree1, Node tree2) {

		if (tree1 == null && tree2 == null) return true;

		if (tree1 == null || tree2 == null) return false;


		return (tree1.data == tree2.data
				&& isSymentric(tree1.left, tree2.right)
				&& isSymentric(tree1.right, tree2.left));
	}

	public static void main(String[] args) {

		CheckBTisSymentric tree = new CheckBTisSymentric();

		tree.root1 = new Node(3);
		tree.root1.left = new Node(1);
		tree.root1.left.left = new Node(0);
		tree.root1.left.left.left = new Node(3);
		tree.root1.left.right = new Node(2);
		tree.root1.left.right.right = new Node(4);

		tree.root1.right = new Node(1);
		tree.root1.right.left = new Node(2);
		tree.root1.right.left.left = new Node(4);
		tree.root1.right.right = new Node(0);	
		tree.root1.right.right.right = new Node(3);



		if (tree.isSymentric(tree.root1, tree.root1)) {
			System.out.println("Tree is Symentric");
		} else {
			System.out.println("Trees is not Symentric");
		}

	}
	private static  class Node {

		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}
}
