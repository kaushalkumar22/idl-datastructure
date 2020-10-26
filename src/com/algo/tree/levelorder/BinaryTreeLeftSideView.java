package com.algo.tree.levelorder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.algo.tree.common.TreeNode;
import com.algo.tree.common.TreeUtil;

/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * Example:
 * 
 * Input: [1,2,3,null,5,null,4] 
 * Output: [1, 2, 5] 
 * Explanation:
 *---> 1            
      /   \
---> 2     3        
      \     \
--->  5     4   

 * 
 */

public class BinaryTreeLeftSideView {

	public static void main(String args[]) {
		BinaryTreeLeftSideView tree = new BinaryTreeLeftSideView();
		TreeNode root = TreeUtil.createTree(Arrays.asList(1,2,3,null,5,null,4));
		System.out.println(tree.leftSideView( root));
		System.out.println(tree.leftSideViewRec( root));
	}

	public List<Integer> leftSideViewRec(TreeNode root) {
		List<Integer> list =new ArrayList<Integer>();
		leftView( root,list,0);
		return list;
	}

	private void leftView(TreeNode root,List<Integer> list, int level) {

		if (root == null) return;

		if (list.size()==level) {
			list.add(root.val);
		}
		leftView(root.left, list,level + 1);
		leftView(root.right, list,level + 1);
		
	}

	public List<Integer> leftSideView(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) return res;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			int size = queue.size();

			for(int i=0;i<size;i++) {
				root = queue.poll();
				if ( i== 0)
					res.add(root.val);
				
				if (root.left != null)
					queue.offer(root.left);
				
				if (root.right != null)
					queue.offer(root.right);		
			}
		}

		return res;
	}

}