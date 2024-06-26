package linkedlist_miscellaneous;

import java.util.Arrays;
import java.util.List;

/**
 * Given a non-empty, singly linked list with head node head, return a middle
 * node of linked list.
 * 
 * If there are two middle nodes, return the second middle node.
 * 
 * 
 * Input: [1,2,3,4,5] Output: Node 3 from this list (Serialization: [3,4,5]) The
 * returned node has value 3. (The judge's serialization of this node is
 * [3,4,5]). Note that we returned a ListNode object ans, such that: ans.val =
 * 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 * 
 * Example 2:
 * 
 * Input: [1,2,3,4,5,6] Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second
 * one.
 *
 * 
 */
public class MiddleOfLinkedList {

	public static void main(String[] args) {

		MiddleOfLinkedList list = new MiddleOfLinkedList();
		List<Integer> nums = Arrays.asList(1, 2, 2, 4, 7, 8, 10, 15);
		ListNode node = ListUtil.createList(nums);
		System.out.print("Original List :: ");
		ListUtil.print(node);
		ListNode k1 = list.middleNode(node);
		System.out.println("Middle " + k1.val);
	}
	public ListNode middleNode(ListNode head) {
		ListNode slow=head,fast=head;
		while(fast!=null&&fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
}
