package com.ds.binarytree.construct;

import java.util.HashMap;
import java.util.Map;

import com.ds.binarytree.common.TreeNode;

public class ConstructBTFromInorderAndPostorderTraversal {

	public TreeNode buildTree(int[] postorder, int[] inorder) {
	   Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

	    for(int i = 0; i < inorder.length; i++) {
	        inMap.put(inorder[i], i);
	    }

	    TreeNode root = buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inMap);
	    return root;
	}
	private TreeNode buildTree(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, 
			HashMap<Integer,Integer> hm){
		if (ps>pe || is>ie) return null;
		TreeNode root = new TreeNode(postorder[pe]);
		int ri = hm.get(postorder[pe]);
		TreeNode leftchild = buildTree(inorder, is, ri-1, postorder, ps, ps+ri-is-1, hm);
		TreeNode rightchild = buildTree(inorder,ri+1, ie, postorder, ps+ri-is, pe-1, hm);
		root.left = leftchild;
		root.right = rightchild;
		return root;
	}

	public TreeNode buildTree(int[] postorder, int postStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
	    if(postStart > preEnd || inStart > inEnd) return null;

	    TreeNode root = new TreeNode(postorder[postStart]);
	    int inRoot = inMap.get(root.val);
	    int numsLeft = inRoot - inStart;

	    root.left = buildTree(postorder, postStart + 1, postStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
	    root.right = buildTree(postorder, postStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

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
		ConstructBTFromInorderAndPostorderTraversal tree = new ConstructBTFromInorderAndPostorderTraversal();
		int inorder[]   = {4, 8, 2, 5, 1, 6, 3, 7};
		int postorder[] = {8, 4, 5, 2, 6, 7, 3, 1};
		TreeNode mynode = tree.buildTree(postorder, inorder);
		System.out.println("Inorder traversal of constructed tree is : ");
		tree.printInorder(mynode);
	}
}

