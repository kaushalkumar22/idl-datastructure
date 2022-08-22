package com.algo.binarysearch;

public class KthSmallestElementInASortedMatrix {
	public static void main(String[] args) {

	}
	public int kthSmallest(int[][] A, int k) {
		int low = A[0][0];
		int high = A[A.length - 1][A[0].length - 1] + 1;//[lo, hi)
		while(low < high) {
			int mid = low + (high - low) / 2;
			int count = 0,  j = A[0].length - 1;
			for(int i = 0; i < A.length; i++) {
				while(j >= 0 && A[i][j] > mid) {
					j--;
				}
				count += (j + 1);
			}
			if(count < k) {
				low = mid + 1;
			}else {
				high = mid;
			}
		}
		return low;
	}
}

