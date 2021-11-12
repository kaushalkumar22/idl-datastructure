package com.algo.backtracking.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * Input: n = 3 Output: ["((()))","(()())","(())()","()(())","()()()"]
 *  
 * Input: n = 1 Output: ["()"]
 * 
 * Constraints:
 * 1 <= n <= 8
 */
public class GenerateParentheses {
	public static void main(String[] args) {
		System.out.println(new GenerateParentheses().generateParenthesis(3));
	}

	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		backtrack(res, new StringBuilder(), n,0, 0);
		return res;
	}

	private void backtrack(List<String> res, StringBuilder subRes, int n,int open, int close) {
	
		if (open == n && close == n) {
			res.add(subRes.toString());
			return;
		}

		if (open < n) {
			subRes.append("(");
			backtrack(res, subRes, n,open + 1, close);
			subRes.deleteCharAt(subRes.length() - 1);
		}
		if (close < open) {
			subRes.append(")");
			backtrack(res, subRes, n,open, close + 1);
			subRes.deleteCharAt(subRes.length() - 1);
		}
	}
}
