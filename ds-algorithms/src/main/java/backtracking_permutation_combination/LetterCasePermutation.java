package backtracking_permutation_combination;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S, we can transform every letter individually to be lowercase
 * or uppercase to create another string.
 * <p>
 * Return a list of all possible strings we could create. You can return the
 * output in any order.
 * <p>
 * Input: S = "a1b2" Output: ["a1b2","a1B2","A1b2","A1B2"]
 * <p>
 * Input: S = "3z4" Output: ["3z4","3Z4"]
 * <p>
 * Input: S = "12345" Output: ["12345"]
 * <p>
 * Input: S = "0" Output: ["0"]
 * <p>
 * Constraints:
 * <p>
 * S will be a string with length between 1 and 12. S will consist only of
 * letters or digits.
 */
public class LetterCasePermutation {
	public static void main(String[] args) {
		System.out.println(new LetterCasePermutation().letterCasePermutation( "a1B2"));
	}
	public List<String> letterCasePermutation(String S) {
		List<String> res = new ArrayList<>();
		char[] a = S.toLowerCase().toCharArray();
		dfs(a, res,0);
		return res;
	}

	void dfs(char[] a, List<String> res, int pos){
		res.add(new String(a));

		for(int i=pos;i<a.length;i++){
			if (!Character.isLetter(a[i])) continue;
			a[i] = Character.toUpperCase(a[i]);
			dfs(a, res, i + 1);
			a[i] = Character.toLowerCase(a[i]);

		}
	}
}
