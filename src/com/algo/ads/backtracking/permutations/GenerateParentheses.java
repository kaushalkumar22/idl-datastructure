package com.algo.ads.backtracking.permutations;

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
		dfs(res, new StringBuilder(), 0, 0, n);
		return res;
	}

	private void dfs(List<String> res, StringBuilder sb, int open, int close, int n) {
		if (open == n && close == n) {
			res.add(sb.toString());
			return;
		}

		if (open < n) {
			sb.append("(");
			dfs(res, sb, open + 1, close, n);
			sb.deleteCharAt(sb.length() - 1);
		}
		if (close < open) {
			sb.append(")");
			dfs(res, sb, open, close + 1, n);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
