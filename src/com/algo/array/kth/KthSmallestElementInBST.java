package com.algo.array.kth;

import java.util.Stack;

import com.algo.binarytree.common.TreeNode;

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
public class KthSmallestElementInBST {
	//time complexity: O(N) best, O(N^2) worst

	public int kthSmallest(TreeNode root, int k) {
	      int count = countNodes(root.left);
	      if (k <= count) {
	          return kthSmallest(root.left, k);
	      } else if (k > count + 1) {
	          return kthSmallest(root.right, k-1-count); // 1 is counted as current node
	      }
	      
	      return root.val;
	  }
	  
	  public int countNodes(TreeNode n) {
	      if (n == null) return 0;
	      
	      return 1 + countNodes(n.left) + countNodes(n.right);
	  }
	//DFS in-order recursive:

	//time complexity: O(N)

	  // better keep these two variables in a wrapper class
	  private static int number = 0;
	  private static int count = 0;

	  public int kthSmallest1(TreeNode root, int k) {
	      count = k;
	      helper(root);
	      return number;
	  }
	  
	  public void helper(TreeNode n) {
	      if (n.left != null) helper(n.left);
	      count--;
	      if (count == 0) {
	          number = n.val;
	          return;
	      }
	      if (n.right != null) helper(n.right);
	  }
	//DFS in-order iterative:

	//time complexity: O(N) best

	public int kthSmallest2(TreeNode root, int k) {
	      Stack<TreeNode> st = new Stack<>();
	      
	      while (root != null) {
	          st.push(root);
	          root = root.left;
	      }
	          
	      while (k != 0) {
	          TreeNode n = st.pop();
	          k--;
	          if (k == 0) return n.val;
	          TreeNode right = n.right;
	          while (right != null) {
	              st.push(right);
	              right = right.left;
	          }
	      }
	      
	      return -1; // never hit if k is valid
	}

	
}