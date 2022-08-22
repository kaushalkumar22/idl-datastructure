package com.algo.trie;

/**
 * 
 * Implement the StreamChecker class as follows:
 * 
 * StreamChecker(words): Constructor, init the data structure with the given
 * words. query(letter): returns true if and only if for some k >= 1, the last k
 * characters queried (in order from oldest to newest, including this letter
 * just queried) spell one of the words in the given list.
 *
StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
streamChecker.query('a');          // return false
streamChecker.query('b');          // return false
streamChecker.query('c');          // return false
streamChecker.query('d');          // return true, because 'cd' is in the wordlist
streamChecker.query('e');          // return false
streamChecker.query('f');          // return true, because 'f' is in the wordlist
streamChecker.query('g');          // return false
streamChecker.query('h');          // return false
streamChecker.query('i');          // return false
streamChecker.query('j');          // return false
streamChecker.query('k');          // return false
streamChecker.query('l');          // return true, because 'kl' is in the wordlist 
 */
public class StreamOfCharacters {


	class TrieNode {
		boolean isWord;
		TrieNode[] next = new TrieNode[26];
	}
	TrieNode root;
	StringBuilder sb;

	public StreamOfCharacters(String[] words) {
		root = new TrieNode();
		sb = new StringBuilder();
		insert(words);
	}
	public boolean query(char letter) {
		sb.append(letter);
		return search(sb);
	}
	private void insert(String[] words) {
		for (String s : words) {
			TrieNode node = root;
			int len = s.length();
			for (int i = len - 1; i >= 0; i--) {
				char c = s.charAt(i);
				if (node.next[c - 'a'] == null) {
					node.next[c - 'a'] = new TrieNode();
				}
				node = node.next[c - 'a'];
			}
			node.isWord = true;
		}
	}                     

	private boolean search(StringBuilder sb) {  
		TrieNode cur = root;
		for (int i = sb.length() - 1; i >= 0; i--) {
			char c = sb.charAt(i);
			cur = cur.next[c - 'a'];
			if (cur == null) return false;
			if (cur.isWord) return true;
		}
		return cur.isWord;
	}
}
