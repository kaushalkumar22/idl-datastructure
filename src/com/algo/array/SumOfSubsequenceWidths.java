package com.algo.array;

import java.util.Arrays;

/**
 * Given an array of integers A, consider all non-empty subsequences of A.
 * For any sequence S, let the width of S be the difference between the maximum
 * and minimum element of S.
 * 
 * Return the sum of the widths of all subsequences of A.
 * 
 * As the answer may be very large, return the answer modulo 10^9 + 7.
 * 
 * Input: [2,1,3] Output: 6 Explanation: Subsequences are [1], [2], [3], [2,1],
 * [2,3], [1,3], [2,1,3]. The corresponding widths are 0, 0, 0, 1, 1, 2, 2. The
 * sum of these widths is 6.
 * 
 * @author I339640
 *
 */
public class SumOfSubsequenceWidths {

	public static void main(String[] args) {
		int[] nums = {2,1,3};
		System.out.println(sumSubseqWidths(nums));
	}
	/*Explanation
	The order in initial arrays doesn't matter,my first intuition is to sort the array.

	For each number A[i]:

	There are i smaller numbers,
	so there are 2 ^ i sequences in which A[i] is maximum.
	we should do res += A[i] * (2 ^ i)

	There are n - i - 1 bigger numbers,
	so there are 2 ^ (n - i - 1) sequences in which A[i] is minimum.
	we should do res -= A[i] * (n - i - 1)

	Done.


	Time Complexity:
	Time O(NlogN)
	Space O(1)


	FAQ
	Q. why do we plus mod before return?
	A In Cpp and Java, mod on negative number will still get a negative number.
*/
	    public static int sumSubseqWidths(int[] A) {
	        Arrays.sort(A);
	        long c = 1, res = 0, mod = (long)1e9 + 7;
	        int n = A.length;
	        for (int i = 0;i < n; ++i) {
	            res = (res + A[i] * c - A[n - i - 1] * c) % mod;
	            c = c * 2 % mod;
	        }
	        return (int)((res + mod) % mod);
	    }
}
