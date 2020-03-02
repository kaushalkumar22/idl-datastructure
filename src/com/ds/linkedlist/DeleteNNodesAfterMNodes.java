package com.ds.linkedlist;

import java.util.Arrays;
import java.util.List;

public class DeleteNNodesAfterMNodes {

	public static void main(String[] args) {
		DeleteNNodesAfterMNodes list = new DeleteNNodesAfterMNodes();
		List<Integer> nums = Arrays.asList(1,2,2,4,7,8,10,15,20);
		ListNode node = ListUtil.createList(nums);	
		System.out.print("Original List :: ");
		ListUtil.print(node);
		list.deleteListNodes(node,2,2);
		System.out.print("New List   :: ");
		list.printList(node);
	}
	private void deleteListNodes(ListNode head,int m,int n){

		if (head == null || head.next == null) return;

		ListNode curr = head, temp =null;
       //it will traverse up to m ListNode and holds previous ListNode in temp
		for (int i = 0; curr != null && i < m; i++) {
			temp = curr;
			curr = curr.next;
		}

		if (curr == null) return;
		//it will traverse up to n ListNode 
		for (int i = 0; curr != null && i < n; i++) {
			curr = curr.next;
		}
        //it will add mth ListNode next as nth+1 ListNodes i.e here doing dereferencing n ListNodes
		temp.next = curr;
		deleteListNodes(curr, m, n);
	}
	private  void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println("");
	}


}
