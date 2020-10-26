package com.algo.tree.levelorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.algo.tree.common.TreeNode;
import com.algo.tree.common.TreeUtil;

/**
 * 
 * Given a binary tree, return the level order traversal of its TreeNodes' values.
 * (ie, from left to right, level by level).
 * 
 * For example: Given binary tree [3,9,20,null,null,15,7],
 * 
 *   3
   / \
  9  20
    /  \
   15   7

 * 
 * return its level order traversal as:
 * 
 * [ [3], [9,20], [15,7] ]
 *
 */
public class BinaryTreeLevelOrderTraversal {

	public static void main(String args[]) {

		BinaryTreeLevelOrderTraversal tree = new BinaryTreeLevelOrderTraversal();
		TreeNode root = TreeUtil.createTree(Arrays.asList(1, 2, 2, null, 3, null, 3));
		System.out.println(tree.levelOrder(root));
		System.out.println(tree.levelOrderRec(root));
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
		if(root==null) {
			return levelOrder;
		}
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.add(root);
		while(!que.isEmpty()) {
			int count = que.size();
			List<Integer> level = new ArrayList<Integer>();
			for(int i=0;i<count;i++) {
				root=que.poll();
				level.add(root.val);
				if(root.left!=null) {
					que.offer(root.left);
				}
				if(root.right!=null) {
					que.offer(root.right);
				}
			}
			levelOrder.add(level);
		}
		return levelOrder;

	}
	
	public List<List<Integer>> levelOrderRec(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		travel(root,0,res);
		return res;

	}
	public void travel(TreeNode root,int level,List<List<Integer>> res){
		if(root==null) return;
		
		if(res.size()==level){
			List<Integer> temp  = new ArrayList<Integer>();
			temp.add(root.val);
			res.add(level,temp);			
		}else{
			List<Integer> list = res.get(level);
			list.add(root.val);
		}
		//go left and right
		travel(root.left,level+1,res);
		travel(root.right,level+1,res);
	}
}
