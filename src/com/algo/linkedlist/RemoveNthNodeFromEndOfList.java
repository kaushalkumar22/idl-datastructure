package com.algo.linkedlist;

import java.util.Arrays;
import java.util.List;

/**
 * Given a linked list, remove the n-th node from the end of list and return its
 * head.
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * 
 * Note: Given n will always be valid.
 * 
 * Follow up: Could you do this in one pass?
 *
 */
public class RemoveNthNodeFromEndOfList {
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(7, 5,6,8,6,8);
		ListNode head = ListUtil.createList(nums);
		System.out.print("Original List :: ");
		ListUtil.print(head);
		ListNode node = removeNthFromEnd(head,1);
		System.out.print("Reverse List   :: ");
		ListUtil.print(node);
	}
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode start = new ListNode(0);
	    ListNode slow = start, fast = start;
	    slow.next = head;
	    
	    //Move fast in front so that the gap between slow and fast becomes n
	    for(int i=1; i<=n+1; i++)   {
	        fast = fast.next;
	    }
	    //Move fast to the end, maintaining the gap
	    while(fast != null) {
	        slow = slow.next;
	        fast = fast.next;
	    }
	    //Skip the desired node
	    slow.next = slow.next.next;
	    return start.next;
	}
}
