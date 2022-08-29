package array;

import java.util.Arrays;

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
       System.out.println(Arrays.toString(nextPermutation(new int[]{1,5,1})));
	}
	public static int[] nextPermutation(int[] nums) {
		int n =nums.length,i,j;
		for( i =n-2;i>=0;i--) {
			if(nums[i]<nums[i+1]) {
				break;
			}
		}
		if(i<0) {
			reverse(nums,0,n-1);
		}else {
			for(j=n-1;j>i;j--) {
				if(nums[j]>nums[i]) {
					break;
				}
			}
			swap(nums, i, j);
			reverse(nums,i+1,n-1);
		}
		return nums;

	}
	private static void reverse(int[] nums,int left,int right) {
		while(left<right) {
			swap(nums,left, right);
			left++;
			right--;
		}
	}
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
