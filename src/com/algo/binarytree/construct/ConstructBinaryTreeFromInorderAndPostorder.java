package com.algo.binarytree.construct;

import java.util.HashMap;

import com.algo.binarytree.common.TreeNode;
/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
You may assume that duplicates do not exist in the tree.
inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

 *
 */
public class ConstructBinaryTreeFromInorderAndPostorder {

	public TreeNode buildTreePostIn(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length != postorder.length)
			return null;
		HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
		for (int i=0;i<inorder.length;++i)
			hm.put(inorder[i], i);
		return buildTreePostIn(inorder, 0, inorder.length-1, postorder, 0, 
				postorder.length-1,hm);
	}

	private TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, 
			HashMap<Integer,Integer> hm){
		if (ps>pe || is>ie) return null;
		TreeNode root = new TreeNode(postorder[pe]);
		int ri = hm.get(postorder[pe]);
		TreeNode leftchild = buildTreePostIn(inorder, is, ri-1, postorder, ps, ps+ri-is-1, hm);
		TreeNode rightchild = buildTreePostIn(inorder,ri+1, ie, postorder, ps+ri-is, pe-1, hm);
		root.left = leftchild;
		root.right = rightchild;
		return root;
	}
	private void printInorder(TreeNode node) {
		if (node == null) 
			return;
		printInorder(node.left);
		System.out.print(node.val + " ");
		printInorder(node.right);
	}

	public static void main(String args[]) {
		ConstructBinaryTreeFromInorderAndPostorder tree = new ConstructBinaryTreeFromInorderAndPostorder();
		int inorder[]   = {9,3,15,20,7};
		int postorder[] = {9,15,7,20,3};
		TreeNode mynode = tree.buildTreePostIn(inorder, postorder);
		System.out.println("Inorder traversal of constructed tree is : ");
		tree.printInorder(mynode);
	}
}

