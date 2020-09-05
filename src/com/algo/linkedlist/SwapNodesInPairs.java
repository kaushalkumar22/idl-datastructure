package com.algo.linkedlist;

import java.util.Arrays;

/**
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3. 
 * 
 */
public class SwapNodesInPairs {

	public static void main(String[] args) {
		ListNode head = ListUtil.createList(Arrays.asList(1,2,3,4,5));
		System.out.print("Original List :: ");
		ListUtil.print(head);
		ListNode res = new SwapNodesInPairs().swapPairs(head);
		System.out.print("Result List   :: ");
		ListUtil.print(res);
	}
	private ListNode swapPairs2(ListNode head){

		ListNode curr = head;
		while (curr != null && curr.next != null) {
			int val = curr.val;
			curr.val=curr.next.val;
			curr.next.val=val;
			curr=curr.next.next;
		}
		return head;
	}        
	public ListNode swapPairs(ListNode head) {

		if(head==null||head.next==null) return head;
		
		ListNode curr= head,prev=null,cnext;
		for(int i=0;i<2&&curr!=null;i++) {
			cnext=curr.next;
			curr.next=prev;
			prev=curr;
			curr=cnext;
		}
		if(curr!=null) {
			head.next= swapPairs( curr);
		}
		return prev;

	}
}
