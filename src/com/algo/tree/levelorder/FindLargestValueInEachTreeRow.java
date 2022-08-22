package com.algo.tree.levelorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.algo.tree.common.TreeNode;
import com.algo.tree.common.TreeUtil;

/**
 * Given the root of a binary tree, return an array of the largest value in each
 * row of the tree (0-indexed).
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: root = [1,3,2,5,3,null,9] Output: [1,3,9]
 * 
 * Example 2:
 * 
 * Input: root = [1,2,3] Output: [1,3]
 * 
 * Example 3:
 * 
 * Input: root = [1] Output: [1]
 * 
 * Example 4:
 * 
 * Input: root = [1,null,2] Output: [1,2]
 * 
 * Example 5:
 * 
 * Input: root = [] Output: []
 *
 * 
 */
public class FindLargestValueInEachTreeRow {
	public static void main(String[] args) {
		FindLargestValueInEachTreeRow tree = new FindLargestValueInEachTreeRow();
		TreeNode root = TreeUtil.createTree(Arrays.asList(1,3,2,5,3,null,9));
		//System.out.println(tree.largestValues( root));
		System.out.println(tree.largestValuesRec( root));
	}

	public List<Integer> largestValuesRec(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		helper(root, res, 0);
		return res;
	}
	private void helper(TreeNode root, List<Integer> res, int d){
		if(root == null) return;

		//expand list size
		if(d == res.size()){
			res.add(root.val);
		} else{
			//or set value
			res.set(d, Math.max(res.get(d), root.val));
		}
		helper(root.left, res, d+1);
		helper(root.right, res, d+1);
	}
	public List<Integer> largestValues(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		List<Integer> values = new ArrayList<Integer>();    
		if(root != null) q.offer(root);      
		while(!q.isEmpty()) {
			int max = Integer.MIN_VALUE, n = q.size();
			for(int i = 0; i < n; i++) {
				root = q.poll();
				max = Math.max(max, root.val);
				if(root.left != null) q.offer(root.left);
				if(root.right != null) q.offer(root.right);
			}
			values.add(max);
		}    
		return values;
	}
}
