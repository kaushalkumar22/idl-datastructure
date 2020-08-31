package com.algo.linkedlist;

public class PairwiseSwapElements {

	private  Node head;

	private Node swapPairwiseElementsRecursive(Node head){

		Node curr=head;
		if (curr != null && curr.next != null) {
			int data = curr.data;
			curr.data= curr.next.data;
			curr.next.data=data;
			swapPairwiseElementsRecursive(curr.next.next);
		}
		return head;
	}   

	private void swapPairwiseElements(Node head1){

		Node curr = head;
		while (curr != null && curr.next != null) {
			int data = curr.data;
			curr.data=curr.next.data;
			curr.next.data=data;
			curr=curr.next.next;
		}
	}                      
	private  void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + "->");
			head = head.next;
		}
		System.out.println("");
	}
	public static void main(String[] args) {

		PairwiseSwapElements list = new PairwiseSwapElements();
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
		list.swapPairwiseElements(list.head);
		System.out.print("Reverse List   :: ");

		list.printList(list.head);
		System.out.println();
		list.swapPairwiseElementsRecursive(list.head);
		System.out.print("Reverse List   :: ");

		list.printList(list.head);
	}
	private	static class Node {
		int data;
		Node next;
		Node(int d) {
			data = d;
			next = null;
		}
	}

}
