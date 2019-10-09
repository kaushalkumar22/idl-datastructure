package com.ds.binarytree.verify;
/*
 * In a complete binary tree every level, except possibly the last, is completely filled, 
 * and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes at the last level h
 * 
 * 1. Calculate the number of nodes (count) in the binary tree.
  2. Start recursion of the binary tree from the root node of the binary tree with index (i) being set as 0 
     and the number of nodes in the binary (count).
  3. If the current node under examination is NULL, then the tree is a complete binary tree. Return true.
  4. If index (i) of the current node is greater than or equal to the number of nodes in the binary tree (count) 
     i.e. (i>= count), then the tree is not a complete binary. Return false.
  5. Recursively check the left and right sub-trees of the binary tree for same condition. 
     For the left sub-tree use the index as (2*i + 1) while for the right sub-tree use the index as (2*i + 2).
 */
class CheckIsBTCompleteBT {

	Node root;
	// This function counts the number of nodes in a binary tree 
	private int countNodes(Node node) {
		if (node == null) return 0;

		return (1 + countNodes(node.left) + countNodes(node.right));
	}

	boolean isComplete(Node node, int i, int number_nodes){

		// An empty tree is complete
		if (node == null)   return true;

		// If index assigned to current node is more than number of nodes in tree, then tree is not complete
		if (i >= number_nodes) return false;

		// Recur for left and right subtrees
		return (isComplete(node.left, 2 * i + 1, number_nodes)
				&& isComplete(node.right, 2 * i + 2, number_nodes));
	}
	public static void main(String args[]) {

		CheckIsBTCompleteBT tree = new CheckIsBTCompleteBT();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.right = new Node(5);
		tree.root.left.left = new Node(4);
		tree.root.right.left = new Node(6);

		int node_count = tree.countNodes(tree.root);
		int index = 0;

		if (tree.isComplete(tree.root, index, node_count))
			System.out.print("The binary tree is complete");
		else
			System.out.print("The binary tree is not complete"); 
	}
	private static class Node {

		private	int data;
		Node left, right;
		Node(int item) {
			this.data = item;
			left = right = null;
		}
	}
}