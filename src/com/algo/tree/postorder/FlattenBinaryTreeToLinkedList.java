package com.algo.tree.postorder;

import java.util.Arrays;
import java.util.List;

import com.algo.tree.common.TreeNode;
import com.algo.tree.common.TreeUtil;

/**
 * Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6

The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6


 * @author I339640
 *
 */
public class FlattenBinaryTreeToLinkedList {
	public static void main(String[] args) {
		List<Integer> nums = (List<Integer>) Arrays.asList(1,2,5,3,4,null,6);
		TreeNode root = TreeUtil.createTree(nums);
		flatten( root);
		TreeUtil.inorder(root);
	}
	private static TreeNode prev = null;

	public static void flatten(TreeNode root) {
	    if (root == null) return;
	    flatten(root.right);
	    flatten(root.left);
	    root.right = prev;
	    root.left = null;
	    prev = root;
	}
}
