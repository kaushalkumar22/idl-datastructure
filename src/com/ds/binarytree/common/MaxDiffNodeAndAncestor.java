package com.ds.binarytree.common;

/* 
 *       1
       /   \
      2     3
     / \   / \
    4   5 6   7
           \   \
            8   9
                 \
                  11      
4 2  1 3 8 7 9 11 

    1
   / \
  2   3
   \
    4
     \
      5
       \
        9
        /\
       7  11
 */

public class MaxDiffNodeAndAncestor{

	Node root;

	private	int getNodeAncestorMaxDiff(Node root, int res){
		if (root == null)
			return Integer.MAX_VALUE;

		if (root.left == null && root.right == null)
			return root.data;

		int v2 = getNodeAncestorMaxDiff(root.left,  res);
		int v1 = getNodeAncestorMaxDiff(root.right, res);
		int val =Math.min(v1,v2);
		res = Math.max(res, root.data - val);

		return Math.min(val, root.data);
	}
	public static void main(String args[]) {
		MaxDiffNodeAndAncestor tree = new MaxDiffNodeAndAncestor();

		tree.root = new Node(15);
		tree.root.left = new Node(2);
		tree.root.left.right = new Node(4);
		tree.root.left.right.right = new Node(5);
		tree.root.left.right.right.right = new Node(9);
		tree.root.left.right.right.right.left = new Node(7);
		tree.root.left.right.right.right.right = new Node(11);
		tree.root.right = new Node(3);

		/*	root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);
		root.right.right.right = new Node(9);
		root.right.right.right.right = new Node(8);
		 */
		int maxDiff = tree.getNodeAncestorMaxDiff(tree.root,Integer.MIN_VALUE);
		System.out.println(tree.root.data-maxDiff);
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