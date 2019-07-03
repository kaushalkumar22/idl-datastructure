package com.ds.dynamicprogramming;

public class SubsetSumIsK {

	public static void main(String[] args) {

		int arr[] = { 2,3,7,8,10};
		int k=15;
		//int length= subsetSumIsK( arr ,k);
		System.out.println("subsets of equal sum k is possible:"+ subsetSumIsK( arr ,k) );	
	}
	
	public static boolean subsetSumIsK(int arr[],int k){

		int n = arr.length;
		boolean[][] T = new boolean[n+1][k+1];

		for(int i=0;i<=n;i++){
			T[i][0]=true;
			System.out.println(T[i][0]);
		}
		for(int i=1;i<=n;i++){
			for(int j=1;j<=k;j++){
				
				if(j<arr[i-1]){
					T[i][j]=T[i-1][j];
				}else{
					if(T[i-1][j]==true){
						T[i][j]=T[i-1][j];
					}else{
						T[i][j]=T[i-1][j-arr[i-1]];
					}
				}
			}
		}
			
		return T[n][k];
	}
}

