package com.algo.linkedlist.reverse;

import java.util.Arrays;
import java.util.List;

import com.algo.linkedlist.ListNode;
import com.algo.linkedlist.ListUtil;

public class RotateList {

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
		ListNode head = ListUtil.createList(nums);
		ListUtil.print(head);
		ListNode node = rotateRight(head,3);
		ListUtil.print(node);
	}
	public static ListNode rotateRight(ListNode head, int k) {
		if(head==null ||k==0) return head;
		ListNode curr=head;
		int len=0;
		//get the length of linked list 
		while(curr.next!=null){
			len++;
			curr=curr.next;
		}
		//link the first node of list with last node
		curr.next=head;
		//if k is greater than len
		k=k%len;
		curr=head;
		ListNode prev=null;   
		//Traverse it len-k and uncut at list and (len-k)th node will be new head;
		for(int i=0;i<=len-k&&curr.next!=null;i++){
			prev=curr;
			curr=curr.next;
		}
		prev.next=null;
		return curr;
	}
}
