package com.algo.linkedlist.mergesort;

import java.util.Arrays;
import java.util.List;

import com.algo.linkedlist.ListNode;
import com.algo.linkedlist.ListUtil;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
 *
 */

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		ListNode head1 = ListUtil.createList(Arrays.asList(1,2,4));
		ListNode head2 = ListUtil.createList(Arrays.asList(1,3,4));
		MergeTwoSortedLists list = new MergeTwoSortedLists();
		ListNode node1 =list.mergeTwoLists(head1,head2);
		ListUtil.print(node1);
	}
	public ListNode mergeTwoLists(ListNode left, ListNode right) {
		ListNode dummy = new ListNode(0);
		ListNode result=dummy;
		while (left != null && right != null) {
			if (left.val < right.val) {
				dummy.next = left;     
				left = left.next;
			} else {
				dummy.next = right;
				right = right.next;
			}
			dummy = dummy.next;
		}
		if(left==null){
			dummy.next=right;        
		}
		if(right==null){
			dummy.next=left;
		} 
		return result.next;
	}

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
}
