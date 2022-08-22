package linkedlist_miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * We are given a linked list with head as the first node. Let's number the
 * nodes in the list: node_1, node_2, node_3, ... etc.
 * 
 * Each node may have a next larger value: for node_i, next_larger(node_i) is
 * the node_j.val such that j > i, node_j.val > node_i.val, and j is the
 * smallest possible choice. If such a j does not exist, the next larger value
 * is 0.
 * 
 * Return an array of integers answer, where answer[i] =
 * next_larger(node_{i+1}).
 * 
 * Note that in the example inputs (not outputs) below, arrays such as [2,1,5]
 * represent the serialization of a linked list with a head node value of 2,
 * second node value of 1, and third node value of 5.
 * 
 * 
 * Input: [2,1,5] Output: [5,5,0] 
 * 
 * Input: [2,7,4,3,5] Output: [7,0,5,5,0]
 * 
 * Input: [1,7,5,1,9,2,5,1] Output: [7,9,9,9,0,5,0,0]
 *
 */
public class NextGreaterNodeInLinkedList {
	public static void main(String[] args) {
		ListNode head = ListUtil.createList(Arrays.asList(1,7,5,1,9,2,5,1));
		System.out.print("Original List :: ");
		ListUtil.print(head);
		int[] res = new NextGreaterNodeInLinkedList().nextLargerNodes(head);
		System.out.println(Arrays.toString(res));
	}
	 public int[] nextLargerNodes(ListNode head) {
	     
		 ListNode curr = head;
		 List<Integer> li = new ArrayList<Integer>();
		 while(curr!=null) {
			li.add(curr.val);
			 curr=curr.next;
		 }
		 int[] res = new int[li.size()];
		 Stack<Integer> st = new Stack<Integer>();
		 for(int i=0;i<li.size();i++) {
			 while(!st.isEmpty()&&li.get(st.peek())<li.get(i)) {
				 res[st.pop()]=li.get(i);
			 }
			 st.push(i);
		 }
		 return res;
	}
}
