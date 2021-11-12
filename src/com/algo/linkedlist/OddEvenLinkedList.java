package com.algo.linkedlist;

import java.util.Arrays;

/**
 * Given a singly linked list, group all odd nodes together followed by the even
 * nodes. Please note here we are talking about the node number and not the
 * value in the nodes.
 * 
 * You should try to do it in place. The program should run in O(1) space
 * complexity and O(nodes) time complexity.
 * 
 * Input: 1->2->3->4->5->NULL Output: 1->3->5->2->4->NULL 
 * 
 * Input:2->1->3->5->6->4->7->NULL Output: 2->3->6->7->1->5->4->NULL
 * 
 *
 */
public class OddEvenLinkedList {

	public static void main(String[] args) {
		ListNode head = ListUtil.createList(Arrays.asList(1,2,3,4,5));
		System.out.print("Original List :: ");
		ListUtil.print(head);
		ListNode res = new OddEvenLinkedList().oddEvenList(head);
		System.out.print("Result List   :: ");
		ListUtil.print(res);
	}
	public ListNode oddEvenList(ListNode head) {
		
		if(head==null||head.next==null) return head;
		
		ListNode odd = head,even=head.next;
		ListNode evenHead =even;
		while(even!=null&&even.next!=null) {
			odd.next=odd.next.next;
			even.next=even.next.next;
			even=even.next;
			odd =odd.next;
		}
		odd.next=evenHead;
		return head;

	}
}