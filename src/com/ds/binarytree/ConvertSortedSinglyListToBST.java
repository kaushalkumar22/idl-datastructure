package com.ds.binarytree;

import com.ds.linkedlist.ListNode;

public class ConvertSortedSinglyListToBST {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) return null;
		if (head.next == null) return new TreeNode(head.val);
		ListNode slow = head, pre = null, fast = head;
		while (fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		pre.next = null; //cut left sub list here
		TreeNode n = new TreeNode(slow.val);
		n.left = sortedListToBST(head);
		n.right = sortedListToBST(slow.next);
		return n;
	}
	
}
