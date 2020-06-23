package com.algo.twopointers;

/**
 * Sometimes people repeat letters to represent extra feeling, such as "hello"
 * -> "heeellooo", "hi" -> "hiiii". In these strings like "heeellooo", we have
 * groups of adjacent letters that are all the same: "h", "eee", "ll", "ooo".
 * 
 * For some given string S, a query word is stretchy if it can be made to be
 * equal to S by any number of applications of the following extension
 * operation: choose a group consisting of characters c, and add some number of
 * characters c to the group so that the size of the group is 3 or more.
 * 
 * For example, starting with "hello", we could do an extension on the group "o"
 * to get "hellooo", but we cannot get "helloo" since the group "oo" has size
 * less than 3. Also, we could do another extension like "ll" -> "lllll" to get
 * "helllllooo". If S = "helllllooo", then the query word "hello" would be
 * stretchy because of these two extension operations: query = "hello" ->
 * "hellooo" -> "helllllooo" = S.
 * 
 * Given a list of query words, return the number of words that are stretchy.
 * 
 * 
 * 
 * Example: Input: S = "heeellooo" words = ["hello", "hi", "helo"] Output: 1
 * Explanation: We can extend "e" and "o" in the word "hello" to get
 * "heeellooo". We can't extend "helo" to get "heeellooo" because the group "ll"
 * is not size 3 or more.
 * 
 *
 */
public class ExpressiveWords {
	/*
	 * We have two pointers, use i to scan S, and use j to scan each word in
	 * words. Firstly, for S and word, we can calculate the length of the
	 * susbtrings which contains the repeated letters of the letter currently
	 * pointed by the two pointers, and get len1 and len2.
	 * 
	 * The two letters currently pointed by the two pointers must be equal,
	 * otherwise the word is not stretchy, we return false. Then, if we find
	 * that len1 is smaller than 3, it means the letter cannot be extended, so
	 * len1 must equals to len2, otherwise this word is not stretchy. In the
	 * other case, if len1 equals to or larger than 3, we must have len1 equals
	 * to or larger than len2, otherwise there are not enough letters in S to
	 * match the letters in word.
	 * 
	 * Finally, if the word is stretchy, we need to guarantee that both of the
	 * two pointers has scanned the whole string.
	 */
	public int expressiveWords(String S, String[] words) {
		if (S == null || words == null) {
			return 0;
		}
		int count = 0;
		for (String word : words) {
			if (stretchy(S, word)) {
				count++;
			}
		}
		return count;
	}

	public boolean stretchy(String S, String word) {
		if (word == null) {
			return false;
		}
		int i = 0;
		int j = 0;
		while (i < S.length() && j < word.length()) {
			if (S.charAt(i) == word.charAt(j)) {
				int len1 = getRepeatedLength(S, i);
				int len2 = getRepeatedLength(word, j);
				if (len1 < 3 && len1 != len2 || len1 >= 3 && len1 < len2) {
					return false;
				}
				i += len1;
				j += len2;
			} else {
				return false;
			}
		}
		return i == S.length() && j == word.length();
	}

	public int getRepeatedLength(String str, int i) {
		int j = i;
		while (j < str.length() && str.charAt(j) == str.charAt(i)) {
			j++;
		}
		return j - i;
	}
}