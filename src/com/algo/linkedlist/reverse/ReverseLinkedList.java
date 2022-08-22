package com.algo.linkedlist.reverse;

import java.util.Arrays;
import java.util.List;

import com.algo.linkedlist.ListNode;
import com.algo.linkedlist.ListUtil;

/**
 * Reverse a singly linked list.
 * 
 * Example:
 * 
 * Input: 1->2->3->4->5->NULL Output: 5->4->3->2->1->NULL
 * 
 * Follow up:
 * 
 * A linked list can be reversed either iteratively or recursively. Could you
 * implement both?
 *
 * 
 */
public class ReverseLinkedList {

	public static void main(String[] args) {
		ReverseLinkedList list = new ReverseLinkedList();
		List<Integer> nums = Arrays.asList(7, 5, 9, 4, 6, 10);
		ListNode head = ListUtil.createList(nums);
		System.out.print("Original List :: ");
		ListUtil.print(head);
		ListNode node = list.reverseList( head);
		ListUtil.print(node);
		node = list.reverseListRec(node,null);
		ListUtil.print(node);
	}

	
	public ListNode reverseList(ListNode head) {
		ListNode curr=head,prev=null;
		while(curr!=null){
			ListNode temp=curr.next;
			curr.next =prev;
			prev=curr;
			curr=temp;
		}
		return prev;
	}
	public ListNode reverseListRec(ListNode head, ListNode newHead) {
		if (head == null)
			return newHead;
		ListNode next = head.next;
		head.next = newHead;
		return reverseListRec(next, head);
	}

}
