package slidingwindow;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Given an array nums, there is a sliding window of size k which is moving from
 * the very left of the array to the very right. You can only see the k numbers
 * in the window. Each time the sliding window moves right by one position.
 * Return the max sliding window.
 * 
 * Example:
 * 
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3 Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
---------------               -----
 [1  3  -1] -3 5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 * 
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ input array's size for
 * non-empty array.
 *
 */
public class SlidingWindowMaximum {

	public static void main(String[] args) {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int[] result = maxSlidingWindow(nums, 3);
		System.out.println(Arrays.toString(result));
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		if (n == 0) return nums;
		int[] result = new int[n - k + 1];
		LinkedList<Integer> dq = new LinkedList<>();
		for (int i = 0; i < n; i++) {

			if (!dq.isEmpty() && dq.getFirst() < i - k + 1) {
				dq.removeFirst();
			}
			while (!dq.isEmpty() && nums[i] >= nums[dq.getLast()]) {
				dq.removeLast();
			}
			dq.addLast(i);
			if (i - k + 1 >= 0) {
				result[i - k + 1] = nums[dq.getFirst()];
			}
		}
		return result;
	}
}
