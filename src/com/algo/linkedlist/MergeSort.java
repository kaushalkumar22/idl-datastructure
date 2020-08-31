package com.algo.linkedlist;


public class MergeSort {

	private  Node head;
	private Node mergeSortLinkList(Node startNode){

		//Break the list until list is null or only 1 element is present in List.
		if(startNode==null || startNode.next==null){
			return startNode;
		}

		//Break the linklist into 2 list.
		//Finding Middle node and then breaking the Linled list in 2 parts.
		//Now 2 list are, 1st list from start to middle and 2nd list from middle+1 to last.

		Node middle = getMiddle(startNode);
		Node nextOfMiddle = middle.next;
		middle.next=null;

		//Again breaking the List until there is only 1 element in each list.
		Node left = mergeSortLinkList(startNode);
		Node right = mergeSortLinkList(nextOfMiddle);

		//Once complete list is divided and contains only single element, 
		//Start merging left and right half by sorting them and passing Sorted list further. 
		Node sortedList = mergeTwoListRecursive(left, right);

		return sortedList;
	}

	//Recursive Approach for Merging Two Sorted List
	private Node mergeTwoListRecursive(Node left, Node right){
			
		if(left==null) return right;
		if(right==null) return left;
		
		Node result;
		if(left.data<right.data){
			result=left;
			result.next=(mergeTwoListRecursive(left.next, right));
		}else{
			result=right;
			result.next=(mergeTwoListRecursive(left, right.next));
		}
		return result;
	}

	private Node getMiddle(Node startNode) {
		if(startNode==null){
			return startNode;
		}

		Node pointer1=startNode;
		Node pointer2=startNode;

		while(pointer2.next!=null && pointer2.next.next!=null){
			pointer1 = pointer1.next;
			pointer2 = pointer2.next.next;

		}
		return pointer1;
	}

	private  void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + "->");
			head = head.next;
		}
		System.out.println("");
	}
	public static void main(String[] args) {

		MergeSort list = new MergeSort();
		list.head = new Node(1);
		list.head.next = new Node(11);
		list.head.next.next = new Node(2);
		list.head.next.next.next = new Node(99);
		list.head.next.next.next.next = new Node(7);
		list.head.next.next.next.next.next = new Node(3);
		list.head.next.next.next.next.next.next = new Node(10);
		list.head.next.next.next.next.next.next.next = new Node(25);
		list.head.next.next.next.next.next.next.next.next = new Node(20);
		
		System.out.print("Original List  :: ");
		list.printList(list.head);
		list.mergeSortLinkList(list.head);
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
