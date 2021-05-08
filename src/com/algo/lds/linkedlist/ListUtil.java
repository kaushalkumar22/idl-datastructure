package com.algo.lds.linkedlist;

import java.util.List;

public class ListUtil {

	private static ListNode head;
	/*public static void main(String[] args) {
		List<Integer> nums = (List<Integer>) Arrays.asList(1,2,2,3,3,4,4);
		System.out.println(nums);
		displayList( createList(nums));
	}*/


	public static ListNode createList(List<Integer> nums){
		head=null;
		return insertLevelOrder(nums,head);
	}
	private static ListNode insertLevelOrder(List<Integer> nums, ListNode root) { 

		ListNode curr = head;
		for (Integer integer : nums) {
			ListNode newNode = new ListNode(integer);
			if(head==null){
				head=newNode;
				curr=head;
			}else{
				curr.next =newNode;
				curr=newNode;
			}
		}
		return head; 
	} 
	public static  int length(ListNode head) {
		int count =0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}
	public static void print(ListNode head) {
		ListNode current = head; 
		while (current != null){
			System.out.print(current.val+"->");
			current = current.next; 
		}
		System.out.println("");
	}
}

