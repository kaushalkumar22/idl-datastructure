package com.ds.linkedlist;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
  *
 */

public class Merge2SortedLists {
	private ListNode head, head1, head2;

	private ListNode mergeSortedLists(ListNode a, ListNode b) {
		ListNode result = null;
		if (a == null)
			return b;
		if (b == null)
			return a;

		/* Pick either a or b, and recur */
		if (a.val <= b.val) {
			result = a;
			result.next = mergeSortedLists(a.next, b);
		} else {
			result = b;
			result.next = mergeSortedLists(a, b.next);
		}
		return result;
	}

	private void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "-->");
			head = head.next;
		}
		System.out.println("");
	}

	public static void main(String[] args) {

		Merge2SortedLists list = new Merge2SortedLists();

		list.head1 = new ListNode(3);
		list.head1.next = new ListNode(7);
		list.head1.next.next = new ListNode(9);
		list.head1.next.next.next = new ListNode(11);
		list.head1.next.next.next.next = new ListNode(13);

		list.head2 = new ListNode(2);
		list.head2.next = new ListNode(4);
		list.head2.next.next = new ListNode(6);
		list.head2.next.next.next = new ListNode(8);
		list.head2.next.next.next.next = new ListNode(10);
		list.head2.next.next.next.next.next = new ListNode(12);

		System.out.print("1st List :: ");
		list.printList(list.head1);
		System.out.print("2nd List :: ");
		list.printList(list.head2);
		list.head = list.mergeSortedLists(list.head1, list.head2);
		System.out.print("Merged Sorted Lists Recursive :: ");
		list.printList(list.head);
	}

	

}
