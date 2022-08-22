package xyz_miscellaneous;

/**
 * Your are given an array of positive integers nums.
 * 
 * Count and print the number of (contiguous) subarrays where the product of all
 * the elements in the subarray is less than k.
 * 
 * 
 * Input: nums = [10, 5, 2, 6], k = 100 Output: 8 Explanation: The 8 subarrays
 * that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2],
 * [2, 6], [5, 2, 6]. Note that [10, 5, 2] is not included as the product of 100
 * is not strictly less than k.
 * 
 * Note: 
 *  0 < nums.length <= 50000.
 *  0 < nums[i] < 1000. 
 *  0 <= k < 10^6.
 *
 */
public class SubarrayProductLessThanK {
	public static void main(String[] args) {
		int nums[] = {10, 5, 2, 6}, k = 100;
		System.out.println(numSubarrayProductLessThanK(nums, k));
	}
	public static int numSubarrayProductLessThanK(int[] nums, int k) {
		        if (k == 0) return 0;
		        int cnt = 0;
		        int pro = 1;
		        for (int i = 0, j = 0; j < nums.length; j++) {
		            pro *= nums[j];
		            while (i <= j && pro >= k) {
		                pro /= nums[i++];
		            }
		            cnt += j - i + 1;
		        }
		        return cnt;        
		    }

	}

