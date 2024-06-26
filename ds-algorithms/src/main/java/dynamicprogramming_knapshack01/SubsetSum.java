package dynamicprogramming_knapshack01;
/**
 * 
 * Given a non-empty array containing only positive integers,and a target sum S find if the array
 * is having a subset sum equal to S, if yes return true otherwise return false
 * subsets is equal.
 * 
 * Input: [2, 3, 7, 8,10],S=11
 * 
 * Output: true
 * 
 * Explanation: The array can have subset  as [8,3]
 * 
 * Input: [1, 2, 3, 5],S=12
 * 
 * Output: false
 * 
 *
 */
public class SubsetSum {
	public static void main(String args[]) {
		int nums[] = {2, 3, 7, 8,10};
		//int nums[] = {1, 2, 3, 5};
		int s=15;
		System.out.print(subsetSum(nums, s));
		System.out.print(subsetSumOpt(nums, s));
		System.out.print(subsetSumRec(nums, s,0,nums.length));

	}
	public static boolean subsetSumRec(int nums[], int s,int i ,int n) {

		if (s == 0)
			return true;
		if (i==n )
			return false;

        boolean res = false;

		if(nums[i]<=s) {
			res = subsetSumRec(nums, s - nums[i], i + 1, n) || subsetSumRec(nums, s, i + 1, n);
		}
		return res;
	}
	public static boolean subsetSumRec1(int nums[], int s,int n) {

		if (s == 0)
			return true;
		if (n == 0)
			return false;

		if(nums[n-1]<=s) {
			return subsetSumRec1(nums, s-nums[n-1], n-1)||subsetSumRec1(nums, s,n-1);
		}else {
			return subsetSumRec1(nums,s,n-1);
		}
	}

	public static boolean subsetSum(int nums[], int s) {

		int n=nums.length;
		boolean[][] T= new boolean[n+1][s+1];
		for(int i=0;i<n;i++) {
			T[i][0]=true;
		}

		for(int i=1;i<=n;i++) {
			for(int j=1;j<=s;j++) {

				if(nums[i-1]<=j) {
					T[i][j]=T[i-1][j-nums[i-1]]||T[i-1][j];
				}else {
					T[i][j]=T[i-1][j];
				}
			}
		}
		return T[n][s];
	}
	public static boolean subsetSumOpt(int nums[], int s) {

		int n = nums.length;
		boolean[] dp= new boolean[s+1];
		dp[0] = true;
		for(int num:nums){
			for(int i=s;i>=num;i--) {
					dp[i] =dp[i-num]|| dp[i];
			}
		}
		return dp[s];
	}
}
