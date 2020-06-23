package com.algo.universal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import com.ds.linkedlist.ListNode;

/**
 * Merge with Divide And Conquer
 * 
 * This approach walks alongside the one above but is improved a lot. We don't
 * need to traverse most ListNodes many times repeatedly
 * 
 * Pair up k\text{k}k lists and merge each pair.
 * 
 * After the first pairing, k\text{k}k lists are merged into k/2k/2k/2 lists
 * with average 2N/k2N/k2N/k length, then k/4k/4k/4, k/8k/8k/8 and so on.
 * 
 * Repeat this procedure until we get the final sorted linked list.
 * 
 * Thus, we'll traverse almost NNN ListNodes per pairing and merging, and repeat
 * this procedure about log�?�2k\log_{2}{k}log2​k times.
 * 
 * 
 * Time complexity : O(Nlog�?�k)O(N\log k)O(Nlogk) where k\text{k}k is the
 * number of linked lists. We can merge two sorted linked list in O(n)O(n)O(n)
 * time where nnn is the total number of ListNodes in two lists. Sum up the merge
 * process and we can get:
 * O(∑i=1log2kN)=O(Nlog�?�k)O\big(\sum_{i=1}^{log_{2}{k}}N \big)= O(N\log
 * k)O(∑i=1log2​k​N)=O(Nlogk)
 * 
 * Space complexity : O(1)O(1)O(1) We can merge two sorted linked lists in
 * O(1)O(1)O(1) space.
 * 
 * @author IBM
 *
 */

public class MergeKSortedLists {

	ListNode head1;
	ListNode head2;
	ListNode head3;
	ListNode head;

	public ListNode mergeKListsOpt(List<ListNode> lists) {
        if (lists==null||lists.size()==0) return null;
        
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else 
                    return 1;
            }
        });
        
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        
        for (ListNode ListNode:lists)
            if (ListNode!=null)
                queue.add(ListNode);
            
        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;
            
            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode h = new ListNode(0);
		ListNode ans=h;
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
	public ListNode mergeKLists(List<ListNode> lists) {
		if(lists.size()==0){
			return null;
		}
		int interval = 1;
		while(interval<lists.size()){
			//System.out.println(lists.size());
			for (int i = 0; i + interval< lists.size(); i=i+interval*2) {
				ListNode ListNode =lists.get(i);
				ListNode=mergeTwoLists(ListNode,lists.get(i+interval));            
			}
			interval*=2;
		}

		return lists.get(0);
	}

	public static void main(String[] args) {


		MergeKSortedLists list = new MergeKSortedLists();

		list.head1 = new ListNode(3);
		list.head1.next = new ListNode(7);
		list.head1.next.next = new ListNode(9);
		list.head1.next.next.next = new ListNode(11);
		list.head1.next.next.next.next = new ListNode(13);


		list.head2 = new ListNode(5);
		list.head2.next = new ListNode(4);
		list.head2.next.next = new ListNode(6);
		list.head2.next.next.next = new ListNode(8);
		list.head2.next.next.next.next = new ListNode(10);
		list.head2.next.next.next.next.next = new ListNode(12);

		list.head3 = new ListNode(15);
		list.head3.next = new ListNode(18);
		list.head3.next.next = new ListNode(30);
		list.head3.next.next.next = new ListNode(40);

		List<ListNode> listNodeList = Arrays.asList(list.head1,list.head2,list.head3);

		list.head = list.mergeKLists(listNodeList);

		System.out.print("Merged Sorted Lists Recursive :: ");
		list.printList(list.head);
	}

	private  void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "-->");
			head = head.next;
		}
		System.out.println("");
	}
	
}
