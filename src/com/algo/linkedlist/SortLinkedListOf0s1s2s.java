package com.algo.linkedlist;

import java.util.Arrays;
import java.util.Stack;

public class SortLinkedListOf0s1s2s {

	public static void main(String[] args) {

		SortLinkedListOf0s1s2s list = new SortLinkedListOf0s1s2s();
		ListNode node =ListUtil.createList(Arrays.asList(0,1,0,2,2,0,2,1,0));
		ListUtil.print(node);
		list.sort0s1s2sInLinkedList(node);
		ListUtil.print(node);	
	}
	private  void sort0s1s2sInLinkedList(ListNode head){

		ListNode curr = head;
		Stack<ListNode> st = new Stack<ListNode>();
		while(curr!=null) {
			st.add(curr);
			curr=curr.next;
		}
		ListNode i=head,j=head,k=st.peek();
		while (j !=k.next) {
			if(j.val==0){
				if(i.val!=j.val)
					swap(i,j);
				i=i.next;
				j=j.next;
			}else if(j.val==1){
				j=j.next;
			}else if(j.val==2){
				swap(j,st.pop());
				k=st.peek();
			}
		}
	}
	private  void swap(ListNode ListNode1,ListNode ListNode2){
		int temp = ListNode1.val;
		ListNode1.val = ListNode2.val;
		ListNode2.val = temp;
	}
}