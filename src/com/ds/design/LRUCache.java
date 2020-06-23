package com.ds.design;

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
 * LRUCache cache = new LRUCache( 2 capacity );
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
	LinkedNodeList list;
	Map<Integer, Node> map;
	Integer cap;
	public LRUCache(int capacity) {
		list = new LinkedNodeList();
		map = new HashMap(capacity);
		cap = capacity;
	}

	public int get(int key) {
		Node node = map.get(key);
		if(node == null){
			return -1;
		}
		list.moveToHead(node);
		return node.val;
	}

	public void put(int key, int value) {
		Node node = map.get(key);
		if(node != null){
			list.moveToHead(node);
			node.val = value;

		}else{
			Node newNode = new Node(key, value);
			if(map.size() == cap){
				Node tail = list.getTail();
				map.remove(tail.key);
				list.removeTail();
			}
			map.put(key, newNode);
			list.addToHead(newNode);
		}
	}
}

class LinkedNodeList{
	Node dummyHead;
	Node dummyTail;

	LinkedNodeList(){
		dummyHead = new Node(0,0);
		dummyTail = new Node(0,0);
		dummyHead.next = dummyTail;
		dummyTail.prev = dummyHead;
	}

	void moveToHead(Node node){
		node.prev.next = node.next;
		node.next.prev = node.prev;
		addToHead(node);
	}

	void addToHead(Node node){
		Node tmp = dummyHead.next ;
		dummyHead.next = node;
		node.next = tmp;
		node.prev = dummyHead;
		tmp.prev = node;
	}

	void removeTail(){
		Node newTail = dummyTail.prev.prev;
		newTail.next = dummyTail;
		dummyTail.prev = newTail;
	}

	Node getTail(){
		return dummyTail.prev;
	}

}

class Node{
	int key;
	int val;
	Node next;
	Node prev;
	Node(int key, int value){
		this.key = key;
		this.val =value;
	}
}

