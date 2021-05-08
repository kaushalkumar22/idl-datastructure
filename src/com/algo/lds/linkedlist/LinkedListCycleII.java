package com.algo.lds.linkedlist;

import java.util.Arrays;
import java.util.List;

/**
 * Given head, the head of a linked list, determine if the linked list has a
 * cycle in it.
 * 
 * There is a cycle in a linked list if there is some node in the list that can
 * be reached again by continuously following the next pointer. Internally, pos
 * is used to denote the index of the node that tail's next pointer is connected
 * to. Note that pos is not passed as a parameter.
 * 
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * 
 * Input: head = [3,2,0,-4], pos = 1 Output: true Explanation: There is a cycle
 * in the linked list, where the tail connects to the 1st node (0-indexed).
 *  
 * Input: head = [1,2], pos = 0 Output: true Explanation: There is a cycle in
 * the linked list, where the tail connects to the 0th node.
 *  
 * Input: head = [1], pos = -1 Output: false Explanation: There is no cycle in
 * the linked list.
 * 
 * Constraints:
 * 
 * The number of the nodes in the list is in the range [0, 104]. -105 <=
 * Node.val <= 105 pos is -1 or a valid index in the linked-list.
 * 
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 * 
 */
public class LinkedListCycleII {
	public static void main(String[] args) {
		LinkedListCycleII list = new LinkedListCycleII();
		List<Integer> nums1 = Arrays.asList(1, 2, 1);
		ListNode head = ListUtil.createList(nums1);
		head.next.next.next = head.next;
		System.out.print("Original List :: ");
		System.out.println(list.detectCycle(head).val);
	}

	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;

		ListNode slow = head;
		ListNode fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) { // there is a cycle
				slow = head;
				while (slow != fast) { // found the entry location
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}
		return null;
	}
}
