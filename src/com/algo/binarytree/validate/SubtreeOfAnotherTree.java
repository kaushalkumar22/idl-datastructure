package com.algo.binarytree.validate;

import java.util.Arrays;
import java.util.List;

import com.algo.binarytree.common.TreeNode;
import com.algo.binarytree.common.TreeUtil;

/**
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
ALgo: 1 time complexity O(n^2) and space O(1)

1.If small tree is null' then return true since 'null' tree is sub-tree for any tree.
2.If Big tree is null'  then return false since null tree cannot have any sub-tree except null tree for which 
we have already checked in.
3.If both 1 and 2 are false then check if value of small root is equal to value of big.
if yes then 
4. If condition #3 evaluated to true then we check if left sub-tree of 
   smallTreeRoot exactly matches to left sub-tree of bigTreeRoot and right sub-tree of smallTreeRoot exactly matches to right sub-tree of bigTreeRoot. 
   If both sub-trees match then we return true since we know that smallTree is now a sub-tree of bigTree.
5. If either #3 or #4 evaluate to false then we check if left sub-tree of bigTreeRoot contains smallTree or 
   right sub-tree of bigTreeRoot contains smallTree. For checking this we simply make recursive calls.*/
//Time Complexity: Time worst case complexity of above solution is O(n^2) where m and n are number of nodes in given two trees. 
public class SubtreeOfAnotherTree {

	/* A utility function to check whether trees with roots as root1 and root2 are identical or not */
	boolean areIdentical(TreeNode node1, TreeNode node2) {

		if (node1 == null && node2 == null) return true;		

		/* Check if the data of both roots is same and data of left and right subtrees are also same */
		return (node1.val == node2.val&& areIdentical(node1.left, node2.left)
				&& areIdentical(node1.right, node2.right));
	}

	/* This function returns true if S is a subtree of T, otherwise false */
	private boolean isSubtree(TreeNode big, TreeNode small) {

		/* base cases */
		if (small == null) return true;
		if (big == null) return false;

		/* Check the tree with root as current node */
		if (areIdentical(big, small)) return true;

		/* If the tree with root as current node doesn't match then try left and right subtrees one by one */
		return isSubtree(big.left, small)|| isSubtree(big.right, small);
	}

	public static void main(String args[]) {

		SubtreeOfAnotherTree tree = new SubtreeOfAnotherTree();
		List<Integer> nums = Arrays.asList(26,10,3,4,6,null,3,null,30);
		TreeNode root1 =TreeUtil.createTree(nums);
		List<Integer> nums1 = Arrays.asList(10,4,6,null,30);
		TreeNode root2 =TreeUtil.createTree(nums1);
		if (tree.isSubtree(root1, root2)) {
			System.out.println("Tree 2 is subtree of Tree 1 ");
		} else {
			System.out.println("Tree 2 is not a subtree of Tree 1");
		}
		/* 
              26
             /   \
            10    3
           /  \    \
          4   6     3
           \
            30  

           10
         /    \
        4      6
         \
          30  */

	}
}
