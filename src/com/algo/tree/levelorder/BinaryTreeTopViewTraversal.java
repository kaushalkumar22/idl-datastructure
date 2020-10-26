package com.algo.tree.levelorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import com.algo.tree.common.TreeNode;
import com.algo.tree.common.TreeUtil;

/**
 * Given a binary tree, imagine yourself standing on the top of it,
 * return the values of the nodes you can see ordered from left to right.
 * 
 * Example:
 * 
 * Input: [1,2,3,null,5,null,4] 
 * Output: [2,1,3,4] 
 * Explanation:
 *       1            
       /   \
      2     3        
       \     \
        5     4   

 * 
 */

public class BinaryTreeTopViewTraversal {

	public static void main(String args[]) {

		BinaryTreeTopViewTraversal tree = new BinaryTreeTopViewTraversal();
		List<Integer> nums = Arrays.asList(1,2,3,null,5,null,4);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println(tree.topViewRec(root));
		System.out.println(tree.topView(root));
	}

	private	List<Integer> topViewRec(TreeNode root) {
		Map<Integer, Integer> levelVal = new TreeMap<Integer,Integer>();
		topViewRec( root, 0,levelVal);
		return new ArrayList<Integer>(levelVal.values());
	}

	private	void topViewRec(TreeNode root, int level,Map<Integer, Integer> levelVal) {
		if (root == null) return;

		if(!levelVal.containsKey(level)){
			levelVal.put(level,root.val);
		}

		topViewRec(root.left,level-1,levelVal);
		topViewRec(root.right,level+1,levelVal);
	}

	private List<Integer> topView(TreeNode root) {
		if (root == null) return new ArrayList<Integer>();

		TreeMap<Integer, Integer> ht = new TreeMap<>();
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		Queue<Integer> lque = new LinkedList<Integer>();
		// add root with level 0
		que.add(root);
		lque.add(0);

		while (!que.isEmpty()) {

			root= que.poll();
			int level =lque.poll();
			if (!ht.containsKey(level)) {
				ht.put(level, root.val);
			}

			// add the left and right children of visiting TreeNodes to the queue
			if (root.left != null) {
				que.offer( root.left);
				lque.offer(level - 1);
			}
			if (root.right != null) {
				que.offer( root.right);
				lque.offer(level + 1);
			}
		}
		return new ArrayList<Integer>(ht.values());
	}
}