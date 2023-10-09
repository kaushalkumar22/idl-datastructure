package stack_pattern2;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * Input: "(()" Output: 2 Explanation: The longest valid parentheses substring
 * is "()"
 * 
 * Input: ")()())" Output: 4 Explanation: The longest valid parentheses
 * substring is "()()"
 * 
 */
public class LongestValidParentheses {

	public static void main(String[] args) {
		String s = ")()())";
		System.out.println(longestValidParentheses2(s));
	}
	public static int longestValidParentheses2(String s) {
		int left = 0, right = 0, maxlength = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if (left == right) {
				maxlength = Math.max(maxlength, 2 * right);
			} else if (right >= left) {
				left = right = 0;
			}
		}
		left = right = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if (left == right) {
				maxlength = Math.max(maxlength, 2 * left);
			} else if (left >= right) {
				left = right = 0;
			}
		}
		return maxlength;
	}
	/*
	 * The idea is simple, we only update the result (max) when we find a "pair". If
	 * we find a pair. We throw this pair away and see how big the gap is between
	 * current and previous invalid. EX: "( )( )" stack: -1, 0, when we get to index
	 * 1 ")", the peek is "(" so we pop it out and see what's before "(". In this
	 * example it's -1. So the gap is "current_index" - (-1) = 2. The idea only
	 * update the result (max) when we find a "pair" and push -1 to stack first
	 * covered all edge cases.
	 * 
	 */
	public static int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<>();
		int result = 0;
		stack.push(-1);// if only one left in stack then ex ()
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
	public int longestValidParentheses1(String s) {
		int maxans = 0;
		int dp[] = new int[s.length()];
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(') {
					dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
				} else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
					dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
				}
				maxans = Math.max(maxans, dp[i]);
			}
		}
		return maxans;
	}

	
}
