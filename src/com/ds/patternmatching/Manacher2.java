package com.ds.patternmatching;

public class Manacher2 {
	public static void main(String[] args) {
		String s = "babcbabcbaccba";
       
        System.out.println(longestPalindrome(s));
	}
	// Transform S into T.
	// For example, S = "abba", T = "^#a#b#b#a#$".
	// ^ and $ signs are sentinels appended to each end to avoid bounds checking
	private static String preprocess(String s) {
	  int n = s.length();
	  if (n == 0) return "^$";
	  String ret = "^";
	  for (int i = 0; i < n; i++)
	    ret += "#" + s.substring(i, 1);
	 
	  ret += "#$";
	  return ret;
	}
	 
	private static String longestPalindrome(String s) {
	  String s1 = preprocess(s);
	  char[] t = s1.toCharArray();
	  int n = t.length;
	  int[] p = new int[n];
	  int C = 0, r = 0;
	  int center = 0;
      int right = 0;
      
      for (int i = 1; i < t.length-1; i++) {
          int mirror = 2*center - i;  // equals to i' = C - (i-C)

          if (right > i)
              p[i] = Math.min(right - i, p[mirror]);

          // attempt to expand palindrome centered at i
          while (t[i + (1 + p[i])] == t[i - (1 + p[i])])
              p[i]++;

          // if palindrome centered at i expands past right,
          // adjust center based on expanded palindrome.
          if (i + p[i] > right) {
              center = i;
              right = i + p[i];
          }
      }
	 
      int length = 0;   // length of longest palindromic substring
          center = 0;   // center of longest palindromic substring
      for (int i = 1; i < p.length-1; i++) {
          if (p[i] > length) {
              length = p[i];
              center = i;
          }
      }
      return s.substring((center - 1 - length) / 2, (center - 1 + length) / 2);
	}
}
