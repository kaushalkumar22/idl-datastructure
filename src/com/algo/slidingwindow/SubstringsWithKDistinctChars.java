package com.algo.slidingwindow;

/**
 * Given a string s and an int k, return an int representing the number of
 * substrings (not unique) of s with exactly k distinct characters. If the given
 * string doesn't have k distinct characters, return 0.
 * 
 * Input: s = "pqpqs", k = 2 Output: 7 Explanation: ["pq", "pqp", "pqpq", "qp",
 * "qpq", "pq", "qs"]
 * 
 * Input: s = "aabab", k = 3 Output: 0
 * 
 * Constraints:
 * 
 * The input string consists of only lowercase English letters [a-z] 0 <= k <=
 * 26
 *
 */
public class SubstringsWithKDistinctChars {

	public static void main(String[] args) {
		String s = "pqpqs";
		int k = 2;
		System.out.println(characterReplacement(s, k));
	}

	/*
	 * Intuition
	 * 
	 * If the substring [left, right] contains K unique chars, and first prefix
	 * numbers also appear in [prefix + left, right] substring, we have total 1 +
	 * prefix good substring. For example, there are k=3 unique chars in
	 * [p,q,p,q,s]. First two chars also appear in the remaining subarray [p,q,s],
	 * so we have 1 + 2 good subarrays: [p,q,p,q,s],[q,p,q,s] and [p,q,s].
	 * 
	 * 
	 * left: left boundary of window
	 * right: right boundary of window
	 * count: 'count' to track substring has how many unique chars
	 * prefix: to track the prefix
	 * cCount[]: to keep track how many times each chars appears in our window
	 * 
	 * 1. first move the right until 'count>=k' and increment the count if new char,
	 * and also increment the respective char count in 'cCount'.
	 * 
	 * 2.if 'count>k', then decrement the 'count' and '--cCount[c]' and reset the
	 * prefix as zero because its a new window.we are trying to shrink our sliding
	 * window while maintaining the same number of unique elements.
	 * 
	 * 3. if cCount[left]= 1 then decrement the 'count' and 'cCount[left]--', and
	 * increment the 'left++'(we try to remove as many as possible numbers from the
	 * front, until the number in the front appears only once. While removing
	 * numbers, we are increasing prefix.)
	 * 
	 * 4. if 'count=k' update the maxlen.
	 * 
	 * 5. Repeat the step 1,2,3
	 * 
	 * Complexity Analysis
	 * 
	 * Time Complexity: O(n) Space Complexity: O(1).
	 * 
	 */
	public static int characterReplacement(String s, int k) {

		int[] cCount = new int[128];
		int count = 0;
		int left = 0;
		int right = 0;
		int prefix = 0;
		int subStringCount = 0;

		for (right = 0; right < s.length(); right++) {
			// increment the count if new char, and also increment the respective char count in 'cCount
			if (cCount[s.charAt(right)]++ == 0) {
				++count;// if new char increased the count
			}

			if (count > k) {
				--cCount[s.charAt(left++)];
				--count;
				prefix = 0;
			}

			while (cCount[s.charAt(left)] > 1) {
				prefix++;
				--cCount[s.charAt(left++)];
			}

			if (count == k) {
				subStringCount += prefix + 1;
			}
		}
		return subStringCount;
	}
}
