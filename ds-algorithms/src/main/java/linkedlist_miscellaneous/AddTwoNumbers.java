package linkedlist_miscellaneous;

import java.util.Arrays;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The most significant digit comes first and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Follow up: What if you cannot modify the input lists? In other words,
 * reversing the lists is not allowed.
 * 
 * 
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 8 -> 0 -> 7
 * 
 */
public class AddTwoNumbers {



	public static void main(String[] args) {

		ListNode list1 = ListUtil.createList(Arrays.asList(7, 5, 9, 4, 6));
		ListNode list2 = ListUtil.createList(Arrays.asList(8, 4, 8));
		AddTwoNumbers list = new AddTwoNumbers();
		list.addTwoNumbers(list1, list2);
		ListUtil.print(list.head);
	}
	private ListNode head;
	int carry = 0;
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		int size1 = listSize(l1);
		int size2 = listSize(l2);
		doAddLinkedListsNodes (l1, l2,size1,size2);
		return head;
	}

	private	void doAddLinkedListsNodes (ListNode first, ListNode second,int size1,int size2){

		if(size1>1&&size2>1&&size1==size2){ 
			doAddLinkedListsNodes (first.next,second.next,size1-1,size2-1);
		}else if(size1>size2){   
			doAddLinkedListsNodes (first.next,second,size1-1,size2);
		}else if(size2>size1){		
			doAddLinkedListsNodes (first,second.next,size1,size2-1);
		}
		doAddNodes( first, second,size1,size2);
	}

	private  void doAddNodes(ListNode first,ListNode second,int size1,int size2) {

		int tempCarry = carry;
		int sum = carry + (size1>=size2 ?first.val:0) + (size2>=size1 ?second.val:0) ;
		carry = (sum >= 10) ? 1 : 0;
		sum = sum % 10;
		if(tempCarry==0){
			crearteNode(sum);
		}else{
			head.val=sum;
		}
		if (carry > 0) {
			crearteNode(carry);
		}
	}
	private static  int listSize(ListNode head) {
		int count =0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}
	private  void crearteNode(int data) {
		ListNode node = new ListNode(data);
		node.next = head;
		head=node;
	}
	
}
