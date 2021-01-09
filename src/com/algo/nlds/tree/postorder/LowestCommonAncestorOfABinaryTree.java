package com.algo.nlds.tree.postorder;

import java.util.Arrays;

import com.algo.nlds.tree.common.TreeNode;
import com.algo.nlds.tree.common.TreeUtil;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
 * in the tree.
 * 
 * According to the definition of LCA on Wikipedia: �The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both p
 * and q as descendants (where we allow a node to be a descendant of itself).�
 * 
 * Given the following binary tree: root = [3,5,1,6,2,0,8,null,null,7,4]
 * Example 1:
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1 Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * 
 * Example 2:
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4 Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant
 * of itself according to the LCA definition.
 * 
 * Note:
 * 
 * All of the nodes' values will be unique. p and q are different and both
 * values will exist in the binary tree
 *
 */
public class LowestCommonAncestorOfABinaryTree {
	public static void main(String args[]) {
		LowestCommonAncestorOfABinaryTree tree = new LowestCommonAncestorOfABinaryTree();
   		TreeNode root = TreeUtil.createTree(Arrays.asList(3,5,1,6,2,0,8,null,null,7,4));
   		TreeNode p=root.left;
   		TreeNode q=root.right.right;
   		System.out.println(tree.lowestCommonAncestor( root,  p,  q).val);
	}
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		 if(root==null||root==p||root==q) return root;
		 
		 TreeNode left=lowestCommonAncestor( root.left,  p,  q);
		 TreeNode right=lowestCommonAncestor( root.right,  p,  q);
		 
		 if(left!=null&&right!=null) return root;
		 
		 return left!=null ?left:right ;
	        
	    }

}