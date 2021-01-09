package com.algo.nlds.trie;

/**
 * 
 * Design a special dictionary which has some words and allows you to search the
 * words in it by a prefix and a suffix.
 * 
 * Implement the WordFilter class:
 * 
 * WordFilter(string[] words) Initializes the object with the words in the
 * dictionary. f(string prefix, string suffix) Returns the index of the word in
 * the dictionary which has the prefix prefix and the suffix suffix. If there is
 * more than one valid index, return the largest of them. If there is no such
 * word in the dictionary, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input ["WordFilter", "f"] [[["apple"]], ["a", "e"]] Output [null, 0]
 * 
 * Explanation WordFilter wordFilter = new WordFilter(["apple"]);
 * wordFilter.f("a", "e"); // return 0, because the word at index 0 has prefix =
 * "a" and suffix = 'e".
 *
 * 
 */
public class PrefixAndSuffixSearch {

	class TrieNode {
		TrieNode[] children;
		int weight;
		public TrieNode() {
			children = new TrieNode[27]; // 'a' - 'z' and '{'. 'z' and '{' are neighbours in ASCII table
			weight = 0;
		}
	}

	TrieNode root;
	public PrefixAndSuffixSearch(String[] words) {
		root = new TrieNode();
		for (int weight = 0; weight < words.length; weight++) {
			String word = words[weight] + "{";
			for (int i = 0; i < word.length(); i++) {
				TrieNode cur = root;
				cur.weight = weight;
				// add "apple{apple", "pple{apple", "ple{apple", "le{apple", "e{apple", "{apple" into the Trie Tree
				for (int j = i; j < 2 * word.length() - 1; j++) {
					int k = word.charAt(j % word.length()) - 'a';
					if (cur.children[k] == null)
						cur.children[k] = new TrieNode();
					cur = cur.children[k];
					cur.weight = weight;
				}
			}
		}
	}
	public int f(String prefix, String suffix) {
		TrieNode cur = root;
		for (char c: (suffix + '{' + prefix).toCharArray()) {
			if (cur.children[c - 'a'] == null) {
				return -1;
			}
			cur = cur.children[c - 'a'];
		}
		return cur.weight;
	}
}
