package com.algo.linkedlist;

import java.util.Arrays;
import java.util.List;

/**
 * Given a linked list, determine if it has a cycle in it.
 * 
 * To represent a cycle in the given linked list, we use an integer pos which
 * represents the position (0-indexed) in the linked list where the tail
 * connects to. If pos == -1, then there is no cycle in the linked list.
 * 
 * Follow up:
 * 
 * Can you solve it using O(1) (i.e. constant) memory?
 * 
 * 
 * Input: head = [3,2,0,-4], pos = 1 Output: true Explanation: There is a cycle
 * in the linked list, where tail connects to the second node.
 * 
 * Example 2:
 * 
 * Input: head = [1,2], pos = 0 Output: true Explanation: There is a cycle in
 * the linked list, where tail connects to the first node.
 * 
 * Example 3:
 * 
 * Input: head = [1], pos = -1 Output: false Explanation: There is no cycle in
 * the linked list.
 *
 */
public class LinkedListCycle {
	public static void main(String[] args) {
		List<Integer> nums1 = Arrays.asList(1, 2, 1);
		ListNode head = ListUtil.createList(nums1);
		System.out.print("Original List :: ");
		head.next.next.next = head.next;
		System.out.println(hasCycle(head));
	}

	public static boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;
	}
}
