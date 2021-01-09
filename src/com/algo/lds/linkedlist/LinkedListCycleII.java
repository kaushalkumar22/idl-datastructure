package com.algo.lds.linkedlist;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * 
 * To represent a cycle in the given linked list, we use an integer pos which
 * represents the position (0-indexed) in the linked list where tail connects
 * to. If pos is -1, then there is no cycle in the linked list.
 * 
 * Note: Do not modify the linked list.
 * 
 * 
 * 
 * Input: head = [3,2,0,-4], pos = 1 Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the
 * second node.
 * 
 * Input: head = [1,2], pos = 0 Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the
 * first node.
 * 
 * Example 3:
 * 
 * Input: head = [1], pos = -1 Output: no cycle Explanation: There is no cycle
 * in the linked list.
 * 
 * Follow-up: Can you solve it without using extra space?
 * 
 */
public class LinkedListCycleII {
	public static void main(String[] args) {
		LinkedListCycleII list = new LinkedListCycleII();
		List<Integer> nums1 = Arrays.asList(1,2,1);
		ListNode head = ListUtil.createList(nums1);
		head.next.next.next = head.next;
		System.out.print("Original List :: ");
		System.out.println(list.detectCycle(head).val);
	}
	public  ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;

		ListNode slow  = head;
		ListNode fast  = head;

		while (fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {                      // there is a cycle
				slow =head;
				while(slow != fast) {               // found the entry location
					slow  = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}
		return null;            
	}
}
