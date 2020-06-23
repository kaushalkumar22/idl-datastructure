package com.algo.array;

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

	/*Intuition:
		I guess this is a general intuition for most solution.
		res = sum(A[i] * f(i))
		where f(i) is the number of subarrays,
		in which A[i] is the minimum.

		To get f(i), we need to find out:
		left[i], the length of strict bigger numbers on the left of A[i],
		right[i], the length of bigger numbers on the right of A[i].

		Then,
		left[i] + 1 equals to
		the number of subarray ending with A[i],
		and A[i] is single minimum.

		right[i] + 1 equals to
		the number of subarray starting with A[i],
		and A[i] is the first minimum.

		Finally f(i) = (left[i] + 1) * (right[i] + 1)

		For [3,1,2,4] as example:
		left + 1 = [1,2,1,1]
		right + 1 = [1,3,2,1]
		f = [1,6,2,1]
		res = 3 * 1 + 1 * 6 + 2 * 2 + 4 * 1 = 17


		Explanation:
		To calculate left[i] and right[i],
		we use two increasing stacks.

		It will be easy if you can refer to this problem and my post:
		901. Online Stock Span
		I copy some of my codes from this solution.


		Complexity:
		All elements will be pushed twice and popped at most twice
		O(N) time, O(N) space

	 */

	public int sumSubarrayMins(int[] A) {
		int res = 0, n = A.length, mod = (int)1e9 + 7;
		int[] left = new int[n], right = new int[n];
		Stack<int[]> s1 = new Stack<>(), s2 = new Stack<>();
		for (int i = 0; i < n; ++i) {
			int count = 1;
			while (!s1.isEmpty() && s1.peek()[0] > A[i])
				count += s1.pop()[1];
			s1.push(new int[] {A[i], count});
			left[i] = count;
		}
		for (int i = n - 1; i >= 0; --i) {
			int count = 1;
			while (!s2.isEmpty() && s2.peek()[0] >= A[i])
				count += s2.pop()[1];
			s2.push(new int[] {A[i], count});
			right[i] = count;
		}
		for (int i = 0; i < n; ++i)
			res = (res + A[i] * left[i] * right[i]) % mod;
		return res;
	}
		/*	Improvement
		1.Here I record (A[i], count) in the stack.
		We can also only record index.
		2. For left part and right part, the logic is same.
		So for each, I used one stack and one pass.
		This process can be optimized to one pass using one stack in total.
		 */

		public int sumSubarrayMins1(int[] A) {
			Stack<Integer> stack = new Stack<>();
			int n = A.length, res = 0, mod = (int)1e9 + 7, j,k;
			for (int i = 0; i <= n; i++) {
				while (!stack.isEmpty() && A[stack.peek()] > (i == n ? 0 : A[i])) {
					j = stack.pop();
					k = stack.isEmpty() ? -1 : stack.peek();
					res = (res + A[j] * (i - j) * (j - k)) % mod;
				}
				stack.push(i);
			}
			return res;
		}

	}
