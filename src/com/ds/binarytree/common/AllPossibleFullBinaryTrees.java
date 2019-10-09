package com.ds.binarytree.common;

import java.util.ArrayList;
import java.util.List;
/**
A full binary tree is a binary tree where each node has exactly 0 or 2 children.
Return a list of all possible full binary trees with N nodes.  Each element of the answer is the root node of one possible tree.
Each node of each tree in the answer must have node.val = 0.
You may return the final list of trees in any order.

Input: 7
Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],
[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 *
 */
public class AllPossibleFullBinaryTrees {

	public static void main(String[] args) {
		List<TreeNode> treeNodes = allPossibleFBT(7);
		for (TreeNode treeNode : treeNodes) {
			System.out.print(treeNode);
			System.out.println();
		}
	}
	public static List<TreeNode> allPossibleFBT(int N) {
        if (N <= 0) {
            return new ArrayList<>();
        }
        
        List<TreeNode>[] dp = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            dp[i] = new ArrayList<>();
        }
        dp[1].add(new TreeNode(0));
        
        for (int numNode = 1; numNode <= N; numNode += 2) {
            for (int leftNode = 1; leftNode < numNode; leftNode += 2) {
                for (TreeNode left : dp[leftNode]) {
                    for (TreeNode right : dp[numNode - 1 - leftNode]) {
                        TreeNode root = new TreeNode(0);
                        root.left = left;
                        root.right = right;
                        dp[numNode].add(root);
                    }
                }
            }
        }
        return dp[N];
    }
}