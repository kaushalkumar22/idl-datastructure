package com.ds.linkedlist;
public class ReverseInGroupOfSizeK {
	private  Node head;

	private Node reverseListInGivenSize(Node head, int k)
	{
		Node curr = head;
		Node cnext,prev = null;
		
		for(int i=0;i<k&&curr!=null;i++){
			cnext = curr.next;
			curr.next = prev;
			prev = curr;
			curr = cnext;
			
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
		list.head.next.next = new Node(2);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(7);
		list.head.next.next.next.next.next = new Node(8);
		list.head.next.next.next.next.next.next = new Node(10);
		list.head.next.next.next.next.next.next.next = new Node(15);
		list.head.next.next.next.next.next.next.next.next = new Node(20);
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
