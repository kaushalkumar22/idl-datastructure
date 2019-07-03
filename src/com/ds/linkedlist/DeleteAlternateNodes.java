package com.ds.linkedlist;

public class DeleteAlternateNodes {
	
	private  Node head;
	
	private void deleteAlternateNode(Node head){
		
		Node curr = head;
		if(curr!=null&&curr.next!=null){
			curr.next=  curr.next.next;
			deleteAlternateNode(curr.next);
		}
	/*	while(curr!=null&&curr.next!=null){
			curr.next=  curr.next.next;
			curr = curr.next;
		}*/
	}
	private  void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + "-->");
			head = head.next;
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {

		DeleteAlternateNodes list = new DeleteAlternateNodes();

		list.head = new Node(7);
		list.head.next = new Node(5);
		list.head.next.next = new Node(9);
	    list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(6);
		list.head.next.next.next.next.next = new Node(10);
		
		System.out.print("1st List :: ");		
		list.printList(list.head);
		
		list.deleteAlternateNode (list.head);
		System.out.print("After delete List :: ");

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
