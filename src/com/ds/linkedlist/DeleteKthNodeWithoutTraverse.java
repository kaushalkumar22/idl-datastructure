package com.ds.linkedlist;

public class DeleteKthNodeWithoutTraverse {

	private Node head;
	public static void main(String[] args) {
		
		DeleteKthNodeWithoutTraverse list = new DeleteKthNodeWithoutTraverse();
		list.head = new Node(7);
		list.head.next = new Node(5);
		list.head.next.next = new Node(9);
	    list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(6);
		list.printList(list.head);
		list.deleteNode(list.head.next.next.next);
		list.printList(list.head);
		
	}
	
	private void deleteNode(Node n) {
		if (n == null || n.next == null) return; 

		n.data = n.next.data; 
		n.next = n.next.next; 
	}
	
	private  void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + "-->");
			head = head.next;
		}
		System.out.println("");
	}
	private static class Node{
		int data;
		Node next;

		private Node(int ele){
			data = ele;
			next = null;
		}
	}

}
