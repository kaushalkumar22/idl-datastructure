package com.algo.stack.pattern2;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * Example 1:
 * 
 * Input: "(()" Output: 2 Explanation: The longest valid parentheses substring
 * is "()"
 * 
 * Example 2:
 * 
 * Input: ")()())" Output: 4 Explanation: The longest valid parentheses
 * substring is "()()"
 * 
 * 
 * @author I339640
 *
 */
public class LongestValidParentheses {

	public static void main(String[] args) {
		String s=")()())";
		System.out.println(longestValidParentheses( s));
	}

	/**
	 * The idea is simple, we only update the result (max) when we find a
	 * "pair". If we find a pair. We throw this pair away and see how big the
	 * gap is between current and previous invalid. EX: "( )( )" stack: -1, 0,
	 * when we get to index 1 ")", the peek is "(" so we pop it out and see
	 * what's before "(". In this example it's -1. So the gap is "current_index"
	 * - (-1) = 2. The idea only update the result (max) when we find a "pair"
	 * and push -1 to stack first covered all edge cases.
	 * 
	 * @param s
	 * @return
	 */
	public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        stack.push(-1);//if only one left in stack then ex ()
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                stack.pop();
                result = Math.max(result, i - stack.peek());
            } else {
                stack.push(i);
            }
        }
        return result;
    }

	/**
    Scan the string from beginning to end.If current character is '(',
    push its index to the stack. If current character is ')' and the
    character at the index of the top of stack is '(', we just find a
    matching pair so pop from the stack. Otherwise, we push the index of
    ')' to the stack.After the scan is done, the stack will only
    contain the indices of characters which cannot be matched. Then
    let's use the opposite side - substring between adjacent indices
    should be valid parentheses.If the stack is empty, the whole input
    string is valid. Otherwise, we can scan the stack to get longest
    valid substring as described in step 3.

	 * @param s
	 * @return
	 */
	static int longestValidParentheses2(String s) {
        int n = s.length(), longest = 0;
        Stack<Integer> st =new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i)== '(') st.push(i);
            else {
                if (!st.empty()) {
                    if (s.charAt(st.peek()) == '(') st.pop();
                    else st.push(i);
                }
                else st.push(i);
            }
        }
        if (st.empty()) longest = n;
        else {
            int a = n, b = 0;
            while (!st.empty()) {
                b = st.peek(); st.pop();
                longest = Math.max(longest, a-b-1);
                a = b;
            }
            longest = Math.max(longest, a);
        }
        return longest;
    }
}
