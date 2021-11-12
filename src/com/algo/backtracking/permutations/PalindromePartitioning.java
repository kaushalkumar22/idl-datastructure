package com.algo.backtracking.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Palindrome Partitioning
 * 
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * Input: "aab" Output: [ ["aa","b"], ["a","a","b"] ]
 *
 */
public class PalindromePartitioning {

	public static void main(String[] args) {
		System.out.println(new PalindromePartitioning().partition("aab").toString());
	}
	
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		backtrack(s,res, new ArrayList<>(), 0);
		return res;
	}

	public void backtrack(String str,List<List<String>> res, List<String> subRes,  int start) {

		if (start == str.length()) {
			res.add(new ArrayList<>(subRes));
			return;
		}
		for (int i = start; i < str.length(); i++) {
			if (!isPalindrome(str, start, i)) continue;
			subRes.add(str.substring(start, i + 1));
			backtrack(str,res, subRes, i + 1);
			subRes.remove(subRes.size() - 1);
		}
	}


	public boolean isPalindrome(String str, int low, int high){
		while(low < high)
			if(str.charAt(low++) != str.charAt(high--)) return false;
		return true;
	} 
}
