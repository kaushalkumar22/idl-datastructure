package array;

import java.util.Arrays;

import static array.RotateArray.reverse;

/**
 *
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 *
 * If such an arrangement is not possible, it must rearrange it as the lowest
 * possible order (i.e., sorted in ascending order).
 *
 * The replacement must be in place and use only constant extra memory.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3] Output: [1,3,2]
 *
 * Example 2:
 *
 * Input: nums = [3,2,1] Output: [1,2,3]
 *
 * Example 3:
 *
 * Input: nums = [1,1,5] Output: [1,5,1]
 *
 * Example 4:
 *
 * Input: nums = [1] Output: [1]
 *
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100 0 <= nums[i] <= 100
 *
 *
 *
 */
public class NextPermutation {
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}
	public static void nextPermutation(int[] nums) {
		int n = nums.length;
		int nextIndex = -1;
		for (int i = n - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				nextIndex = i;
				break;
			}
		}
		if (nextIndex == -1) {
			reverse(nums, 0, n - 1);
		} else {
			for (int i = n - 1; i > nextIndex; i--) {
				if (nums[i] > nums[nextIndex]) {
					int temp = nums[i];
					nums[i] = nums[nextIndex];
					nums[nextIndex] = temp;
					reverse(nums, nextIndex + 1, n - 1);
					break;
				}
			}

		}
	}
	static void  reverse(int[] nums,int low,int high){
		while(low++<high--){
			int temp = nums[low];
			nums[low]=nums[high];
			nums[high] = temp;
		}
	}
}

