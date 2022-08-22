package stack_pattern1;

import java.util.Stack;

/**
 * Reverse Substrings Between Each Pair of Parentheses Medium
 * 
 * You are given a string s that consists of lower case English letters and
 * brackets.
 * 
 * Reverse the strings in each pair of matching parentheses, starting from the
 * innermost one.
 * 
 * Your result should not contain any brackets.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "(abcd)" Output: "dcba"
 * 
 * Example 2:
 * Input: s = "(u(love)i)" Output: "iloveu" Explanation: The substring "love" is
 * reversed first, then the whole string is reversed.
 * 
 * Example 3:
 * 
 * Input: s = "(ed(et(oc))el)" Output: "leetcode" Explanation: First, we reverse
 * the substring "oc", then "etco", and finally, the whole string.
 * 
 * Example 4:
 * 
 * Input: s = "a(bcdefghijkl(mno)p)q" Output: "apmnolkjihgfedcbq"
 *  oc=etco edocte
 *  etcodele le
 */
public class ReverseSubstringsBetweenEachPairOfParentheses {

	public static void main(String[] args) {
		String s = "a(bcdefghijkl(mno)p)q";
		System.out.println(reverseParentheses( s));
	}
	public static String reverseParentheses(String s) {
		Stack<String> st = new Stack<String>();
		String current="";
		char[] c = s.toCharArray();
		for(int i=0;i<c.length;i++) {
			if(c[i]=='(') {
				st.push(current);
				current="";
			}else if(c[i]==')'){
				String prev = st.isEmpty()?"":st.pop();
				current=prev+reverse(current);
			}else {
				current =current+c[i];
			}
		}

		while(!st.isEmpty()) {
			current =st.pop()+current;
		}
		return current;        
	}
	private static String reverse(String s) {
		return new StringBuilder(s).reverse().toString();
	}
}
