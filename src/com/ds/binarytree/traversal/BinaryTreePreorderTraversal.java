package com.ds.binarytree.traversal;

import java.util.Stack;

public class BinaryTreePreorderTraversal {

	private Node root;
	
	private void preorderTraversal(Node root){

		Node node = root;

		System.out.print(node.data+" ");
		if(node.left!=null)
			preorderTraversal(node.left);
		if(node.right!= null)
			preorderTraversal(node.right);
	}

	private void preorderWithoutRecursive(Node root){
		Stack<Node> s = new Stack<Node>();
		Node node = root;
		while(node!=null || !s.isEmpty()){
			if(node!=null)
			{
				System.out.print(node.data+" ");
				s.push(node.right);
				node = node.left;
			}else{
				node = s.pop();
			}
		}
	}
	private	void morrisTraversalPreorder(Node root)
	{
		while (root!=null){
			// If left child is null, print the current node data. Move to right child.
			if (root.left == null){
				System.out.print(root.data+" ");
				root = root.right;
			}else{
				// Find inorder predecessor
				Node current = root.left;
				while (current.right!=null&&current.right != root){
					current = current.right;
				}
				// If the right child of inorder predecessor already points to this node
				if (current.right == root){
					current.right = null;
					root = root.right;
				}
				// If right child doesn't point to this node, then print this node and make right child point to this node
				else{
					System.out.print( root.data+" ");
					current.right = root;
					root = root.left;
				}
			}
		}
	}
	public static void main(String args[]) {

		BinaryTreePreorderTraversal tree = new BinaryTreePreorderTraversal();

		/*	tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);
		tree.root.right.left.right.left = new Node(11);
		tree.root.right.right.right = new Node(9);*/


		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.left.right.right = new Node(5);
		tree.root.left.right.right.right = new Node(9);
		tree.root.left.right.right.right.left = new Node(7);
		tree.root.left.right.right.right.right = new Node(11);

		tree.preorderTraversal(tree.root);
		System.out.println();
		tree.preorderWithoutRecursive(tree.root);
		System.out.println();
		tree.morrisTraversalPreorder(tree.root);

	}
	private	static class Node {
		int data;
		Node left, right;
		Node(int item){
			data = item;
			left = right = null;
		}
	}
}
