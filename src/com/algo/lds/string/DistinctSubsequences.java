package com.algo.lds.string;

public class DistinctSubsequences {
	
	public static void main(String[] args) {
		System.out.println(numDistinct("rabbbit", "rabbit"));
	}
	/**
	 * Given a string S and a string T, count the number of distinct subsequences of
	 * S which equals T. A subsequence of a string is a new string which is formed
	 * from the original string by deleting some (can be none) of the characters
	 * without disturbing the relative positions of the remaining characters. (ie,
	 * "ACE" is a subsequence of "ABCDE" while "AEC" is not). It's guaranteed the
	 * answer fits on a 32-bit signed integer. Example 1: Input: S = "rabbbit", T =
	 * "rabbit" Output: 3 Explanation: As shown below, there are 3 ways you can
	 * generate "rabbit" from S. (The caret symbol ^ means the chosen letters)
	 * 
	 * rabbbit 
	 * ^^^^ ^^ 
	 * rabbbit 
	 * ^^ ^^^^ 
	 * rabbbit 
	 * ^^^ ^^^ 
	 * Example 2: Input: S =
	 * "babgbag", T = "bag" Output: 5 Explanation: As shown below, there are 5 ways
	 * you can generate "bag" from S. (The caret symbol ^ means the chosen letters)
	 * 
	 * babgbag 
	 * ^^ ^ 
	 * babgbag 
	 * ^^ ^ 
	 * babgbag 
	 * ^ ^^ 
	 * babgbag 
	 * ^ ^^
	 * babgbag 
	 * ^^^
	 */
	/*
	 * Well, a dynamic programming problem. Let's first define its state dp[i][j] to
	 * be the number of distinct subsequences of t[0..i - 1] in s[0..j - 1]. Then we
	 * have the following state equations:
	 * 
	 * General case 1: dp[i][j] = dp[i][j - 1] if t[i - 1] != s[j - 1]; General case
	 * 2: dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1] if t[i - 1] == s[j - 1];
	 * Boundary case 1: dp[0][j] = 1 for all j; Boundary case 2: dp[i][0] = 0 for
	 * all positive i.
	 * 
	 * Now let's give brief explanations to the four equations above.
	 * 
	 * If t[i - 1] != s[j - 1], the distinct subsequences will not include s[j - 1]
	 * and thus all the number of distinct subsequences will simply be those in
	 * s[0..j - 2], which corresponds to dp[i][j - 1]; If t[i - 1] == s[j - 1], the
	 * number of distinct subsequences include two parts: those with s[j - 1] and
	 * those without; An empty string will have exactly one subsequence in any
	 * string :-) Non-empty string will have no subsequences in an empty string.
	 * 
	 * Putting these together, we will have the following simple codes (just like
	 * translation :-)):
	 */
	static int numDistinct(String s, String t) {
	        int m = t.length(), n = s.length();
	        int[][] dp =new int[m+1][n+1];
	        for (int j = 0; j <= n; j++) dp[0][j] = 1;
	        for (int j = 1; j <= n; j++)
	            for (int i = 1; i <= m; i++)
	                dp[i][j] = dp[i][j - 1] + (t.charAt(i - 1) == s.charAt(j - 1) ? dp[i - 1][j - 1] : 0);
	        return dp[m][n];
	    }


	/**
	 * Given a string S, count the number of distinct, non-empty subsequences of S .
	 * Since the result may be large, return the answer modulo 10^9 + 7.
	 * 
	 * Example 1: Input: "abc" Output: 7 
	 * Explanation: The 7 distinct subsequences
	 * are "a", "b", "c", "ab", "ac", "bc", and "abc". 
	 * Example 2: Input: "aba"
	 * Output: 6 
	 * Explanation: The 6 distinct subsequences are "a", "b", "ab", "ba","aa" and "aba". 
	 * Example 3: Input: "aaa" Output: 3 
	 * Explanation: The 3 distinct 	subsequences are "a", "aa" and "aaa".
	 * 
	 * @param S
	 * @return
	 */
	public int distinctSubseqII(String S) {
		int end[] = new int[26], res = 0, added = 0, mod = (int)1e9 + 7;
		for (char c : S.toCharArray()) {
			added = (res + 1 - end[c - 'a']) % mod;
			res = (res + added) % mod;
			end[c - 'a'] = (end[c - 'a'] + added) % mod;
		}
		return (res + mod) % mod;	

	}
	
	 public int distinctSubseqII2(String S) {
	        int n = S.length(), M = (int)1e9 + 7;
	        int[] count = new int[26];
	        int sum = 0;
	        for (int i = 0; i < n; i++) {
	            int index = S.charAt(i) - 'a';
	            int cur = (1 + sum - count[index] + M) % M;
	            sum = (sum + cur) % M;
	            count[index] = (count[index] + cur) % M;
	        }
	        return sum;
	    }
	}

