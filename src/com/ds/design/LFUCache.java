package com.ds.design;

import java.util.HashMap;
import java.util.LinkedHashSet;

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
	    HashMap<Integer, Integer> vals;
	    HashMap<Integer, Integer> counts;
	    HashMap<Integer, LinkedHashSet<Integer>> lists;
	    int cap;
	    int min = -1;
	    public LFUCache(int capacity) {
	        cap = capacity;
	        vals = new HashMap<>();
	        counts = new HashMap<>();
	        lists = new HashMap<>();
	        lists.put(1, new LinkedHashSet<>());
	    }
	    
	    public int get(int key) {
	        if(!vals.containsKey(key))
	            return -1;
	        int count = counts.get(key);
	        counts.put(key, count+1);
	        lists.get(count).remove(key);
	        if(count==min && lists.get(count).size()==0)
	            min++;
	        if(!lists.containsKey(count+1))
	            lists.put(count+1, new LinkedHashSet<>());
	        lists.get(count+1).add(key);
	        return vals.get(key);
	    }
	    
	    public void set(int key, int value) {
	        if(cap<=0)
	            return;
	        if(vals.containsKey(key)) {
	            vals.put(key, value);
	            get(key);
	            return;
	        } 
	        if(vals.size() >= cap) {
	            int evit = lists.get(min).iterator().next();
	            lists.get(min).remove(evit);
	            vals.remove(evit);
	        }
	        vals.put(key, value);
	        counts.put(key, 1);
	        min = 1;
	        lists.get(1).add(key);
	    }
	}
class LFUCache2 {
    class Node{
        int key,value,freq;
        Node prev,next;
        Node(int key,int value){
            this.key = key;
            this.value = value;
            this.freq = 0;
        }
    }
    class DLinkedList{
        int freq;
        Node head,tail;
        DLinkedList(int freq){
            this.freq =  freq;
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
        }
        void add(Node node){
            Node t = head.next;
            head.next = node;
            node.prev = head;
            node.next = t;
            t.prev = node;
        }
        boolean isEmpty(){
            return head.next==tail;
        }
        void delete(Node node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
        
        Node pop(){
            if (isEmpty()) return null;
            Node node = tail.prev;
            delete(node);
            return node;
        }
        
        
    }
    
    int capacity,size,minFreq;
    HashMap<Integer,Node> keyMap;
    HashMap<Integer,DLinkedList> freqMap;
    
    public LFUCache2(int capacity) {
        this.capacity = capacity;
        this.size = minFreq = 0;
        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
        freqMap.put(0,new DLinkedList(0));
    }
    
    private int _update(Node node){
        int freq = node.freq;
        freqMap.get(freq).delete(node);
        node.freq ++;
        freqMap.computeIfAbsent(node.freq,k->new DLinkedList(node.freq)).add(node);
        
        while (freqMap.get(minFreq).isEmpty()) minFreq++;
        return node.value;
    }
    
    
    public int get(int key) {
        if(!keyMap.containsKey(key)) return -1;
        Node node = keyMap.get(key);
        return  _update(node);
        
    }
    
    public void put(int key, int value) {
        if(capacity==0) return;
        if (keyMap.containsKey(key)){
            Node node = keyMap.get(key);
            node.value = value;
            _update(node);
            return ;
        }
        if(size>=capacity){
            Node old = freqMap.get(minFreq).pop();
            keyMap.remove(old.key);
            size --;
        }
        Node node = new Node(key,value);
        freqMap.get(0).add(node);
        keyMap.put(key,node);
        minFreq = 0;
        size ++;
    }
}
