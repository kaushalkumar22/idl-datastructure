package stack_miscellaneous;

/**
 * Remove All Adjacent Duplicates in String II Medium
 * 
 * Given a string s, a k duplicate removal consists of choosing k adjacent and
 * equal letters from s and removing them causing the left and the right side of
 * the deleted substring to concatenate together.
 * 
 * We repeatedly make k duplicate removals on s until we no longer can.
 * 
 * Return the final string after all such duplicate removals have been made.
 * 
 * It is guaranteed that the answer is unique.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abcd", k = 2 Output: "abcd" Explanation: There's nothing to
 * delete.
 * 
 * Example 2:
 * 
 * Input: s = "deeedbbcccbdaa", k = 3 Output: "aa" Explanation: First delete
 * "eee" and "ccc", get "ddbbbdaa" Then delete "bbb", get "dddaa" Finally delete
 * "ddd", get "aa"
 * 
 * Example 3:
 * 
 * Input: s = "pbbcggttciiippooaais", k = 2 Output: "ps"
 *
 * 
 */
public class RemoveAllAdjacentDuplicatesInStringII {

	public static void main(String[] args) {
		String s = "pbbcggttciiippooaais";
		int k = 2;
		System.out.println(removeDuplicates( s,k));
	}

	public static String removeDuplicates(String s, int k) {
		int i = 0, n = s.length(), count[] = new int[n];
		char[] stack = s.toCharArray();
		for (int j = 0; j < n; ++j, ++i) {
			stack[i] = stack[j];
			count[i] = i > 0 && stack[i - 1] == stack[j] ? count[i - 1] + 1 : 1;
			if (count[i] == k) i -= k;
		}
		return new String(stack, 0, i);
	}

	public static String removeDuplicates1(String s, int k) {
		int[] count = new int[s.length()];
		StringBuilder sb = new StringBuilder();
		for(char c : s.toCharArray()) {
			sb.append(c);
			int last = sb.length()-1;
			count[last] = 1 + (last > 0 && sb.charAt(last) == sb.charAt(last-1) ? count[last-1] : 0);
			if(count[last] >= k) sb.delete(sb.length()-k, sb.length());
		}
		return sb.toString();
	}
}