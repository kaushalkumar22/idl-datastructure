package com.algo.nlds.tree.dp;

import java.util.ArrayList;
import java.util.List;

import com.algo.nlds.tree.common.TreeNode;

/**
 * 
 * Given an integer n, generate all structurally unique BST's (binary search
 * trees) that store values 1 ... n.
 * 
 * Example:
 * 
 * Input: 3 Output: [ [1,null,3,2], [3,2,null,1], [3,1,null,null,2], [2,1,3],
 * [1,null,2,null,3] ] Explanation: The above output corresponds to the 5 unique
 * BST's shown below:
 *

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * 
 */
public class UniqueBinarySearchTreesII {
	public static void main(String[] args) {

	}

	public static List<TreeNode> generateTrees(int n) {
	    List<TreeNode>[] result = new List[n + 1];
	    result[0] = new ArrayList<TreeNode>();
	    if (n == 0) {
	        return result[0];
	    }

	    result[0].add(null);
	    for (int len = 1; len <= n; len++) {
	        result[len] = new ArrayList<TreeNode>();
	        for (int j = 0; j < len; j++) {
	            for (TreeNode nodeL : result[j]) {
	                for (TreeNode nodeR : result[len - j - 1]) {
	                    TreeNode node = new TreeNode(j + 1);
	                    node.left = nodeL;
	                    node.right = clone(nodeR, j + 1);
	                    result[len].add(node);
	                }
	            }
	        }
	    }
	    return result[n];
	}

	private static TreeNode clone(TreeNode n, int offset) {
	    if (n == null) {
	        return null;
	    }
	    TreeNode node = new TreeNode(n.val + offset);
	    node.left = clone(n.left, offset);
	    node.right = clone(n.right, offset);
	    return node;
	}
}
