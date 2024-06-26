package stack_miscellaneous;

import java.util.Stack;

/**
 * 
 * Given a balanced parentheses string S, compute the score of the string based
 * on the following rule:
 * 
 * () has score 1 AB has score A + B, where A and B are balanced parentheses
 * strings. (A) has score 2 * A, where A is a balanced parentheses string.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "()" Output: 1
 * 
 * Example 2:
 * 
 * Input: "(())" Output: 2
 * 
 * Example 3:
 * 
 * Input: "()()" Output: 2
 * 
 * Example 4:
 * 
 * Input: "(()(()))" Output: 6
 *
 * 
 */
public class ScoreOfParentheses {
	public static void main(String[] args) {
		String S="(()(()))";
		System.out.println(scoreOfParentheses( S));
	}
	public static int scoreOfParentheses(String S) {
		Stack<Integer> stack = new Stack<>();
		int cur = 0;
		for (char c : S.toCharArray()) {
			if (c == '(') {
				stack.push(cur);
				cur = 0;
			} else {
				cur = stack.pop() + Math.max(cur * 2, 1);
			}
		}
		return cur;
	}
/*
	Same as stack, I do it with an array.
	We change a pointer instead of pushing/popping repeatedly.
	Complexity: O(N) time and O(N) space
*/

	public int scoreOfParentheses1(String S) {
		int res[] = new int[30], i = 0;
		for (char c : S.toCharArray())
			if (c == '(') res[++i] = 0;
			else res[i - 1] += Math.max(res[i--] * 2, 1);
		return res[0];
	}

}
