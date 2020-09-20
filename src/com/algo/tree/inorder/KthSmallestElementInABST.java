package com.algo.tree.inorder;

import java.util.Arrays;
import java.util.Stack;

import com.algo.tree.common.TreeNode;
import com.algo.tree.common.TreeUtil;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it.
 * 
 * Note: You may assume k is always valid, 1 <= k <= BST's total elements.
 * 
 * Example 1:
 * 
 * Input: root = [3,1,4,null,2], k = 1
 * 
 * 3
  / \
 1   4
  \
   2
 * 
 *  Output: 1 Example 2:
 * 
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *     5
      / \
     3   6
    / \
   2   4
  /
 1
 * Output: 3
 * 
 *
 */
public class KthSmallestElementInABST {

	public static void main(String[] args) {
		KthSmallestElementInABST tree = new KthSmallestElementInABST();
		TreeNode root=TreeUtil.createTree(Arrays.asList(5,3,6,2,4,null,null,1));
		System.out.println(tree.kthSmallest(root, 3));
		System.out.println(tree.kthSmallestRecurcive(root, 3));
	}
	public int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<>();
		while(root != null || !stack.isEmpty()) {
			while(root != null) {
				stack.push(root);    
				root = root.left;   
			} 
			root = stack.pop();
			if(--k == 0) break;
			root = root.right;
		}
		return root.val;
	}

	//DFS in-order recursive:
	//time complexity: O(N)
	private static int number = 0;
	private static int count = 0;

	public int kthSmallestRecurcive(TreeNode root, int k) {
		count = k;
		helper(root);
		return number;
	}

	public void helper(TreeNode n) {
		if (n.left != null) {
			helper(n.left);
		}
		count--;
		if (count == 0) {
			number = n.val;
			return;
		}
		if (n.right != null) {
			helper(n.right);
		}
	}
}