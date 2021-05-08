package com.algo.ads.backtracking.common;

import java.util.ArrayList;
import java.util.Arrays;
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
 * 
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
		permute(digits, new StringBuilder(), res, 0);
		return res;
	}

	private void permute(String digits, StringBuilder res, List<String> results, int i) {
		if (i == digits.length()) {
			results.add(res.toString());
			return;
		}
		for (char c : KEYPAD[Character.getNumericValue(digits.charAt(i))].toCharArray()) {
			res.append(c);
			permute(digits, res, results, i + 1);
			res.deleteCharAt(res.length() - 1);
		}
	}
}
