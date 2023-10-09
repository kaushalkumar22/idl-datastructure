package linkedlist_mergesort;

import java.util.Arrays;

import linkedlist_miscellaneous.ListNode;
import linkedlist_miscellaneous.ListUtil;

/**
 * 
 * You are given an array of k linked-lists lists, each linked-list is sorted in
 * ascending order.
 * 
 * Merge all the linked-lists into one sorted linked-list and return it.
 * 
 * Input: lists = [[1,4,5],[1,3,4],[2,6]] Output: [1,1,2,3,4,4,5,6] Explanation:
 * The linked-lists are: [ 1->4->5, 1->3->4, 2->6 ] merging them into one sorted
 * list: 1->1->2->3->4->4->5->6
 * 
 * 
 * Input: lists = [] Output: []
 * 
 * Input: lists = [[]] Output: []
 * 
 * This approach walks alongside the one above but is improved a lot. We don't
 * need to traverse most nodes many times repeatedly
 * 
 * Pair up k lists and merge each pair.
 * 
 * After the first pairing, k lists are merged into k/ lists
 * with average 2N/k length, then k/4, k/8 and so on.
 * 
 * Repeat this procedure until we get the final sorted linked list.
 * 
 * Thus, we'll traverse almost NNN nodes per pairing and merging, and repeat
 * this procedure about log�?�k times.
 * 
 * 
 * 
 * Time complexity : 
 * O(Nlog�?�k) where k is the number
 * of linked lists. We can merge two sorted linked list in O(n) time
 * where nnn is the total number of nodes in two lists. Sum up the merge process
 * and we can get:O(Nlogk)
 * 
 * Space complexity : 
 * O(1)We can merge two sorted linked lists in O(1) space.
 * 
 */
public class MergeKSortedLists {

	public static void main(String[] args) {
		ListNode head1 = ListUtil.createList(Arrays.asList(1, 4, 5));
		ListNode head2 = ListUtil.createList(Arrays.asList(1, 3, 4));
		ListNode head3 = ListUtil.createList(Arrays.asList(2, 6));
		ListNode[] list = { head1, head2, head3 };
		ListNode res = new MergeKSortedLists().mergeKLists(list);
		ListUtil.print(res);
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		}
		return mergeKLists(lists, 0, lists.length - 1);
	}

	public ListNode mergeKLists(ListNode[] lists, int low, int high) {
		if (low >= high)
			return lists[low];
		int mid = low + (high - low) / 2;
		ListNode left = mergeKLists(lists, low, mid);
		ListNode right = mergeKLists(lists, mid + 1, high);
		return merge(left, right);

	}

	private ListNode merge(ListNode left, ListNode right) {

		ListNode res = new ListNode(0);
		ListNode result = res;
		while (left != null && right != null) {
			if (left.val < right.val) {
				res.next = left;
				left = left.next;
			} else {
				res.next = right;
				right = right.next;
			}
			res = res.next;
		}
		if (left == null) {
			res.next = right;		
		}
		if (right== null) {
			res.next = left;
		}
		return result.next;
	}
}
