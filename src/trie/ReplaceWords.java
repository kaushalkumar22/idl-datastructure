package trie;

import java.util.List;

/**
 * 
 * In English, we have a concept called root, which can be followed by some
 * other word to form another longer word - let's call this word successor. For
 * example, when the root "an" is followed by the successor word "other", we can
 * form a new word "another".
 * 
 * Given a dictionary consisting of many roots and a sentence consisting of
 * words separated by spaces, replace all the successors in the sentence with
 * the root forming it. If a successor can be replaced by more than one root,
 * replace it with the root that has the shortest length.
 * 
 * Return the sentence after the replacement.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled
 * by the battery" Output: "the cat was rat by the bat"
 * 
 * Example 2:
 * 
 * Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
 * Output: "a a b c"
 * 
 * Example 3:
 * 
 * Input: dictionary = ["a", "aa", "aaa", "aaaa"], sentence = "a aa a aaaa aaa
 * aaa aaa aaaaaa bbb baba ababa" Output: "a a a a a a a a bbb baba a"
 * 
 * Example 4:
 * 
 * Input: dictionary = ["catt","cat","bat","rat"], sentence = "the cattle was
 * rattled by the battery" Output: "the cat was rat by the bat"
 * 
 * Example 5:
 * 
 * Input: dictionary = ["ac","ab"], sentence = "it is abnormal that this
 * solution is accepted" Output: "it is ab that this solution is ac"
 *
 * 
 */
public class ReplaceWords {

	public String replaceWords(List<String> dict, String sentence) {
		String[] tokens = sentence.split(" ");
		TrieNode trie = buildTrie(dict);
		return replaceWords(tokens, trie);
	}

	private String replaceWords(String[] tokens, TrieNode root) {
		StringBuilder stringBuilder = new StringBuilder();
		for (String token : tokens) {
			stringBuilder.append(getShortestReplacement(token, root));
			stringBuilder.append(" ");
		}
		return stringBuilder.substring(0, stringBuilder.length() - 1);
	}

	private String getShortestReplacement(String token, final TrieNode root) {
		TrieNode temp = root;
		StringBuilder stringBuilder = new StringBuilder();
		for (char c : token.toCharArray()) {
			stringBuilder.append(c);
			if (temp.children[c - 'a'] != null) {
				if (temp.children[c - 'a'].isWord) {
					return stringBuilder.toString();
				}
				temp = temp.children[c - 'a'];
			} else {
				return token;
			}
		}
		return token;
	}

	private TrieNode buildTrie(List<String> dict) {
		TrieNode root = new TrieNode(' ');
		for (String word : dict) {
			TrieNode temp = root;
			for (char c : word.toCharArray()) {
				if (temp.children[c - 'a'] == null) {
					temp.children[c - 'a'] = new TrieNode(c);
				}
				temp = temp.children[c - 'a'];
			}
			temp.isWord = true;
		}
		return root;
	}

	public class TrieNode {
		char val;
		TrieNode[] children;
		boolean isWord;

		public TrieNode(char val) {
			this.val = val;
			this.children = new TrieNode[26];
			this.isWord = false;
		}
	}
}