package com.ds.linkedlist;



public class ReverseAlternateKNodes {

	private  Node head;
	private  Node reverseAlternateKNodes(Node node, int k) {
	    Node curr = node;
		Node cnext = null, prev = null;
		
		// 1) reverse first k nodes of the linked list 
		for(int i=0;i<k&&curr!=null;i++){
			cnext = curr.next;
			curr.next = prev;
			prev = curr;
			curr = cnext;
		}

		// 2) Now head points to the kth node.  So change next  of head to (k+1)th node
		if (curr != null) {
			node.next = curr;
		}

		// 3) We do not want to reverse next k nodes. So move the current pointer to skip next k nodes 
		for(int i=0;i<k-1&&curr!=null;i++){
			curr = curr.next;
		}

		// 4) Recursively call for the list starting from current->next. And make rest of the list as next of first node 
		if (curr != null) {
			curr.next = reverseAlternateKNodes(curr.next, k);
		}

		// 5) prev is new head of the input list 
		return prev;
	}
	private  void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println("");
	}
	public static void main(String[] args) {

		ReverseAlternateKNodes list = new ReverseAlternateKNodes();
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
		list.head= list.reverseAlternateKNodes(list.head,3);
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