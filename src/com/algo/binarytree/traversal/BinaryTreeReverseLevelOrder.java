package com.algo.binarytree.traversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//http://www.geeksforgeeks.org/reverse-level-order-traversal/

//Do something like normal level order traversal order. Following are the differences with normal level order traversal
// 1) Instead of printing a node, we push the node to stack
// 2) Right subtree is visited before left subtree
public class BinaryTreeReverseLevelOrder {

	private Node root;

	private void reverseLevelOrder(Node node) {
		Stack<Node> stack = new Stack<Node>();
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);


		while (queue.isEmpty() == false) {

			/* Dequeue node and make it root */
			node = queue.peek();
			queue.remove();
			stack.push(node);

			/* Enqueue right child */
			if (node.right != null) {
				queue.add(node.right); // NOTE: RIGHT CHILD IS ENQUEUED BEFORE LEFT
			}
			/* Enqueue left child */
			if (node.left != null) {
				queue.add(node.left);
			}
		}

		// Now pop all items from stack one by one and print them
		while (stack.empty() == false) {
			node = stack.peek();
			System.out.print(node.data + " ");
			stack.pop();
		}
	}

	public static void main(String args[]) {

		BinaryTreeReverseLevelOrder tree = new BinaryTreeReverseLevelOrder();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);

		System.out.println("Level Order traversal of binary tree is : ");
		tree.reverseLevelOrder(tree.root);

	}
	private static class Node {

		int data;
		Node left, right;
		Node(int item) {
			data = item;
			left = right;
		}
	}
}