package linkedlist_miscellaneous;

import java.util.Arrays;
import java.util.List;

/**
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Input: 1->2->6->3->4->5->6, val = 6 Output: 1->2->3->4->5
 *
 * 
 * 
 */
public class RemoveLinkedListElements {

	public static void main(String[] args) {
		List<Integer> nums =Arrays.asList(1,2,6,4,5,6);
		ListNode head = ListUtil.createList(nums);	
		System.out.print("Original List :: ");
		ListUtil.print(head);
		ListNode list=removeElements( head,6);
		ListUtil.print(list);
	}
	public static ListNode removeElements1(ListNode head, int val) {
		ListNode dummy = new ListNode(0);
		ListNode res=dummy;
		dummy.next=head;
		while(dummy!=null&&dummy.next!=null) {
			if(dummy.next.val==val) {
				dummy.next=dummy.next.next;
			}else {
				dummy=dummy.next;
			}
		}
		return res.next;
	}
	public static ListNode removeElements(ListNode head, int val) {
		if(head == null) return null;
		ListNode next = removeElements(head.next, val);
		if(head.val == val) return next;
		head.next = next;
		return head;
	}

}
