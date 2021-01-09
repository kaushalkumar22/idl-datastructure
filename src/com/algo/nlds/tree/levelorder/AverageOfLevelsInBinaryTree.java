package com.algo.nlds.tree.levelorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.algo.nlds.tree.common.TreeNode;
import com.algo.nlds.tree.common.TreeUtil;

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
 *
 * Simply its level order traversal,each level need to sum 
 * and divide by count of node at each level
 * Time and Space complexity
 * Time O(n)
 * Space O(n)
 */
public class AverageOfLevelsInBinaryTree {

	public static void main(String[] args) {
		List<Integer> nums = (List<Integer>) Arrays.asList(3, 9, 20, null, null, 15, 7);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println("Average Of Levels : " + averageOfLevels(root));
	}
	
	public static List<Double> averageOfLevels(TreeNode root) {
		List<Double> res = new ArrayList<>();
		Queue<TreeNode> que = new LinkedList<>();
		if (root == null) return res;
		que.add(root);
		while (!que.isEmpty()) {
			int count = que.size();
			double sum = 0.0;
			for (int i = 0; i < count; i++) {
				root = que.poll();
				sum += root.val;
				if (root.left != null) {
					que.offer(root.left);
				}				
				if (root.right != null) {
					que.offer(root.right);
				}
			}
			res.add(sum / count);
		}
		return res;
	}

}
