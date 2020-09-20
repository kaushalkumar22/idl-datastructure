package com.algo.tree.levelorder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.algo.tree.common.TreeNode;
import com.algo.tree.common.TreeUtil;
/**
Given a binary tree, find the leftmost value in the last row of the tree.
Input:
    2
   / \
  1   3
Output:1
Input:
        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7
Output:7
 *
 */
public class BottomLeftTreeValue {

	public static void main(String[] args) {
		List<Integer> nums = (List<Integer>) Arrays.asList(1,2,3,4,5,6,null,null,7);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println("Bottom Left Tree Value : " + findLeftMostNode(root));
	}
	public static int findLeftMostNode(TreeNode root) {
	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.add(root);
	    while (!queue.isEmpty()) {
	        root = queue.poll();
	        if (root.right != null)
	            queue.add(root.right);
	        if (root.left != null)
	            queue.add(root.left);
	    }
	    return root.val;
	}
}
