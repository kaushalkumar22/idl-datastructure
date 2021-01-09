package com.algo.ads.dp.numbers;

public class MaxSumContiguousSubsequence {
	public static void main(String[] args) {

		int arr[] = { -1,3,4,-2,-1,6,-9,12};
		int n = arr.length;
		System.out.println("MaxSum is:"+ maxSumContiguousSubsequence( arr, n ) );
		System.out.println(KadanesAlgorithm( arr));
	}
	public static int KadanesAlgorithm(int A[]){

		int globalMaxSum=Integer.MIN_VALUE;
		int localMaxSum=0;
		
		for (int i=0;i<A.length;i++) {
			localMaxSum=Math.max(A[i], localMaxSum+A[i]);
			globalMaxSum=Math.max(localMaxSum, globalMaxSum);
		}
		return globalMaxSum;

	}
	public static int maxSumContiguousSubsequence(int A[],int n){

		int[] subSetSum = new int[n];
		int maxSum =0;
		if(A[0]>subSetSum[0]){
			subSetSum[0]=A[0];
		}else{
			subSetSum[0]=0;
		}
		for(int i=1;i<n;i++){
			if(subSetSum[i-1]+A[i]>0){
				subSetSum[i]=subSetSum[i-1]+A[i];
			}else{
				subSetSum[i]=A[i];
			}
		}
		for(int i=1;i<n;i++){
			
			if(subSetSum[i]>maxSum){
				maxSum =subSetSum[i];
			}
		}
		return maxSum;
	}
}
