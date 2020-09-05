package com.algo.linkedlist;

import java.util.Arrays;
import java.util.List;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
  *
 */

public class MergeTwoSortedLists {
	
	public static void main(String[] args) {
		List<Integer> nums1 = Arrays.asList(1,2,4);
		ListNode head1 = ListUtil.createList(nums1);
		System.out.print("Original List :: ");
		ListUtil.print(head1);
		List<Integer> nums2 = Arrays.asList(1,3,4);
		ListNode head2 = ListUtil.createList(nums2);
		System.out.print("Original List :: ");
		ListUtil.print(head2);
		MergeTwoSortedLists list = new MergeTwoSortedLists();
		//ListNode node =list.mergeSortedLists(head1,head2);
		//ListUtil.print(node);
		ListNode node1 =list.mergeTwoLists(head1,head2);
		System.out.println();
		ListUtil.print(node1);
	}
	  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		    ListNode h = new ListNode(0);
		    ListNode ans=h;
		    while (l1 != null && l2 != null) {
		        if (l1.val < l2.val) {
		            h.next = l1;
		            h = h.next;
		            l1 = l1.next;
		        } else {
		            h.next = l2;
		            h = h.next;
		            l2 = l2.next;
		        }
		    }
		    if(l1==null){
		        h.next=l2;
		    }
		    if(l2==null){
		        h.next=l1;
		    } 
		    return ans.next;
		}
	private ListNode mergeSortedLists(ListNode a, ListNode b) {
		ListNode result = null;
		if (a == null)
			return b;
		if (b == null)
			return a;

		/* Pick either a or b, and recur */
		if (a.val <= b.val) {
			result = a;
			result.next = mergeSortedLists(a.next, b);
		} else {
			result = b;
			result.next = mergeSortedLists(a, b.next);
		}
		return result;
	}



	

}
