package com.algo.tree.levelorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.algo.tree.common.TreeNode;
import com.algo.tree.common.TreeUtil;

/**
 * 
 * Given a binary tree, return the vertical order traversal of its nodes values.
 * 
 * For each node at position (X, Y), its left and right children respectively
 * will be at positions (X-1, Y-1) and (X+1, Y-1).
 * 
 * Running a vertical line from X = -infinity to X = +infinity, whenever the
 * vertical line touches some nodes, we report the values of the nodes in order
 * from top to bottom (decreasing Y coordinates).
 * 
 * If two nodes have the same position, then the value of the node that is
 * reported first is the value that is smaller.
 * 
 * Return an list of non-empty reports in order of X coordinate. Every report
 * will have a list of values of nodes.
 * 
 * 
 * Input: [3,9,20,null,null,15,7] Output: [[9],[3,15],[20],[7]] 
 * 
 * Input: [1,2,3,4,5,6,7] Output: [[4],[2],[1,5,6],[3],[7]]
 *
 */
public class BinaryTreeVerticalOrderTraversal {

	public static void main(String args[]) {

		BinaryTreeVerticalOrderTraversal tree = new BinaryTreeVerticalOrderTraversal();
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println(tree.verticalTraversal(root));
	}
	public List<List<Integer>> verticalTraversal(TreeNode root) {
		Map<Integer, List<Integer>> hzOrderList = new TreeMap<Integer, List<Integer>>();
		traverse(root, 0, hzOrderList);
		return new ArrayList<List<Integer>>(hzOrderList.values());
	}

	private void traverse(TreeNode node, int distace, Map<Integer, List<Integer>> hzOrderList) {

		if (node == null) return;

		if (hzOrderList.containsKey(distace)) {
			List<Integer> nList = hzOrderList.get(distace);
			nList.add(node.val);
		} else {
			List<Integer> n = new ArrayList<Integer>();
			n.add(node.val);
			hzOrderList.put(distace, n);
		}
		traverse(node.left, distace - 1, hzOrderList);
		traverse(node.right, distace + 1, hzOrderList);

	}



}