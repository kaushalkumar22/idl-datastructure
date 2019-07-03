package com.ds.advance;


/**
 * Let's start by writing the in order traversal:

private void traverse (TreeNode root) {
   if (root == null)
      return;
   traverse(root.left);
   // Do some business
   traverse(root.right);
}

So when we need to print the node values in order, we insert System.out.println(root.val) in the place of "Do some business".

What is the business we are doing here?
We need to find the first and second elements that are not in order right?

How do we find these two elements? For example, we have the following tree that is printed as in order traversal:

6, 3, 4, 5, 2

We compare each node with its next one and we can find out that 6 is the first element to swap because 6 > 3 and 2 is the second element to swap because 2 < 5.

Really, what we are comparing is the current node and its previous node in the "in order traversal".

Let us define three variables, firstElement, secondElement, and prevElement. Now we just need to build the "do some business" logic as finding the two elements. See the code below:
 * @author I339640
 *
 */
public class RecoverBinarySearchTree {
	private TreeNode root;
	private TreeNode first;
	private TreeNode second;
	private TreeNode pre;
	
	public static void main(String[] args) {
		RecoverBinarySearchTree tree = new RecoverBinarySearchTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(3);
		tree.root.right =null;
		tree.root.left.left = null;
		tree.root.left.right = new TreeNode(2);
		
		tree.printInorder(tree.root);
		tree.recoverTree(tree.root);
		tree.printInorder(tree.root);
	}
	private void printInorder(TreeNode node) {
		if (node == null) 
			return;
		System.out.print(node.val + " ");
		printInorder(node.left);
		printInorder(node.right);
	}
	public void recoverTree(TreeNode root) {
		if(root==null) return;
		first = null;
		second = null;
		pre = null;
		inorder(root);
		int temp = first.val;
		first.val = second.val;
		second.val = temp;
	}

	private void inorder(TreeNode root){
		if(root==null) return;
		inorder(root.left);

		if(first==null && (pre==null ||pre.val>=root.val)){
			first = pre;
		}
		if(first!=null && pre.val>=root.val){
			second = root;
		}
		pre = root;
		inorder(root.right);
	}
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
