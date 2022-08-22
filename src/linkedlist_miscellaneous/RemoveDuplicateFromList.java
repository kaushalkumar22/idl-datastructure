package linkedlist_miscellaneous;



import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
public class RemoveDuplicateFromList {


	public static void main(String[] args) {
		RemoveDuplicateFromList list = new RemoveDuplicateFromList();
		List<Integer> nums = Arrays.asList(3,2,2,1,3,2,4);
		ListNode node = ListUtil.createList(nums);
		System.out.print("Original List :: ");
		ListUtil.print(node);
		list.deleteDuplicatesUnsorted(node);
		System.out.print("New List   :: ");
		ListUtil.print(node);
	}
	public void removeDuplicates(ListNode head) {
		ListNode curr = head;
		ListNode temp = null;
		Hashtable<Integer,Boolean> table = new Hashtable<Integer,Boolean>();
		while (curr != null) {			
			if (table.containsKey(curr.val)) 
				temp.next = curr.next;
			else {
				table.put(curr.val, true);
				temp =curr;
			}			
			curr = curr.next;
		}
	}
	public ListNode deleteDuplicatesUnsorted(ListNode head) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		ListNode temp = head;
		while (temp != null) {
			int val = temp.val;
			map.put(val, map.getOrDefault(val, 0) + 1);
			temp = temp.next;
		}
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		temp = dummyHead;
		while (temp.next != null) {
			ListNode next = temp.next;
			int nextVal = next.val;
			if (map.get(nextVal) > 1)
				temp.next = next.next;
			else
				temp = temp.next;
		}
		return dummyHead.next;
	}
}
