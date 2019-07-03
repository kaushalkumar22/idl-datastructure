package com.ds.linkedlist;


public class RotateListBothSideFromKPostion {

	private  Node head;
	private  Node rotateListBothSideFromKthPostion(Node node, int k) {

		Node curr = node;
		Node cnext,prev=null;

		for(int i=0;i<k&&curr!=null;i++){
			
			cnext = curr.next;
			curr.next=prev;
			prev= curr;
			curr=cnext;	
		}
        Node temp = prev;
		prev = null;
		while(curr!=null){			
			cnext = curr.next;
			curr.next=prev;
			prev= curr;
			curr=cnext;
		}		
		node.next = prev;		
		return temp;

	}
	private  void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println("");
	}
	public static void main(String[] args) {

		RotateListBothSideFromKPostion list = new RotateListBothSideFromKPostion();
		list.head = new Node(1);
		list.head.next = new Node(2);
		list.head.next.next = new Node(3);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(7);
		list.head.next.next.next.next.next = new Node(8);
		list.head.next.next.next.next.next.next = new Node(10);
		list.head.next.next.next.next.next.next.next = new Node(15);
		list.head.next.next.next.next.next.next.next.next = new Node(20);
		System.out.print("Original List :: ");
		list.printList(list.head);
		System.out.println();
		list.head= list.rotateListBothSideFromKthPostion(list.head,4);
		System.out.print("Rotated List   :: ");

		list.printList(list.head);
	}
	private static class Node {
		int data;
		Node next;
		Node(int d) {
			data = d;
			next = null;
		}
	}
}
