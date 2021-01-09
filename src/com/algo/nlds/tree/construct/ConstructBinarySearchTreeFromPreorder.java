package com.algo.nlds.tree.construct;

import java.util.Stack;

import com.algo.nlds.tree.common.TreeNode;
/**
Return the root TreeNode of a binary search tree that matches the given preorder traversal.
(Recall that a binary search tree is a binary tree where for every TreeNode, any descendant of TreeNode.left has a 
value < TreeNode.val, and any descendant of TreeNode.right has a value > TreeNode.val.  
Also recall that a preorder traversal displays the value of the TreeNode first, then traverses TreeNode.left, 
then traverses TreeNode.right.)
Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]
 *
 */
public class ConstructBinarySearchTreeFromPreorder {

	private int index=0;
	// A recursive function to construct Full from pre[]. preIndex is used to keep track of index in pre[].
	//Method 1 ( O(n^2) time complexity )
	TreeNode constructBST(int pre[],int low, int high) {

		// Base case
		if (low > high) {
			return null;
		}

		// The first TreeNode in preorder traversal is root. So take the TreeNode at
		// preIndex from pre[] and make it root, and increment preIndex
		TreeNode root = new TreeNode(pre[low]);
		//low = low + 1;

		// If the current subarry has only one element, no need to recur
		if (low == high) {
			return root;
		}

		// Search for the first element greater than root
		int i;
		for (i = low; i <= high; ++i) {
			if (pre[i] > root.val) {
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
	TreeNode constructBST(int pre[],int min, int max, int size) {

		if (index >= size) {
			return null;
		}
       int key = pre[index];
		TreeNode root = null;

		// If current element of pre[] is in range, then only it is part of current subtree
		if (key > min && key < max) {

			// Allocate memory for root of this subtree and increment *preIndex
			root = new TreeNode(key);
			index ++;

			

				// All TreeNodes which are in range {min .. key} will go in left
				// subtree, and first such TreeNode will be root of left subtree.
				root.left = constructBST(pre,min, key, size);

				// All TreeNodes which are in range {key,max} will go in right
				// subtree, and first such TreeNode will be root of right subtree.
				root.right = constructBST(pre,key, max, size);
		}

		return root;
	}
	public static TreeNode constructBST(int pre[]){
		TreeNode root = new TreeNode(pre[0]);
		TreeNode ptr = null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		// Iterate through rest of the size-1 items of given preorder array
		for(int i = 1; i<pre.length; i++){
			ptr = null;
			 /* Keep on popping while the next value is greater than
            stack's top value. */
			while(!stack.isEmpty() && (pre[i] > stack.peek().val)){
				ptr = stack.pop();
			}
			// Make this greater value as the right child and push it to the stack
			if(ptr == null){
				stack.peek().left = new TreeNode(pre[i]);
				stack.push(stack.peek().left);
			}
			 // If the next value is less than the stack's top value, make this value
            // as the left child of the stack's top TreeNode. Push the new TreeNode to stack
			else{
				ptr.right = new TreeNode(pre[i]);
				stack.push(ptr.right);
			}
		}

		return root;
	}
	// A utility function to print inorder traversal of a Binary Tree
	void printInorder(TreeNode TreeNode) {
		if (TreeNode == null) {
			return;
		}
		printInorder(TreeNode.left);
		System.out.print(TreeNode.val + " ");
		printInorder(TreeNode.right);
	}

	public static void main(String[] args) {
		ConstructBinarySearchTreeFromPreorder tree = new ConstructBinarySearchTreeFromPreorder();
		int pre[] = new int[]{10, 5, 1, 7, 40, 50};
		int size = pre.length;
		TreeNode root = tree.constructBST(pre, 0, size - 1);;
		System.out.println("Inorder traversal of the constructed tree is ");
		tree.printInorder(root);
		System.out.println();
		tree.index =0;
		TreeNode root1 = tree.constructBST(pre,Integer.MIN_VALUE,Integer.MAX_VALUE, size);
		System.out.println("Inorder traversal of the constructed tree is ");
		tree.printInorder(root1);
		System.out.println();
		System.out.println("Inorder traversal of the constructed tree is ");
		TreeNode root2 = constructBST(pre);
		tree.printInorder(root2);
		System.out.println();
	}
	
}