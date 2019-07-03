package com.ds.binarytree;

import java.util.Stack;

public class ConstructBSTFromPreorder {

	private int index=0;
	// A recursive function to construct Full from pre[]. preIndex is used to keep track of index in pre[].
	//Method 1 ( O(n^2) time complexity )
	Node constructBST(int pre[],int low, int high) {

		// Base case
		if (low > high) {
			return null;
		}

		// The first node in preorder traversal is root. So take the node at
		// preIndex from pre[] and make it root, and increment preIndex
		Node root = new Node(pre[low]);
		//low = low + 1;

		// If the current subarry has only one element, no need to recur
		if (low == high) {
			return root;
		}

		// Search for the first element greater than root
		int i;
		for (i = low; i <= high; ++i) {
			if (pre[i] > root.data) {
				break;
			}
		}

		// Use the index of element found in preorder to divide preorder array in
		// two parts. Left subtree and right subtree
		root.left = constructBST(pre, low+1, i - 1);
		root.right = constructBST(pre, i, high);

		return root;
	}
	//Method 2 : O(n) time complexity 
	Node constructBST(int pre[],int min, int max, int size) {

		if (index >= size) {
			return null;
		}
       int key = pre[index];
		Node root = null;

		// If current element of pre[] is in range, then only it is part of current subtree
		if (key > min && key < max) {

			// Allocate memory for root of this subtree and increment *preIndex
			root = new Node(key);
			index ++;

			

				// All nodes which are in range {min .. key} will go in left
				// subtree, and first such node will be root of left subtree.
				root.left = constructBST(pre,min, key, size);

				// All nodes which are in range {key,max} will go in right
				// subtree, and first such node will be root of right subtree.
				root.right = constructBST(pre,key, max, size);
		}

		return root;
	}
	public static Node constructBST(int pre[]){
		Node root = new Node(pre[0]);
		Node ptr = null;
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		// Iterate through rest of the size-1 items of given preorder array
		for(int i = 1; i<pre.length; i++){
			ptr = null;
			 /* Keep on popping while the next value is greater than
            stack's top value. */
			while(!stack.isEmpty() && (pre[i] > stack.peek().data)){
				ptr = stack.pop();
			}
			// Make this greater value as the right child and push it to the stack
			if(ptr == null){
				stack.peek().left = new Node(pre[i]);
				stack.push(stack.peek().left);
			}
			 // If the next value is less than the stack's top value, make this value
            // as the left child of the stack's top node. Push the new node to stack
			else{
				ptr.right = new Node(pre[i]);
				stack.push(ptr.right);
			}
		}

		return root;
	}
	// A utility function to print inorder traversal of a Binary Tree
	void printInorder(Node node) {
		if (node == null) {
			return;
		}
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	public static void main(String[] args) {
		ConstructBSTFromPreorder tree = new ConstructBSTFromPreorder();
		int pre[] = new int[]{10, 5, 1, 7, 40, 50};
		int size = pre.length;
		Node root = tree.constructBST(pre, 0, size - 1);;
		System.out.println("Inorder traversal of the constructed tree is ");
		tree.printInorder(root);
		System.out.println();
		tree.index =0;
		Node root1 = tree.constructBST(pre,Integer.MIN_VALUE,Integer.MAX_VALUE, size);
		System.out.println("Inorder traversal of the constructed tree is ");
		tree.printInorder(root1);
		System.out.println();
		System.out.println("Inorder traversal of the constructed tree is ");
		Node root2 = constructBST(pre);
		tree.printInorder(root2);
		System.out.println();
	}
	private  static  class Node {

		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}
}