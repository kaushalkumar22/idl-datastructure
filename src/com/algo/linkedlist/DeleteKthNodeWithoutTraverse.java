package com.algo.linkedlist;

import java.util.Arrays;
import java.util.List;

public class DeleteKthNodeWithoutTraverse {

	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(7,5,9,4,6,10);
		ListNode listNode = ListUtil.createList(nums);	
		System.out.print("Original List :: ");
		ListUtil.print(listNode);
		DeleteKthNodeWithoutTraverse list = new DeleteKthNodeWithoutTraverse();
		list.deleteNode (listNode.next.next);
		System.out.print("After delete List :: ");
		ListUtil.print(listNode);	
	}
	
	private void deleteNode(ListNode n) {
		if (n == null || n.next == null) return; 

		n.val = n.next.val; 
		n.next = n.next.next; 
	}
}
