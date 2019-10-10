package com.ds.common.hard;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println(longestPalindromeManacher("asdfgababcbabaelkjhgf"));
	}
	// Transform S into T.
		// For example, S = "abba", T = "^#a#b#b#a#$".
		// ^ and $ signs are sentinels appended to each end to avoid bounds checking
		private static String preprocess(String s) {
		  int n = s.length();
		  if (n == 0) return "^$";
		  String ret = "^";
		  for (int i = 0; i < n; i++)
		    ret += "#" + s.substring(i,i+1);
		 
		  ret += "#$";
		  return ret;
		}
		 
		private static String longestPalindromeManacher(String s) {
		  String s1 = preprocess(s);
		  char[] t = s1.toCharArray();
		  int n = t.length;
		  int[] p = new int[n];
		  int C = 0, R = 0;
		 // int center = 0;
	      //int right = 0;
	      
	      for (int i = 1; i < t.length-1; i++) {
	          int mirror = 2*C - i;  // equals to i' = C - (i-C)

	          if (R > i)
	              p[i] = Math.min(R - i, p[mirror]);//becase min will fall between C-R

	          // attempt to expand palindrome centered at i
	          while (t[i + (1 + p[i])] == t[i - (1 + p[i])])
	              p[i]++;

	          // if palindrome centered at i expands past right,
	          // adjust center based on expanded palindrome.
	          if (i + p[i] > R) {
	              C = i;
	              R = i + p[i];
	          }
	      }
		 
	      int length = 0;   // length of longest palindromic substring
	          C = 0;   // center of longest palindromic substring
	      for (int i = 1; i < p.length-1; i++) {
	          if (p[i] > length) {
	              length = p[i];
	              C = i;
	          }
	      }
	      return s.substring((C - 1 - length) / 2, (C - 1 + length) / 2);
		}
	/**
	 * In fact, we could solve it in O(n2) time using only constant space.
	 * We observe that a palindrome mirrors around its center. Therefore, a palindrome can be 
	 * expanded from its center, and there are only 2n−12n - 12n−1 such centers.
	 * You might be asking why there are 2n−12n - 12n−1 but not nnn centers? The reason is the center of 
	 * a palindrome can be in between two letters. Such palindromes have even number of 
	 * letters (such as "abba") and its center are between the two 'b's.
	 * 
	 *Time complexity : O(n2). Since expanding a palindrome around its center 
	 *could take O(n) time, the overall complexity is O(n2).
	 *Space complexity : O(1)
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		if (s == null || s.length() < 1) return "";
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private int expandAroundCenter(String s, int left, int right) {
		int L = left, R = right;
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}
}
