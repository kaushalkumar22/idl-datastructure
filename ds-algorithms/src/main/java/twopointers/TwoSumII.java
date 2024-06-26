package twopointers;

import java.util.Arrays;

/**
 * Given an array of integers that is already sorted in ascending order, find
 * two numbers such that they add up to a specific target number.
 *<p>
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2.
 *<p>
 * Note:
 *<p>
 * Your returned answers (both index1 and index2) are not zero-based. You may
 * assume that each input would have exactly one solution and you may not use
 * the same element twice.
 * <p>
 * Input: numbers = [2,7,11,15], target = 9 Output: [1,2] Explanation: The sum
 * of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 *
 *
 */
public class TwoSumII {
	public static void main(String[] args) {
		int numbers[] = {2,7,11,15}, target = 9;
		System.out.println(Arrays.toString(twoSum(numbers,target)));
	}
	public static int[] twoSum(int[] numbers, int target) {
		int[] res = new int[2];
		int low =0;
		int high = numbers.length-1;
		while(low<high) {
			int sum =numbers[low]+numbers[high];
			if(sum>target) {
				high--;
			}else if (sum<target) {
				low++;
			}else{
				res[0]=++low;
				res[1]=++high;
				break;
			}
		}
		return res;
	}
}
