package dynamicprogramming_knapshack01;
/**
 * 
 * Given a non-empty array containing only positive integers,and a target sum S find if the array
 * is having subset sum equal to S, Count the Subsets.
 * 
 * Input: [2, 3, 5,6,8,10], S=10
 * 
 * Output: 3
 * 
 * Explanation: Subsets are [2,3,5],[2,8],[10]

 * 
 */
public class CountSubsetsSum {
	public static void main(String args[]) {
		int arr[] = {2, 3, 5,6,8,10};
		int s=10;
		System.out.println(countSubsetSum(arr, s));
		System.out.println(countSubsetSumOpt(arr, s));

	}

	public static int countSubsetSum(int nums[], int s) {

		int n=nums.length;
		int[][] dp= new int[n+1][s+1];
		for(int i=0;i<n;i++) {
			dp[i][0]=1;
		}

		for(int i=1;i<n+1;i++) {
			for(int j=1;j<s+1;j++) {

				if(nums[i-1]<=j) {
					dp[i][j]=dp[i-1][j-nums[i-1]]+dp[i-1][j];
				}else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[n][s];

	}
	public static int countSubsetSumOpt(int nums[], int s) {

		int n=nums.length;
		int[] dp= new int[s+1];
		dp[0]=1;
		for(int i=1;i<=n;i++) {
			for(int j=s;j>=nums[i-1];j--) {
				dp[j]=dp[j-nums[i-1]]+dp[j];
			}
		}
		return dp[s];
	}
}

