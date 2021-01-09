package com.algo.ads.design;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. put(key, value) - Set or insert the
 * value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new
 * item.
 * 
 * The cache is initialized with a positive capacity.
 * 
 * Follow up: Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
  LRUCache cache = new LRUCache( 2 capacity );
 * 
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1); // returns 1 
 * cache.put(3,3); //evicts key 2 
 * cache.get(2); // returns -1 (not found) 
 * cache.put(4,4); //evicts key 1 
 * cache.get(1); // returns -1 (not found) 
 * cache.get(3); // returns 3
 * cache.get(4); // returns 4
 * 
 *
 */
public class LRUCache {
	
	private ListNode tail,head;
	private Map<Integer, ListNode> keyVal;
	private Integer cap;

	public LRUCache(int capacity) {
		createDummyList();
		keyVal = new HashMap<Integer, ListNode>(capacity);
		cap = capacity;
	}
	
	private void createDummyList(){
		head = new ListNode(0,0);
		tail = new ListNode(0,0);
		head.next = tail;
		tail.prev = head;
	}
	public int get(int key) {
		ListNode node = keyVal.get(key);
		if(node == null){
			return -1;
		}
		moveToHead(node);
		return node.val;
	}

	public void put(int key, int value) {
		ListNode node = keyVal.get(key);
		if(node != null){
			moveToHead(node);
			node.val = value;

		}else{
			ListNode newNode = new ListNode(key, value);
			if(keyVal.size() == cap){
				ListNode tail = getTail();
				keyVal.remove(tail.key);
				removeTail();
			}
			keyVal.put(key, newNode);
			addToHead(newNode);
		}
	}
	private void moveToHead(ListNode node){
		node.prev.next = node.next;
		node.next.prev = node.prev;
		addToHead(node);
	}
	private void addToHead(ListNode node){
		ListNode tmp = head.next ;
		head.next = node;
		node.next = tmp;
		node.prev = head;
		tmp.prev = node;
	}

	private void removeTail(){
		ListNode newTail = tail.prev.prev;
		newTail.next = tail;
		tail.prev = newTail;
	}

	private ListNode getTail(){
		return tail.prev;
	}
	private class ListNode{
		private int key,val;	
		private ListNode prev,next;
		ListNode(int key, int value){
			this.key = key;
			this.val =value;
		}
	}
}