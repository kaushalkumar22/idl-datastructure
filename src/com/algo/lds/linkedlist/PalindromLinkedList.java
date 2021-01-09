package com.algo.lds.linkedlist;

import java.util.Arrays;
import java.util.List;

/** 
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Input: 1->2 Output: false
 * 
 * Input: 1->2->2->1 Output: true
 * 
 * Follow up: Could you do it in O(n) time and O(1) space?
 *
 */
public class PalindromLinkedList {

	private ListNode head1;
	boolean isPalindrom = true;
	public static void main(String[] args) {
		List<Integer> nums1 = Arrays.asList(1,2,1);
		ListNode head = ListUtil.createList(nums1);
		System.out.print("Original List :: ");
		ListUtil.print(head);
		PalindromLinkedList list = new PalindromLinkedList();
		System.out.println(list.isPalindrome(head));
	}
	 public boolean isPalindrome(ListNode head) {
         if (head== null) return true;
         head1=head;
        return isLinkedListPalindrom(head);
    }
    private  boolean isLinkedListPalindrom(ListNode node){
        
		if (node.next != null) {
			isLinkedListPalindrom(node.next);
		}
		if(!isPalindrom1(head1,node)){
			isPalindrom =false;
		}
		return isPalindrom;
	}
	private  boolean isPalindrom1(ListNode start,ListNode end){	
		boolean isPal =false;
		if(start.val==end.val) {
			isPal =true;		
		}	
		head1=head1.next;
		return isPal;
	}	
}