package com.ds.sorting;

public class KthSmallestFrom2SortedArray {

	public static void main(String[] args) {

		int arr1[] = {2,3,5,7,9,13,15,21,22};
		int arr2[] = {3,4,6,10,12,14,17,25,43};
		int k = findKthSMallest(arr1, arr2, 9);
		System.out.println(k);
	}
	static 	int findKthSMallest(int[] A, int[] B, int k) {
		int a_offset = 0, b_offset = 0;
		if (A.length + B.length < k) 
			return -1;

		while (true) {
			if (a_offset < A.length) {
				while (b_offset == B.length ||
						A[a_offset] <= B[b_offset]) {
					a_offset++;
					if (a_offset + b_offset == k) 
						return A[a_offset];
				}
			}
			if (b_offset < B.length) {
				while (a_offset == A.length ||
						A[a_offset] >= B[b_offset]) {
					b_offset++;
				}
				if (a_offset + b_offset == k)
					return B[b_offset];
			}
		}
	}
}

