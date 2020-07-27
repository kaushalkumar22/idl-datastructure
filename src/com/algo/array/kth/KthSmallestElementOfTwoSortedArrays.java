package com.algo.array.kth;

import java.util.Arrays;

/**
 * Find Kth Smallest Element of Two Sorted Arrays 
 * 
 * Given two sorted arrays nums1 and nums2 of size m and n respectively and an int k. 
 * Find the k-th smallest element of these arrays. 
 * 
 * Note that it is the k-th smallest element in the sorted order, not the k-th distinct element.
 * 
 * Input: nums1 = [-2, -1, 3, 5, 6, 8], nums2 = [-1,0, 1, 2, 5, 9], k = 4 Output: 0
 * Explanation: Union of above arrays will be [-2, -1,-1,0,1, 2, 3, 5, 5, 6, 8,9]
 * and the 4th smallest element is 0 .
 * 
 * Input: nums1 = [2, 4], nums2 = [2,6], k = 2 Output: 2 Explanation: union of
 * above arrays will be [2,2, 4, 6] and the 1st smallest element is 2.
 * 
 * You may assume k is always valid, 1 <= k <= m + n.
 */


public class KthSmallestElementOfTwoSortedArrays {
	
	public static void main(String[] args) {
		 int arr1[] = { -2, -1, 3, 5, 6, 8 };
		 int arr2[] = { -1,0, 1, 2, 5, 9 };
		//int[] arr1 = { 3, 5, 7, 9 };
		//int[] arr2 = { 2, 4, 6, 8, 10, 12, 14 };
		int m = arr1.length;
		int n = arr2.length;
		int k = 6;
		System.out.println(kth(arr1, m, arr2, n, k));
		System.out.println(kthSmallest(arr1, arr2, k));
	}


	// O(logk)
	public static int kthSmallest(int X[], int Y[], int k) {

		int m = X.length;
		int n = Y.length;

		if (k < 1 || k > (m + n))
			return -1;

		if (m > n)
			return kthSmallest(Y, X, k);

		// if X is empty returning k-th element of Y
		if (m == 0)
			return Y[k - 1];

		m = Math.min(m, k);// if k is greater than m
		n = Math.min(n, k); // if k is greater than n
		int low = 0;
		int high = m;
		while (low <= high) {
			int pIndexX = (low + high) / 2;
			int pIndexY = Math.min(n, k - pIndexX);
			/*
			 * left_part                           | right_part 
			 * A[0], A[1], ..., A[i-1]             | A[i], A[i+1],
			 * ..., A[m-1] B[0], B[1], ..., B[j-1] | B[j], B[j+1], ..., B[n-1]
			 * size of (leftA+leftB) must be equal to k if not need to move
			 * further
			 */
			if ((pIndexX + pIndexY) != k) {
				low++;
				continue;
			}
			int maxLeftX = (pIndexX == 0) ? Integer.MIN_VALUE : X[pIndexX - 1];
			int minRightX = (pIndexX == m) ? Integer.MAX_VALUE : X[pIndexX];

			int maxLeftY = (pIndexY == 0) ? Integer.MIN_VALUE : Y[pIndexY - 1];
			int minRightY = (pIndexY == n) ? Integer.MAX_VALUE : Y[pIndexY];

			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				return Math.max(maxLeftX, maxLeftY);
			} else if (maxLeftX > minRightY) {
				high = pIndexX - 1;
			} else {
				low = pIndexX + 1;
			}
		}
		return -1;
	}

	static int kth(int arr1[], int m, int arr2[], int n, int k) {

		if (k < 1 || k > (m + n))
			return -1;

		// let m > n
		if (m > n)
			return kth(arr2, n, arr1, m, k);

		// if arr1 is empty returning k-th element of arr2
		if (m == 0)
			return arr2[k - 1];

		// if k = 1 return minimum of first two elements of both arrays
		if (k == 1)
			return Math.min(arr1[0], arr2[0]);

		// now the divide and conquer part
		int i = Math.min(m, k / 2);
		int j = Math.min(n, k / 2);

		if (arr1[i - 1] > arr2[j - 1]) {
			// Now we need to find only k-j th element
			// since we have found out the lowest j
			int temp[] = Arrays.copyOfRange(arr2, j, n);
			return kth(arr1, m, temp, n - j, k - j);
		}

		// Now we need to find only k-i th element
		// since we have found out the lowest i
		int temp[] = Arrays.copyOfRange(arr1, i, m);
		return kth(temp, m - i, arr2, n, k - i);
	}

	
}
