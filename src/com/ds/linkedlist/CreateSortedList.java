package com.ds.linkedlist;

public class CreateSortedList {
	private Node head;
	public static void main(String[] args) {
		CreateSortedList list = new CreateSortedList();
		list.sortedLinkedLast(5);
		list.sortedLinkedLast(3);
		list.sortedLinkedLast(66);
		list.sortedLinkedLast(7);
		list.sortedLinkedLast(13);
		list.sortedLinkedLast(12);		
		list.sortedLinkedLast(11);
		list.sortedLinkedLast(8);
		list.sortedLinkedLast(9);
		list.displayList();
		
	}
	
	private void sortedLinkedLast(int num) {	
		Node current = head;
		Node newNode = new Node(num);
		/* if list is empty or if new node is to be inserted
		 * before the first node */
		if( current == null ||current.data>num ){
			head = newNode;
			head.next = current ;
		}else{
			while(current!= null ){
				if(current.data <= num &&(current.next == null
						         ||current.next.data>num )){
					newNode.next = current.next ;
					current.next = newNode ;
					return;
				}
				current = current.next ;
			}
		}
	}
	
	public void displayList() {
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

		private Node(int ele){
			data = ele;
			next = null;
		}
	}

}
