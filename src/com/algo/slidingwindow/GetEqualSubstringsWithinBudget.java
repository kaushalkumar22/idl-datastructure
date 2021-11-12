package com.algo.slidingwindow;

/**
 * You are given two strings s and t of the same length. You want to change s to
 * t. Changing the i-th character of s to i-th character of t costs |s[i] -
 * t[i]| that is, the absolute difference between the ASCII values of the
 * characters.
 * 
 * You are also given an integer maxCost.
 * 
 * Return the maximum length of a substring of s that can be changed to be the
 * same as the corresponding substring of twith a cost less than or equal to
 * maxCost.
 * 
 * If there is no substring from s that can be changed to its corresponding
 * substring from t, return 0.
 * 
 * 
 * Input: s = "abcd", t = "bcdf", maxCost = 3 Output: 3 Explanation: "abc" of s
 * can change to "bcd". That costs 3, so the maximum length is 3.
 * 
 * Input: s = "abcd", t = "cdef", maxCost = 3 Output: 1 Explanation: Each
 * character in s costs 2 to change to charactor in t, so the maximum length is
 * 1.
 * 
 * Input: s = "abcd", t = "acde", maxCost = 0 Output: 1 Explanation: You can't
 * make any change, so the maximum length is 1.
 * 
 *
 */
public class GetEqualSubstringsWithinBudget {

	public static void main(String[] args) {
		String s = "abcd", t = "cdef";
		int maxCost = 3;
		System.out.println(equalSubstring( s, t, maxCost));

	}
	/*
	 * Intuition
	 * 
	 * Change the input of string s and t into an array of difference. Then it's a
	 * standard sliding window problem.
	 * 
	 * Complexity
	 * 
	 * Time O(N) for one pass Space O(1)
	 */

	    public static int equalSubstring(String s, String t, int maxCost) {
	        int  left = 0;
	        int right; 
	        for (right = 0; right < s.length(); ++right) {
	        	maxCost -= Math.abs(s.charAt(right) - t.charAt(right));
	            if (maxCost < 0) {
	            	maxCost += Math.abs(s.charAt(left) - t.charAt(left));
	                ++left;
	            }
	        }
	        return right - left;
	    }


}
