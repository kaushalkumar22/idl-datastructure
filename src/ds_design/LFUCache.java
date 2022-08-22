package ds_design;

import java.util.HashMap;

/**
 * Design and implement a data structure for Least Frequently Used (LFU) cache.
 * It should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. put(key, value) - Set or insert the
 * value if the key is not already present. When the cache reaches its capacity,
 * it should invalidate the least frequently used item before inserting a new
 * item. For the purpose of this problem, when there is a tie (i.e., two or more
 * keys that have the same frequency), the least recently used key would be
 * evicted.
 * 
 * Note that the number of times an item is used is the number of calls to the
 * get and put functions for that item since it was inserted. This number is set
 * to zero when the item is removed.
 * 
 * 
 * 
 * Follow up: Could you do both operations in O(1) time complexity?
 * 
 * LFUCache cache = new LFUCache( 2 //capacity );
 * 
 * cache.put(1, 1); 
 * cache.put(2, 2); 
 * cache.get(1); // returns 1 
 * cache.put(3, 3);// evicts key 2 
 * cache.get(2); // returns -1 (not found) 
 * cache.get(3); // returns 3. 
 * cache.put(4, 4); // evicts key 1. 
 * cache.get(1); // returns -1 (not found) 
 * cache.get(3); // returns 3 
 * cache.get(4); // returns 4
 *
 */
public class LFUCache {

	int capacity,size,minFreq;
	HashMap<Integer,ListNode> keyMap;
	HashMap<Integer,DLinkedList> freqMap;

	public LFUCache(int capacity) {
		this.capacity = capacity;
		this.size = minFreq = 0;
		keyMap = new HashMap<>();
		freqMap = new HashMap<>();
		freqMap.put(0,new DLinkedList(0));
	}

	private int update(ListNode ListNode){
		int freq = ListNode.freq;
		freqMap.get(freq).delete(ListNode);
		ListNode.freq ++;
		freqMap.computeIfAbsent(ListNode.freq,k->new DLinkedList(ListNode.freq)).add(ListNode);

		while (freqMap.get(minFreq).isEmpty()) minFreq++;
		return ListNode.value;
	}


	public int get(int key) {
		if(!keyMap.containsKey(key)) return -1;
		ListNode ListNode = keyMap.get(key);
		return  update(ListNode);

	}

	public void put(int key, int value) {
		if(capacity==0) return;
		if (keyMap.containsKey(key)){
			ListNode ListNode = keyMap.get(key);
			ListNode.value = value;
			update(ListNode);
			return ;
		}
		if(size>=capacity){
			ListNode old = freqMap.get(minFreq).pop();
			keyMap.remove(old.key);
			size --;
		}
		ListNode ListNode = new ListNode(key,value);
		freqMap.get(0).add(ListNode);
		keyMap.put(key,ListNode);
		minFreq = 0;
		size ++;
	}
	private class ListNode{
		private int key,value,freq;
		private ListNode prev,next;
		ListNode(int key,int value){
			this.key = key;
			this.value = value;
			this.freq = 0;
		}
	}
	private class DLinkedList{
		//private int freq;
		private ListNode head,tail;
		DLinkedList(int freq){
			//this.freq =  freq;
			head = new ListNode(0,0);
			tail = new ListNode(0,0);
			head.next = tail;
			tail.prev = head;
		}
		void add(ListNode ListNode){
			ListNode t = head.next;
			head.next = ListNode;
			ListNode.prev = head;
			ListNode.next = t;
			t.prev = ListNode;
		}
		boolean isEmpty(){
			return head.next==tail;
		}
		void delete(ListNode ListNode){
			ListNode.next.prev = ListNode.prev;
			ListNode.prev.next = ListNode.next;
		}

		ListNode pop(){
			if (isEmpty()) return null;
			ListNode ListNode = tail.prev;
			delete(ListNode);
			return ListNode;
		}
	}
}
