package com.ds.binarytree.verify;

/*
 * Check if a given Binary Tree is SumTree( Complexity O(n))

A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present in its 
left subtree and right subtree. An empty tree is SumTree and sum of an empty tree can be considered as 0.
A leaf node is also considered as SumTree.

The Method uses following rules to get the sum directly.
1) If the node is a leaf node then sum of subtree rooted with this node is equal to value of this node.
2) If the node is not a leaf node then sum of subtree rooted with this node is twice the value of this node 
(Assuming that the tree rooted with this node is SumTree).

            26
           /  \
          10   3
         /  \   \
        4    6   3
 */

public class CheckBTIsSumTree {

	private Node root;

	// returns 1 if SumTree property holds for the given tree 
	private boolean isSumTree(Node node) {
		int lSubSum; // for sum of nodes in left subtree 
		int rSubSum; // for sum of nodes in right subtree 
		/* If node is NULL or it's a leaf node then return true */
		if (node == null || isLeafNode(node)) {
			return true;
		}

		if (isSumTree(node.left)  && isSumTree(node.right) ) {

			// Get the sum of nodes in left subtree
			if (node.left == null) {
				lSubSum = 0;
			} else if (isLeafNode(node.left) ) {
				lSubSum = node.left.data;
			} else {
				lSubSum = 2 * (node.left.data);
			}

			// Get the sum of nodes in right subtree
			if (node.right == null) {
				rSubSum = 0;
			} else if (isLeafNode(node.right) ) {
				rSubSum = node.right.data;
			}else {
				rSubSum = 2 * (node.right.data);
			}

			/* If root's data is equal to sum of nodes in left and right subtrees then return 1 else return 0*/
			if ((node.data == rSubSum + lSubSum)) {
				return true;
			} 
		}
		return false;
	}
	private boolean isLeafNode(Node node) {
		if (node == null) {
			return false;
		}
		if (node.left == null && node.right == null) {
			return true;
		}
		return false;
	}
	public static void main(String args[]) {

		CheckBTIsSumTree tree = new CheckBTIsSumTree();
		tree.root = new Node(26);
		tree.root.left = new Node(10);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(6);
		tree.root.right.right = new Node(3);

		if (tree.isSumTree(tree.root)) {
			System.out.println("The given tree is a sum tree");

		} else {
			System.out.println("The given tree is not a sum tree");
		}
	}
	private static class Node {

		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right  = null;
		}
	}
}
