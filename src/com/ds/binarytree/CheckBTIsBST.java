package com.ds.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/** Given a binary tree, return true if it is binary search tree else return false.
 * 
 * Keep track min, max for every node. Initial min and max is very small and very larger
 * number for root. Check if root.data is in this range. When you go left pass min and root.data and 
 * for right pass root.data and max.
 */
public class CheckBTIsBST{

	private Node root;
	private Node prev;
	boolean isBST(Node node,int min,int max)  {
		/* an empty tree is BST */
		if (node == null) return true;

		/* false if this node violates the min/max constraints */
		if (node.data < min || node.data > max) return false;

		/* otherwise check the subtrees recursively tightening the min/max constraints */
		return (isBST(node.left, min, node.data) && isBST(node.right, node.data, max));
	}

	public boolean isBSTIterative() {

		if (root == null) return true;

		Deque<Node> stack = new LinkedList<Node>();
		Node node = root;
		int prev = Integer.MIN_VALUE;
		int current;
		while ( true ) {
			if (node != null) {
				stack.addFirst(node);
				node = node.left;
			} else {
				if (stack.isEmpty()) {
					break;
				}
				node = stack.pollFirst();
				current = node.data;
				if (current < prev) {
					return false;
				}
				prev = current;
				node = node.right;
			}
		}
		return true;
	}
	// this method will check by using inorder traversal
	private boolean isBSTInorder(Node node){

		if (node != null)
        {
            if (!isBSTInorder(node.left))
                return false;
            // allows only distinct values node
            if (prev != null && node.data <= prev.data )
                return false;
            prev = node;
            return isBSTInorder(node.right);
        }
        return true;
    }

	public static void main(String args[]){

		CheckBTIsBST tree = new CheckBTIsBST();
		tree.root = new Node(10);
		tree.root.left = new Node(4);
		tree.root.right = new Node(11);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(9);

		if (tree.isBST(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE))
			System.out.println("Tree is BST");
		else
			System.out.println("Not a BST");
		if (tree.isBSTIterative())
			System.out.println("IS BST");
		else
			System.out.println("Not a BST");
	}

	private static class Node{
		int data;
		Node left, right;

		public Node(int item){
			data = item;
			left = right = null;
		}
	}
}