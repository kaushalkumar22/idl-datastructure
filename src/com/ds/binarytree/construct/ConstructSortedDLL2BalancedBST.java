package com.ds.binarytree.construct;

public class ConstructSortedDLL2BalancedBST {

	private ListNode head = null;
	private ListNode tail = null;

	public void addToList(int data) {
		ListNode n = new ListNode(data);
		if (head == null) {
			head = n;
			tail = n;
		} else {
			// Add to end of list
			n.prev = tail;
			tail.next = n;
			tail = n;
		}
	}

	/**
	 * Convert DLL to BST: 
	 * prev node will be right child
	 * next node will be left child
	 */
	public void convertDllToBST() {
		int len = getListLength();
		// head is root of BST, tail is null.
		head = convertDllToBST(len);
		tail = null;
	}

	private int getListLength() {
		int len = 0;
		ListNode curr = head;
		while (curr != null) {
			len++;
			curr = curr.next;
		}
		return len;
	}

	private ListNode convertDllToBST(int len) {
		if (len == 0) {
			return null;
		}

		ListNode left = convertDllToBST(len / 2);
		ListNode root = head;
		root.prev = left;
		head = head.next;
		ListNode right = convertDllToBST(len - (len / 2) - 1);
		root.next = right;
		return root;
	}

	public void printInorderOrderTraversal() {
		printInorderOrderTraversalHelper(head);
	}

	private void printInorderOrderTraversalHelper(ListNode root) {
		if (root == null) {
			return;
		}

		printInorderOrderTraversalHelper(root.prev);
		System.out.print(root.val + " ");
		printInorderOrderTraversalHelper(root.next);
	}

	public static void main(String args[]) {
		ConstructSortedDLL2BalancedBST dll = new ConstructSortedDLL2BalancedBST();
		for (int i = 1; i < 8; i++) {
			dll.addToList(i);
		}
		dll.convertDllToBST();
		dll.printInorderOrderTraversal();
	}
	private class ListNode {
		int val;
		ListNode prev;
		ListNode next;

		public ListNode(int data) {
			this.val = data;
		}
	}
}


