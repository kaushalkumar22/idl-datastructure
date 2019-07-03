package com.ds.linkedlist;



import java.util.Hashtable;
public class RemoveDuplicateFromList {
	
	private Node head;
	private Node last;
	public static void main(String[] args) {
		RemoveDuplicateFromList list = new RemoveDuplicateFromList();
		list.createList(5);
		list.createList(3);
		list.createList(6);
		list.createList(6);
		list.createList(7);
		list.createList(13);
		list.createList(11);		
		list.createList(11);
		list.createList(8);
		list.createList(9);
		System.out.print("Actual Linked  ");
		list.displayForward();	 
		list.removeDuplicateWithBuffer();
		System.out.print("With Buffer    ");
		list.displayForward();
		list.removeDuplicateWithoutBuffer();
		System.out.print("Without Buffer ");
		list.displayForward();

	}
	void removeDuplicateWithBuffer() {
		Node current = head;
		Node temp = null;
		Hashtable<Integer,Boolean> table = new Hashtable<Integer,Boolean>();
		while (current != null) {			
			if (table.containsKey(current.data)) 
				temp.next = current.next;
			else {
				table.put(current.data, true);
				temp =current;
			}			
			current = current.next;
		}
	}
	void removeDuplicateWithoutBuffer() {
		if(head == null){ 
			return;
		}
		Node previous = head;
		Node current = previous.next;
		while (current != null) {
			Node temp = head;
			while (temp != current) { 
				if (temp.data == current.data) {
					Node tmp = current.next; 
					previous.next = tmp; 
					current = tmp; 
					break; 
				}
				temp = temp.next;
			}
			if (temp == current) {
				previous = current;
				current = current.next;
			}
		}
	}
	void createList(int e) {
		Node current = last;
		Node newNode = new Node(e, null);
		last = newNode;
		if (current == null)
			head = newNode;
		else
			current.next = newNode;
	}
	public void displayForward() {
		System.out.print("List: ");
		Node current = head;
		while (current != null){
			System.out.print(current.data+"-->");
			current = current.next;
		}
		System.out.println("");
	}
	private static class Node{
		int data;
		Node next;

		private Node(int ele,Node n){
			data = ele;
			next = n;
		}
	}
}
