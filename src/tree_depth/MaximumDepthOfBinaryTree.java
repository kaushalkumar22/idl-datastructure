package tree_depth;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import tree_miscellaneous.TreeNode;
import tree_miscellaneous.TreeUtil;

/**
 * Given a binary tree, find its maximum depth. The maximum depth is the number
 * of nodes along the longest path from the root node down to the farthest leaf
 * node. Note: A leaf is a node with no children.
 * 
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 *     3
 *    / \ 
 *   9   20 
 *      /  \ 
 *     15   7
 * 
 * return its depth = 3.
 *
 * 
 */
public class MaximumDepthOfBinaryTree {

	public static void main(String[] args) {

		MaximumDepthOfBinaryTree tree = new MaximumDepthOfBinaryTree();
		List<Integer> nums = (List<Integer>) Arrays.asList(1, 2, 3, 4, 5);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println("Height of tree is : " + tree.maxDepthRec(root));
		System.out.println("Height of tree is : " + tree.maxDepth(root));
	}

	/*
	 * 1. If tree is empty then return 0 
	 * 
	 * 2.
	 *(a) Get the max depth of left subtree recursively i.e.,
	 *    call maxDepth( tree.left-subtree)
	 *(b) Get the max depth of right subtree recursively i.e., 
	 *    call maxDepth( tree.right-subtree)
	 *(c) Get the max of max depths of left and right subtrees and add 1 to it for
	 *    the current node. 
	 *    max_depth = max(max dept of left subtree, max depth of right subtree) + 1 
	 *(d) Return max_depth
	 */
	private int maxDepthRec(TreeNode root) {

		if (root == null)
			return 0;

		int left  = maxDepth(root.left);
		int right = maxDepth(root.right);

		int maxDepth = 1 + Math.max(left, right);
		return maxDepth;
	}

	public int maxDepth(TreeNode root) {
		TreeNode node = root;
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		Stack<Integer> depthStack = new Stack<Integer>();

		int max = 0;
		int depth = 1;
		while (node != null || !nodeStack.isEmpty()) {
			if (node != null) {
				nodeStack.push(node);
				depthStack.push(depth);
				node = node.left;
				depth++;
			} else {
				node = nodeStack.pop();
				depth = depthStack.pop();

				if (depth > max)
					max = depth;

				node = node.right;
				depth++;
			}
		}

		return max;
	}

}