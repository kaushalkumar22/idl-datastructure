package com.ds.binarytree.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Given a binary tree, return all root-to-leaf paths.
Note: A leaf is a node with no children.
Input:

   1
 /   \
2     3
 \
  5
Output: ["1->2->5", "1->3"]
Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 *
 */
public class BinaryTreePaths {

	public static void main(String[] args) {
		BinaryTreePaths tree =new BinaryTreePaths();
		List<Integer> nums = Arrays.asList(1,2,3,null,5);
		TreeNode root =TreeUtil.createTree(nums);
		System.out.println(tree.binaryTreePaths( root));
	}
	public List<String> binaryTreePaths(TreeNode root) {
	    List<String> answer = new ArrayList<String>();
	    if (root != null) searchBT(root, "", answer);
	    return answer;
	}
	private void searchBT(TreeNode root, String path, List<String> answer) {
	    if (root.left == null && root.right == null) answer.add(path + root.val);
	    if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
	    if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
	}
}
