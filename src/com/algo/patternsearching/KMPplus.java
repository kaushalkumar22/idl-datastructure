package com.algo.patternsearching;

/******************************************************************************
 *  Compilation:  javac KMPplus.java
 *  Execution:    java KMPplus pattern text
 *  Dependencies: StdOut.java
 * 
 *  Knuth-Morris-Pratt algorithm over UNICODE alphabet.
 *
 *  % java KMPplus ABABAC BCBAABACAABABACAA
 *  text:    BCBAABACAABABACAA
 *  pattern:          ABABAC
 *
 *  % java KMPplus aabaaaba ccaabaabaabaaabaab
 *  text:    ccaabaabaabaaabaab
 *  pattern:         aabaaaba
 *
 *  % java KMPplus aabaaabb ccaabaabaabaaabaab
 *  text:    ccaabaabaabaaabaab
 *  pattern:                   aabaaabb
 *
 ******************************************************************************/

public class KMPplus {

	private  int[] preprocessing(String pattern){
		int M = pattern.length();
		int[] next = new int[M];
		int j = -1;
		for (int i = 0; i < M; i++) {
			if (i == 0)
				next[i] = -1;
			else if (pattern.charAt(i) != pattern.charAt(j)) 
				next[i] = j;
			else                                             
				next[i] = next[j];
			while (j >= 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = next[j];
			}
			j++;
		}

		for (int i = 0; i < M; i++)
			System.out.println("next[" + i + "] = " + next[i]);
		return next;
	}
	// return offset of first occurrence of text in pattern (or N if no match)
	// simulate the NFA to find match
	public int search(String text,String pattern) {
		int[] next = preprocessing( pattern);
		int M = pattern.length();
		int N = text.length();
		int i, j;
		for (i = 0, j = 0; i < N && j < M; i++) {
			while (j >= 0 && text.charAt(i) != pattern.charAt(j))
				j = next[j];
			j++;
		}
		if (j == M) return i - M;
		return N;
	}


	// test client
	public static void main(String[] args) {

		String text    = "ccaabaabaabaaabaab";
		String pattern = "aabaaaba";
		int M = pattern.length();
		int N = text.length();

		// substring search
		KMPplus kmp = new KMPplus();
		int offset = kmp.search(text,pattern);

		// print results
		System.out.println("M = " + M + ", N = " + N);
		System.out.println("text:    " + text);
		System.out.print("pattern: ");
		for (int i = 0; i < offset; i++)
			System.out.print(" ");
		System.out.println(pattern);
	}

}



