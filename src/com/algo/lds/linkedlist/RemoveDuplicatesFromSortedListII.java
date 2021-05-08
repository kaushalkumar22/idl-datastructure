package com.algo.lds.linkedlist;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * Return the linked list sorted as well.
 * 
 * Input: 1->2->3->3->4->4->5 Output: 1->2->5
 *  
 * Input: 1->1->1->2->3 Output: 2->3
 *
 */
public class RemoveDuplicatesFromSortedListII {

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedListII list = new RemoveDuplicatesFromSortedListII();
		List<Integer> nums = Arrays.asList(1, 2,3,3,4,4,5);
		ListNode node = ListUtil.createList(nums);
		ListNode d =list.deleteDuplicates(node);
		ListUtil.print(d);
	}
	public ListNode deleteDuplicates(ListNode head) {
		if(head==null) return null;
		ListNode dummyHead=new ListNode(0);
		dummyHead.next=head;
		ListNode pre=dummyHead;
		ListNode curr=head;
		while(curr!=null){
			while(curr.next!=null&&curr.val==curr.next.val){
				curr=curr.next;
			}
			if(pre.next==curr){
				pre=curr;
			}
			else{
				pre.next=curr.next;
			}
			curr=curr.next;
		}
		return dummyHead.next;
	}
}
