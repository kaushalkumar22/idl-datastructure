package com.algo.nlds.tree.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 *     5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
 * 
 * Return:
 * 
 * [ [5,4,11,2], [5,8,4,5] ]
 *
 * 
 * 
 */
public class PathSumII {
	public static void main(String[] args) {
		PathSumII tree=new PathSumII();
		List<Integer> nums = (List<Integer>) Arrays.asList(5,4,8,11,null,13,4,7,2,null,null,5,1);
		System.out.println(nums);
		TreeNode root = TreeUtil.createTree(nums);
		System.out.println(tree.pathSum(root,22));
	}
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, sum, res, path);
        return res;
    }
    
    public void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path){
        if(root==null) return;
        path.add(root.val);
        
        if(root.left==null && root.right==null ){
            if(root.val==sum)
                res.add(new ArrayList<Integer>(path));
            return;
        }
        if(root.left!=null) {
            dfs(root.left,sum-root.val,res,path);
            path.remove(path.size()-1);
        }
        if(root.right!=null) {
            dfs(root.right,sum-root.val,res,path);
            path.remove(path.size()-1);
        }
        
    }
}
