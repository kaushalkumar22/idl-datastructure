package com.algo.lds.linkedlist;


public class NthNodeFromLast {

	private Node head;
	private Node last;
	public static void main(String[] args) {
		NthNodeFromLast list = new NthNodeFromLast();
		list.linkLast(5);
		list.linkLast(3);
		list.linkLast(6);
		list.linkLast(7);
		list.linkLast(13);
		list.linkLast(12);		
		list.linkLast(11);
		list.linkLast(8);
		list.linkLast(9);
		list.displayForward();
		Node k=list.nthToLast(6);
		System.out.println(k.data);
	}
	private Node nthToLast( int n) {	  
		Node p1 = head;
		Node p2 = head;
		for (int j = 0; j < n ; ++j) { // skip n-1 steps ahead
		
			if (p2 == null) return null; // not found since list size < n
			
			p2 = p2.next;
		}
		while (p2 != null) {
			p1 = p1.next;
			p2 = p2.next;
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
		Node current = head; // start at beginning
		while (current != null) // until end of list,
		{
			System.out.print(current.data+"-->");
			current = current.next; // move to next link
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
