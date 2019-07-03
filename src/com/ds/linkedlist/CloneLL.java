package com.ds.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CloneLL {

	private Node head;
	public Node clone(Node head){

		Node curr = head;
		Map<Node,Node> map = new HashMap<Node,Node>();
		while(curr!=null) {
			map.put(curr, new Node(curr.data));
			curr= curr.next;
		}
		for(Map.Entry<Node,Node> entry: map.entrySet()) {
			Node n1 = entry.getKey();
			Node n2= entry.getValue();
			n2.next= map.get(n1.next);
			n2.random= map.get(n1.random);
		}
		return map.get(head);

	}
	public static void main(String[] args) {

		CloneLL list = new CloneLL();
		list.head = new Node(10);
		list.head.next = new Node(20);
		list.head.next.next = new Node(30);
		list.head.next.next.next = new Node(40);
		list.head.next.next.next.next = new Node(50);
		list.head.next.next.next.next.next = new Node(60);

		list.head.random=list.head.next.next.next.next.next;
		list.head.next.random=list.head.next.next.next.next;
		list.head.next.next.random=list.head.next.next.next;
		list.head.next.next.next.next.next.random=list.head.next.next.next.next;
		list.head.next.next.next.next.random=list.head.next;
		list.head.next.next.next.random=list.head;

		list.displayForward();
		list.head=list.clone(list.head);
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
		Node next,random;
		private Node(int ele){
			data = ele;
			next =random= null;
		}
	}
}
