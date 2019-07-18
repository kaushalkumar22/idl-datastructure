package com.ds.advance;
/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

Note:

    s could be empty and contains only lowercase letters a-z.
    p could be empty and contains only lowercase letters a-z, and characters like ? or *.

Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:

Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.
https://leetcode.com/problems/wildcard-matching/
 * @author I339640
 *
 */
public class WildcardMatching {
	
	public static void main(String[] args) {

		String str="acdfghjdcb";
		String pattern="a*d?b";
		System.out.println(wildcardMatchingLinearLime( str,  pattern));
		//System.out.println(wildcardMatchingDynamicPrograming( str,  pattern));
		
	}
	static boolean wildcardMatchingDynamicPrograming(String str, String pattern) {
		   boolean[][] match=new boolean[str.length()+1][pattern.length()+1];
	        match[str.length()][pattern.length()]=true;
	        for(int i=pattern.length()-1;i>=0;i--){
	            if(pattern.charAt(i)!='*')
	                break;
	            else
	                match[str.length()][i]=true;
	        }
	        for(int i=str.length()-1;i>=0;i--){
	            for(int j=pattern.length()-1;j>=0;j--){
	                if(str.charAt(i)==pattern.charAt(j)||pattern.charAt(j)=='?')
	                        match[i][j]=match[i+1][j+1];
	                else if(pattern.charAt(j)=='*')
	                        match[i][j]=match[i+1][j]||match[i][j+1];
	                else
	                    match[i][j]=false;
	            }
	        }
	        return match[0][0];
	    }
		
	static boolean wildcardMatchingLinearLime(String str, String pattern) {
		int s = 0, p = 0, match = 0, starIdx = -1;            
		while (s < str.length()){
			// advancing both pointers
			if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
				s++;
				p++;
			}
			// * found, only advancing pattern pointer
			else if (p < pattern.length() && pattern.charAt(p) == '*'){
				starIdx = p;
				match = s;
				p++;
			}
			// last pattern pointer was *, advancing string pointer
			else if (starIdx != -1){
				p = starIdx + 1;
				match++;
				s = match;
			}
			//current pattern pointer is not star, last patter pointer was not *
			//characters do not match
			else return false;
		}

		//check for remaining characters in pattern
		while (p < pattern.length() && pattern.charAt(p) == '*')
			p++;

		return p == pattern.length();
	}
}
