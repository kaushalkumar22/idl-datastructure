package com.ds.binarytree;

/**
1. If both trees are empty then return true.
2. Else If both trees are non -empty
     (a) Check data of the root nodes (tree1.data ==  tree2.data)
     (b) Check left subtrees recursively  i.e., 
	     call sameTree(tree1.left, tree2.left)
     (c) Check right subtrees recursively  i.e., 
	     call sameTree(tree1.right_subtree, tree2.right_subtree)
     (d) If a,b and c are true then return 1.
3  Else return false (one is empty and other is not)
 * @author Kaushal.Kumar
 *
 */

public class CheckAreBTsIdentical {

	private Node root1, root2;

	// Given two trees, return true if they are structurally identical 
	private boolean identicalTrees(Node tree1, Node tree2) {

		if (tree1 == null && tree2 == null) return true;

		if (tree1 == null || tree2 == null) return false;

		
			return (tree1.data == tree2.data
					&& identicalTrees(tree1.left, tree2.left)
					&& identicalTrees(tree1.right, tree2.right));
	}

	public static void main(String[] args) {

		CheckAreBTsIdentical tree = new CheckAreBTsIdentical();

		tree.root1 = new Node(1);
		tree.root1.left = new Node(2);
		tree.root1.right = new Node(3);
		tree.root1.left.left = new Node(4);
		tree.root1.left.right = new Node(5);

		tree.root2 = new Node(1);
		tree.root2.left = new Node(2);
		tree.root2.right = new Node(3);
		tree.root2.left.left = new Node(4);
		tree.root2.left.right = new Node(6);

		if (tree.identicalTrees(tree.root1, tree.root2)) {
			System.out.println("Both trees are identical");
		} else {
			System.out.println("Trees are not identical");
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