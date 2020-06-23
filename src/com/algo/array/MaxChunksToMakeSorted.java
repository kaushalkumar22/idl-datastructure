package com.algo.array;

public class MaxChunksToMakeSorted {

	/**
	 * 
	 * Given an array arr that is a permutation of [0, 1, ..., arr.length - 1],
	 * we split the array into some number of "chunks" (partitions), and
	 * individually sort each chunk. After concatenating them, the result equals
	 * the sorted array.
	 * 
	 * What is the most number of chunks we could have made?
	 * 
	 * Example 1:
	 * 
	 * Input: arr = [4,3,2,1,0] Output: 1 Explanation: Splitting into two or
	 * more chunks will not return the required result. For example, splitting
	 * into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't
	 * sorted. Example 2:
	 * 
	 * Input: arr = [1,0,2,3,4] Output: 4 Explanation: We can split into two
	 * chunks, such as [1, 0], [2, 3, 4]. However, splitting into [1, 0], [2],
	 * [3], [4] is the highest number of chunks possible.
	 *
	 * ===========
	 * 
	 * The basic idea is to use max[] array to keep track of the max value until
	 * the current position, and compare it to the sorted array (indexes from 0
	 * to arr.length - 1). If the max[i] equals the element at index i in the
	 * sorted array, then the final count++.
	 * 
	 * the numbers range from 0 to arr.length - 1. So there is no need to sort
	 * the arr, we can simply use the index for comparison. Now this solution is
	 * even more straightforward with O(n) time complelxity.
	 * 
	 * 
	 * original: 0, 2, 1, 4, 3, 5, 7, 6 max: 0, 2, 2, 4, 4, 5, 7, 7 sorted: 0,1,
	 * 2, 3, 4, 5, 6, 7 index: 0, 1, 2, 3, 4, 5, 6, 7 The chunks are: 0 | 2, 1 |
	 * 4, 3 | 5 | 7, 6
	 * 
	 */
	public int maxChunksToSorted(int[] arr) {
		if (arr == null || arr.length == 0)
			return 0;

		int count = 0, max = 0;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
			if (max == i) {
				count++;
			}
		}

		return count;
	}

	/**
	 * This question is the same as "Max Chunks to Make Sorted" except the
	 * integers of the given array are not necessarily distinct, the input array
	 * could be up to length 2000, and the elements could be up to 10**8.
	 * 
	 * Given an array arr of integers (not necessarily distinct), we split the
	 * array into some number of "chunks" (partitions), and individually sort
	 * each chunk. After concatenating them, the result equals the sorted array.
	 * 
	 * What is the most number of chunks we could have made?
	 * 
	 * Example 1:
	 * 
	 * Input: arr = [5,4,3,2,1] Output: 1 Explanation: Splitting into two or
	 * more chunks will not return the required result. For example, splitting
	 * into [5, 4], [3, 2, 1] will result in [4, 5, 1, 2, 3], which isn't
	 * sorted. Example 2:
	 * 
	 * Input: arr = [2,1,3,4,4] Output: 4 Explanation: We can split into two
	 * chunks, such as [2, 1], [3, 4, 4]. However, splitting into [2, 1], [3],
	 * [4], [4] is the highest number of chunks possible.
	 * 
	 * ==========
	 * Algorithm: Iterate through the array, each time all elements to the left
	 * are smaller (or equal) to all elements to the right, there is a new
	 * chunck. Use two arrays to store the left max and right min to achieve
	 * O(n) time complexity. Space complexity is O(n) too. This algorithm can be
	 * used to solve ver1 too.
	 */

	public int maxChunksToSortedII(int[] arr) {
		int n = arr.length;
		int[] maxOfLeft = new int[n];
		int[] minOfRight = new int[n];

		maxOfLeft[0] = arr[0];
		for (int i = 1; i < n; i++) {
			maxOfLeft[i] = Math.max(maxOfLeft[i - 1], arr[i]);
		}

		minOfRight[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			minOfRight[i] = Math.min(minOfRight[i + 1], arr[i]);
		}

		int res = 0;
		for (int i = 0; i < n - 1; i++) {
			if (maxOfLeft[i] <= minOfRight[i + 1])
				res++;
		}

		return res + 1;
	}
}
