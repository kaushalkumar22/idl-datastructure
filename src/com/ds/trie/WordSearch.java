package com.ds.trie;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in
 * the board. Each word must be constructed from letters of sequentially
 * adjacent cell, where "adjacent" cells are those horizontally or vertically
 * neighboring. The same letter cell may not be used more than once in a word.
 * 
 * board = [ ['o','a','a','n'], ['e','t','a','e'], ['i','h','k','r'],
 * ['i','f','l','v'] ] words = ["oath","pea","eat","rain"] Output:
 * ["eat","oath"]
 *
 */
public class WordSearch {

	public static void main(String[] args) {
		char[][] board = {
				{'o','a','a','n'},
				{'e','t','a','e'},
				{'i','h','k','r'},
				{'i','f','l','v'}
		};
		String[] words = {"oath","pea","eat","rain"};
		System.out.println(new WordSearch().findWords(board,words));

	}

	/*
	 * Intuitively, start from every cell and try to build a word in the dictionary.
	 * Backtracking (dfs) is the powerful way to exhaust every possible ways.
	 * Apparently, we need to do pruning when current character is not in any word.
	 * 
	 * How do we instantly know the current character is invalid? HashMap? How do we
	 * instantly know what's the next valid character? LinkedList? But the next
	 * character can be chosen from a list of characters. "Mutil-LinkedList"?
	 * 
	 * Combing them, Trie is the natural choice. Notice that:
	 * 
	 * TrieNode is all we need. search and startsWith are useless. No need to store
	 * character at TrieNode. c.next[i] != null is enough. Never use c1 + c2 + c3.
	 * Use StringBuilder. No need to use O(n^2) extra space visited[m][n]. No need
	 * to use StringBuilder. Storing word itself at leaf node is enough. No need to
	 * use HashSet to de-duplicate. Use "one time search" trie
	 */
	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();
		TrieNode root = buildTrie(words);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs (board, i, j, root, res);
			}
		}
		return res;
	}

	public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
		char c = board[i][j];
		if (c == '#' || p.next[c - 'a'] == null) return;
		p = p.next[c - 'a'];
		if (p.word != null) {   // found one
			res.add(p.word);
			p.word = null;     // de-duplicate
		}

		board[i][j] = '#';
		if (i > 0) dfs(board, i - 1, j ,p, res); 
		if (j > 0) dfs(board, i, j - 1, p, res);
		if (i < board.length - 1) dfs(board, i + 1, j, p, res); 
		if (j < board[0].length - 1) dfs(board, i, j + 1, p, res); 
		board[i][j] = c;
	}

	public TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		for (String w : words) {
			TrieNode p = root;
			for (char c : w.toCharArray()) {
				int i = c - 'a';
				if (p.next[i] == null) p.next[i] = new TrieNode();
				p = p.next[i];
			}
			p.word = w;
		}
		return root;
	}

	class TrieNode {
		TrieNode[] next = new TrieNode[26];
		String word;
	}
	
	/**
	 * Given a 2D board and a word, find if the word exists in the grid. The word
	 * can be constructed from letters of sequentially adjacent cell, where
	 * "adjacent" cells are those horizontally or vertically neighboring. The same
	 * letter cell may not be used more than once. Example: board = [
	 * ['A','B','C','E'], ['S','F','C','S'], ['A','D','E','E'] ]
	 * 
	 * Given word = "ABCCED", return true. Given word = "SEE", return true. Given
	 * word = "ABCB", return false.
	 */
	public boolean exist(char[][] board, String word) {
	    char[] w = word.toCharArray();
	    for (int y=0; y<board.length; y++) {
	    	for (int x=0; x<board[y].length; x++) {
	    		if (exist(board, y, x, w, 0)) return true;
	    	}
	    }
	    return false;
	}

	private boolean exist(char[][] board, int y, int x, char[] word, int i) {
		if (i == word.length) return true;
		if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
		if (board[y][x] != word[i]) return false;
		board[y][x] ^= 256;
		boolean exist = exist(board, y, x+1, word, i+1)
			|| exist(board, y, x-1, word, i+1)
			|| exist(board, y+1, x, word, i+1)
			|| exist(board, y-1, x, word, i+1);
		board[y][x] ^= 256;
		return exist;
	}
}
