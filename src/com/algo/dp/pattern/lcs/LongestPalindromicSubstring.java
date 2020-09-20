package com.algo.dp.pattern.lcs;

/**
 * 
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * Input: "babad" Output: "bab" Note: "aba" is also a valid answer.
 * 
 * Input: "cbbd" Output: "bb"
 *
 * 
 */
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		String s ="aacdefcaa";
		System.out.println(longestPalindrome( s));
		System.out.println(longestPalindrome2( s));

	}
	public static String longestPalindrome2(String s) {
		int n = s.length();
		String res = null;
		int palindromeStartsAt = 0, maxLen = 0;

		boolean[][] dp = new boolean[n][n];//starting at index i and ending at j is palindrome

		for(int i = 0; i<n; i++) { // keep increasing the possible palindrome string
			for(int j = i; j>=0; j--) { // find the max palindrome within this window of (i,j)

				//check if substring between (i,j) is palindrome
				dp[i][j] = (s.charAt(i) == s.charAt(j)) // chars at i and j should match
						&& 
						( i-j < 3  // if window is less than or equal to 3, just end chars should match
								|| dp[i-1][j+1]  ); // if window is > 3, substring (i+1, j-1) should be palindrome too

				//update max palindrome string
				if(dp[i][j] && (i-j+1 > maxLen)) {
					palindromeStartsAt = j;
					maxLen = i-j+1;
				}
			}
		}
		return s.substring(palindromeStartsAt, palindromeStartsAt+maxLen);
	}
	private static int lo;
	private static int maxLen;
	public static String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2)
			return s;

		for (int i = 0; i < len-1; i++) {
			extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
			extendPalindrome(s, i, i+1); //assume even length.
		}
		return s.substring(lo, lo + maxLen);
	}

	private static void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (maxLen < k - j - 1) {
			lo = j + 1;
			maxLen = k - j - 1;
		}
	}
	int count = 0;
	public int countSubstrings(String s) {
		if (s == null || s.length() == 0) return 0;

		for (int i = 0; i < s.length(); i++) { // i is the mid point
			extendPalindrome1(s, i, i); // odd length;
			extendPalindrome1(s, i, i + 1); // even length
		}

		return count;
	}

	private void extendPalindrome1(String s, int left, int right) {
		while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			count++; left--; right++;
		}
	}
}
