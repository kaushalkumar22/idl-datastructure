package linkedlist_reverse;

import java.util.Arrays;
import java.util.List;

import linkedlist_miscellaneous.ListNode;
import linkedlist_miscellaneous.ListUtil;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked
 * list. If the number of nodes is not a multiple of k then left-out nodes in
 * the end should remain as it is.
 * 
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * Note:
 * 
 * Only constant extra memory is allowed. You may not alter the values in the
 * list's nodes, only nodes itself may be changed.
 * 
 */
public class ReversNodesInKGroup {
	public static void main(String[] args) {
		List<Integer> nums1 = Arrays.asList(1,2,3,4,5);
		ListNode head = ListUtil.createList(nums1);
		System.out.print("Original List :: ");
		ListUtil.print(head);
		int k=2;
		ListNode node = reverseKGroup( head,  k);
		System.out.print("Rev List :: ");
		ListUtil.print(node);
	}
	public static ListNode reverseKGroup(ListNode head, int k) {

		ListNode curr = head;
		int count=0;
		for(int i=0;i<k&&curr!=null;i++) {
			curr=curr.next;
			count++;
		}
		if(count<k) {
			return head;
		}
		curr=head;
		ListNode prev=null;
		for(int i=0;i<k&&curr!=null;i++){
			ListNode cnext = curr.next;
			curr.next = prev;
			prev = curr;
			curr = cnext;
		} 

		/* next is now a pointer to (k+1)th node  
		 * Recursively call for the list starting from current. And make rest of the list as next of first node */
		if (curr != null) 
			head.next = reverseKGroup(curr, k);

		return prev;
	}                      
}

