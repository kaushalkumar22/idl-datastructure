package linkedlist_miscellaneous;

import java.util.Arrays;
import java.util.List;

/**
 Given the head of a sorted linked list, delete all duplicates such that each element appears only once. 
 Return the linked list sorted as well.
 Input: head = [1,1,2]
 Output: [1,2]

 Input: head = [1,1,2,3,3]
 Output: [1,2,3]
 *
 */
public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedList list = new RemoveDuplicatesFromSortedList();
		List<Integer> nums = Arrays.asList(1, 2, 2,3,3,4,4,5);
		ListNode node = ListUtil.createList(nums);
		System.out.print("Original List :: ");
		ListUtil.print(node);
		list.deleteDuplicates(node);
		System.out.print("New List   :: ");
		ListUtil.print(node);
	}
	public ListNode deleteDuplicates(ListNode head) {
		ListNode curr=head;
		while(curr != null&&curr.next != null){
			if( curr.val == curr.next.val){
				curr.next= curr.next.next;
			}else{
				curr=curr.next;
			}
		} 
		return head;
	}
	public ListNode deleteDuplicatesRec(ListNode head) {
        if(head == null || head.next == null)return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
}
}
