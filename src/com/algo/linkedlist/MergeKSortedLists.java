package com.algo.linkedlist;

import java.util.Arrays;

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
 */
public class MergeKSortedLists {

	public static void main(String[] args) {
		ListNode head1 = ListUtil.createList(Arrays.asList(1,4,5));
		ListNode head2 = ListUtil.createList(Arrays.asList(1,3,4));
		ListNode head3 = ListUtil.createList(Arrays.asList(2,6));
		ListNode[] list = {head1,head2,head3};
		ListNode res = new MergeKSortedLists().mergeKLists(list);
		System.out.print("Result List   :: ");
		ListUtil.print(res);
	}
	public ListNode mergeKLists(ListNode[] lists) {

		if(lists.length==0) {
			return null;
		}
		return	 mergeKLists(lists,0,lists.length-1);
	}
	public ListNode mergeKLists(ListNode[] lists,int start,int end) {

		if(start==end) return lists[start];
		if(start<end) {
           int mid = start+(end-start)/2;
           ListNode left  =  mergeKLists(lists,start,mid);
           ListNode right =  mergeKLists(lists,mid+1,end);
           return merge(left,right);
		}
		return null;
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
