package com.algo.lds.linkedlist;

import java.util.Arrays;
import java.util.List;

/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * Input: head = 1->4->3->2->5->2, x = 3 Output: 1->2->2->4->3->5
 * 
 *
 */
public class PartitionList {

	public static void main(String[] args) {

		List<Integer> nums = Arrays.asList(1,4,3,2,5,2);
		ListNode node = ListUtil.createList(nums);
		System.out.print("Original List :: ");
		ListUtil.print(node);
		ListNode x =new PartitionList().partition(node,3);
		System.out.print("New List   :: ");
		ListUtil.print(x);
	}

	public ListNode partition(ListNode head, int x) {
		ListNode smallerThan = new ListNode(0);
		ListNode greaterThanEqual = new ListNode(0);
		ListNode smaller = smallerThan;	
		ListNode greater = greaterThanEqual;	
	
		while(head!=null) {		
			if(head.val<x) {
				smallerThan.next=head;
				smallerThan=smallerThan.next;
			}else {
				greaterThanEqual=greaterThanEqual.next=head;
			}
			head=head.next;
		}
		smallerThan.next=greater.next;
		greaterThanEqual.next = null;
		return smaller.next;
	}
}
