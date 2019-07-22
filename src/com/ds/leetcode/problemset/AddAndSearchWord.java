package com.ds.leetcode.problemset;

/**
Design a data structure that supports the following two operations:
void addWord(word)
bool search(word)

search(word) can search a literal word or a regular expression string containing only letters a-z or .. A .
 means it can represent any one letter.
addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
 *
 */
public class AddAndSearchWord {
	public static void main(String[] args) {


		WordDictionary wd = new WordDictionary();
		wd.addWord("bad");
		wd.addWord("dad");
		wd.addWord("mad");
		System.out.println(wd.search("pad") );
		System.out.println(wd.search("bad"));
		System.out.println(wd.search(".ad") );
		System.out.println(wd.search("b.."));
	}
}
class WordDictionary {
	private class TrieNode {
		public TrieNode[] children = new TrieNode[26];
		public String item = "";
	}

	private TrieNode root = new TrieNode();

	public void addWord(String word) {
		TrieNode node = root;
		for (char c : word.toCharArray()) {
			if (node.children[c - 'a'] == null) {
				node.children[c - 'a'] = new TrieNode();
			}
			node = node.children[c - 'a'];
		}
		node.item = word;
	}

	public boolean search(String word) {
		return match(word.toCharArray(), 0, root);
	}

	private boolean match(char[] chs, int k, TrieNode node) {
		if (k == chs.length) return !node.item.equals("");   
		if (chs[k] != '.') {
			return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
		} else {
			for (int i = 0; i < node.children.length; i++) {
				if (node.children[i] != null) {
					if (match(chs, k + 1, node.children[i])) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
