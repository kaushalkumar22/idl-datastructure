package com.algo.tree.postorder;

import java.util.Arrays;
import java.util.List;

import com.algo.tree.common.TreeNode;
import com.algo.tree.common.TreeUtil;

/**
 * 
 * Given the root of a binary search tree and the lowest and highest boundaries
 * as low and high, trim the tree so that all its elements lies in [low, high].
 * You might need to change the root of the tree, so the result should return
 * the new root of the trimmed binary search tree.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: root = [1,0,2], low = 1, high = 2 Output: [1,null,2]
 * 
 * Example 2:
 * 
 * Input: root = [3,0,4,null,2,null,null,1], low = 1, high = 3 Output:
 * [3,2,null,1]
 * 
 * Example 3:
 * 
 * Input: root = [1], low = 1, high = 2 Output: [1]
 * 
 * Example 4:
 * 
 * Input: root = [1,null,2], low = 1, high = 3 Output: [1,null,2]
 * 
 * Example 5:
 * 
 * Input: root = [1,null,2], low = 2, high = 4 Output: [2]
 * 
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree in the range [1, 104]. 0 <= Node.val <= 104
 * The value of each node in the tree is unique. root is guaranteed to be a
 * valid binary search tree. 0 <= l <= r <= 104
 *
 * 
 * 
 */
public class TrimABinarySearchTree {
	public static void main(String[] args) {
		List<Integer> nums = (List<Integer>) Arrays.asList(3,0,4,null,2,null,null,1);
		TreeNode root = TreeUtil.createTree(nums);
		TrimABinarySearchTree tree = new TrimABinarySearchTree();
		System.out.println("Average Of Levels : " + tree.trimBST(root,1,3));
	}

	public TreeNode trimBST(TreeNode root, int L, int R) {
		if (root == null)
			return root;

		root.left = trimBST(root.left, L, R);
		root.right = trimBST(root.right, L, R);
		if (root.val > R)
			return root.left;
		if (root.val < L)
			return root.right;
		return root;
	}
}
