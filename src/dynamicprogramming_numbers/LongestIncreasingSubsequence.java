package dynamicprogramming_numbers;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		int arr[] = { 5, 6, 1, 7, 4 };
		int n = arr.length;
		System.out.println("Length of LCS is:" + lengthOfLIS(arr));
		System.out.println("Length of LCS is:" + lengthOfLIS1(arr));
	}

	public static int lengthOfLIS1(int A[]) {
		int n = A.length;
		int[] dp = new int[n + 1];
		int max = 0;
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (A[i] > A[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					max=Math.max(max, dp[i]);
				}
			}
		}

		return max;
	}


	//nlogn
	public static int lengthOfLIS(int[] nums) { 
		int n =nums.length;
		if(n<2) return n;
		int[] dp = new int[n];
		int count=1;
		dp[0]=nums[0];
		for(int i=1;i<n;i++) {
			if(dp[count-1]<nums[i]) {
				dp[count++]=nums[i];
			}else {
				int index = binarySearch(dp,0, count, nums[i]);
				dp[index] = nums[i];
			}
		}
		return n-count;
	}
	static int binarySearch(int[] A,int low, int high,int target) {
		while (low <high) {
			int mid = (low+high) / 2;
			if (A[mid] < target)
				low = mid + 1;
			else
				high = mid;
		}
		return low;
	}


}
