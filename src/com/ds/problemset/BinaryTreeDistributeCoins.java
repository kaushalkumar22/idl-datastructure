package com.ds.problemset;

import com.ds.binarytree.TreeNode;

/**
Given the root of a binary tree with N nodes, each node in the tree has node.val coins, and there are N coins total.
In one move, we may choose two adjacent nodes and move one coin from one node to another.  
(The move may be from parent to child, or from child to parent.)
Return the number of moves required to make every node have exactly one coin.

Input: [3,0,0]
Output: 2
Explanation: From the root of the tree, we move one coin to its left child, and one coin to its right child.

Input: [0,3,0]
Output: 3
Explanation: From the left child of the root, we move two coins to the root [taking two moves].  
Then, we move one coin from the root of the tree to the right child.

Input: [1,0,2]
Output: 2

Input: [1,0,0,null,3]
Output: 4

 *
 */
public class BinaryTreeDistributeCoins {

	public int distributeCoins(TreeNode root) {
		return distributeCoins(root,null);
	}
	//If we can modify values of tree nodes, we can store the balance in nodes, and use the 
	//return value to accumulate the number of moves. This way we can get rid of the helper 
	//method. The solution below is courtesy of Lee:

	int distributeCoins(TreeNode r, TreeNode p ) {
		if (r == null) return 0;
		int res = distributeCoins(r.left, r) + distributeCoins(r.right, r);
		if (p != null) p.val += r.val - 1;
		return res + Math.abs(r.val - 1);
	}
}
