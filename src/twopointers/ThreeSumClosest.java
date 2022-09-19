package twopointers;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 *<p>
 * Given array nums = [-1, 2, 1, -4], and target = 1. The sum that is closest to
 * the target is 2. (-1 + 2 + 1 = 2).
 *<p>
 * Input:[2,7,11,15],3 Output:20 Explanation: 2+7+11=20
 *
 */
public class ThreeSumClosest {

	public static void main(String[] args) {
		int arr[] = { -1, 2, 1, -4 };
		int target = 1;
		System.out.println(threeSumClosest(arr, target));
	}

	public static int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length < 3)
			return -1;
		Arrays.sort(nums);
		int closest = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length - 1; i++) {

			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == target)
					return sum;
				if (Math.abs(sum - target) < Math.abs(closest - target)) {
					closest = sum;
				}
				if (sum > target) {
					right--;
				} else {
					left++;
				}
			}
		}
		return closest;
	}
}
