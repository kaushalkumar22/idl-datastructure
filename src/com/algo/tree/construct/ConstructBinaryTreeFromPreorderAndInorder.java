package com.algo.tree.construct;

import java.util.HashMap;
import java.util.Map;

import com.algo.tree.common.TreeNode;
import com.algo.tree.common.TreeUtil;

/**
 * 
 * Construct Binary Tree from Preorder and Inorder Traversal Medium
 * 
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * preorder = [3,9,20,15,7] inorder = [9,3,15,20,7]
 * 
 * Return the following binary tree:
 *
 *   3
   / \
  9  20
    /  \
   15   7
 * 
 * 
 */
class ConstructBinaryTreeFromPreorderAndInorder {

	public static void main(String args[]) {

		ConstructBinaryTreeFromPreorderAndInorder tree = new ConstructBinaryTreeFromPreorderAndInorder();
		int in[] = new int[]  { 3, 9, 20, 15, 7 };
		int pre[] = new int[] { 9, 3, 15, 20, 7 };
		TreeNode mynode = tree.buildTree(pre, in);
		TreeUtil.inorder(mynode);
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			indexMap.put(inorder[i], i);
		}
		return build(preorder,inorder, 0, preorder.length - 1,0, inorder.length - 1, indexMap);
	}

	public TreeNode build(int[] preorder,int[] inorder, int pStart, int pEnd,  int iStart, int iEnd,Map<Integer, Integer> indexMap) {
		
		if(pStart>pEnd||iStart>iEnd) return null;
		
		TreeNode root = new TreeNode(preorder[pStart]);
		int iRoot = indexMap.get(root.val);
		int numsLeft = iRoot - iStart;
		root.left= build(preorder,inorder,pStart+1,pStart+numsLeft, iStart,iRoot-1,indexMap);
		root.right= build(preorder,inorder,pStart + numsLeft + 1,pEnd, iRoot+1,iEnd,indexMap);
		return root;
	}
	
	
}