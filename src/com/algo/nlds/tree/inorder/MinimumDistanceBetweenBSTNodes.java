package com.algo.nlds.tree.inorder;

import java.util.Arrays;

import com.algo.nlds.tree.common.TreeNode;
import com.algo.nlds.tree.common.TreeUtil;

/**
 * 
 * Given a Binary Search Tree (BST) with the root node root, return the minimum
 * difference between the values of any two different nodes in the tree.
 * 
 * Example :
 * 
 * Input: root = [4,2,6,1,3,null,null] Output: 1 Explanation: Note that root is
 * a TreeNode object, not an array.
 * 
 * The given tree [4,2,6,1,3,null,null] is represented by the following diagram:
 * 
 * 
          4
        /   \
      2      6
     / \    
    1   3  

 * while the minimum difference in this tree is 1, it occurs between node 1 and
 * node 2, also between node 3 and node 2.
 *
 */
//same code of MinimumAbsolutDifferenceInBST
public class MinimumDistanceBetweenBSTNodes {

	public static void main(String[] args) {

		MinimumDistanceBetweenBSTNodes tree = new MinimumDistanceBetweenBSTNodes();
		TreeNode root = TreeUtil.createTree(Arrays.asList(1,3,2,5,3,null,9));
		//System.out.println(tree.largestValues( root));
		System.out.println(tree.minDiffInBST( root));
	}
	int minDiff = Integer.MAX_VALUE;
	TreeNode prev;

	public int minDiffInBST(TreeNode root) {
		inorder(root);
		return minDiff;
	}

	public void inorder(TreeNode root) {
		if (root == null) return;
		inorder(root.left);
		if (prev != null) minDiff = Math.min(minDiff, root.val - prev.val);
		prev = root;
		inorder(root.right);
	}
}
