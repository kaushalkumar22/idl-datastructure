package com.algo.string;

/**
 * An encoded string S is given. To find and write the decoded string to a tape,
 * the encoded string is read one character at a time and the following steps
 * are taken: If the character read is a letter, that letter is written onto the
 * tape. If the character read is a digit (say d), the entire current tape is
 * repeatedly written d-1 more times in total. Now for some encoded string S,
 * and an index K, find and return the K-th letter (1 indexed) in the decoded
 * string.
 * 
 * Example 1: Input: S = "leet2code3", K = 10 Output: "o" 
 * Explanation: The decoded string is "leetleetcodeleetleetcodeleetleetcode". The 10th letter in
 * the string is "o". 
 * Example 2: Input: S = "ha22", K = 5 Output: "h"
 * Explanation: The decoded string is "hahahaha". The 5th letter is "h".
 *  Example 3: Input: S = "a2345678999999999999999", K = 1 Output: "a" Explanation: The
 * decoded string is "a" repeated 8301530446056247680 times. The 1st letter is "a".
 *
 */
public class DecodedStringAtIndex {

	/*
	 * We decode the string and N keeps the length of decoded string, until N >= K.
	 * Then we go back from the decoding position. If it's S[i] = d is a digit, then
	 * N = N / d before repeat and K = K % N is what we want. If it's S[i] = c is a
	 * character, we return c if K == 0 or K == N
	 */	
	public String decodeAtIndex(String S, int K) {
	    long N = 0L;
	    int i;
	    char[] chs = S.toCharArray();
	    for (i = 0; N < K; i++) N = chs[i] >= '0' && chs[i] <= '9' ? N*(chs[i] - '0') : N + 1;
	    i--;
	    while (true){
	        if (chs[i] >= '0' && chs[i] <= '9') {
	            N /= chs[i] - '0';
	            K %= N;
	        } else if (K%N == 0) return "" + chs[i];
	        else N--;
	        i--;
	    }
	}
}
