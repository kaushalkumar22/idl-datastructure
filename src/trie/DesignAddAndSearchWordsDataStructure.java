package trie;

/**
 * Design a data structure that supports adding new words and finding if a
 * string matches any previously added string.
 * 
 * Implement the WordDictionary class:
 * 
 * WordDictionary() Initializes the object.
 * 
 * void addWord(word) Adds word to the data structure, it can be matched later.
 * 
 * bool search(word) Returns true if there is any string in the data structure
 * that matches word or false otherwise. word may contain dots '.' where dots
 * can be matched with any letter.
 * 
 * 
 Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
 *
 */
public class DesignAddAndSearchWordsDataStructure {
	public static void main(String[] args) {

		DesignAddAndSearchWordsDataStructure wd = new DesignAddAndSearchWordsDataStructure();
		wd.addWord("bad");
		wd.addWord("dad");
		wd.addWord("mad");
		System.out.println(wd.search("pad"));
		System.out.println(wd.search("bad"));
		System.out.println(wd.search(".ad"));
		System.out.println(wd.search("b.."));
	}

	private TrieNode root;
	public DesignAddAndSearchWordsDataStructure() {
		this.root = new TrieNode();
	}

	public void addWord(String word) {
		TrieNode node = root;
		for (char c : word.toCharArray()) {
			if (node.next[c - 'a'] == null) {
				node.next[c - 'a'] = new TrieNode();
			}
			node = node.next[c - 'a'];
		}
		node.item = word;
	}

	public boolean search(String word) {
		return match(word.toCharArray(), 0, root);
	}

	private boolean match(char[] chars, int index, TrieNode node) {
		if (index == chars.length)
			return !(node.item==null);

		if(chars[index] == '.') {
			for (int i = 0; i < node.next.length; i++) {
				if (node.next[i] != null && match(chars, index + 1, node.next[i])) {
                    return true;
                }
			}
		}else {
			return node.next[chars[index] - 'a'] != null 
					&& match(chars, index + 1, node.next[chars[index] - 'a']);
		}
		return false;
	}

	private class TrieNode {
		public TrieNode[] next = new TrieNode[26];
		public String item;
	}

}
