package com.algo.tree.validate;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.algo.tree.common.TreeNode;
import com.algo.tree.common.TreeUtil;

/*
 * In a complete binary tree every level, except possibly the last, is completely filled, 
 * and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes at the last level h
 * 
 * 1. Calculate the number of nodes (count) in the binary tree.
  2. Start recursion of the binary tree from the root node of the binary tree with index (i) being set as 0 
     and the number of nodes in the binary (count).
  3. If the current node under examination is NULL, then the tree is a complete binary tree. Return true.
  4. If index (i) of the current node is greater than or equal to the number of nodes in the binary tree (count) 
     i.e. (i>= count), then the tree is not a complete binary. Return false.
  5. Recursively check the left and right sub-trees of the binary tree for same condition. 
     For the left sub-tree use the index as (2*i + 1) while for the right sub-tree use the index as (2*i + 2).
 */
public class CompleteBinaryTree {

	public static void main(String args[]) {

		CompleteBinaryTree tree = new CompleteBinaryTree();
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
		TreeNode root =TreeUtil.createTree(nums);


		int node_count = tree.countNodes(root);
		int index = 0;
        System.out.println(tree.isComplete(root, index, node_count));
	}
	// This function counts the number of nodes in a binary tree 
	private int countNodes(TreeNode node) {
		if (node == null) return 0;

		return (1 + countNodes(node.left) + countNodes(node.right));
	}

	boolean isComplete(TreeNode node, int i, int number_nodes){

		// An empty tree is complete
		if (node == null)   return true;

		// If index assigned to current node is more than number of nodes in tree, then tree is not complete
		if (i >= number_nodes) return false;

		// Recur for left and right subtrees
		return (isComplete(node.left, 2 * i + 1, number_nodes)
				&& isComplete(node.right, 2 * i + 2, number_nodes));
	}
	 public boolean isCompleteTree(TreeNode root) {
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.offer(root);
	        boolean seenEmpty = false;
	        
	        while(!queue.isEmpty()) {
	            TreeNode curr = queue.poll();
	            if (curr == null) {
	                seenEmpty = true;
	                continue;
	            } else if (seenEmpty) {
	                    return false;
	            }      
	            queue.offer(curr.left);
	            queue.offer(curr.right);
	        }   
	        return true;
	    }

	

}