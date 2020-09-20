package com.algo.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Letter Combinations of a Phone Number
 *  
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * Example:
 * 
 * Input: "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 *
 */
public class LetterCombinationsOfAPhoneNumber {
	public static void main(String[] args) {
		System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations("23").toString());
	}
	private static final String[] LETTERS = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	public List<String> letterCombinations(String digits) { 
		return (digits.length() == 0) ? Arrays.asList()
				: permute(digits, new StringBuilder(), new ArrayList<>(), 0); 
	} 
	private List<String> permute(String digits, StringBuilder result, List<String> results, int i) {
		if (i == digits.length()) results.add(result.toString());
		else for (char c : LETTERS[Character.digit(digits.charAt(i), 10)].toCharArray()) {
			result.append(c);
			permute(digits, result, results, i + 1);
			result.deleteCharAt(result.length() - 1);
		}
		return results;
	}
}
