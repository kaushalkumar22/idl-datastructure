package com.ds.leetcode.problemset;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/**
 *  Merge with Divide And Conquer

    This approach walks alongside the one above but is improved a lot. We don't need to traverse most nodes many times repeatedly

    Pair up k\text{k}k lists and merge each pair.

    After the first pairing, k\text{k}k lists are merged into k/2k/2k/2 lists with average 2N/k2N/k2N/k length, then k/4k/4k/4, k/8k/8k/8 and so on.

    Repeat this procedure until we get the final sorted linked list.

    Thus, we'll traverse almost NNN nodes per pairing and merging, and repeat this procedure about logâ?¡2k\log_{2}{k}log2â€‹k times.


    Time complexity : O(Nlogâ?¡k)O(N\log k)O(Nlogk) where k\text{k}k is the number of linked lists.
    We can merge two sorted linked list in O(n)O(n)O(n) time where nnn is the total number of nodes in two lists.
    Sum up the merge process and we can get: O(âˆ‘i=1log2kN)=O(Nlogâ?¡k)O\big(\sum_{i=1}^{log_{2}{k}}N \big)= O(N\log k)O(âˆ‘i=1log2â€‹kâ€‹N)=O(Nlogk)

    Space complexity : O(1)O(1)O(1)
    We can merge two sorted linked lists in O(1)O(1)O(1) space.

 * @author IBM
 *
 */

public class MergeKSortedLists {

	Node head1;
	Node head2;
	Node head3;
	Node head;

	public Node mergeTwoLists(Node l1, Node l2) {
		Node h = new Node(0);
		Node ans=h;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				h.next = l1;
				h = h.next;
				l1 = l1.next;
			} else {
				h.next = l2;
				h = h.next;
				l2 = l2.next;
			}
		}
		if(l1==null){
			h.next=l2;
		}
		if(l2==null){
			h.next=l1;
		} 
		return ans;
	}
	public Node mergeKLists(List<Node> lists) {
		if(lists.size()==0){
			return null;
		}
		int interval = 1;
		while(interval<lists.size()){
			//System.out.println(lists.size());
			for (int i = 0; i + interval< lists.size(); i=i+interval*2) {
				Node node =lists.get(i);
				node=mergeTwoLists(node,lists.get(i+interval));            
			}
			interval*=2;
		}

		return lists.get(0);
	}

	public static void main(String[] args) {


		MergeKSortedLists list = new MergeKSortedLists();

		list.head1 = new Node(3);
		list.head1.next = new Node(7);
		list.head1.next.next = new Node(9);
		list.head1.next.next.next = new Node(11);
		list.head1.next.next.next.next = new Node(13);


		list.head2 = new Node(5);
		list.head2.next = new Node(4);
		list.head2.next.next = new Node(6);
		list.head2.next.next.next = new Node(8);
		list.head2.next.next.next.next = new Node(10);
		list.head2.next.next.next.next.next = new Node(12);

		list.head3 = new Node(15);
		list.head3.next = new Node(18);
		list.head3.next.next = new Node(30);
		list.head3.next.next.next = new Node(40);

		List<Node> nodeList = Arrays.asList(list.head1,list.head2,list.head3);

		list.head = list.mergeKLists(nodeList);

		System.out.print("Merged Sorted Lists Recursive :: ");
		list.printList(list.head);
	}

	private  void printList(Node head) {
		while (head != null) {
			System.out.print(head.val + "-->");
			head = head.next;
		}
		System.out.println("");
	}
	static private class Node {
		int val;
		Node next;
		private Node(int val) {
			this.val = val;
			this.next = null;
		}
	}
}
