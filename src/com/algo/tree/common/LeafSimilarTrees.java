package com.algo.tree.common;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Consider all the leaves of a binary tree, from left to right order, the
 * values of those leaves form a leaf value sequence.
 * 
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9,
 * 8).
 * 
 * Two binary trees are considered leaf-similar if their leaf value sequence is
 * the same.
 * 
 * Return true if and only if the two given trees with head nodes root1 and
 * root2 are leaf-similar.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 =
 * [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8] Output: true
 * 
 * Example 2:
 * 
 * Input: root1 = [1], root2 = [1] Output: true
 * 
 * Example 3:
 * 
 * Input: root1 = [1], root2 = [2] Output: false
 * 
 * Example 4:
 * 
 * Input: root1 = [1,2], root2 = [2,2] Output: true
 * 
 * Example 5:
 * 
 * Input: root1 = [1,2,3], root2 = [1,3,2] Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in each tree will be in the range [1, 200]. Both of the
 * given trees will have values in the range [0, 200].
 * 
 * 
 */
public class LeafSimilarTrees {

	public static void main(String[] args) {
		LeafSimilarTrees tree = new LeafSimilarTrees();
		List<Integer> nums1 = (List<Integer>) Arrays.asList(3, 5, 1, 6, 2, 9, 8, null, null, 7, 4);
		TreeNode root1 = TreeUtil.createTree(nums1);
		List<Integer> nums2 = (List<Integer>) Arrays.asList(3, 10, 12, 6, 22, 9, 8, null, null, 7, 4);
		TreeNode root2 = TreeUtil.createTree(nums2);
		System.out.println(tree.leafSimilar(root1, root2));
	}

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();
		s1.push(root1);
		s2.push(root2);
		while (!s1.empty() && !s2.empty())
			if (dfs(s1) != dfs(s2))
				return false;
		return s1.empty() && s2.empty();
	}

	public int dfs(Stack<TreeNode> s) {
		while (true) {
			TreeNode node = s.pop();
			if (node.right != null)
				s.push(node.right);
			if (node.left != null)
				s.push(node.left);
			if (node.left == null && node.right == null)
				return node.val;
		}
	}
}
