package com.algo.binarytree.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a non-empty binary tree, return the average value of the nodes on each
 * level in the form of an array. 
 * Input:      
    3
   / \
  9  20
    /  \
   15   7
 * Output: [3, 14.5, 11] Explanation: The average value of nodes on level 0 is
 * 3, on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 *
 */
public class AverageOfLevelsInBinaryTree {

	public static void main(String[] args) {
		List<Integer> nums = (List<Integer>) Arrays.asList(3, 9, 20, null, null, 15, 7);
		System.out.println(nums);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println("Average Of Levels : " + averageOfLevels(root));
	}

	public static List<Double> averageOfLevels(TreeNode root) {
		List<Double> result = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();

		if (root == null)
			return result;
		q.add(root);
		while (!q.isEmpty()) {
			int n = q.size();
			double sum = 0.0;
			for (int i = 0; i < n; i++) {
				TreeNode node = q.poll();
				sum += node.val;
				if (node.left != null)
					q.offer(node.left);
				if (node.right != null)
					q.offer(node.right);
			}
			result.add(sum / n);
		}
		return result;
	}

}
