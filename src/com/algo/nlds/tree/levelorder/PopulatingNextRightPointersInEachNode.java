package com.algo.nlds.tree.levelorder;
/**
 * Populating Next Right Pointers in Each Node Medium
 * 
 * You are given a perfect binary tree where all leaves are on the same level,
 * and every parent has two children. The binary tree has the following
 * definition:
 * 
 * struct Node { int val; Node *left; Node *right; Node *next; }
 * 
 * Populate each next pointer to point to its next right Node. If there is no
 * next right Node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * Follow up:
 * 
 * You may only use constant extra space. Recursive approach is fine, you may
 * assume implicit stack space does not count as extra space for this problem.
 * Example 1:
 * 
 * Input: root = [1,2,3,4,5,6,7] 
 * Output: [1,#,2,3,#,4,5,6,7,#] 
 * Explanation:
 * Given the above perfect binary tree (Figure A), your function should populate
 * each next pointer to point to its next right Node, just like in Figure B. The
 * serialized output is in level order as connected by the next pointers, with
 * '#' signifying the end of each level.
 * 
 */
public class PopulatingNextRightPointersInEachNode {

	public Node connect(Node root) {
		if (root == null) return null;
		Node pre = root;
		Node cur = null;
		while(pre.left!=null) {
			cur = pre;
			while(cur!=null) {
				cur.left.next = cur.right;
				if(cur.next!=null) cur.right.next = cur.next.left;
				cur = cur.next;
			}
			pre = pre.left;
		}
		return root;
	}
	public Node connectRec(Node root) {
		if(root == null)
			return root;

		if(root.left != null){
			root.left.next = root.right;
			if(root.next != null)
				root.right.next = root.next.left;
		}

		connectRec(root.left);
		connectRec(root.right);
		return root;
	}
	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {}

		public Node(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
			this.next = null;
		}
	};
}
