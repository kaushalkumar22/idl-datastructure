package com.ds.binarytree.traversal;

import java.util.Stack;

public class PrintInorder {
	
	private  Node root;
	
	private void inorderTraversal(Node node){

		if(node==null) return;
		
		inorderTraversal(node.left);
		System.out.print(node.data+" ");
		inorderTraversal(node.right);
	}

	private void inorderWithoutRecursion(Node node){

		Stack<Node> s = new Stack<Node>();
		while(!s.isEmpty()||node!=null){
			if(node!=null){
				s.push(node);
				node=node.left;
			}else{
				System.out.print(s.peek().data+" ");
				node=s.pop().right;
			}
		}			
	}

	private void inorderWithoutRecursionAndStack(Node root){

		Node curr =root;
		Node cNext = curr.left;
	
		while(cNext != null) {
			if (curr != null) {
				curr.left = cNext.right;
				cNext.right = curr;
			}
			if (cNext.left != null) {
				curr = cNext;
				cNext = cNext.left;
			} else {
				System.out.print(cNext.data +" ");
				cNext = cNext.right;
				curr = null;
			}
		}
	}
	public static void main(String args[]) {

		PrintInorder tree = new PrintInorder();

			tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);
		tree.root.right.left.right.left = new Node(11);
		tree.root.right.right.right = new Node(9);


	/*	tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.left.right.right = new Node(5);
		tree.root.left.right.right.right = new Node(9);
		tree.root.left.right.right.right.left = new Node(7);
		tree.root.left.right.right.right.right = new Node(11);*/

		tree.inorderTraversal(tree.root);
		System.out.println();
		tree.inorderWithoutRecursion(tree.root);
		System.out.println();
		tree.inorderWithoutRecursionAndStack(tree.root);
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
