package com.algo.tree.construct;

import com.algo.linkedlist.ListNode;
import com.algo.tree.common.TreeNode;

public class ConvertSortedListToBinarySearchTree {
	
		public TreeNode sortedListToBST(ListNode head) {
			if(head==null) return null;
			return build(head,null);
		}
		public TreeNode build(ListNode head, ListNode tail){
			ListNode slow = head;
			ListNode fast = head;
			if(head==tail) return null;

			while(fast!=tail&&fast.next!=tail){
				fast = fast.next.next;
				slow = slow.next;
			}
			TreeNode thead = new TreeNode(slow.val);
			thead.left  = build(head,slow);
			thead.right = build(slow.next,tail);
			return thead;
		}
	}
