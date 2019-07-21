package com.ds.binarytree;

import java.util.HashMap;
import java.util.Map;

class ConstructBTFromPreorderAndInorderTraversal {
 
	public TreeNode buildTree(int[] preorder, int[] inorder) {
	    Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

	    for(int i = 0; i < inorder.length; i++) {
	        inMap.put(inorder[i], i);
	    }

	    TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
	    return root;
	}

	public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
	    if(preStart > preEnd || inStart > inEnd) return null;

	    TreeNode root = new TreeNode(preorder[preStart]);
	    int inRoot = inMap.get(root.val);
	    int numsLeft = inRoot - inStart;

	    root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
	    root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

	    return root;
	}
    void printInorder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }
 
    public static void main(String args[]) {
    	ConstructBTFromPreorderAndInorderTraversal tree = new ConstructBTFromPreorderAndInorderTraversal();
    	int in[] = new int[]{3,9,20,15,7};
    	int pre[] = new int[]{9,3,15,20,7};
    	TreeNode mynode = tree.buildTree(pre,in);
 
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printInorder(mynode);
    }
  
}