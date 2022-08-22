package com.algo.linkedlist;

import java.util.Arrays;
/**
 * Sort a linked list ,sorted by absolute value, in O(n log n) time using constant space complexity.
 * 
 * Input: 1->-2->3->-4->7->-8->-10->-15->-20 Output: -20-->-15-->-10-->-8-->-4-->-2-->1-->3-->7
 * 
 */
public class SortLinkedListSortedByAbsolutetValue {

	public static void main(String[] args) {

		SortLinkedListSortedByAbsolutetValue list = new SortLinkedListSortedByAbsolutetValue();
		ListNode node =ListUtil.createList(Arrays.asList(1,-2,3,-4,7,-8,-10,-15,-20));
		ListNode head=list.sortAbstValueSortedList(node);	
		ListUtil.print(head);
	}

	public ListNode sortAbstValueSortedList(ListNode head){
		if(head==null) return head;
		ListNode curr = head,prev = null;
		while (curr != null) {
			if(curr!=head&&curr.val<0){			
				prev.next = curr.next;
				curr.next=head;
				head=curr;
				curr=prev;
			}else
			 prev=curr;
			curr= curr.next;
		}
		return head;
	}
}