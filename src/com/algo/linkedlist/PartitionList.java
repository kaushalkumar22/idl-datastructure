package com.algo.linkedlist;

/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * Example:
 * 
 * Input: head = 1->4->3->2->5->2, x = 3 Output: 1->2->2->4->3->5
 * 
 * @author I339640
 *
 */
public class PartitionList {

	public ListNode partition(ListNode head, int x) {
	    ListNode smallerHead = new ListNode(0), biggerHead = new ListNode(0);
	    ListNode smaller = smallerHead, bigger = biggerHead;
	    while (head != null) {
	        if (head.val < x) {
	            smaller = smaller.next = head;
	        } else {
	            bigger = bigger.next = head;
	        }
	        head = head.next;
	    }
	    // no need for extra check because of fake heads
	    smaller.next = biggerHead.next; // join bigger after smaller
	    bigger.next = null; // cut off anything after bigger
	    return smallerHead.next;
	}
}
