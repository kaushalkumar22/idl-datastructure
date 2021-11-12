package com.algo.tree.common;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * input :[7,3,15,null,null,9,20]
BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false

 * Note:
 * 
 * next() and hasNext() should run in average O(1) time and uses O(h) memory,
 * where h is the height of the tree. You may assume that next() call will
 * always be valid, that is, there will be at least a next smallest number in
 * the BST when next() is called.
 * 
 * 
 */
public class BinarySearchTreeIterator {

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(7,3,15,null,null,9,20);
		TreeNode root = TreeUtil.createTree(nums);
		TreeUtil.inorder(root);
		BinarySearchTreeIterator tree= new BinarySearchTreeIterator( root);
		
		System.out.println(tree.next());
		System.out.println(tree.next());
		System.out.println(tree.next());

	}
	Stack<TreeNode> st = new Stack<TreeNode>();
	public BinarySearchTreeIterator(TreeNode root) {
		addAll(root);	
	}

	private Stack<TreeNode> addAll(TreeNode root) {
		
		while(root != null) {
			st.push(root);
			root = root.left;
		}
		return st;
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode root= st.pop();
		addAll(root.right);
		return root.val;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
          return st.size()>0?true:false;
	}
}

