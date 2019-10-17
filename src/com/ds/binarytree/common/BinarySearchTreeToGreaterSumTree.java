package com.ds.binarytree.common;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
Given the root of a binary search tree with distinct values, modify it so that every node has a 
new value equal to the sum of the values of the original tree that are greater than or equal to node.val.
As a reminder, a binary search tree is a tree that satisfies these constraints:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Input: [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 *
 */
public class BinarySearchTreeToGreaterSumTree {

	public static void main(String[] args) {

		List<Integer> nums = (List<Integer>) Arrays.asList(4,1,6,0,2,5,7,null,null,null,3,null,null,null,8);
		System.out.println(nums);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println("Average Of Levels : " + bstToGst(root));

	}
	static int pre = 0;
    public static TreeNode bstToGst(TreeNode root) {
        if (root.right != null) bstToGst(root.right);
        pre = root.val = pre + root.val;
        if (root.left != null) bstToGst(root.left);
        return root;
    }
    //iterative
    public TreeNode bstToGst2 (TreeNode root) {
        int sum = 0;
        TreeNode cur = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            cur.val += sum;
            sum = cur.val;
            cur = cur.left;
        }
        return root;
    }

}
