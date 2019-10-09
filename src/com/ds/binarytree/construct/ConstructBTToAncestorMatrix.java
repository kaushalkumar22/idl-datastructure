package com.ds.binarytree.construct;



public class ConstructBTToAncestorMatrix {

	private Node root;

	public static void main(String args[]) {

		ConstructBTToAncestorMatrix tree = new ConstructBTToAncestorMatrix();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);

	}
	private static class Node {
		int data;
		Node left, right;
		Node(int item){
			data = item;
			left = right = null;
		}
	}

}
