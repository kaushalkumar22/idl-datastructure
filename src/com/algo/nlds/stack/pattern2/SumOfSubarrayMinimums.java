package com.algo.nlds.stack.pattern2;

import java.util.Stack;

/**
 * 
 * Given an array of integers A, find the sum of min(B), where B ranges over
 * every (contiguous) subarray of A.
 * 
 * Since the answer may be large, return the answer modulo 10^9 + 7.
 * 
 * 
 * Input: [3,1,2,4] Output: 17 Explanation: Subarrays are [3], [1], [2], [4],
 * [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. Minimums are 3, 1, 2, 4, 1,
 * 1, 2, 1, 1, 1. Sum is 17.
 * 
 *
 */
public class SumOfSubarrayMinimums {

	public static void main(String[] args) {
		int[] A = { 3, 1, 2, 4 };
		System.out.println(sumSubarrayMins1(A));
	}

	/*
	 * Improvement 
	 * 1.Here I record (A[i], count) in the stack. We can also only
	 * record index. 
	 * 2. For left part and right part, the logic is same.
	 */

	public static int sumSubarrayMins1(int[] A) {
		Stack<Integer> stack = new Stack<>();
		int n = A.length, res = 0, mod = (int) 1e9 + 7, j, k;
		for (int i = 0; i <= n; i++) {
			int num = i == n ? 0 : A[i];
			while (!stack.isEmpty() && A[stack.peek()] > num) {
				j = stack.pop();
				k = stack.isEmpty() ? -1 : stack.peek();
				res = (res + A[j] * (i - j) * (j - k)) % mod;
			}
			stack.push(i);
		}
		return res;
	}

}
