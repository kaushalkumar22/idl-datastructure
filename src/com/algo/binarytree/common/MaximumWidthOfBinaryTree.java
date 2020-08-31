package com.algo.binarytree.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum 
 * width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.The width of 
 * one level is defined as the length between the end-nodes(the leftmost and right most non-null nodes in the level, 
 * where the null nodes between the end-nodes are also counted into the length calculation.

           1
         /   \
        3     2
       / \     \  
      5   3     9 

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
          1
         /  
        3    
       / \       
      5   3     

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).

          1
         / \
        3   2 
       /        
      5      

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).

We know that a binary tree can be represented by an array (assume the root begins from the position with index 1 in the array). 
If the index of a node is i, the indices of its two children are 2*i and 2*i + 1. The idea is to use two arrays (start[] and end[]) 
to record the the indices of the leftmost node and rightmost node in each level, respectively. For each level of the tree, the width 
is end[level] - start[level] + 1. Then, we just need to find the maximum width.

 *
 */
public class MaximumWidthOfBinaryTree {

	public static void main(String[] args) {
		MaximumWidthOfBinaryTree tree = new MaximumWidthOfBinaryTree();
		List<Integer> nums = (List<Integer>) Arrays.asList(1,3,2,5,3,null,9);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println("Height of tree is : " + tree.widthOfBinaryTree(root));
	}
	public int widthOfBinaryTree(TreeNode root) {
		return dfs(root, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
	} 
	public int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end){
		if(root == null)return 0;
		if(start.size() == level){
			start.add(order); end.add(order);
		}
		else end.set(level, order);
		int cur = end.get(level) - start.get(level) + 1;
		int left = dfs(root.left, level + 1, 2*order, start, end);
		int right = dfs(root.right, level + 1, 2*order + 1, start, end);
		return Math.max(cur, Math.max(left, right));
	}
}
