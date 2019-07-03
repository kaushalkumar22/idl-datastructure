package com.ds.binarytree;

public class ConstructBTPostorderInorder {

	static Node root;
	// static int preIndex = 0;

	/* Recursive function to construct binary of size len from
	     Inorder traversal in[] and Preorder traversal pre[].  Initial values
	     of inStrt and inEnd should be 0 and len -1.  The function doesn't
	     do any error checking for cases where inorder and preorder
	     do not form a tree */
	Node buildUtil(int in[], int post[], int inStrt,int inEnd, int pIndex){
		
		if (inStrt > inEnd)
			return null;

		/* Pick current node from Preorder traversal using postIndex and decrement postIndex */
		Node node = new Node(post[pIndex]);
		pIndex--;

		/* If this node has no children then return */
		if (inStrt == inEnd)
			return node;

		/* Else find the index of this node in Inordertraversal */
		int iIndex = search(in, inStrt, inEnd, node.data);

		/* Using index in Inorder traversal, construct left and
       right subtress */
		node.right= buildUtil(in, post, iIndex+1, inEnd, pIndex);
		node.left = buildUtil(in, post, inStrt, iIndex-1, pIndex);

		return node;
	}

	/* UTILITY FUNCTIONS */
	/* Function to find index of value in arr[start...end]
	     The function assumes that value is present in in[] */
	private int search(int arr[], int strt, int end, int value) {
		int i;
		for (i = strt; i <= end; i++) {
			if (arr[i] == value) {
				return i;
			}
		}
		return i;
	}

	private void printInorder(Node node) {
		if (node == null) 
			return;
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	public static void main(String args[]) {
		ConstructBTPostorderInorder tree = new ConstructBTPostorderInorder();
		int in[]   = {4, 8, 2, 5, 1, 6, 3, 7};
		int post[] = {8, 4, 5, 2, 6, 7, 3, 1};
		int len = in.length;
		Node mynode = tree.buildUtil(in, post, 0, len - 1,len-1);

		// building the tree by printing inorder traversal
		System.out.println("Inorder traversal of constructed tree is : ");
		tree.printInorder(mynode);
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

