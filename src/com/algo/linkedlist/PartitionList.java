package com.algo.linkedlist;

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

		ListNode lessThanX = new ListNode(0); 
		ListNode greaterThanX = new ListNode(0); 
		ListNode lessHead=lessThanX,greaterHead=greaterThanX;

		while(head!=null){
			if(head.val<x){
				lessThanX.next=head;
				lessThanX=lessThanX.next;
			} else{
				greaterThanX.next=head;
				greaterThanX=greaterThanX.next;
			}
			head=head.next;
		}
		greaterThanX.next=null;
		lessThanX.next=greaterHead.next;
		return lessHead.next;
	}
}
