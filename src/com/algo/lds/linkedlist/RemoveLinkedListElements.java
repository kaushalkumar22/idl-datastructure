package com.algo.lds.linkedlist;

import java.util.Arrays;
import java.util.List;

/**
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Input: 1->2->6->3->4->5->6, val = 6 Output: 1->2->3->4->5
 *
 * 
 * 
 */
public class RemoveLinkedListElements {

	public static void main(String[] args) {
		List<Integer> nums =Arrays.asList(1,2,6,3,4,5,6);
		ListNode head = ListUtil.createList(nums);	
		System.out.print("Original List :: ");
		ListUtil.print(head);
		ListNode list=removeElements( head,6);
		ListUtil.print(list);
	}
	public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
}
}
