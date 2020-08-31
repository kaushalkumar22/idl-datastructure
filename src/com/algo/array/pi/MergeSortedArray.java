package com.algo.array.pi;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * 
 * The number of elements initialized in nums1 and nums2 are m and n
 * respectively. You may assume that nums1 has enough space (size that is
 * greater or equal to m + n) to hold additional elements from nums2.
 * 
 * Input: nums1 = [1,2,3,0,0,0], m = 3 nums2 = [2,5,6], n = 3
 * 
 * Output: [1,2,2,3,5,6]
 *
 */
public class MergeSortedArray {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 0, 0, 0 }, nums2 = { 2, 5, 6 };
		int m = 3, n = 3;
		merge(nums1, m, nums2, n);
		System.out.println(Arrays.stream(nums1).boxed().collect(Collectors.toList()));
	}

	/*
	 * the main idea of this algo is start iterating from end of both array and
	 * append at end of A. take 3 vars i j and k, k will point at end of A if any
	 * greater number add at k and decrement k
	 * 
	 * Time complexity O(n)
	 */
	static void merge(int A[], int m, int B[], int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		while (i >= 0 && j >= 0) {
			if (A[i] > B[j]) {
				A[k] = A[i];
				k--;
				i--;
			} else {
				A[k] = B[j];
				k--;
				j--;
			}
		}
		while (j >= 0) {
			A[k] = B[j];
			k--;
			j--;
		}
	}
}
