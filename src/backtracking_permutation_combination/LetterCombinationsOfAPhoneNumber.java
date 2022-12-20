package backtracking_permutation_combination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a digit string excluded 0 and 1, return all possible letter
 * combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. 
 * 1 2 ABC 3 DEF 4 GHI 5 JKL 6 MNO 7 PQRS 8 TUV 9 WXYZ
 * 
 * Although the answer above is in lexicographical order, your answer could be
 * in any order you want. Example
 * 
 * Example 1:
 * 
 * Input: "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 * Explanation: '2' could be 'a', 'b' or 'c' '3' could be 'd', 'e' or 'f'
 * 
 * Input: "5" Output: ["j", "k", "l"]
 *
 */
public class LetterCombinationsOfAPhoneNumber {
	public static void main(String[] args) {
		System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations("23").toString());
	}

	String[] KEYPAD = { " ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits.length() == 0 || digits.equals(""))
			return res;
		backtrack(digits, res,new StringBuilder(),  0);
		return res;
	}

	private void backtrack(String digits,List<String> res, StringBuilder subRes,  int i) {
		if (i == digits.length()) {
			res.add(subRes.toString());

			return;
		}
		for (char c : KEYPAD[Character.getNumericValue(digits.charAt(i))].toCharArray()) {
			subRes.append(c);
			backtrack(digits,res, subRes,  i + 1);
			subRes.deleteCharAt(subRes.length() - 1);
		}
	}

	public List<String> letterCombinationsOpt(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if(digits.isEmpty()) return ans;
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		while(ans.peek().length()!=digits.length()){
			String remove = ans.remove();
			String map = mapping[digits.charAt(remove.length())-'0'];
			for(char c: map.toCharArray()){
				ans.addLast(remove+c);
			}
		}
		return ans;
	}
}
