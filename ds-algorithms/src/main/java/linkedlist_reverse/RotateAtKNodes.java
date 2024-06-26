package linkedlist_reverse;

import java.util.Arrays;
import java.util.List;

import linkedlist_miscellaneous.ListNode;
import linkedlist_miscellaneous.ListUtil;

/**
 * Given a linked list, reverse the At Kth ListNodes of a linked list and
 * return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked
 * list. 
 * 
 * Given this linked list: 1->2->3->4->5->6
 * 
 * For k = 2, you should return: 2->1->6->5->4->3
 * 
 * For k = 3, you should return: 3->2->1->6->5->4
 * 
 * Note:
 * 
 * Only constant extra memory is allowed. You may not alter the values in the
 * list's ListNodes, only ListNodes itself may be changed.
 * 
 */
public class RotateAtKNodes {
	public static void main(String[] args) {

		RotateAtKNodes list = new RotateAtKNodes();
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
		ListNode head = ListUtil.createList(nums);
		ListUtil.print(head);
		ListNode node = list.rotateAtK(head,3);
		ListUtil.print(node);
	}
	private  ListNode rotateAtK(ListNode head, int k) {

		ListNode curr=head,prev=null;
		for(int i=0;i<k&&curr!=null;i++) {
			ListNode cnext= curr.next;
			curr.next= prev;
			prev =curr;
			curr=cnext;
		}
		if(curr!=null) {
			head.next=rotateAtK( curr, Integer.MAX_VALUE);
		}
		return prev;
	}
}
