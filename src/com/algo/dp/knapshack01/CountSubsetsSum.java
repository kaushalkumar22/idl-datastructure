package com.algo.dp.knapshack01;
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
		System.out.print(subsetSum(arr, s));

	}
	public static int subsetSum(int arr[], int s) {

		int n=arr.length;
		int[][] T= new int[n+1][s+1];
		for(int i=0;i<n;i++) {
			T[i][0]=1;
		}

		for(int i=1;i<n+1;i++) {
			for(int j=1;j<s+1;j++) {

				if(arr[i-1]<=j) {
					T[i][j]=T[i-1][j-arr[i-1]]+T[i-1][j];
				}else {
					T[i][j]=T[i-1][j];
				}
			}
		}
		return T[n][s];

	}
}

