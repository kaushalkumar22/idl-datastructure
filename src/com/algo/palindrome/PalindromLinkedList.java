package com.algo.palindrome;

public class PalindromLinkedList{

	private  Node head;
	private  Node head1;
	 boolean isPalindrom =true;
	private  boolean isLinkedListPalindrom(Node node){

		if (node.next != null) {
			isLinkedListPalindrom(node.next);
		}
		if(!isPalindrom(head1,node)){
			isPalindrom=false;
		}
		return isPalindrom;
	}
	private  boolean isPalindrom(Node start,Node end){	
		head1=head1.next;
		return start.data==end.data;
	}
	private  void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + "->");
			head = head.next;
		}
		System.out.println("");
	}
	public static void main(String[] args) {

		PalindromLinkedList list = new PalindromLinkedList();

		list.head = new Node(1);
		list.head.next = new Node(3);
		list.head.next.next = new Node(2);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(2);
		list.head.next.next.next.next.next = new Node(3);
		list.head.next.next.next.next.next.next = new Node(1);

		list.head1=list.head;
		System.out.print("Original List :: ");
		list.printList(list.head);
		System.out.print("List Is Palindrom   :: "+list.isLinkedListPalindrom(list.head));

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