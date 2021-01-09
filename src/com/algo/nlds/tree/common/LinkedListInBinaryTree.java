package com.algo.nlds.tree.common;

import java.util.ArrayList;
import java.util.List;

import com.algo.lds.linkedlist.ListNode;

/**
 * Given a binary tree root and a linked list with head as the first node.
 * 
 * Return True if all the elements in the linked list starting from the head
 * correspond to some downward path connected in the binary tree otherwise
 * return False.
 * 
 * In this context downward path means a path that starts at some node and goes
 * downwards.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: head = [4,2,8], root =
 * [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3] Output: true
 * Explanation: Nodes in blue form a subpath in the binary Tree.
 * 
 * Example 2:
 * 
 * Input: head = [1,4,2,6], root =
 * [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3] Output: true
 * 
 * Example 3:
 * 
 * Input: head = [1,4,2,6,8], root =
 * [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3] Output: false
 * Explanation: There is no path in the binary tree that contains all the
 * elements of the linked list from head.
 * 
 */
public class LinkedListInBinaryTree {

	public boolean isSubPathRec(ListNode head, TreeNode root) {
		if (head == null) return true;
		if (root == null) return false;
		return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
	}

	private boolean dfs(ListNode head, TreeNode root) {
		if (head == null) return true;
		if (root == null) return false;
		return head.val == root.val && (dfs(head.next, root.left) || dfs(head.next, root.right));
	}
	public boolean isSubPath(ListNode head, TreeNode root) {
		List<Integer> A = new ArrayList(), dp = new ArrayList();
		A.add(head.val);
		dp.add(0);
		int i = 0;
		head = head.next;
		while (head != null) {
			while (i > 0 && head.val != A.get(i))
				i = dp.get(i - 1);
			if (head.val == A.get(i)) ++i;
			A.add(head.val);
			dp.add(i);
			head = head.next;
		}
		return dfs(root, 0, A, dp);
	}

	private boolean dfs(TreeNode root, int i, List<Integer> A, List<Integer> dp) {
		if (root == null) return false;
		while (i > 0 && root.val != A.get(i))
			i = dp.get(i - 1);
		if (root.val == A.get(i)) ++i;
		return i == dp.size() || dfs(root.left, i, A, dp) || dfs(root.right, i, A, dp);
	}
}
