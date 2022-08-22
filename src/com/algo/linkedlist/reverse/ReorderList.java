package com.algo.linkedlist.reverse;

import java.util.Arrays;
import java.util.List;

import com.algo.linkedlist.ListNode;
import com.algo.linkedlist.ListUtil;


/**
 * Given a singly linked list L0 -> L1 -> … -> Ln-1 -> Ln. Rearrange the nodes
 * in the list so that the new formed list is : L0 -> Ln -> L1 -> Ln-1 -> L2 ->
 * Ln-2 …
 * 
 * You are required do this in-place without altering the nodes’ values.
 * 
 * Examples: Input: 1 -> 2 -> 3 -> 4 Output: 1 -> 4 -> 2 -> 3
 */
public class ReorderList {

	public static void main(String[] args) {

		List<Integer> nums = Arrays.asList(1, 2, 3, 4,5);
		ListNode node = ListUtil.createList(nums);
		System.out.print("Original List :: ");
		ListUtil.print(node);
		new ReorderList().reorderList(node);
		System.out.print("New List   :: ");
		ListUtil.print(node);
	}

	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;
		ListNode slow = head,fast=head;
		while(fast!=null&&fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		ListNode rev = reverse( slow.next);
		slow.next=null;

		merge(head,rev);
	}
	public ListNode reverse(ListNode head) {		
		ListNode curr = head;
		ListNode prev = null;
		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;	
	}

	public void merge2(ListNode curr,ListNode rev) {	

		while (rev != null) {
			ListNode n1 = curr.next; 
			ListNode n2 = rev.next;
			curr.next = rev;

			if (n1 == null)
				break;

			rev.next = n1;
			curr = n1;
			rev = n2;
		}
	}
	
	//this method is common template of merge
	public void merge(ListNode head,ListNode rev) {	
		ListNode dummy = new  ListNode(0);
		ListNode res = dummy;
		while (rev != null) {
			dummy.next=head;
			head= head.next;
			dummy=dummy.next;

			dummy.next=rev;
			dummy=dummy.next;
			rev= rev.next;
		}
		if(rev==null) {
			dummy.next=head;
		}
		head= res.next;
	}
}
