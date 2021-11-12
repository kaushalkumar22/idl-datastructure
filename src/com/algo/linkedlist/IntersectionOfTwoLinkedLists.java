package com.algo.linkedlist;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 * 
 * For example, the following two linked lists:
 * 
 * begin to intersect at node c1.
 * 
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA =
 * 2, skipB = 3 Output: Reference of the node with value = 8 Input Explanation:
 * The intersected node's value is 8 (note that this must not be 0 if the two
 * lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head
 * of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected
 * node in A; There are 3 nodes before the intersected node in B.
 * 
 * Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3,
 * skipB = 1 Output: Reference of the node with value = 2 Input Explanation: The
 * intersected node's value is 2 (note that this must not be 0 if the two lists
 * intersect). From the head of A, it reads as [1,9,1,2,4]. From the head of B,
 * it reads as [3,2,4]. There are 3 nodes before the intersected node in A;
 * There are 1 node before the intersected node in B.
 *
 */
public class IntersectionOfTwoLinkedLists {

	public static void main(String[] args) {
		List<Integer> nums =Arrays.asList(9,1,2,4);
		ListNode headA = ListUtil.createList(nums);	
		System.out.print("Original List :: ");
		ListUtil.print(headA);
		List<Integer> nums1 =Arrays.asList(3,2,4);
		
		ListNode headB = ListUtil.createList(nums1);	
		System.out.print("Original List :: ");
		ListUtil.print(headB);
		headA.next.next = headB.next;
		System.out.println(getIntersectionNode( headA,  headB).val);
	}
	 public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		    //boundary check
		    if(headA == null || headB == null) return null;
		    
		    ListNode a = headA;
		    ListNode b = headB;
		    
		    //if a & b have different len, then we will stop the loop after second iteration
		    while( a != b){
		    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
		        a = a == null? headB : a.next;
		        b = b == null? headA : b.next;    
		    }
		    
		    return a;
		}
}
