package tree_levelorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import tree_miscellaneous.TreeNode;
import tree_miscellaneous.TreeUtil;

/**
 * 
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 * 
 * For example: Given binary tree [3,9,20,null,null,15,7],
 * 
    3
   / \
  9  20
    /  \
   15   7
 * 
 * return its zigzag level order traversal as:
 * 
 * [ [3], [20,9], [15,7] ]
 *
 * 
 */
public class BinaryTreeZigZagLevelOrderTraversal {
	public static void main(String args[]) {
		BinaryTreeZigZagLevelOrderTraversal tree = new BinaryTreeZigZagLevelOrderTraversal();
		TreeNode root = TreeUtil.createTree(Arrays.asList(3, 9, 20, null, null, 15, 7));
		System.out.println(tree.zigzagLevelOrder(root));
		System.out.println(tree.zigzagLevelOrderRec(root));

	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		boolean zigzag = false;
		while (!queue.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			int cnt = queue.size();
			for (int i = 0; i < cnt; i++) {
				root =queue.poll();
				if (zigzag) {
					level.add(root.val);
				} else {
					level.add(0, root.val);
				}
				if (root.right != null) {
					queue.offer(root.right);
				}
				if (root.left != null) {
					queue.offer(root.left);
				}

			}
			res.add(level);
			zigzag = !zigzag;
		}
		return res;
	}

	public List<List<Integer>> zigzagLevelOrderRec(TreeNode root) {
		List<List<Integer>> sol = new ArrayList<>();
		travel(root, sol, 0);
		return sol;
	}

	private void travel(TreeNode curr, List<List<Integer>> sol, int level) {
		if (curr == null)
			return;

		if (sol.size() <= level) {
			List<Integer> newLevel = new LinkedList<>();
			sol.add(newLevel);
		}

		List<Integer> collection = sol.get(level);
		if (level % 2 == 0)
			collection.add(curr.val);
		else
			collection.add(0, curr.val);

		travel(curr.left, sol, level + 1);
		travel(curr.right, sol, level + 1);
	}
}