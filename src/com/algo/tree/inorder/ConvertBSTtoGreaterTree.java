package com.algo.tree.inorder;

import java.util.Arrays;
import java.util.Stack;

import com.algo.tree.common.TreeNode;
import com.algo.tree.common.TreeUtil;

/**
 * 
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that
 * every key of the original BST is changed to the original key plus sum of all
 * keys greater than the original key in BST.
 * 
 Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
 *
 * 
 */
public class ConvertBSTtoGreaterTree {
	public static void main(String[] args) {
		ConvertBSTtoGreaterTree tree = new ConvertBSTtoGreaterTree();
		TreeNode root = TreeUtil.createTree(Arrays.asList(3, 9, 20, null, null, 15, 7));
		TreeNode r1=tree.convertBSTRec(root);
		TreeNode r2=tree.convertBST(root);
		TreeUtil.inorder(r1);
		TreeUtil.inorder(r2);

	}

	int sum = 0;

	 public TreeNode convertBSTRec(TreeNode root) {
	        // Write your code here
	        int sum = 0; 
	        helper(root, sum);
	        return root;
	    }
	    
	    public int helper(TreeNode root, int sum) {
	        if (root == null) {
	            return sum;
	        }
	        int right = helper(root.right, sum);
	        root.val += right;
	        int left = helper(root.left, root.val);
	        
	        return left;
	    }
	public TreeNode convertBST(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        int sum = 0;
        while (node != null || !stack.isEmpty())
        {
            if (node != null)
            {
                stack.push(node);
                node = node.right;
            }
            else
            {
                node = stack.pop();
                sum += node.val;
                node.val = sum;
                
                node = node.left;
            }
        }
        
        return root;
    }
}

