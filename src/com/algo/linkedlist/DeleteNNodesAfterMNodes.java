package com.algo.linkedlist;

import java.util.Arrays;
import java.util.List;

/**
 * Given the head of a linked list and two integers m and n. Traverse the linked
 * list and remove some nodes in the following way:
 * 
 * Start with the head as the current node. Keep the first m nodes starting with
 * the current node. Remove the next n nodes Keep repeating steps 2 and 3 until
 * you reach the end of the list
 * 
 * Input: head = [1,2,3,4,5,6,7,8,9,10,11,12,13], m = 2, n = 3 Output:
 * [1,2,6,7,11,12]
 * 
 * Explanation: Keep the first (m = 2) nodes starting from the head of the
 * linked List (1 ->2) show in black nodes. Delete the next (n = 3) nodes (3 ->
 * 4 -> 5) show in read nodes. Continue with the same procedure until reaching
 * the tail of the Linked List. Head of linked list after removing nodes is
 * returned.
 *
 */
public class DeleteNNodesAfterMNodes {

	public static void main(String[] args) {
		DeleteNNodesAfterMNodes list = new DeleteNNodesAfterMNodes();
		List<Integer> nums = Arrays.asList(1, 2, 2, 4, 7, 8, 10, 15, 20);
		ListNode node = ListUtil.createList(nums);
		System.out.print("Original List :: ");
		ListUtil.print(node);
		list.deleteListNodes(node, 2, 2);
		System.out.print("New List   :: ");
		list.printList(node);
	}

	private void deleteListNodes(ListNode head, int m, int n) {

		if (head == null)
			return;

		ListNode curr = head, temp = null;
		// it will traverse up to m ListNode and holds previous ListNode in temp
		for (int i = 0; curr != null && i < m; i++) {
			temp = curr;
			curr = curr.next;
		}

		if (curr == null)
			return;
		// it will traverse up to n ListNode
		for (int i = 0; curr != null && i < n; i++) {
			curr = curr.next;
		}
		// it will add mth ListNode next as nth+1 ListNodes i.e here doing dereferencing
		// n ListNodes
		temp.next = curr;
		deleteListNodes(curr, m, n);
	}

	private void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println("");
	}

}
