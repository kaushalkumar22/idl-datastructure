package com.ds.linkedlist;

public class SegregateEvenOddNodes {

	private  Node head;
	private  void segregateEvenOddNodes(Node node){
		Node curr = node;
		Node evenIndexNode =head;
		Node temp = null;
		while (curr != null) {	

			if(curr.data%2==0){

				if(curr== head||evenIndexNode.next==curr&&evenIndexNode.data%2==0){
					evenIndexNode=curr;
				}else if(evenIndexNode.data%2!=0){//it will handle starting wi
					Node cTemp =curr;	
					temp.next= cTemp.next;
					cTemp.next=head;
					evenIndexNode=cTemp;
					head = cTemp;
					curr=temp;
				}else{

					Node tem = evenIndexNode;
					Node cTemp =curr;			
					temp.next= cTemp.next;
					cTemp.next = tem.next;
					tem.next=cTemp;	
					evenIndexNode=cTemp;
					curr=temp;
				}
				temp=curr;
				curr=curr.next;
			}else{
				temp = curr;
				curr= curr.next;
			}
		}
	}
	private  void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + "->");
			head = head.next;
		}
		System.out.println("");
	}
	public static void main(String[] args) {

		SegregateEvenOddNodes list = new SegregateEvenOddNodes();
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
		//System.out.print("Sorted List   :: ");
		list.segregateEvenOddNodes(list.head);
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