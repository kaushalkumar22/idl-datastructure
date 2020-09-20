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
 * Given a binary tree, return the bottom-up level order traversal of its nodes'
 * values. (ie, from left to right, level by level from leaf to root).
 * 
 * For example: Given binary tree [3,9,20,null,null,15,7],
 * 
 *   3
   / \
  9  20
    /  \
   15   7
 * 
 * return its bottom-up level order traversal as:
 * 
 * [ [15,7], [9,20], [3] ]
 *
 */
public class BinaryTreeLevelOrderTraversalII {
	public static void main(String args[]) {

		BinaryTreeLevelOrderTraversalII tree = new BinaryTreeLevelOrderTraversalII();
		List<Integer> nums = Arrays.asList(3,9,20,null,null,15,7);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println(tree.levelOrderBottom(root));
		System.out.println(tree.levelOrderBottomRec(root));
	}
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
				root =que.poll();
				level.add(root.val);
				if(root.left!=null) {
					que.offer(root.left);
				}
				if(root.right!=null) {
					que.offer(root.right);
				}		
			}
			levelOrder.add(0,level);
		}
		return levelOrder;
	}
	public List<List<Integer>> levelOrderBottomRec(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        levelMaker(wrapList, root, 0);
        return wrapList;
    }
    
    public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if(root == null) return;
        if(level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }
        levelMaker(list, root.left, level+1);
        levelMaker(list, root.right, level+1);
        list.get(list.size()-level-1).add(root.val);
    }
}
