package com.algo.linkedlist;

public class SortLinkedListOf0s1s2s {

	private static Node head,tail;
	private static void sort0s1s2sInLinkedList(Node root){
		Node i=root,j=root,k=tail;
		while (j !=k.next) {
			if(j.data==0){
				if(i.data!=j.data)
					swap(i,j);
				i=i.next;
				j=j.next;
			}else if(j.data==1){
				j=j.next;
			}else if(j.data==2){
				swap(j,k);
				k = getPreviousNode(root, k);//other option push the all element to stack and pop one by one
			}
		}
	}
	private static Node getPreviousNode(Node node,Node k){		
		while(node.next!=k){
			node=node.next;
		}
		return node;
		
	}
	private static void swap(Node node1,Node node2){
		int temp = node1.data;
		node1.data = node2.data;
		node2.data = temp;
	}
	private  void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + "->");
			head = head.next;
		}
		System.out.println("");
	}
	public static void main(String[] args) {

		SortLinkedListOf0s1s2s list = new SortLinkedListOf0s1s2s();
		list.head = new Node(0);
		list.head.next = new Node(1);
		list.head.next.next = new Node(0);
		list.head.next.next.next = new Node(2);
		list.head.next.next.next.next = new Node(2);
		list.head.next.next.next.next.next = new Node(0);
		list.head.next.next.next.next.next.next = new Node(2);
		list.head.next.next.next.next.next.next.next = new Node(1);
		tail = list.head.next.next.next.next.next.next.next.next = new Node(0);
		System.out.print("Original List :: ");
		list.printList(head);
		System.out.print("Sorted List   :: ");
		sort0s1s2sInLinkedList(head);
		list.printList(head);
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