package stack_pattern2;

import java.util.Stack;

/**
 * Given a string S of lowercase letters, a duplicate removal consists of
 * choosing two adjacent and equal letters, and removing them.
 * 
 * We repeatedly make duplicate removals on S until we no longer can.
 * 
 * Return the final string after all such duplicate removals have been made. It
 * is guaranteed the answer is unique.
 * 
 * 
 * Input: "abbaca" Output: "ca" Explanation: For example, in "abbaca" we could
 * remove "bb" since the letters are adjacent and equal, and this is the only
 * possible move. The result of this move is that the string is "aaca", of which
 * only "aa" is possible, so the final string is "ca".

 * 1 <= S.length <= 20000 S consists only of English lowercase letters.
 *
 */
public class RemoveAllAdjacentDuplicatesInString {

	public static void main(String[] args) {
		String s = "abbaca";
		System.out.println(removeDuplicates(s));
	}

	public static String removeDuplicates(String s) {
		Stack<Character> st = new Stack<Character>();
		char[] cr = s.toCharArray();
		for (int i = 0; i < cr.length; i++) {
			if (!st.isEmpty() && st.peek()==cr[i]) {
				st.pop();
			} else {
				st.push(cr[i]);
			}

		}
		String res = "";
		while (!st.isEmpty())
			res = st.pop() + res;
		return res;

	}
	public String removeDuplicatesOpt(String s) {
		int i = 0, n = s.length();
		char[] res = s.toCharArray();
		for (int j = 0; j < n; ++j, ++i) {
			res[i] = res[j];
			if (i > 0 && res[i - 1] == res[i]) // count = 2
				i -= 2;
		}
		return new String(res, 0, i);

	}
}
