package com.algo.array;

/**
 * You are given a circular array nums of positive and negative integers. If a
 * number k at an index is positive, then move forward k steps. Conversely, if
 * it's negative (-k), move backward k steps. Since the array is circular, you
 * may assume that the last element's next element is the first element, and the
 * first element's previous element is the last element.
 * 
 * Determine if there is a loop (or a cycle) in nums. A cycle must start and end
 * at the same index and the cycle's length > 1. Furthermore, movements in a
 * cycle must all follow a single direction. In other words, a cycle must not
 * consist of both forward and backward movements.
 * 
 * Input: [2,-1,1,2,2] Output: true Explanation: There is a cycle, from index 0
 * -> 2 -> 3 -> 0. The cycle's length is 3.
 * 
 * Input: [-1,2] Output: false Explanation: The movement from index 1 -> 1 -> 1
 * ... is not a cycle, because the cycle's length is 1. By definition the
 * cycle's length must be greater than 1.
 * 
 * Input: [-2,1,-1,-2,-2] Output: false Explanation: The movement from index 1
 * -> 2 -> 1 -> ... is not a cycle, because movement from index 1 -> 2 is a
 * forward movement, but movement from index 2 -> 1 is a backward movement. All
 * movements in a cycle must follow a single direction.
 * 
 * Can you do it in O(n) time complexity and O(1) space complexity?
 */
public class CircularArrayLoop {

	public static void main(String[] args) {
		int[] nums = {2,-1,1,2,2};
		System.out.println(circularArrayLoop(nums));
	}

	public static boolean circularArrayLoop(int[] nums) {
		
		int len = nums.length;
		if (nums == null || len < 2) {return false;}

		/**
		 * Check every possible start location. We may start at a short-loop,
		 * for instance, but the Array may still contain a valid loop.
		 */
		for (int i = 0; i < len; i++) {
			/**
			 * We set elements to 0 which are on known non-loop paths. So, if we
			 * encounter a 0, we know we're not on a loop path. So, move to the
			 * next start location in the list.
			 */
			if (nums[i] == 0)
				continue;

			// Stagger our starts, so we don't conclude we've found a loop,
			// as we might otherwise when slow == fast.
			int slow = i;
			int fast = nextIndex(nums, slow);

			/**
			 * Whether i is positive or negative defines our direction, so if
			 * the directions differ, so too will the signs. If the signs
			 * differ, we can't be in a 'forward' or a 'backward' loop, so we
			 * exit the traverse.
			 */
			while (nums[i] * nums[fast] > 0 && nums[i] * nums[nextIndex(nums, fast)] > 0) {
				if (slow == fast) {
					if (slow == nextIndex(nums, slow))
						break; // 1-element loop
					return true;
				}
				slow = nextIndex(nums, slow);
				fast = nextIndex(nums, fast);
				fast = nextIndex(nums, fast );
			}

			/**
			 * If we're here, we didn't find a loop, so we know this path
			 * doesn't have a loop, so we re-traverse it until we reverse
			 * direction or encounter a '0' element. During the re-traverse, we
			 * set each element we see to 0.
			 */
			slow = i;
			int sgn = nums[i];
			while (sgn * nums[slow] > 0) {
				int next = nextIndex(nums, slow);
				nums[slow] = 0;
				slow = next;
			}
		}

		// We've tested the whole array and have not found a loop,
		// therefore there isn't one, so return false.
		return false;
	}
	
		 public static int nextIndex(int[] nums,int index) {
		        int n = nums.length;
		        return index + nums[index] >= 0? (index + nums[index]) % n: n + ((index + nums[index]) % n);
		    }
}
