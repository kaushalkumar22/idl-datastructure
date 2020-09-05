package com.algo.linkedlist;

import java.util.Arrays;
import java.util.List;

/**
 * Given a linked list, reverse the Alternate K ListNodes of a linked list and
 * return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked
 * list. 
 * 
 * Given this linked list: 1->2->3->4->5->6
 * 
 * For k = 2, you should return: 2->1->3->4->6->5
 * 
 * For k = 3, you should return: 3->2->1->4->5->6
 * 
 * Note:
 * 
 * Only constant extra memory is allowed. You may not alter the values in the
 * list's ListNodes, only ListNodes itself may be changed.
 * 
 */

public class ReverseAlternateKNodes {
	public static void main(String[] args) {

		ReverseAlternateKNodes list = new ReverseAlternateKNodes();
		List<Integer> nums = Arrays.asList(7, 5, 9, 4, 6, 10);
		ListNode head = ListUtil.createList(nums);
		System.out.print("Original List :: ");
		ListUtil.print(head);
		ListNode node = list.reverseAlternateK(head,2);
		System.out.print("Reverse List   :: ");
		ListUtil.print(node);
	}
	private  ListNode reverseAlternateK(ListNode head, int k) {

		ListNode curr = head;
		ListNode cnext = null, prev = null;

		// 1) reverse first k ListNodes of the linked list 
		for(int i=0;i<k&&curr!=null;i++){
			cnext = curr.next;
			curr.next = prev;
			prev = curr;
			curr = cnext;
		}

		// 2) Now head points to the kth ListNode.  So change next  of head to (k+1)th ListNode
		if (curr != null) {
			head.next = curr;
		}

		// 3) We do not want to reverse next k ListNodes. So move the current pointer to skip next k ListNodes 
		for(int i=0;i<k-1&&curr!=null;i++){
			curr = curr.next;
		}

		// 4) Recursively call for the list starting from current->next. And make rest of the list as next of first ListNode 
		if (curr != null) {
			curr.next = reverseAlternateK(curr.next, k);
		}

		// 5) prev is new head of the input list 
		return prev;
	}
}