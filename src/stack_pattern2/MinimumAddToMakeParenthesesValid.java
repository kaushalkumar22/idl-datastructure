package stack_pattern2;

import java.util.Stack;

/**
 * Minimum Add to Make Parentheses Valid
 * 
 * Given a string S of '(' and ')' parentheses, we add the minimum number of
 * parentheses ( '(' or ')', and in any positions ) so that the resulting
 * parentheses string is valid.
 * 
 * Formally, a parentheses string is valid if and only if:
 * 
 * It is the empty string, or It can be written as AB (A concatenated with B),
 * where A and B are valid strings, or It can be written as (A), where A is a
 * valid string.
 * 
 * Given a parentheses string, return the minimum number of parentheses we must
 * add to make the resulting string valid.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "())" Output: 1
 * 
 * Example 2:
 * 
 * Input: "(((" Output: 3
 * 
 * Example 3:
 * 
 * Input: "()" Output: 0
 * 
 * Example 4:
 * 
 * Input: "()))((" Output: 4
 * 
 * @author IBM
 *
 */
public class MinimumAddToMakeParenthesesValid {

	public static void main(String[] args) {
		String S="())";
		System.out.println(minAddToMakeValid( S));
	}
	public static int minAddToMakeValid(String S) {

		Stack<Character> st = new Stack<Character>();
		char[] c = S.toCharArray();
		for(int i=0;i<c.length;i++) {
			if(!st.isEmpty()&&st.peek()=='('&&c[i]==')') {
				st.pop();
			}else {
				st.push(c[i]);
			}
		}
		return st.size();
	}
	public int minAddToMakeValid1(String S) {
		int left = 0, right = 0;
		for (int i = 0; i < S.length(); ++i) {
			if (S.charAt(i) == '(') {
				right++;
			} else if (right > 0) {
				right--;
			} else {
				left++;
			}
		}
		return left + right;
	}

}
