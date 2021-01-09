package com.algo.lds.linkedlist;

import java.util.Arrays;
import java.util.List;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * Return the linked list sorted as well.
 * 
 * Example 1:
 * 
 * Input: 1->2->3->3->4->4->5 Output: 1->2->5
 * 
 * Input: 1->1->1->2->3 Output: 2->3
 * 
 *
 */
public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedList list = new RemoveDuplicatesFromSortedList();
		List<Integer> nums = Arrays.asList(1, 2, 2,3,3,4,4,5);
		ListNode node = ListUtil.createList(nums);
		System.out.print("Original List :: ");
		ListUtil.print(node);
		list.deleteDuplicates(node);
		System.out.print("New List   :: ");
		ListUtil.print(node);
	}
	public ListNode deleteDuplicates(ListNode head) {
		ListNode curr=head;
		while(curr != null&&curr.next != null){
			if( curr.val == curr.next.val){
				curr.next= curr.next.next;
			}else{
				curr=curr.next;
			}
		} 
		return head;
	}
	public ListNode deleteDuplicatesRec(ListNode head) {
        if(head == null || head.next == null)return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
}
}
