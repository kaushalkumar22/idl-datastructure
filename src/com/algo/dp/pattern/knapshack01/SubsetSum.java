package com.algo.dp.pattern.knapshack01;
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
		int arr[] = {1, 2, 5};
		int s=4;
		System.out.print(subsetSum(arr, s));

	}
	public static boolean subsetSum(int arr[], int s) {

		int n=arr.length;
		boolean[][] T= new boolean[n+1][s+1];
		for(int i=0;i<n;i++) {
			T[i][0]=true;
		}

		for(int i=1;i<n+1;i++) {
			for(int j=1;j<s+1;j++) {

				if(arr[i-1]<=j) {
					T[i][j]=T[i-1][j-arr[i-1]]||T[i-1][j];
				}else {
					T[i][j]=T[i-1][j];
				}
			}
		}
		return T[n][s];


	}




}
