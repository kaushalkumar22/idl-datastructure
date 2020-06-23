package com.algo.misc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedListsPriorityQueue {

	Node head1;
	Node head2;
	Node head3;
	Node head;

	public Node mergeKLists(List<Node> lists) {
		if (lists==null||lists.size()==0) return null;
		PriorityQueue<Node> queue= new PriorityQueue<Node>(lists.size(),new Comparator<Node>(){
			@Override
			public int compare(Node o1,Node o2){
				if (o1.element<o2.element)
					return -1;
				else if (o1.element==o2.element)
					return 0;
				else 
					return 1;
			}
		});

		Node dummy = new Node(0);
		Node tail=dummy;

		for (Node node:lists)
			if (node!=null)
				queue.add(node);

		while (!queue.isEmpty()){
			tail.next=queue.poll();
			tail=tail.next;

			if (tail.next!=null)
				queue.add(tail.next);
		}
		return dummy.next;
	}
	public static void main(String[] args) {


		MergeKSortedListsPriorityQueue list = new MergeKSortedListsPriorityQueue();

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

		list.head3 = new Node(15);
		list.head3.next = new Node(18);
		list.head3.next.next = new Node(30);
		list.head3.next.next.next = new Node(40);


		System.out.print("1st List :: ");
		list.printList(list.head1);
		System.out.print("2nd List :: ");
		list.printList(list.head2);
		list.head =list.mergeKLists(Arrays.asList(list.head1,list.head2,list.head3));
		System.out.print("Merged Sorted Lists Recursive :: ");
		list.printList(list.head);
	}

	private  void printList(Node head) {
		while (head != null) {
			System.out.print(head.element + "-->");
			head = head.next;
		}
		System.out.println("");
	}
	static class Node {
		int element;
		Node next;
		Node tail;

		public Node(int element) {
			this.element = element;
			this.next = null;
			this.tail = null;
		}
	}
}
