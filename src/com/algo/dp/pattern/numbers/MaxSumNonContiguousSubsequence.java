package com.algo.dp.pattern.numbers;

public class MaxSumNonContiguousSubsequence {

	public static void main(String[] args) {

		int arr[] = { 1,-3,4,-2,-1,6,12,7};
		int n = arr.length;
		int length= maxSumNonContiguousSubsequence( arr, n );
		System.out.println("MaxSum is:"+ length );
		System.out.println("MaxSum is:"+ maxSum( arr) );
	}
	 public static int maxSum(int arr[]) {
	        int excl = 0;
	        int incl = arr[0];
	        for (int i = 1; i < arr.length; i++) {
	            int temp = incl;
	            incl = Math.max(excl + arr[i], incl);
	            excl = temp;
	        }
	        return incl;
	}
	public static int maxSumNonContiguousSubsequence(int A[],int n){

		int[] M = new int[n+1];
		M[0]=A[0];
		if(A[0]>A[1]){
			M[1]=A[0];
		}else{
			M[1]=A[1];
		}
		for(int i=2;i<n;i++){
			if(M[i-1]>M[i-2]+A[i]){
				M[i]=M[i-1];
			}else{
				M[i]=M[i-2]+A[i];
			}
		}
		return M[n-1];
	}
}
