package com.algo.lds.linkedlist.reverse;

import java.util.Arrays;

import com.algo.lds.linkedlist.ListNode;
import com.algo.lds.linkedlist.ListUtil;

/** 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3. 
 */
public class SwapNodesInPairs {

	public static void main(String[] args) {
		ListNode head = ListUtil.createList(Arrays.asList(1,2,3,4,5));
		ListNode res = new SwapNodesInPairs().swapPairs(head);
		ListUtil.print(res);
	}

	public ListNode swapPairs(ListNode head) {

		if(head==null||head.next==null) return head;

		ListNode curr= head,prev=null;
		for(int i=0;i<2&&curr!=null;i++) {
			ListNode temp=curr.next;
			curr.next=prev;
			prev=curr;
			curr=temp;
		}
		if(curr!=null) {
			head.next= swapPairs( curr);
		}
		return prev;
	}
}
