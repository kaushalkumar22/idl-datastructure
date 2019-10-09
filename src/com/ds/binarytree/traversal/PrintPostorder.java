package com.ds.binarytree.traversal;

import java.util.Stack;
//http://www.geeksforgeeks.org/iterative-postorder-traversal-using-stack/
//http://www.geeksforgeeks.org/iterative-postorder-traversal/
public class PrintPostorder {

	private Node root;
	
	private void postorderTraversal(Node root){

		Node node = root;

		if(node.left!=null)
			postorderTraversal(node.left);
		if(node.right!= null)
			postorderTraversal(node.right);
		System.out.print(node.data+" ");
	}

	private void postorderWithoutRecursive(Node root){
		// Check for empty tree
		if (root == null)
			return;

		Stack<Node> stack = new Stack<Node>();
		do
		{
			// Move to leftmost node
			while (root!=null)
			{
				// Push root's right child and then root to stack.
				if (root.right!=null)
					stack.push(root.right);
				stack.push(root);

				// Set root as root's left child  
				root = root.left;
			}

			// Pop an item from stack and set it as root    
			root = stack.pop();

			// If the popped item has a right child and the right child is not
			// processed yet, then make sure right child is processed before root
			if (root.right!=null&&!stack.isEmpty()&& stack.peek() == root.right)
			{
				stack.pop();  // remove right child from stack
				stack.push(root);  // push root back to stack
				root = root.right; // change root so that the right 
				// child is processed next
			}
			else  // Else print root's data and set root as NULL
			{
				System.out.print(root.data+ " ");
				root = null;
			}
		} while (!stack.isEmpty());
	}
	private void postorderIterative(Node root){
		// Create two stacks
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();

		// push root to first stack
		s1.push(root);
		Node node;

		// Run while first stack is not empty
		while (!s1.isEmpty())
		{
			// Pop an item from s1 and push it to s2
			node = s1.pop();
			s2.push(node);

			// Push left and right children of removed item to s1
			if (node.left!=null)
				s1.push(node.left);
			if (node.right!=null)
				s1.push(node.right);
		}

		// Print all elements of second stack
		while (!s2.isEmpty())
		{
			node = s2.pop();
			System.out.print(node.data+" ");
		}
	}
	public static void main(String args[]) {

		PrintPostorder tree = new PrintPostorder();

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

		tree.postorderTraversal(tree.root);
		System.out.println();
		tree.postorderWithoutRecursive(tree.root);
		System.out.println();
		tree.postorderIterative(tree.root);
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
