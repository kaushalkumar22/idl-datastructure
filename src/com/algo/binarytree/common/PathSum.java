package com.algo.binarytree.common;

import java.util.ArrayList;
import java.util.List;

/**
Path Sum II
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
Note: A leaf is a node with no children.
Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:
[
   [5,4,11,2],
   [5,8,4,5]
]

Path Sum III
you are given a binary tree in which each node contains an integer value.
Find the number of paths that sum to a given value.
The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
 *
 */
public class PathSum {

	//Also using ArrayList allows O(1) access to the each node, that means removing the last element takes only O(1). 
	//If you use LinkedList, initially we have traverse the list to the last node then remove it, which takes O(n) time. 
	//I guess this is what @firesum is trying to suggest.

	public List<List<Integer>> pathSumII(TreeNode root, int sum) {
	    List<List<Integer>>ret = new ArrayList<List<Integer>>(); 
	    List<Integer> cur = new ArrayList<Integer>(); 
	    pathSumII(root, sum, cur, ret);
	    return ret;
	}

	public void pathSumII(TreeNode root, int sum, List<Integer>cur, List<List<Integer>>ret){
	    if (root == null){
	        return; 
	    }
	    cur.add(root.val);
	    if (root.left == null && root.right == null && root.val == sum){
	        ret.add(new ArrayList(cur));
	    }else{
	        pathSumII(root.left, sum - root.val, cur, ret);
	        pathSumII(root.right, sum - root.val, cur, ret);
	    }
	    cur.remove(cur.size()-1);
	}
	//Space: O(n) due to recursion.
	//Time: O(n^2) in worst case (no branching); O(nlogn) in best case (balanced tree).

	    public int pathSumIII(TreeNode root, int sum) {
	        if (root == null) return 0;
	        return pathSumFromIII(root, sum) + pathSumIII(root.left, sum) + pathSumIII(root.right, sum);
	    }
	    
	    private int pathSumFromIII(TreeNode node, int sum) {
	        if (node == null) return 0;
	        return (node.val == sum ? 1 : 0) 
	            + pathSumFromIII(node.left, sum - node.val) + pathSumFromIII(node.right, sum - node.val);
	    }
	}

