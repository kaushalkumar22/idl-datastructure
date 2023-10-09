package dynamicprogramming_knapshack01;

import java.util.Arrays;

//s1-s2=k
//s1+s2=sum
//-----------
//2*s1=sum+k
//s1 =(sum+k)/2
public class CountSubsetsDifferenceK {
	public static void main(String args[]) {
		int arr[] = {1,1,2,3};
		int k=1;
		System.out.println(countSubsetsDifferenceKOpt(arr,k));
		System.out.println(countSubsetsDifferenceK(arr,k));

	}
	public static int countSubsetsDifferenceKOpt(int nums[],int k) {
		int n=nums.length;
		int sum = Arrays.stream(nums).sum();
                     if(n==1&&sum==Math.abs(k)) return 1;
		int s =( sum+k)/2;
		int[] dp= new int [s+1];
		dp[0]=1;
		for(int i=1;i<=n;i++) {
			for(int j=s;j>=nums[i-1];j--){
				dp[j]=dp[j-nums[i-1]]+dp[j];
			}
		}
		return dp[s];
	}

	public static int countSubsetsDifferenceK(int nums[],int k) {

		int n=nums.length;
		int sum = Arrays.stream(nums).sum();
        if(n==1&&sum==Math.abs(k)) return 1;

		int s =( sum+k)/2;
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
}

