package com.algo.linkedlist;

import java.util.Arrays;
import java.util.List;

public class DeleteAlternateNodes {
	public static void main(String[] args) {

		List<Integer> nums =Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13);
		ListNode listNode = ListUtil.createList(nums);	
		System.out.print("Original List :: ");
		ListUtil.print(listNode);
		DeleteAlternateNodes list = new DeleteAlternateNodes();
		list.deleteAlternateListNode (listNode);
		System.out.print("After delete List :: ");
		ListUtil.print(listNode);
	}


	private void deleteAlternateListNode1(ListNode head){

		while(head!=null&&head.next!=null) {
			head.next=head.next.next;
			head=head.next;
		}
	}

	private void deleteAlternateListNode(ListNode head){

		if(head==null||head.next==null) {
			return;
		}
		head.next=head.next.next;
		deleteAlternateListNode(head.next);
	}
}
