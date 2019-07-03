package com.ds.common;

public class FindMedianOf2SortedArrays {

	public static void main(String[] args) {
		int ar1[] = {900};
		int   ar2[] = {5, 8, 10, 20};
		//findMedianSortedArrays(ar1, ar1.length, ar2,ar2.length) ;
		System.out.println(findMedianSortedArrays(ar1, ar1.length, ar2,ar2.length) );
	}

	static double findMedianSortedArrays(int A[], int m, int B[], int n) {

		if (m > n) 
			return findMedianSortedArrays(B, n, A, m);

		int minIndex = 0, maxIndex = m, i=0, j=0, num1=0,num2;
		int	mid = (m + n + 1)/2;

		while (minIndex <= maxIndex){

			i = (minIndex + maxIndex)/2;
			j = mid - i;
			if (i< m && j>0 && B[j-1] > A[i]) {
				minIndex = i + 1;
			} else if (j<n && i>0 && A[i-1]>B[j]) {
				maxIndex = i - 1;
			}else{

				if (i == 0) {
					num1 = B[j-1];
				}else if (j == 0) {
					num1 = A[i - 1];
				}else {
					num1 = Math.max(A[i-1],B[j-1]);
				}
				break;
			}
		}
		if( (m + n) % 2 == 1) {
			return num1;
		}

		if (i == m) { 
			num2 = B[j];
		}else if (j == n) {
			num2 = A[i];
		}else {
			num2 = Math.min(A[i],B[j]);
		}
		return (num1 + num2) / 2.;
	}
}