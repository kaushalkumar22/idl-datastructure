package com.ds.binarytree.traversal;


/* 
 * First print the left view except leaves 
 * Print all leaves only
 * print right view bottom up manner(first call recursively then print) except root,included in left view,and leaves.
 *       1
       /   \
      2     3
     / \   / \
    4   5 6   7
           \   \
            8   9
                 \
                  11      
 */
public class BinaryTreeBoundaryViewTraversal{

	private  Node root;

	private	void printLeftBoundary(Node node){
		if (node == null) return;

		if (node.left != null) {
			System.out.print(node.data + " ");
			printLeftBoundary(node.left);
		} else if (node.right != null) {
			System.out.print(node.data + " ");
			printLeftBoundary(node.right);
		}
	}
	private	void printLeaves(Node node) {
		if (node == null) 
			return;

		printLeaves(node.left);
		printLeaves(node.right);
		if (node.left == null && node.right == null) {
			System.out.print(node.data + " ");
		}
	}
	private	void printRightBoundary(Node node) {
		if (node == null) 
			return;

		if (node.right != null) {
			printRightBoundary(node.right);
			System.out.print(node.data + " ");
		} else if (node.left != null) {
			printRightBoundary(node.left);
			System.out.print(node.data + " ");
		}
	}

	private	void printBoundary(Node node) {
		if (node != null) {
			printLeftBoundary(node);
			printLeaves(node);
			printRightBoundary(node.right);
		}
	}
	public static void main(String args[]){

		BinaryTreeBoundaryViewTraversal tree = new BinaryTreeBoundaryViewTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);
		tree.root.right.right.right = new Node(9);
		tree.root.right.right.right.right = new Node(11);
		tree.printBoundary(tree.root);
	}
	private static class Node{
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}
}