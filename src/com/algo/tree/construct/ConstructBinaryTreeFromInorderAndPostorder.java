package com.algo.tree.construct;

import java.util.HashMap;
import java.util.Map;

import com.algo.tree.common.TreeNode;
import com.algo.tree.common.TreeUtil;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * inorder = [9,3,15,20,7] postorder = [9,15,7,20,3]
 * 
 * Return the following binary tree:
 *
 * 3
   / \
  9  20
    /  \
   15   7
 * 
 */
public class ConstructBinaryTreeFromInorderAndPostorder {
	public static void main(String args[]) {
		ConstructBinaryTreeFromInorderAndPostorder tree = new ConstructBinaryTreeFromInorderAndPostorder();
		int inorder[] = { 9, 3, 15, 20, 7 };
		int postorder[] = { 9, 15, 7, 20, 3 };
		TreeNode mynode = tree.buildTree(inorder, postorder);
		System.out.println("Inorder traversal of constructed tree is : ");
		TreeUtil.inorder(mynode);
	}
    public TreeNode buildTree(int[] inorder, int[] postorder) {
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; ++i) {
			indexMap.put(inorder[i], i);
		}
		return build(inorder,postorder, 0, inorder.length - 1,0, postorder.length - 1, indexMap);
    }
	

	private TreeNode build(int[] inorder,int[] postorder, int iStart, int iEnd, int pStart, int pEnd,Map<Integer, Integer> indexMap) {
		
		if (pStart > pEnd || iStart > iEnd) return null;
		
		TreeNode root = new TreeNode(postorder[pEnd]);
		int iRoot = indexMap.get(root.val);
		int numLeft = iRoot - iStart;
		root.left  = build(inorder, postorder,iStart, iRoot - 1, pStart, pStart +numLeft - 1, indexMap);
		root.right = build(inorder, postorder,iRoot + 1, iEnd, pStart + numLeft, pEnd - 1, indexMap);
		return root;
	}
	
}
