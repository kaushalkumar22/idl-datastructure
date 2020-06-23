package com.algo.array.kth;


public class MostFrequentWordInAnArrayOfStringsUsingTrie {

	private static final int R = 26;        // extended ASCII
    private Node root;      // root of trie
    private int n;          // number of keys in trie
    
    // R-way trie node
    private static class Node {
        private String key;
        private int count;
        private Node[] next;
		public Node(String key) {
			this.key = key;
			this.count = 0;
			this.next =  new Node[R];
		}
        
    }

	public static void main(String[] args) {
		
		// given set of keys 
	    String arr[] = { "geeks", "for", "geeks", "a", 
	                     "portal", "to", "learn", "can", "be", 
	                     "computer", "science", "zoom", "yup", 
	                     "fire", "in", "be", "data", "geeks" }; 
	    int n = arr.length; 	  
	    mostFrequentWord(arr, n); 
	}

	private static void mostFrequentWord(String[] arr, int n) {
		
		
	}
	

}
