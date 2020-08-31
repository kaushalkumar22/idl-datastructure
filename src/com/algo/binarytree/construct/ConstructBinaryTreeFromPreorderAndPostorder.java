package com.algo.binarytree.construct;

import com.algo.binarytree.common.TreeNode;
import com.algo.binarytree.common.TreeUtil;
/**
Return any binary tree that matches the given preorder and postorder traversals.
Values in the traversals pre and post are distinct positive integers.
Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]
 
 * @author I339640
 *
 */
public class ConstructBinaryTreeFromPreorderAndPostorder {
	
	int preIndex = 0, posIndex = 0;
	public static void main(String[] args) {
		ConstructBinaryTreeFromPreorderAndPostorder tree = new ConstructBinaryTreeFromPreorderAndPostorder();
		int[] pre ={1,2,4,5,3,6,7};
		int[] post ={4,5,2,6,7,3,1};
		TreeNode root = tree.constructFromPrePost(pre, post);
		TreeUtil.preorder(root);
	}
    public TreeNode constructFromPrePost(int[]pre, int[]post) {
        TreeNode root = new TreeNode(pre[preIndex++]);
        if (root.val != post[posIndex])
            root.left = constructFromPrePost(pre, post);
        if (root.val != post[posIndex])
            root.right = constructFromPrePost(pre, post);
        posIndex++;
        return root;
    }
}
