package ds_design;

import java.util.*;

/**
 * Design a search autocomplete system for a search engine.
 *  Users may input a sentence (at least one word and end with a special character '#').
 *  For each character they type except '#', you need to return the top 3 historical hot sentences that have prefix the same as the part of sentence already typed.
 *
 *  Here are the specific rules:
 *
 *      The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
 *      The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one).
 *             If several sentences have the same degree of hot, you need to use ASCII-code order (smaller one appears first).
 *      If less than 3 hot sentences exist, then just return as many as you can.
 *      When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.
 *      Your job is to implement the following functions:
 *
 *  The constructor function:
 *
 *      AutocompleteSystem(String[] sentences, int[] times): This is the constructor.
 *         The input is historical data. Sentences is a string array consists of previously typed sentences.
 *         Times is the corresponding times a sentence has been typed. Your system should record these historical data.
 *
 *  Now, the user wants to input a new sentence. The following function will provide the next character the user types:
 *
 *     List<String> input(char c): The input c is the next character typed by the user.
 *         The character will only be lower-case letters ('a' to 'z'), blank space (' ') or a special character ('#').
 *         Also, the previously typed sentence should be recorded in your system.
 *         The output will be the top 3 historical hot sentences that have prefix the same as the part of sentence already typed.
 *
 *
 *  Example:
 *
 *  Operation: AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2])
 *  The system have already tracked down the following sentences and their corresponding times:
 *  "i love you" : 5 times
 *  "island" : 3 times
 *  "ironman" : 2 times
 *  "i love leetcode" : 2 times
 *
 *  Now, the user begins another search:
 *
 *  Operation: input('i')
 *  Output: ["i love you", "island","i love leetcode"]
 *  Explanation:
 *      There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree.
 *      Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman".
 *      Also we only need to output top 3 hot sentences, so "ironman" will be ignored.
 *
 *  Operation: input(' ')
 *  Output: ["i love you","i love leetcode"]
 *  Explanation:
 *  There are only two sentences that have prefix "i ".
 *
 *  Operation: input('a')
 *  Output: []
 *  Explanation:
 *  There are no sentences that have prefix "i a".
 *
 *  Operation: input('#')
 *  Output: []
 *  Explanation:
 *      The user finished the input, the sentence "i a" should be saved as a historical sentence in system.
 *      And the following input will be counted as a new search.
 *
 *
 *  Note:
 *
 *      The input sentence will always start with a letter and end with '#', and only one blank space will exist between two words.
 *      The number of complete sentences that to be searched won't exceed 100. The length of each sentence including those in the historical data won't exceed 100.
 *      Please use double-quote instead of single-quote when you write test cases even for a character input.
 *      Please remember to RESET your class variables declared in class AutocompleteSystem, as static/class variables are persisted across multiple test cases. Please see here for more details.
 */
public class DesignSearchAutocompleteSystem {
	public static void main(String[] args) {

	}
	/*
	Thinking direction

    For text search, there is no doubt that you need to use Prefix tree, trie.

Find all possible word/leaf, two options:

    After Trie is built, do prefix search, then DFS/BFS return all leaf items. [high runtime complexity]
    Store all possible words in TrieNode. [high space usage]
    in memory space should not be a big problem, so we can choose to store all possible words

Given k words, find top k frequent items. MinHeap must be used, but there are two options:

    Store MinHeap with TrieNode: Because it will continue to search for new entries, the same prefix (especially at higher level) will be searched multiple times.
    [complexity: need to update heaps across all visited TrieNodes once new sentence is completed]
    Compute MinHeap on the fly: Of course, we can’t come to a DFS every time, otherwise it will be very slow, so we must store a list of possible candidates in TrieNode.
    The Map<String, freq> in Top K Frequent Words is used here, so O(m) is actually very convenient to construct min-heap.

Train the system

    Every time an entry is marked after # to be added into search history. Then insert it into trie.
    This one can be done after meeting # at the end, very concise

The problem is very long, but not too difficult, it can be solved with Trie, but you need to pay attention:

    In input, you need to read and write, but note that it must be read and then written, otherwise the sentence just inserted in will be detected
    When encountering’#’, return to empty list
    To return the sentences stored in Trie, one approach is to add a member variable str to Trie to store the str formed on the path from root to curr. Another approach is to pass str as a parameter to child when querying. This topic uses the latter idea.
    In dfs trie, you must now add root to the result set, and then traverse the children! Otherwise, the root at the bottom of the stack will be missed. This is very important. Trie’s queries must be written like this.
    In getKHot, you can use PriorityQueue to do it, you can also use List to do and then sort
	 */
	TrieNode root, curr;
	StringBuffer sb;

	public DesignSearchAutocompleteSystem(String[] sentences, int[] times) {
		if (sentences == null || times == null || sentences.length != times.length) {
			return;
		}

		reset();

		root = new TrieNode();

		for (int i = 0; i < times.length; i++) {
			insert(sentences[i], times[i]);
		}
	}

	public List<String> input(char c) {
		List<String> result = new ArrayList<>();
		if (curr == null) curr = root;
		if (c == '#') { // save sentence and reset state
			insert(sb.toString(), 1);
			reset();
			return result;
		}

		// Update global variable (curr TrieNode and string buffer); or append new character if not exist.
		sb.append(c);
		curr.children.putIfAbsent(c, new TrieNode());
		curr = curr.children.get(c);

		// MinHeap to find top 3.
		result.addAll(findTopK(curr, 3));

		return result;
	}

	private List<String> findTopK(TrieNode node, int k) {
		List<String> result = new ArrayList<>();
		if (node.freq.isEmpty()) {
			return result;
		}

		PriorityQueue<Pair> queue = new PriorityQueue<>(
				(a, b) -> a.count == b.count ? b.s.compareTo(a.s) : a.count - b.count);

		for (Map.Entry<String, Integer> entry : node.freq.entrySet()) {
			if (queue.size() < 3 || entry.getValue() >= queue.peek().count) {
				queue.offer(new Pair(entry.getKey(), entry.getValue()));
			}
			if (queue.size() > 3) queue.poll();
		}

		while (!queue.isEmpty()) {
			result.add(0, queue.poll().s);
		}

		return result;
	}

	private void reset() {
		curr = null;
		sb = new StringBuffer();
	}

	private void insert(String sentence, int count) {
		if (sentence == null || sentence.length() == 0) {
			return;
		}

		TrieNode node = root;
		for (char c : sentence.toCharArray()) {
			node.children.putIfAbsent(c, new TrieNode());
			node = node.children.get(c);
			node.freq.put(sentence, node.freq.getOrDefault(sentence, 0) + count);
		}
		node.isEnd = true; // can set word to node as well, if needed
	}
}

class TrieNode {
	public boolean isEnd;
	public Map<String, Integer> freq;
	public Map<Character, TrieNode> children; // Map is more applicable to all chars, not limited to 256 ASCII
	public TrieNode() {
		this.freq = new HashMap<>();
		this.children = new HashMap<>();
	}
}

class Pair {
	String s;
	int count;
	public Pair(String s, int count) {
		this.s = s;
		this.count = count;
	}
}

