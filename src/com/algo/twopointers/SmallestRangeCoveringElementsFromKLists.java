package com.algo.twopointers;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * You have k lists of sorted integers in non-decreasing order. Find the
 * smallest range that includes at least one number from each of the k lists.
 * 
 * We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a
 * < c if b - a == d - c.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]] Output: [20,24]
 * Explanation: List 1: [4, 10, 15, 24,26], 24 is in range [20,24]. List 2: [0,
 * 9, 12, 20], 20 is in range [20,24]. List 3: [5, 18, 22, 30], 22 is in range
 * [20,24].
 * 
 * Example 2:
 * 
 * Input: nums = [[1,2,3],[1,2,3],[1,2,3]] Output: [1,1]
 * 
 * Example 3:
 * 
 * Input: nums = [[10,10],[11,11]] Output: [10,11]
 * 
 * Example 4:
 * 
 * Input: nums = [[10],[11]] Output: [10,11]
 * 
 * Example 5:
 * 
 * Input: nums = [[1],[2],[3],[4],[5],[6],[7]] Output: [1,7]
 * 
 * 
 * 
 * Constraints:
 * 
 * nums.length == k 1 <= k <= 3500 1 <= nums[i].length <= 50 -105 <= nums[i][j]
 * <= 105 nums[i] is sorted in non-decreasing order.
 * 
 * 
 * @author IBM
 *
 */
public class SmallestRangeCoveringElementsFromKLists {

	public static void main(String[] args) {
		List<List<Integer>> nums = Arrays.asList(Arrays.asList(1,2,3),Arrays.asList(1,2,3),Arrays.asList(1,2,3));
		System.out.println(Arrays.toString(smallestRange(nums)));
	}

	public static int[] smallestRange(final List<List<Integer>> nums) {
		final Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
		final int[] res = new int[] { (int) -1e5, (int) 1e5 };
		int right = (int) -1e5;

		for (int i = 0; i < nums.size(); i++) {
			pq.offer(new int[] { nums.get(i).get(0), i, 0 });
			right = Math.max(right, nums.get(i).get(0));
		}

		while (!pq.isEmpty()) {
			final int[] cur = pq.poll();
			final int left = cur[0];
			final int list = cur[1];
			final int indice = cur[2];

			if (right - left < res[1] - res[0]) {
				res[0] = left;
				res[1] = right;
			}

			if (indice + 1 == nums.get(list).size()) {
				return res;
			}

			right = Math.max(right, nums.get(list).get(indice + 1));

			pq.offer(new int[] { nums.get(list).get(indice + 1), list, indice + 1 });
		}

		return new int[] {};
	}
}
