package com.ds.linkedlist;

public class AddTwoNumbers {

	private Node head,head1, head2;
	int carry = 0;
	Node curr =null;
	
	private	void doAddLinkedListsNodes (Node first, Node second,int size1,int size2){
		
		if(size1>1&&size2>1&&size1==size2){ 
			doAddLinkedListsNodes (first.next,second.next,size1-1,size2-1);
		}else if(size1>size2){   
			doAddLinkedListsNodes (first.next,second,size1-1,size2);
		}else if(size2>size1){		
			doAddLinkedListsNodes (first,second.next,size1,size2-1);
		}
		doAddNodes( first, second,size1,size2);
	}
	private  void doAddNodes(Node first,Node second,int size1,int size2) {

		//System.out.println(first.data+" "+ second.data+" "+size1+" "+size2);
		int tempCarry = carry;
		int sum = carry + (size1>=size2 ?first.data:0) + (size2>=size1 ?second.data:0) ;
		carry = (sum >= 10) ? 1 : 0;
		sum = sum % 10;
		if(tempCarry==0){
			crearteNode(sum);
		}else{
			head.data=sum;
		}
		if (carry > 0) {
			crearteNode(carry);
		}
	}
	private  void crearteNode(int data) {
		Node node = new Node(data);
		node.next = head;
		head=node;
	}
	private  void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + "-->");
			head = head.next;
		}
		System.out.println("");
	}
	private static  int listSize(Node head) {
		int count =0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}

	public static void main(String[] args) {

		AddTwoNumbers list = new AddTwoNumbers();

		list.head1 = new Node(7);
		list.head1.next = new Node(5);
		list.head1.next.next = new Node(9);
	    list.head1.next.next.next = new Node(4);
		list.head1.next.next.next.next = new Node(6);
		
		System.out.print("1st List :: ");		
		list.printList(list.head1);
		
		list.head2 = new Node(8);
		list.head2.next = new Node(4);
		list.head2.next.next = new Node(8);
		
		System.out.print("2nd List :: ");
		list.printList(list.head2);

		int size1 = listSize(list.head1);
		int size2 = listSize(list.head2);
		list.doAddLinkedListsNodes (list.head1, list.head2,size1,size2);
		System.out.print("Sum List :: ");

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