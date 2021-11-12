package com.algo.linkedlist;

import java.util.Arrays;
import java.util.List;

/**Use Hashing:
Traverse the list one by one and keep putting the node addresses in a Hash Table. At any point,
 if NULL is reached then return false and if next of current node points to any of the previously 
 stored nodes in Hash then return true.

Mark Visited Nodes:
This solution requires modifications to basic linked list data structure.  Have a visited flag with each node.
Traverse the linked list and keep marking visited nodes.  If you see a visited node again then there is a loop.
 This solution works in O(n) but requires additional information with each node.
A variation of this solution that doesn’t require modification to basic data structure can be implemented using hash.
Just store the addresses of visited nodes in a hash and if you see an address that already exists in hash 
then there is a loop.

Floyd’s Cycle-Finding Algorithm:
This is the fastest method. Traverse linked list using two pointers.  Move one pointer by one and other
 pointer by two.  If these pointers meet at some node then there is a loop.  If pointers do not meet then 
 linked list doesn’t have loop.
*/
public class LinkedListCycleOld {
	
	

	private	boolean isContainsLoop(ListNode head){
		ListNode  slowPtr = head;
		ListNode  fastPtr = head;

		while(slowPtr!=null&&fastPtr!=null){
			fastPtr = fastPtr.next; // advance the fast pointer
			if(fastPtr == slowPtr)   // and check if its equal to the slow pointer
				return true;         // loop detected

			if(fastPtr == null)
				return false;        // since fastPtr is NULL we reached the tail

			fastPtr = fastPtr.next; //advance and check again
			if(fastPtr == slowPtr)
				return true;

			slowPtr = slowPtr.next;  // advance the slow pointer only once
		}
		return false;                // we reach here if we reach the tail
	}
	public static void main(String[] args) {
		
		List<Integer> nums =Arrays.asList(50,20,15,4,10);
		ListNode list = ListUtil.createList(nums);	
		System.out.print("Original List :: ");
		ListUtil.print(list);
		list.next.next.next.next.next = list.next.next;	// Creating a loop for testing 
		LinkedListCycleOld detectCycle = new LinkedListCycleOld(); 
		System.out.println("list having cycle:"+detectCycle.isContainsLoop(list));	
	}
}

