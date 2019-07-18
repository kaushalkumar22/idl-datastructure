package com.ds.advance;


/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL

Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
 *
 */
public class RotateList {

	ListNode head;
	public ListNode rotateRight(ListNode head, int k) {
		
		if(head==null||head.next==null||k==0) return head;
		ListNode p1 = head,p2 = head,tail = null,newHead;
		
		for (int j = 0; j < k ; ++j) { // skip n-1 steps ahead
		
			if (p2 == null) return null; // not found since list size < n
			
			p2 = p2.next;
		}
		while (p2 != null) {
			tail=p1;
			p1 = p1.next;
			p2 = p2.next;
		}
		tail.next=null;
		newHead=p1;
		while (p1.next!= null) {
			p1 = p1.next;
		}
		p1.next=head;
		return newHead;
	}
	public static void main(String[] args) {
		RotateList list = new RotateList();
		list.head = new ListNode(10);
		list.head.next = new ListNode(20);
		//list.head.next.next = new ListNode(30);
		//list.head.next.next.next = new ListNode(40);
		//list.head.next.next.next.next = new ListNode(50);
		//list.head.next.next.next.next.next = new ListNode(60);

		list.displayForward();
		list.head = list.rotateRight(list.head,2);
		list.displayForward();
	}
	public void displayForward() {
		System.out.print("List: ");
		ListNode current = head; 
		while (current != null){
			System.out.print(current.val+" ");
			current = current.next; 
		}
		System.out.println("");
	}

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}


}
