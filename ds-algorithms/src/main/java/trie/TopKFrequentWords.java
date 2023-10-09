package trie;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 * Given a non-empty list of words, return the k most frequent elements.
 * 
 * Your answer should be sorted by frequency from highest to lowest. If two
 * words have the same frequency, then the word with the lower alphabetical
 * order comes first.
 * 
 * Example 1:
 * 
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2 Output: ["i",
 * "love"] Explanation: "i" and "love" are the two most frequent words. Note
 * that "i" comes before "love" due to a lower alphabetical order.
 * 
 * Example 2:
 * 
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is",
 * "is"], k = 4 Output: ["the", "is", "sunny", "day"] Explanation: "the", "is",
 * "sunny" and "day" are the four most frequent words, with the number of
 * occurrence being 4, 3, 2 and 1 respectively.
 * 
 * Note:
 * 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements. Input
 * words contain only lowercase letters.
 * 
 * Follow up:
 * 
 * Try to solve it in O(n log k) time and O(n) extra space.
 *
 * 
 */
public class TopKFrequentWords {

	public List<String> topKFrequent(String[] words, int k) {
		// calculate frequency of each word
		Map<String, Integer> freqMap = new HashMap<>();
		for (String word : words) {
			freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
		}
		// build the buckets
		TrieNode[] count = new TrieNode[words.length + 1];
		for (String word : freqMap.keySet()) {
			int freq = freqMap.get(word);
			if (count[freq] == null) {
				count[freq] = new TrieNode();
			}
			addWord(count[freq], word);
		}
		// get k frequent words
		List<String> list = new LinkedList<>();
		for (int f = count.length - 1; f >= 1 && list.size() < k; f--) {
			if (count[f] == null)
				continue;
			getWords(count[f], list, k);
		}
		return list;
	}

	private void getWords(TrieNode node, List<String> list, int k) {
		if (node == null)
			return;
		if (node.word != null) {
			list.add(node.word);
		}
		if (list.size() == k)
			return;
		for (int i = 0; i < 26; i++) {
			if (node.next[i] != null) {
				getWords(node.next[i], list, k);
			}
		}
	}

	private boolean addWord(TrieNode root, String word) {
		TrieNode curr = root;
		for (char c : word.toCharArray()) {
			if (curr.next[c - 'a'] == null) {
				curr.next[c - 'a'] = new TrieNode();
			}
			curr = curr.next[c - 'a'];
		}
		curr.word = word;
		return true;
	}

	class TrieNode {
		TrieNode[] next;
		String word;

		TrieNode() {
			this.next = new TrieNode[26];
			this.word = null;
		}
	}
}
