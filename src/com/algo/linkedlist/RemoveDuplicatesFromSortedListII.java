package com.algo.linkedlist;

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
		List<Integer> nums = Arrays.asList(1, 2,2);
		ListNode node = ListUtil.createList(nums);
		System.out.print("Original List :: ");
		ListUtil.print(node);
		ListNode d =list.deleteDuplicates(node);
		System.out.print("New List   :: ");
		ListUtil.print(d);
	}
	public ListNode deleteDuplicates(ListNode head) {
		if(head==null) return null;
        ListNode FakeHead=new ListNode(0);
        FakeHead.next=head;
        ListNode pre=FakeHead;
        ListNode cur=head;
        while(cur!=null){
            while(cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;
            }
            if(pre.next==cur){
                pre=pre.next;
            }
            else{
                pre.next=cur.next;
            }
            cur=cur.next;
        }
        return FakeHead.next;
	}
}
