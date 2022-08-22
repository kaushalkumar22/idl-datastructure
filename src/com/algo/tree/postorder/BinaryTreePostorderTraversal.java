package com.algo.tree.postorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import com.algo.tree.common.TreeNode;
import com.algo.tree.common.TreeUtil;

/**
 * Given the root of a binary tree, return the postorder traversal of its nodes'
 * values.
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * 
 * 
 * Input: root = [1,null,2,3] Output: [3,2,1]
 * 
 * Example 2:
 * 
 * Input: root = [] Output: []
 * 
 * Example 3:
 * 
 * Input: root = [1] Output: [1]
 * 
 * Example 4:
 * 
 * Input: root = [1,2] Output: [2,1]
 * 
 * Example 5:
 * 
 * Input: root = [1,null,2] Output: [2,1]
 * 
 * 
 * 
 * Constraints:
 * 
 * The number of the nodes in the tree is in the range [0, 100]. -100 <=
 * Node.val <= 100
 * 
 * Accepted 405,898 Submissions 730,615
 * 
 */
public class BinaryTreePostorderTraversal {
	public static void main(String args[]) {

		BinaryTreePostorderTraversal tree = new BinaryTreePostorderTraversal();
		TreeNode root = TreeUtil.createTree(Arrays.asList(1, null, 2, null, null, 3));
		System.out.println(tree.postorderTraversal(root));
		System.out.println(tree.postorderTraversalRec(root));
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> postOrder = new ArrayList<Integer>();
		if (root == null)
			return postOrder;
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(root);
		while (!st.isEmpty()) {
			TreeNode node = st.pop();
			postOrder.add(0,node.val);

			if (node.left != null) {
				st.push(node.left);
			}
			if (node.right != null) {
				st.push(node.right);
			}

		}
		return postOrder;

	}

	private List<Integer> postorderTraversalRec(TreeNode root) {
		List<Integer> postOrder = new ArrayList<Integer>();
		helper(root, postOrder);
		return postOrder;
	}

	private void helper(TreeNode root, List<Integer> list) {

		if (root == null) return;
		helper(root.left, list);
		helper(root.right, list);
		list.add(root.val);

	}

}
