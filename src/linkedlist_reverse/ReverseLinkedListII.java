package linkedlist_reverse;

import java.util.Arrays;
import java.util.List;

import linkedlist_miscellaneous.ListNode;
import linkedlist_miscellaneous.ListUtil;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4 Output: 1->4->3->2->5->NULL
 * 
 */
public class ReverseLinkedListII {

	public static void main(String[] args) {
		ReverseLinkedListII list = new ReverseLinkedListII();
		List<Integer> nums = Arrays.asList(1);
		ListNode head = ListUtil.createList(nums);
		System.out.print("Original List :: ");
		ListUtil.print(head);
		ListNode node = list.reverseBetween(head,1,1);
		System.out.print("Reverse List  :: ");
		ListUtil.print(node);
	}
	public ListNode reverseBetween(ListNode head, int m, int n) {
		
		ListNode curr=head,prev=null,cnext,temp = null;
		
		for(int i=1;i<m&&curr!=null;i++) {
			temp=curr;
			curr=curr.next;
		}
		if(curr==null||curr.next==null) return head;
		ListNode temp2=curr;
		for(int i=m;i<=n&&curr!=null;i++) {
			cnext=curr.next;
			curr.next=prev;
			prev=curr;
			curr=cnext;
		}
		if(temp!=null) temp.next=prev;
		temp2.next=curr;
		return temp!=null?head:prev;

	}
}
