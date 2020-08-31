package com.algo.linkedlist;
public class ReverseLL {

	private Node head;

	private Node reverseRecurcive( Node curr,Node prev){

		if(curr.next==null){
			head=curr;
			curr.next=prev;
			return null;
		}
		Node cnext = curr.next;
		curr.next = prev;
		reverseRecurcive( cnext,curr);

		return head;
	}
	private Node reverseIterative( Node head){

		Node curr = head;
		Node prev=null,cnext;	
		while(curr!=null){
			cnext = curr.next;
			curr.next=prev;
			prev=curr;
			curr=cnext;
		}
		return prev;
	}
	public static void main(String[] args) {
		ReverseLL list = new ReverseLL();
		list.head = new Node(10);
		list.head.next = new Node(20);
		list.head.next.next = new Node(30);
		list.head.next.next.next = new Node(40);
		list.head.next.next.next.next = new Node(50);
		list.head.next.next.next.next.next = new Node(60);

		list.displayForward();
		list.head = list.reverseIterative(list.head);
		list.displayForward();
		list.head = list.reverseRecurcive(list.head,null);

		list.displayForward();
	}
	public void displayForward() {
		System.out.print("List: ");
		Node current = head; 
		while (current != null){
			System.out.print(current.data+" ");
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
