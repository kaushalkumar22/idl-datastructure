package xyz_bitmanipulation;

/**
 * Given a non-empty array of integers nums, every element appears twice except
 * for one. Find that single one.
 * 
 * Follow up: Could you implement a solution with a linear runtime complexity
 * and without using extra memory?
 * 
 * Input: nums = [2,2,1] Output: 1
 * Input: nums = [4,1,2,1,2] Output: 4
 * Input: nums = [1] Output: 1
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 3 * 104 -3 * 104 <= nums[i] <= 3 * 104 Each element in
 * the array appears twice except for one element which appears only once.
 *
 * 
 */
public class SingleNumber {
	public static void main(String[] args) {
		System.out.println(singleNumber(new int[] {4,1,2,1,2}));
	}
	static int singleNumber(int A[]) {
		int n =A.length;
		int result = 0;
		for (int i = 0; i<n; i++)
		{
			result ^=A[i];
		}
		return result;
	}
}
