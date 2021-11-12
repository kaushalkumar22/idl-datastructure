package com.algo.tree.inorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import com.algo.tree.common.TreeNode;
import com.algo.tree.common.TreeUtil;

/**
 * 
 * Given a binary tree, return the inorder traversal of its TreeNodes' values.
 * 
 * Example:
 * 
 * Input: [1, null, 2, null, null, 3]
 *  1 
 *   \ 
 *    2
 *   / 
 *  3
 * 
 * Output: [1,3,2]
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 * 
 */
public class BinaryTreeInorderTraversal {

	public static void main(String args[]) {
		BinaryTreeInorderTraversal tree = new BinaryTreeInorderTraversal();

		TreeNode root = TreeUtil.createTree(Arrays.asList(1,null,2,null,null,3));
		System.out.println( tree.inorderRecursion(root));
		System.out.println(tree.inorderTraversal(root));
	}
	private List<Integer> inorderRecursion(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		inorderRecursion( root,list);
		return list;
	}

	private void inorderRecursion(TreeNode root, List<Integer> list) {
		if(root==null) return;
		inorderRecursion( root.left,list);
		list.add(root.val);
		inorderRecursion( root.right,list);         
	}

	public List<Integer> inorderTraversal(TreeNode root) {

		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode curr = root;
		while(curr!=null||!st.isEmpty()){

			if(curr!=null){
				st.push(curr);
				curr=curr.left;
			}else{
				curr = st.pop();
				res.add(curr.val);
				curr=curr.right;
			}
		}
		return res;
	}
}

