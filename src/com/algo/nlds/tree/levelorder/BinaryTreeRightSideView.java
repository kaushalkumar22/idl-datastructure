package com.algo.nlds.tree.levelorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.algo.nlds.tree.common.TreeNode;
import com.algo.nlds.tree.common.TreeUtil;

/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * Example:
 * 
 * Input: [1,2,3,null,5,null,4] 
 * Output: [1, 3, 4] 
 * Explanation:
 * 1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

 * 
 */
public class BinaryTreeRightSideView {

	public static void main(String args[]) {
		BinaryTreeRightSideView tree = new BinaryTreeRightSideView();
		TreeNode root = TreeUtil.createTree(Arrays.asList(1,2,3,null,5,null,4));
		System.out.println(tree.rightSideView( root));
		System.out.println(tree.rightSideViewRec( root));
	}

	public List<Integer> rightSideViewRec(TreeNode root) {
		List<Integer> list =new ArrayList<Integer>();
		rightView( root,list,0);
		return list;
	}

	private void rightView(TreeNode root,List<Integer> list, int level) {

		if (root == null) return;

		if (list.size()==level) {
			list.add(root.val);
		}
		rightView(root.right, list,level + 1);
		rightView(root.left, list,level + 1);
	}

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) return res;
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.offer(root);
		while(!que.isEmpty()){
			int count = que.size();
			for(int i=0;i<count;i++) {
				root = que.poll();
				if ( i== 0) {
					res.add(root.val);
				}
				if (root.right != null) {
					que.offer(root.right);
				}
				if (root.left != null) {
					que.offer(root.left);
				}

			}
		}

		return res;
	}

}