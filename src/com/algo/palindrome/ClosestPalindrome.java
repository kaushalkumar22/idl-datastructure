package com.algo.palindrome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer n, find the closest integer (not including itself), which is
 * a palindrome.
 * 
 * The 'closest' is defined as absolute difference minimized between two integers.
 * 
 * Input: "123" Output: "121"
 *
 */
public class ClosestPalindrome {

	/*
	 * Let's build a list of candidate answers for which the final answer must
	 * be one of those candidates. Afterwards, choosing from these candidates is
	 * straightforward.
	 * 
	 * If the final answer has the same number of digits as the input string S,
	 * then the answer must be the middle digits + (-1, 0, or 1) flipped into a
	 * palindrome. For example, 23456 had middle part 234, and 233, 234, 235
	 * flipped into a palindrome yields 23332, 23432, 23532. Given that we know
	 * the number of digits, the prefix 235 (for example) uniquely determines
	 * the corresponding palindrome 23532, so all palindromes with larger prefix
	 * like 23732 are strictly farther away from S than 23532 >= S.
	 * 
	 * If the final answer has a different number of digits, it must be of the
	 * form 999....999 or 1000...0001, as any palindrome smaller than 99....99
	 * or bigger than 100....001 will be farther away from S.
	 */
	public String nearestPalindromic(String n) {
		int len = n.length();
		if (len == 1)
			return Long.toString(Long.valueOf(n) - 1);
		List<String> candidates = new ArrayList<>();
		candidates.add(allNine(len - 1));
		candidates.add(allNine(len));
		candidates.add(oneZeroOne(len + 1));
		candidates.add(oneZeroOne(len));

		long half = Long.valueOf(n.substring(0, (len + 1) / 2));
		long[] prefixes = { half - 1, half, half + 1 };
		for (long i : prefixes) {
			String str = Long.toString(i);
			if (len % 2 == 0) {
				candidates.add(str + new StringBuilder(str).reverse().toString());
			} else
				candidates.add(str + new StringBuilder(str.substring(0, str.length() - 1)).reverse().toString());
		}

		long diff = Long.MAX_VALUE;
		long result = 0;
		long num = Long.valueOf(n);
		for (String candidate : candidates) {
			if (candidate.equals(n))
				continue;
			long can = Long.valueOf(candidate);
			if (Math.abs(can - num) < diff || (Math.abs(can - num) == diff && can < result)) {
				diff = Math.abs(can - num);
				result = can;
			}
		}

		return Long.toString(result);
	}

	public String allNine(int len) {
		char[] charArray = new char[len];
		Arrays.fill(charArray, '9');
		return new String(charArray);
	}

	public String oneZeroOne(int len) {
		char[] charArray = new char[len];
		Arrays.fill(charArray, '0');
		charArray[0] = '1';
		charArray[len - 1] = '1';
		return new String(charArray);
	}
}
