package com.ds.dynamicprogramming;

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {

		//int arr[] = { 5,6,2,3,4,1,9,1,2,3,4,5,4,7,8,9,8,9,5,7,8,11};
		int arr[] = { 5,6,2,-3,4,-1,6,8,11,7,21};
		int n = arr.length;
		int length= LIS( arr, n );
		System.out.println("Length of LCS is:"+ length );	
	}
	public static int LIS(int A[],int n){

		int[] LIS = new int[n+1];
		int max =0;
		for(int i=0;i<n;i++){
			LIS[i] = 1;
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<i;j++){
				if(A[i]>A[j]&&LIS[i]<LIS[j]+1){
					LIS[i]=LIS[j]+1;
				}
			}
		}
		for(int i=0;i<n;i++){
			if(max<LIS[i])
			{
				max =LIS[i];
			}

		}
		return max;
	}
}
