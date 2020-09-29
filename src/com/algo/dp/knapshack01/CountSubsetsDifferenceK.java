package com.algo.dp.knapshack01;

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
		System.out.print(countSubsetsDifferenceK(arr,k));

	}
	public static int countSubsetsDifferenceK(int arr[],int k) {

		int n=arr.length;
		int sum = Arrays.stream(arr).sum();
        if(n==1&&sum==Math.abs(k)) return 1;

		int s =( sum+k)/2;
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

