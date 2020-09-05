package com.algo.linkedlist;

import java.util.Arrays;
import java.util.List;

/**
 * Write a function to delete a node (except the tail) in a singly linked list,
 * given only access to that node.
 * 
 * Given linked list -- head = [4,5,1,9], which looks like following:
 * 
 * Input: head = [4,5,1,9], node = 5 Output: [4,1,9] Explanation: You are given
 * the second node with value 5, the linked list should become 4 -> 1 -> 9 after
 * calling your function.
 * 
 * 
 * Input: head = [4,5,1,9], node = 1 Output: [4,5,9] Explanation: You are given
 * the third node with value 1, the linked list should become 4 -> 5 -> 9 after
 * calling your function.
 * 
 * Note:
 * 
 * The linked list will have at least two elements. All of the nodes' values
 * will be unique. The given node will not be the tail and it will always be a
 * valid node of the linked list. Do not return anything from your function.
 * 
 *
 */
public class DeleteNodeInALinkedList {

	public static void main(String[] args) {

		List<Integer> nums = Arrays.asList(7, 5, 9, 4, 6, 10);
		ListNode listNode = ListUtil.createList(nums);
		System.out.print("Original List :: ");
		ListUtil.print(listNode);
		DeleteNodeInALinkedList list = new DeleteNodeInALinkedList();
		list.deleteNode(listNode.next.next);
		System.out.print("After delete List :: ");
		ListUtil.print(listNode);
	}

	public void deleteNode(ListNode node) {     
        ListNode curr= node;
        curr.val= curr.next.val;
        curr.next =curr.next.next;
    }
}
