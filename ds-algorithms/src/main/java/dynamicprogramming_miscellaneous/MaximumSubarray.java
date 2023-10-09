package dynamicprogramming_miscellaneous;

/**
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4], Output: 6 Explanation: [4,-1,2,1] has the
 * largest sum = 6
 * 
 *
 */
public class MaximumSubarray {

	public static void main(String[] args) {
		int nums[] = {-2,-1,-3,-4,-1,-2,-1,-5};
				System.out.println(maxSubArray(nums));
				System.out.println(maxSubArray1(nums));
	}
	public static int maxSubArray(int[] A) {
		int n = A.length;
		int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
		dp[0] = A[0];
		int max = dp[0];

		for(int i = 1; i < n; i++){
			dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
			max = Math.max(max, dp[i]);
		}

		return max;
	}
	public static int maxSubArray1(int[] nums) {

		int max =nums[0];
		int sum =nums[0];
		for(int i=1;i<nums.length;i++){
			sum = nums[i]+(sum>0?sum:0);
			max =Math.max(sum,max);
		}
		return max;
	}
}
