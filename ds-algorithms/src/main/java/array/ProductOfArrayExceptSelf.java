package array;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given an array nums of n integers where n > 1, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Input: [1,2,3,4] Output: [24,12,8,6] Constraint: It's guaranteed that the
 * product of the elements of any prefix or suffix of the array (including the
 * whole array) fits in a 32 bit integer.
 * 
 * Note: Please solve it without division and in O(n).
 * 
 * Follow up: Could you solve it with constant space complexity? (The output
 * array does not count as extra space for the purpose of space complexity
 * analysis.)
 *
 */
public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		int[] nums = { 4};
		System.out.println(Arrays.toString(productExceptSelf(nums)));

	}

	public static int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		//Arrays.fill(res,1);
		res[0]=1;
		for(int i=1;i<n;i++) {
			res[i] = res[i - 1] * nums[i - 1];
		}
		int prod =1;
		for(int i=n-2;i>=0;i--){
			prod *=nums[i+1];
			res[i]=res[i]*prod;
		}
		return res;
	}
}
