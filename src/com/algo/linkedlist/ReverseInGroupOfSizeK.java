package com.algo.linkedlist;
/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

    Only constant extra memory is allowed.
    You may not alter the values in the list's nodes, only nodes itself may be changed.


 * @author IBM
 *
 */
public class ReverseInGroupOfSizeK {
	private  Node head;

	private Node reverseListInGivenSize(Node head, int k)
	{
		Node curr = head;
		Node temp = head;
		Node cnext,prev = null;
		int count=0;
		for(int i=0;i<k&&temp!=null;i++) {
			temp=temp.next;
			count++;
		}
		if(count==k) {	
			for(int i=0;i<k&&curr!=null;i++){
				cnext = curr.next;
				curr.next = prev;
				prev = curr;
				curr = cnext;
			} 
		}else {
			return curr; 
		}
		/* next is now a pointer to (k+1)th node  
		 * Recursively call for the list starting from current. And make rest of the list as next of first node */
		if (curr != null) 
			head.next = reverseListInGivenSize(curr, k);
		return prev;
	}                      
	private  void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + "->");
			head = head.next;
		}
		System.out.println("");
	}
	public static void main(String[] args) {

		ReverseInGroupOfSizeK list = new ReverseInGroupOfSizeK();
		list.head = new Node(1);
		list.head.next = new Node(2);
		list.head.next.next = new Node(3);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(5);
		//list.head.next.next.next.next.next = new Node(8);
		//list.head.next.next.next.next.next.next = new Node(10);
		//list.head.next.next.next.next.next.next.next = new Node(15);
		//list.head.next.next.next.next.next.next.next.next = new Node(20);
		System.out.print("Original List :: ");
		list.printList(list.head);
		System.out.println();
		list.head=list.reverseListInGivenSize(list.head,3);
		System.out.print("Reverse List   :: ");

		list.printList(list.head);
	}
	static class Node {
		int data;
		Node next;
		Node(int d) {
			data = d;
			next = null;
		}
	}

}
