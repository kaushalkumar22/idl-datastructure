package com.ds.linkedlist;



public class Merge2SortedLists {
	private  Node head,head1, head2;

	private Node mergeSortedLists(Node a,Node b) 
	{
		Node result = null;
		if (a == null) return b;
		if (b==null) return a;
		
		/* Pick either a or b, and recur */
		if (a.data <= b.data){
			result = a;
			result.next = mergeSortedLists(a.next, b);
		}else{
			result = b;
			result.next = mergeSortedLists(a, b.next);
		}
		return result;
	}
	
	private  void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + "-->");
			head = head.next;
		}
		System.out.println("");
	}
	public static void main(String[] args) {

		Merge2SortedLists list = new Merge2SortedLists();

		list.head1 = new Node(3);
		list.head1.next = new Node(7);
		list.head1.next.next = new Node(9);
		list.head1.next.next.next = new Node(11);
		list.head1.next.next.next.next = new Node(13);


		list.head2 = new Node(2);
		list.head2.next = new Node(4);
		list.head2.next.next = new Node(6);
		list.head2.next.next.next = new Node(8);
		list.head2.next.next.next.next = new Node(10);
		list.head2.next.next.next.next.next = new Node(12);

		System.out.print("1st List :: ");
		list.printList(list.head1);
		System.out.print("2nd List :: ");
		list.printList(list.head2);
		list.head =list.mergeSortedLists(list.head1,list.head2);
		System.out.print("Merged Sorted Lists Recursive :: ");
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
