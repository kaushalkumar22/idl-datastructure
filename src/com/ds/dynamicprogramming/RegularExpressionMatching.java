package com.ds.dynamicprogramming;
/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

Note:

    s could be empty and contains only lowercase letters a-z.
    p could be empty and contains only lowercase letters a-z, and characters like . or *.

Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
https://leetcode.com/problems/regular-expression-matching/discuss/191830/Java-DP-solution-beats-100-with-explanation
 * @author I339640
 *
 */
public class RegularExpressionMatching {
	    
    public boolean matchRegex(String s, String p) {
        if (p == null || p.length() == 0) return (s == null || s.length() == 0);
        
        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int j=2; j<=p.length(); j++) {
            dp[0][j] = p.charAt(j-1) == '*' && dp[0][j-2]; 
        }
        
        for (int j=1; j<=p.length(); j++) {
            for (int i=1; i<=s.length(); i++) {
                if (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.') 
					dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(j-1) == '*')
                    dp[i][j] = dp[i][j-2] || ((s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') && dp[i-1][j]); 
            }
        }
        return dp[s.length()][p.length()];
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


