package com.algo.nlds.stack.pattern1;

import java.util.Stack;

/**
 * Given two strings S and T, return if they are equal when both are typed into
 * empty text editors. # means a backspace character.
 * 
 * Note that after backspacing an empty text, the text will continue empty.
 *  
 * Input: S = "ab#c", T = "ad#c" Output: true Explanation: Both S and T become "ac".
 * 
 * Input: S = "ab##", T = "c#d#" Output: true Explanation: Both S and T become "".
 * 
 * Input: S = "a##c", T = "#a#c" Output: true Explanation: Both S and T become "c".
 * 
 * Input: S = "a#c", T = "b" Output: false Explanation: S becomes "c" while T becomes "b".
 * 
 */
public class BackspaceStringCompare {

	public static void main(String[] args) {
		System.out.println(backspaceCompare("ab##", "c#d#"));
	}
	public static boolean backspaceCompare(String S, String T) {
		Stack<Character> ss = new Stack<Character>();
		Stack<Character> ts = new Stack<Character>();
		for (Character cs : S.toCharArray()) {
			if(cs!='#') {
				ss.push(cs);
			}else if(!ss.isEmpty()) {
				ss.pop();
			}
		}
		for (Character ct : T.toCharArray()) {
			if(ct!='#') {
				ts.push(ct);
			}else if(!ts.isEmpty()) {
				ts.pop();
			}
		}

		return ts.equals(ss)?true:false;

	}
	public boolean backspaceCompare1(String S, String T) {
		int i = S.length() - 1, j = T.length() - 1, back;
		while (true) {
			back = 0;
			while (i >= 0 && (back > 0 || S.charAt(i) == '#')) {
				back += S.charAt(i) == '#' ? 1 : -1;
				i--;
			}
			back = 0;
			while (j >= 0 && (back > 0 || T.charAt(j) == '#')) {
				back += T.charAt(j) == '#' ? 1 : -1;
				j--;
			}
			if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
				i--;
				j--;
			} else {
				break;
			}
		}
		return i == -1 && j == -1;
	}
}
