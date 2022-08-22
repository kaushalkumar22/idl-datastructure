package linkedlist_mergesort;

import java.util.Arrays;
import java.util.List;

import linkedlist_miscellaneous.ListNode;
import linkedlist_miscellaneous.ListUtil;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * Input: 4->2->1->3 Output: 1->2->3->4
 * 
 * Input: -1->5->3->4->0 Output: -1->0->3->4->5
 */
public class SortLinkedList {

	public static void main(String[] args) {
		ListNode head = ListUtil.createList(Arrays.asList(1,4,3,2,5,2));
		ListUtil.print(head);
		ListNode res = new SortLinkedList().sortList(head);
		ListUtil.print(res);
	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode slow=head,fast =head,prev=null;

		while(fast!=null&&fast.next!=null) {
			prev=slow;
			slow=slow.next;
			fast=fast.next.next;
		}
		prev.next=null;
		ListNode left = sortList( head);
		ListNode right = sortList( slow);		
		return merge(left,right);
	}

	private ListNode merge(ListNode left, ListNode right) {

		ListNode res = new ListNode(0);
		ListNode result = res;
		while(left!=null&&right!=null) {
			if(left.val<right.val) {
				res.next=left;
				left=left.next;
			}else {
				res.next=right;
				right= right.next;
			}
			res=res.next;
		}
		if(left!=null) {
			res.next=left;
		}
		if(right!=null) {
			res.next=right;
		}
		return result.next;
	}
}
