package stack_pattern1;

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
		System.out.println(backspaceCompare2("ab##", "c#d#"));
	}
	public static boolean backspaceCompare(String S, String T) {
		return build(S).equals(build(T));
	}

	public static String build(String S) {
		Stack<Character> ans = new Stack<>();
		for (char c: S.toCharArray()) {
			if (c != '#')
				ans.push(c);
			else if (!ans.empty())
				ans.pop();
		}
		return String.valueOf(ans);
	}
	public static boolean backspaceCompare2(String S, String T) {
		int i = S.length() - 1, j = T.length() - 1;
		int skipS = 0, skipT = 0;

		while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
			while (i >= 0) { // Find position of next possible char in build(S)
				if (S.charAt(i) == '#') {skipS++; i--;}
				else if (skipS > 0) {skipS--; i--;}
				else break;
			}
			while (j >= 0) { // Find position of next possible char in build(T)
				if (T.charAt(j) == '#') {skipT++; j--;}
				else if (skipT > 0) {skipT--; j--;}
				else break;
			}
			// If two actual characters are different
			if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
				return false;
			// If expecting to compare char vs nothing
			if ((i >= 0) != (j >= 0))
				return false;
			i--; j--;
		}
		return true;
	}
}
