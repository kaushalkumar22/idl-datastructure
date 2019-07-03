package com.ds.linkedlist;

public class DeleteNnodesAfterMnodes {

	private Node head;	
	
	private void deleteNodes(Node head,int m,int n){

		if (head == null || head.next == null) return;

		Node curr = head, temp =null;
       //it will traverse up to m node and holds previous node in temp
		for (int i = 0; curr != null && i < m; i++) {
			temp = curr;
			curr = curr.next;
		}

		if (curr == null) return;
		//it will traverse up to n node 
		for (int i = 0; curr != null && i < n; i++) {
			curr = curr.next;
		}
        //it will add mth node next as nth+1 nodes i.e here doing dereferencing n nodes
		temp.next = curr;
		deleteNodes(curr, m, n);
	}
	private  void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + "->");
			head = head.next;
		}
		System.out.println("");
	}
	public static void main(String[] args) {

		DeleteNnodesAfterMnodes list = new DeleteNnodesAfterMnodes();
		list.head = new Node(1);
		list.head.next = new Node(2);
		list.head.next.next = new Node(2);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(7);
		list.head.next.next.next.next.next = new Node(8);
		list.head.next.next.next.next.next.next = new Node(10);
		list.head.next.next.next.next.next.next.next = new Node(15);
		list.head.next.next.next.next.next.next.next.next = new Node(20);
		System.out.print("Original List :: ");
		list.printList(list.head);
		System.out.println();
		list.deleteNodes(list.head,2,2);
		System.out.print("Reverse List   :: ");

		list.printList(list.head);
	}
	private	static class Node {
		int data;
		Node next;
		Node(int d) {
			data = d;
			next = null;
		}
	}

}
