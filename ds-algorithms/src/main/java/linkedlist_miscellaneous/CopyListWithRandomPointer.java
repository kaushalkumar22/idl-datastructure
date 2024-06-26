package linkedlist_miscellaneous;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * 
 * The Linked List is represented in the input/output as a list of n nodes. Each
 * node is represented as a pair of [val, random_index] where:
 * 
 * val: an integer representing Node.val random_index: the index of the node
 * (range from 0 to n-1) where random pointer points to, or null if it does not
 * point to any node.
 * 
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]] 
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 
 * Input: head = [[1,1],[2,1]] 
 * Output: [[1,1],[2,1]]
 * 
 * 
 * Input: head = [[3,null],[3,0],[3,null]] 
 * Output: [[3,null],[3,0],[3,null]]
 * 
 * Input: head = [] Output: [] 
 * Explanation: Given linked list is empty (null pointer), so return null.
 * 
 * Constraints:
 * 
 * -10000 <= Node.val <= 10000 Node.random is null or pointing to a node in the
 * linked list. Number of Nodes will not exceed 1000.
 * 
 * @author IBM
 *
 */
public class CopyListWithRandomPointer {

	public Node copyRandomList(Node head) {

		Map<Node,Node> map = new HashMap<Node,Node>();
		Node curr =head;
		while(curr!=null) {
			map.put(curr, new Node(curr.val));
			curr=curr.next;
		}
		for (Entry<Node, Node> entry : map.entrySet()) {
			Node key  = entry.getKey();
			Node value = entry.getValue();
			value.next= map.get(key.next);
			value.random= map.get(key.random);
		}
		return map.get(head);
	}
	public Node copyRandomList2(Node head) {       
		Map<Node,Node> map = new HashMap<>();
		Node curr=head;
		while(curr!=null){
			map.put(curr,new Node(curr.val));
			curr=curr.next;
		}
		curr=head;
		while(curr!=null){
			Node val =map.get(curr);
			val.next=map.get(curr.next); 
			val.random = map.get(curr.random);
			curr=curr.next;
		}
		return map.get(head);
	}
	private class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}
}

