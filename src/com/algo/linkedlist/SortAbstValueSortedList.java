package com.algo.linkedlist;

public class SortAbstValueSortedList {

	private static Node head;
	private static void sortAbstValueSortedList(Node node){
		Node curr = node;
		while (curr != null) {
			if(curr.next!=null&&curr.next.data<0){
				Node temp = curr.next;
				curr.next = curr.next.next;
				insertAtBegning(temp);
				if(curr.next==null){
					break;
				}
				if(curr.next.data<0){
					sortAbstValueSortedList(curr);
				}
			}
			curr= curr.next;
		}
	}

	private static void insertAtBegning(Node node){
		node.next = head;
		head= node;
	}
	private  void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + "->");
			head = head.next;
		}
		System.out.println("");
	}
	public static void main(String[] args) {

		SortAbstValueSortedList list = new SortAbstValueSortedList();
		list.head = new Node(1);
		list.head.next = new Node(-2);
		list.head.next.next = new Node(3);
		list.head.next.next.next = new Node(-4);
		list.head.next.next.next.next = new Node(7);
		list.head.next.next.next.next.next = new Node(-8);
		list.head.next.next.next.next.next.next = new Node(-10);
		list.head.next.next.next.next.next.next.next = new Node(-15);
		list.head.next.next.next.next.next.next.next.next = new Node(-20);
		System.out.print("Original List :: ");
		list.printList(head);
		System.out.print("Sorted List   :: ");
		sortAbstValueSortedList(head);
		list.printList(head);
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