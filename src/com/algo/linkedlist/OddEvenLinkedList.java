package com.algo.linkedlist;

/**
 * Given a singly linked list, group all odd nodes together followed by the even
 * nodes. Please note here we are talking about the node number and not the
 * value in the nodes.
 * 
 * You should try to do it in place. The program should run in O(1) space
 * complexity and O(nodes) time complexity.
 * 
 * 
 * Input: 1->2->3->4->5->NULL Output: 1->3->5->2->4->NULL
 * Input: 2->1->3->5->6->4->7->NULL Output: 2->3->6->7->1->5->4->NULL
 * 
 *
 */
public class OddEvenLinkedList {

	private Node head;

	public ListNode oddEvenList(ListNode head) {
	    if (head != null) {
	    
	        ListNode odd = head, even = head.next, evenHead = even; 
	    
	        while (even != null && even.next != null) {
	            odd.next = odd.next.next; 
	            even.next = even.next.next; 
	            odd = odd.next;
	            even = even.next;
	        }
	        odd.next = evenHead; 
	    }
	    return head;
	}
	private void segregateEvenOddNodes(Node node) {
		Node curr = node;
		Node evenIndexNode = head;
		Node temp = null;
		while (curr != null) {

			if (curr.data % 2 == 0) {

				if (curr == head || evenIndexNode.next == curr && evenIndexNode.data % 2 == 0) {
					evenIndexNode = curr;
				} else if (evenIndexNode.data % 2 != 0) {// it will handle
															// starting wi
					Node cTemp = curr;
					temp.next = cTemp.next;
					cTemp.next = head;
					evenIndexNode = cTemp;
					head = cTemp;
					curr = temp;
				} else {

					Node tem = evenIndexNode;
					Node cTemp = curr;
					temp.next = cTemp.next;
					cTemp.next = tem.next;
					tem.next = cTemp;
					evenIndexNode = cTemp;
					curr = temp;
				}
				temp = curr;
				curr = curr.next;
			} else {
				temp = curr;
				curr = curr.next;
			}
		}
	}

	private void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + "->");
			head = head.next;
		}
		System.out.println("");
	}

	public static void main(String[] args) {

		OddEvenLinkedList list = new OddEvenLinkedList();
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
		// System.out.print("Sorted List :: ");
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