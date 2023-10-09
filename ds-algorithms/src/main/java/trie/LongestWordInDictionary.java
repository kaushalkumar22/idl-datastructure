package trie;

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

	public static void main(String[] args) {
		String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
		LongestWordInDictionary dictionary = new LongestWordInDictionary();
		System.out.println(dictionary.longestWord(words));

	}
	public String longestWord(String[] words) {
		TrieNode root = new TrieNode();
		root.item = "-";
		insert(root,words);
		return search( root,"");

	}
	private String search(TrieNode node,String accum) {
		if (node == null || node.item.length() == 0)
			return accum;
		String res = "";
		if (!node.item.equals ("-"))
			accum = node.item;
		for (TrieNode child : node.children) {
			String curRes = search (child, accum);
			if (curRes.length () > res.length () 
					|| (curRes.length () == res.length () 
					&& curRes.compareTo (res) < 0))
				res = curRes;
		}
		return res;

	}
	private void insert(TrieNode root,String[] words) {
		for (String word : words) {
			insert(root, word);
		}
	}
	private void insert(TrieNode root,String word) {
		TrieNode node = root;
		for (char c : word.toCharArray()) {
			if(node.children[c-'a']==null) {
				node.children[c-'a']=new TrieNode();
			}
			node =node.children[c-'a'];
		}    	
		node.item=word;
	}
	private class TrieNode{
		TrieNode[] children = new TrieNode[26];
		String item="";
	}

}
