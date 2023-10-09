package array;

/**
 * Given an array of integers and an integer k, you need to find the total
 * number of continuous subarrays whose sum equals to k.
 * 
 * Example 1:
 * 
 * Input:nums = [1,1,1], k = 2 Output: 2
 *
 Constraints:

 1 <= nums.length <= 2 * 104
 -1000 <= nums[i] <= 1000
 -107 <= k <= 107

 * 
 */
public class SubarraySumEqualsK {
	public static void main(String[] args) {
		int[] nums = { 2,6,4,8,10,9,15};
		System.out.println(subarraySum(nums,18));
		System.out.println(subarraySum1(nums,18));
	}
	public static int subarraySum(int[] nums, int k) {
		int count = 0;
		int[] sum = new int[nums.length + 1];
		sum[0] = 0;
		for (int i = 1; i <= nums.length; i++)
			sum[i] = sum[i - 1] + nums[i - 1];
		for (int start = 0; start < nums.length; start++) {
			for (int end = start + 1; end <= nums.length; end++) {
				if (sum[end] - sum[start] == k)
					count++;
			}
		}
		return count;
	}
	public static int subarraySum1(int[] nums, int k) {
		int count = 0;
		for (int start = 0; start < nums.length; start++) {
			int sum=0;
			for (int end = start; end < nums.length; end++) {
				sum+=nums[end];
				if (sum == k)
					count++;
			}
		}
		return count;
	}
}

