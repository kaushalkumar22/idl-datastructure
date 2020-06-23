package com.algo.array;

/**
 * Let's call any (contiguous) subarray B (of A) a mountain if the following
 * properties hold:
 * 
 * B.length >= 3 There exists some 0 < i < B.length - 1 such that B[0] < B[1] <
 * ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1] (Note that B could be any
 * subarray of A, including the entire array A.)
 * 
 * Given an array A of integers, return the length of the longest mountain.T
 * 
 * Return 0 if there is no mountain.
 * 
 * Input: [2,1,4,7,3,2,5] Output: 5 Explanation: The largest mountain is
 * [1,4,7,3,2] which has length 5.
 * 
 * Input: [2,2,2] Output: 0 Explanation: There is no mountain.
 * 
 * @author I339640
 *
 */
public class LongestMountainInArray {

	/*
	 * Intuition: We have already many 2-pass or 3-pass problems, like 821.
	 * Shortest Distance to a Character. They have almost the same idea. One
	 * forward pass and one backward pass. Maybe another pass to get the final
	 * result, or you can merge it in one previous pass.
	 * 
	 * Explanation: In this problem, we take one forward pass to count up hill
	 * length (to every point). We take another backward pass to count down hill
	 * length (from every point). Finally a pass to find max(up[i] + down[i] +
	 * 1) where up[i] and down[i] should be positives.
	 * 
	 * Time Complexity: O(N)
	 */
	public int longestMountain(int[] A) {
		int N = A.length, res = 0;
		int[] up = new int[N], down = new int[N];
		for (int i = N - 2; i >= 0; --i)
			if (A[i] > A[i + 1])
				down[i] = down[i + 1] + 1;
		for (int i = 0; i < N; ++i) {
			if (i > 0 && A[i] > A[i - 1])
				up[i] = up[i - 1] + 1;
			if (up[i] > 0 && down[i] > 0)
				res = Math.max(res, up[i] + down[i] + 1);
		}
		return res;
	}

}
