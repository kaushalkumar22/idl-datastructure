package com.algo.lds.slidingwindow;

/**
 * Given a string S, find the length of the longest substring T that contains at
 * most k distinct characters.
 * 
 * Input: S = "eceba" and k = 3 Output: 4 Explanation: T = "eceb" Input: s =
 * "pqpqs", k = 2 Output: 4 Input: S = "WORLD" and k = 4 Output: 4 Explanation:
 * T = "WORL" or "ORLD"
 * 
 */
public class LongestSubstringWithAtMostKDistinctCharacters {

	public static void main(String[] args) {
		String s = "WORLD";
		int k = 4;
		System.out.println(lenOfLongestSubstring(s, k));
	}

	/*
	 * If the problem talks about continuous substrings, the sliding
	 * window technique may help solve it in a linear time.
	 * 
	 * left: left boundary of window
	 * 
	 * right: right boundary of window
	 * 
	 * count: 'count' to track unique chars
	 * 
	 * maxLen: to track max length of substring with k unique chars
	 * 
	 * cCount[]: to keep track how many times each chars appears in our window
	 * 
	 * 1. first move the right until 'count>=k' and increment the count if new char,
	 * and also increment the respective char count in 'cCount'.
	 * 
	 * 2.if 'count>k', then check the count of char in cCount at cCount[left],
	 * 
	 *a.  if cCount[left]= 1 then decrement the 'count' and 'cCount[left]--', and
	 * increment the 'left++' pointer to shrink our sliding window (because the same
	 * char present only once in the window).
	 * 
	 * b.  if cCount[left]>1 then decrement the --cCount[left], and increment the left++
	 * until cCount[left]=1 
	 * 
	 * 3. if 'count=k' update the maxlen.
	 * 
	 * 4. Repeat the step 1,2,3
	 * 
	 * Time complexity O(n) space complexity O(1)
	 */
	public static int lenOfLongestSubstring(String s, int k) {
		int left = 0;
		int right = 0;
		int count = 0;
		int maxLen = Integer.MIN_VALUE;
		int[] cCount = new int[128];

		for (right = 0; right < s.length(); right++) {
			//increment the count if new char, and also increment the respective char count in 'cCount'.
			if (cCount[s.charAt(right)]++ == 0) {
				count++;
			}

			while (count > k) {
				if (cCount[s.charAt(left)] == 1)
					count--;
				cCount[s.charAt(left++)]--;
			}

			if (count == k) {
				maxLen = Math.max(maxLen, right - left + 1);
			}
		}

		return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
	}
}
