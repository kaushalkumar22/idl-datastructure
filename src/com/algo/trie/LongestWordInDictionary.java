package com.algo.trie;

/**
 * Given a list of strings words representing an English Dictionary, find the
 * longest word in words that can be built one character at a time by other
 * words in words. If there is more than one possible answer, return the longest
 * word with the smallest lexicographical order. If there is no answer, return
 * the empty string.
 * 
 * Example 1:
 * 
 * Input: words = ["w","wo","wor","worl", "world"] Output: "world" Explanation:
 * The word "world" can be built one character at a time by "w", "wo", "wor",
 * and "worl".
 * 
 * Example 2:
 * 
 * Input: words = ["a", "banana", "app", "appl", "ap", "apply", "apple"] Output:
 * "apple" Explanation: Both "apply" and "apple" can be built from other words
 * in the dictionary. However, "apple" is lexicographically smaller than
 * "apply".
 * 
 * Note: All the strings in the input will only contain lowercase letters. The
 * length of words will be in the range [1, 1000]. The length of words[i] will
 * be in the range [1, 30].
 *
 */
public class LongestWordInDictionary {

	 public String longestWord(String[] words) {
	        TrieNode root = new TrieNode ();
	        root.word = "-";
	        for (String word : words)
	            root.insert (word);
	        return dfs (root, "");
	    }

	    String dfs (TrieNode node, String accum) {
	        if (node == null || node.word.length () == 0)
	            return accum;
	        String res = "";
	        if (!node.word.equals ("-"))
	            accum = node.word;
	        for (TrieNode child : node.links) {
	            String curRes = dfs (child, accum);
	            if (curRes.length () > res.length () || (curRes.length () == res.length () && curRes.compareTo (res) < 0))
	                res = curRes;
	        }
	        return res;
	    }

	    /* Hand write this class every time you need to so you can remember well */
	    static class TrieNode {
	        String word = "";
	        TrieNode[] links = new TrieNode[26];

	        void insert (String s) {
	            char[] chs = s.toCharArray ();
	            TrieNode curNode = this;
	            for (int i = 0; i < chs.length; i++) {
	                int index = chs[i] - 'a';
	                if (curNode.links[index] == null)
	                    curNode.links[index] = new TrieNode ();
	                curNode = curNode.links[index];
	            }
	            curNode.word = s;
	        }
	    }
	}
