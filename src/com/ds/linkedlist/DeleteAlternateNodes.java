package com.ds.linkedlist;

import java.util.Arrays;
import java.util.List;

public class DeleteAlternateNodes {
	
	private void deleteAlternateListNode(ListNode curr){
			
		if(curr==null||curr.next==null) return;
		curr.next=curr.next.next;
		deleteAlternateListNode(curr.next);

		//ListNode curr = head;
				/*if(curr!=null&&curr.next!=null){
					curr.next=  curr.next.next;
					deleteAlternateListNode(curr.next);
				}*/
		
	/*	while(curr!=null&&curr.next!=null){
			curr.next=  curr.next.next;
			curr = curr.next;
		}*/
	}

	
	public static void main(String[] args) {

		List<Integer> nums =Arrays.asList(7,5,9,4,6,10);
		ListNode listNode = ListUtil.createList(nums);	
		System.out.print("Original List :: ");
		ListUtil.print(listNode);
		DeleteAlternateNodes list = new DeleteAlternateNodes();
		list.deleteAlternateListNode (listNode);
		System.out.print("After delete List :: ");
		ListUtil.print(listNode);
	}
	

}
