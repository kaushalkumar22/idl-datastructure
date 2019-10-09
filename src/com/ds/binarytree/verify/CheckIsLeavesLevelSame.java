package com.ds.binarytree.verify;

class CheckIsLeavesLevelSame {

	Node root;
	boolean checkLeafLevel(Node node, int level, int leafLevel) {

		if (node == null) {
			return true;
		}
		if (node.left == null && node.right == null) {
			if (leafLevel == 0) {
				leafLevel = level; // Set first found leaf's level
				return true;
			}
			// If this is not first leaf node, compare its level with first leaf's level
			return (level == leafLevel);
		}
		// If this node is not leaf, recursively check left and right subtrees
		return checkLeafLevel(node.left, level + 1, leafLevel)
				&& checkLeafLevel(node.right, level + 1, leafLevel);
	}

	public static void main(String args[]) {

		CheckIsLeavesLevelSame tree = new CheckIsLeavesLevelSame();
		tree.root = new Node(12);
		tree.root.left = new Node(5);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(9);
		tree.root.left.left.left = new Node(1);
		tree.root.left.right.left = new Node(1);
		if (tree.checkLeafLevel(tree.root,0,0)) {
			System.out.println("Leaves are at same level");
		} else {
			System.out.println("Leaves are not at same level");
		}
	}
	static class Node {

		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}
}