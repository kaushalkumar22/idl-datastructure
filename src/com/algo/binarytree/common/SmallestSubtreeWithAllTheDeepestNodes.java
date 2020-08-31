package com.algo.binarytree.common;

import java.util.Arrays;
import java.util.List;

/**
 * Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.
A node is deepest if it has the largest depth possible among any node in the entire tree.
The subtree of a node is that node, plus the set of all descendants of that node.
Return the node with the largest depth such that it contains all the deepest nodes in its subtree.

Input: [3,5,1,6,2,0,8,null,null,7,4]
Output: [2,7,4]

We return the node with value 2, colored in yellow in the diagram.
The nodes colored in blue are the deepest nodes of the tree.
The input "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]" is a serialization of the given tree.
The output "[2, 7, 4]" is a serialization of the subtree rooted at the node with value 2.
Both the input and output have TreeNode type.
 * @author I339640
 *
 */
public class SmallestSubtreeWithAllTheDeepestNodes {
	public static void main(String[] args) {
		SmallestSubtreeWithAllTheDeepestNodes tree = new SmallestSubtreeWithAllTheDeepestNodes();
		List<Integer> nums = Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
		TreeNode root =TreeUtil.createTree(nums);
		System.out.println(tree.subtreeWithAllDeepest(root));
	}

	private class Pair<T,K>{
		final T key;
		final K value;
		public Pair(T key, K value){
			this.key = key;
			this.value = value;
		}
	}
	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		if(root == null)
			return null;
		return findDepth(root,0).key;
	}
	private Pair<TreeNode,Integer> findDepth(TreeNode node, int depth){
		if(node == null){
			return new Pair<>(null, depth);
		}
		Pair<TreeNode,Integer> left = findDepth(node.left, depth+1);
		Pair<TreeNode,Integer> right = findDepth(node.right, depth+1);
		if(left.value > right.value) 
		{ 
			return left; 
		}
		else if (left.value < right.value)
		{ 
			return right; 
		}
		else
		{
			return new Pair<>(node, left.value);
		}
	}
}