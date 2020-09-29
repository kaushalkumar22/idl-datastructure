package com.algo.dp.common;

/**
 * Given an input string (s) and a pattern (p), implement regular expression
 * matching with support for '.' and '*'.
 * 
 * '.' Matches any single character. '*' Matches zero or more of the preceding
 * element.
 * 
 * The matching should cover the entire input string (not partial). Note: s
 * could be empty and contains only lowercase letters a-z. p could be empty and
 * contains only lowercase letters a-z, and characters like . or *.
 * 
 * Input: s = "aa" p = "a" Output: false Explanation: "a" does not match the
 * entire string "aa".
 * 
 * Input: s = "aa" p = "a*" Output: true Explanation: '*' means zero or more of
 * the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes
 * "aa".
 * 
 * Input: s = "ab" p = ".*" Output: true Explanation: ".*" means "zero or more
 * (*) of any character (.)".
 * 
 * @author I339640
 *
 */
public class RegularExpressionMatching {
	    
    public boolean matchRegex(String s, String p) {
    	  boolean T[][] = new boolean[s.length() + 1][p.length() + 1];

          T[0][0] = true;
          //Deals with patterns like a* or a*b* or a*b*c*
          for (int i = 1; i < T[0].length; i++) {
              if (p.charAt(i-1) == '*') {
                  T[0][i] = T[0][i - 2];
              }
          }
//"mississippi"
         // "mis*is*ip*."
          for (int i = 1; i < T.length; i++) {
              for (int j = 1; j < T[0].length; j++) {
                  if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                      T[i][j] = T[i-1][j-1];
                  } else if (p.charAt(j - 1) == '*')  {
                      T[i][j] = T[i][j - 2];
                      if (p.charAt(j-2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                          T[i][j] = T[i][j] || T[i - 1][j];
                      }
                  } 
              }
          }
          return T[s.length()][p.length()];
    }
    public static void main(String args[]){
    	RegularExpressionMatching rm = new RegularExpressionMatching();
        System.out.println(rm.matchRegex("Tushar","Tushar"));
        System.out.println(rm.matchRegex("Tusha","Tushar*a*b*"));
        System.out.println(rm.matchRegex("","a*b*"));
        System.out.println(rm.matchRegex("abbbbccc","a*ab*bbbbc*"));
        System.out.println(rm.matchRegex("abbbbccc","aa*bbb*bbbc*"));
        System.out.println(rm.matchRegex("abbbbccc",".*bcc"));
        System.out.println(rm.matchRegex("abbbbccc",".*bcc*"));
        System.out.println(rm.matchRegex("abbbbccc",".*bcc*"));
        System.out.println(rm.matchRegex("aaa","ab*a*c*a"));

        System.out.println(rm.matchRegex("aa", "a*"));
    }
}


