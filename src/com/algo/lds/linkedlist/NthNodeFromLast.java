package com.algo.lds.linkedlist;

import java.util.Arrays;

public class NthNodeFromLast {

	public static void main(String[] args) {
		ListNode head = ListUtil.createList(Arrays.asList(5,3,6,7,13,12,11,8,9));
		NthNodeFromLast list = new NthNodeFromLast();
		ListNode k=list.nthToLast(head,6);
		System.out.println(k.val);
	}
	private ListNode nthToLast(ListNode head, int n) {	  
		ListNode p1 = head;
		ListNode p2 = head;
		for (int i = 0; i < n ; ++i) { // skip n-1 steps ahead
			if (p2 == null) {
				return null; // not found since list size < n
			}
			p2 = p2.next;
		}
		while (p2 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
}