package com.algo.nlds.tree.common;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * For a binary tree T, we can define a flip operation as follows: choose any
 * node, and swap the left and right child subtrees.
 * 
 * A binary tree X is flip equivalent to a binary tree Y if and only if we can
 * make X equal to Y after some number of flip operations.
 * 
 * Write a function that determines whether two binary trees are flip
 * equivalent. The trees are given by root nodes root1 and root2.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 =
 * [1,3,2,null,6,4,5,null,null,null,null,8,7] Output: true Explanation: We
 * flipped at nodes with values 1, 3, and 5. Flipped Trees Diagram
 * 
 *             1                            1
 *            / \                          / \
 *           2   3                        3   2
 *          /   / \                      / \   \
           4   5   6                    6   5   4
 *
 */        
public class FlipEquivalentBinaryTrees {

/*	Recursive version: DFS

	If at least one of the two root nodes is null, are they equal? if yes, true; if no, false;
	otherwise, neither node is null; if the values of the two nodes are:
	2a) NOT equal, return false;
	2b) equal, compare their children recursively.*/
	    public boolean flipEquiv(TreeNode r1, TreeNode r2) {
	        if (r1 == null || r2 == null) return r1 == r2;
	        return r1.val == r2.val &&
	               (flipEquiv(r1.left, r2.left) && flipEquiv(r1.right, r2.right) || 
	               flipEquiv(r1.left, r2.right) && flipEquiv(r1.right, r2.left));
	    }
	  
	//Iterative version: BFS

	    public boolean flipEquiv1(TreeNode root1, TreeNode root2) {
	        Queue<TreeNode> q1 = new LinkedList<>(), q2 = new LinkedList<>();
	        q1.offer(root1);
	        q2.offer(root2);
	        while (!q1.isEmpty() && !q2.isEmpty()) {
	            TreeNode n1 = q1.poll(), n2 = q2.poll();
	            if (n1 == null || n2 == null) {
	                if (n1 != n2) return false;
	                else continue;
	            }
	            if (n1.val != n2.val) {
	                return false;
	            }
	            if (n1.left == n2.left || n1.left != null && n2.left != null && n1.left.val == n2.left.val) {
	                q1.addAll(Arrays.asList(n1.left, n1.right));
	            }else {
	                q1.addAll(Arrays.asList(n1.right, n1.left));
	            }
	            q2.addAll(Arrays.asList(n2.left, n2.right));
	        }
	        return q1.isEmpty() && q2.isEmpty();
	    }
	  
	//Iterative version: DFS

	    public boolean flipEquiv2(TreeNode root1, TreeNode root2) {
	        Stack<TreeNode> stk1 = new Stack<>(), stk2 = new Stack<>();
	        stk1.push(root1);
	        stk2.push(root2);
	        while (!stk1.isEmpty() && !stk2.isEmpty()) {
	            TreeNode n1 = stk1.pop(), n2 = stk2.pop();
	            if (n1 == null && n2 == null) {
	                continue;
	            }else if (n1 == null || n2 == null || n1.val != n2.val) {
	                return false;
	            }

	            if (n1.left == n2.left || n1.left != null && n2.left != null && n1.left.val == n2.left.val) {
	                stk1.addAll(Arrays.asList(n1.left, n1.right));
	            }else {
	                stk1.addAll(Arrays.asList(n1.right, n1.left));
	            }
	            stk2.addAll(Arrays.asList(n2.left, n2.right));
	        }
	        return stk1.isEmpty() && stk2.isEmpty();
	    }
	  
	/*Update:
	For some time, I forgot the following constraint and changed the comlexity from O(n) to O(n ^ 2):
	Each value in each tree will be a unique integer in the range [0, 99]

	The follows are correct only without the above condition.
	Complexity analysis corrected from O(n) to O(n ^ 2).
	Analysis:

	In worst case, the recursion corresponds to a perfect quaternary (means 4-nary) tree, which has 4 ^ d = N ^ 2 nodes, and we have to traverse all nodes. d = logN is the depth of the binary tree.

	One worst case for input:
	two perfect binary trees: root1 & root2.

	Root1's nodes are all 0s;
	Root2's nodes are all 0s, with the exception that left and right bottoms are both 1s.
	Time & Space: O(n ^ 2).
	Thanks correction from @heruslu @coder_coder @Everestsky007

	Q & A:

	Q1:
	why it's N^2 and how it corresponds to a 4-nary tree? why it was initially considered O(N)?
	A1:
	Yes, because the return statement has 4 recursive calls.

	The problem states Each value in each tree will be a unique integer in the range [0, 99], hence we have the following deduction:

	ir1.left.val == r2.left.val and r1.left.val == r2.right.val, 

	at most 1 of the 2 relations is true; otherwise r2.left.val == r2.right.val, this contradicts the above problem constraint.
	Therefore, at least 1 out of flipEquiv(r1.left, r2.left) and flipEquiv(r1.left, r2.right) will terminate; Similiarly, at least 1 out of flipEquiv(r1.right, r2.right) andflipEquiv(r1.right, r2.leftt) will terminate.

	Obviously at most 2 out of the 4 recursive calls could go all the way down to the bottom.

	That is why the time is O(N).

	Without the aforementioned constraint, all of the 4 recursive calls could expand the 4-nary tree to the bottom and result time O(N ^ 2).

	Q2: In iterative Python code, why there needs to be a comparison of node1.left == node2.left?
	A2: It is a short form of node1.left == node2.left == None.*/
}
