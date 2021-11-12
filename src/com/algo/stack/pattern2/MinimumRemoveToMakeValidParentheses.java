package com.algo.stack.pattern2;

import java.util.Stack;

/**
 * 
 * Minimum Remove to Make Valid Parentheses
 * 
 * Given a string s of '(' , ')' and lowercase English characters.
 * 
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any
 * positions ) so that the resulting parentheses string is valid and return any
 * valid string.
 * 
 * Formally, a parentheses string is valid if and only if:
 * 
 * It is the empty string, contains only lowercase characters, or It can be
 * written as AB (A concatenated with B), where A and B are valid strings, or It
 * can be written as (A), where A is a valid string.
 * 
 * Input: s = "lee(t(c)o)de)" Output: "lee(t(c)o)de" Explanation: "lee(t(co)de)"
 * , "lee(t(c)ode)" would also be accepted.
 * 
 * Example 2:
 * 
 * Input: s = "a)b(c)d" Output: "ab(c)d"
 * 
 * Example 3:
 * 
 * Input: s = "))((" Output: "" Explanation: An empty string is also valid.
 * 
 * Example 4:
 * 
 * Input: s = "(a(b(c)d)" Output: "a(b(c)d)"
 *
 * 
 */
public class MinimumRemoveToMakeValidParentheses {
	public static void main(String[] args) {
		String S="(a(b(c)d)";
		System.out.println(minRemoveToMakeValid( S));
	}
	public static String minRemoveToMakeValid(String s) {

		Stack<Integer> st = new Stack<Integer>();
		char[] c = s.toCharArray();
		for(int i=0;i<c.length;i++) {
			if(!st.isEmpty()&&c[st.peek()]=='('&&c[i]==')') {
				st.pop();
			}else if(c[i]=='('||c[i]==')'){
				st.push(i);
			}
		}
		StringBuilder sb = new StringBuilder(s);
		while(!st.isEmpty()) {
			sb.deleteCharAt(st.pop());
		}
		return sb.toString();

	}
}
