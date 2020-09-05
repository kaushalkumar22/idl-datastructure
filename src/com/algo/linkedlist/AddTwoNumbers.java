package com.algo.linkedlist;

import java.util.Arrays;
import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The most significant digit comes first and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Follow up: What if you cannot modify the input lists? In other words,
 * reversing the lists is not allowed.
 * 
 * 
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 8 -> 0 -> 7
 * 
 */
public class AddTwoNumbers {
	private ListNode head;
	int carry = 0;

	private void doAddLinkedListsNodes(ListNode first, ListNode second, int size1, int size2) {

		if (size1 > 1 && size2 > 1 && size1 == size2) {
			doAddLinkedListsNodes(first.next, second.next, size1 - 1, size2 - 1);
		} else if (size1 > size2) {
			doAddLinkedListsNodes(first.next, second, size1 - 1, size2);
		} else if (size2 > size1) {
			doAddLinkedListsNodes(first, second.next, size1, size2 - 1);
		}
		doAddNodes(first, second, size1, size2);
	}

	private void doAddNodes(ListNode first, ListNode second, int size1, int size2) {

		int sum = carry + (size1 >= size2 ? first.val : 0) + (size2 >= size1 ? second.val : 0);
		if (carry == 0) {
			crearteNode(sum % 10);
		} else {
			head.val = sum % 10;
		}
		carry = (sum > 9) ? 1 : 0;
		if (carry > 0) {
			crearteNode(carry);
		}
	}

	private void crearteNode(int data) {
		ListNode node = new ListNode(data);
		node.next = head;
		head = node;
	}

	public static void main(String[] args) {

		List<Integer> nums1 = Arrays.asList(7, 5, 9, 4, 6);
		List<Integer> nums2 = Arrays.asList(8, 4, 8);
		ListNode list1 = ListUtil.createList(nums1);
		ListNode list2 = ListUtil.createList(nums2);
		AddTwoNumbers list = new AddTwoNumbers();
		int length1 = ListUtil.length(list1);
		int length2 = ListUtil.length(list2);
		list.doAddLinkedListsNodes(list1, list2, length1, length2);
		System.out.print("Sum List :: ");
		ListUtil.print(list.head);
	}
}