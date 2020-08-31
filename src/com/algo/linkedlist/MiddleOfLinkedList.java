package com.algo.linkedlist;



public class MiddleOfLinkedList {
	
	private Node head;
	private Node last;
	public static void main(String[] args) {
		
		MiddleOfLinkedList list = new MiddleOfLinkedList();
		list.linkLast(5);
		list.linkLast(3);
		list.linkLast(6);
		list.linkLast(7);
		list.linkLast(13);
		list.linkLast(12);		
		list.linkLast(11);
		
		list.displayForward();
		Node k1=list.linkLastMidlle();
		System.out.println(k1.data);
	}
	
	private Node linkLastMidlle() {
		Node p1 = head;
		Node p2 = head;
		while (p2.next != null){
			p1 = p1.next;
			p2 = p2.next.next;
		
		}
		return p1;
	}
	private void linkLast(int e) {
		Node current = last;
		Node newNode = new Node(e);
		last = newNode;
		if (current == null)
			head = newNode;
		else
			current.next = newNode;
	}
	public void displayForward() {
		System.out.print("List: ");
		Node current = head; 
		while (current != null) 
		{
			System.out.print(current.data+"-->");
			current = current.next; 
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
