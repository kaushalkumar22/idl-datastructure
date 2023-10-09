package dynamicprogramming_knapshack01;

/**
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target,
 * S. Now you have 2 symbols + and -. For each integer, you should choose one
 * from + and - as its new symbol. Find out how many ways to assign symbols to
 * make sum of integers equal to target S. Example 1: Input: nums is [1, 1, 1,
 * 1, 1], S is 3. Output: 5 Explanation:
 *
 * -1+1+1+1+1 = 3 
 * +1-1+1+1+1 = 3 
 * +1+1-1+1+1 = 3 
 * +1+1+1-1+1 = 3 
 * +1+1+1+1-1 = 3
 *
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 *
 */
public class TargetSum {
	public static void main(String[] args) {
         int nums[] = {1, 1, 1, 1, 1}, t = 3;
		 new TargetSum().findTargetSumWays(nums,  t);
	}
	public int findTargetSumWays(int[] nums, int t) {
		int sum = 0;
		int n =nums.length;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if(n==1&&sum!=Math.abs(t)) return 0;

		if(t > sum || (sum + t) % 2 == 1)   return 0;
		System.out.println(targetSumRec(nums, 0,n,(sum + t) / 2));
		System.out.println(subsetSum(nums, (sum + t) / 2));

		return subsetSum(nums, (sum + t) / 2);
	}

	private int targetSumRec(int[] nums, int i,int n,int s) {
		if(s==0) return 1;

		if(i==n) return 0;

		int res =0;
		if(nums[i]<=s){
			res = targetSumRec(nums, i+1,n,s-nums[i])+targetSumRec(nums, i+1,n,s);
		}
      return res;
	}

	private int subsetSum(int[] nums, int s) {
		int n = nums.length;
		int[] dp = new int[s + 1];
		dp[0] = 1;
		for (int num : nums) {
			for (int i = s; i >= num; i--) {
				dp[i] = dp[i - num] + dp[i];
			}
		}
		return dp[s];
	}


}
