package com.algo.lds.linkedlist;

import java.util.Arrays;
import java.util.List;

/** 
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Input: 1->2 Output: false
 * 
 * Input: 1->2->2->1 Output: true
 * 
 * Follow up: Could you do it in O(n) time and O(1) space?
 *
 */
public class PalindromLinkedList {

	public static void main(String[] args) {
		ListNode head = ListUtil.createList(Arrays.asList(1,2,2,1));
		PalindromLinkedList list = new PalindromLinkedList();
		System.out.println(list.isPalindrome(head));
	}
	public boolean isPalindrome(ListNode head) {
	    ListNode fast = head, slow = head;
	    while (fast != null && fast.next != null) {
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	    if (fast != null) { // odd nodes: let right half smaller
	        slow = slow.next;
	    }
	    slow = reverse(slow);
	    fast = head;
	    
	    while (slow != null) {
	        if (fast.val != slow.val) {
	            return false;
	        }
	        fast = fast.next;
	        slow = slow.next;
	    }
	    return true;
	}

	public ListNode reverse(ListNode head) {
	    ListNode prev = null;
	    while (head != null) {
	        ListNode next = head.next;
	        head.next = prev;
	        prev = head;
	        head = next;
	    }
	    return prev;
	}
}