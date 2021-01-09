package com.algo.lds.mustdo.array;

/**
 * Given a positive 32-bit integer n, you need to find the smallest 32-bit
 * integer which has exactly the same digits existing in the integer n and is
 * greater in value than n. If no such positive 32-bit integer exists, you need
 * to return -1.
 * 
 * Input: 12 Output: 21
 * 
 * Input: 21 Output: -1
 *
 * 
 */
public class NextGreaterElementIII {

	public static void main(String[] args) {
		int number = 1999999999;
		System.out.println("Next greater number is: " + nextGreaterElement(number));
	}
	/*
	 * Iterate from right side and find the arr[i] <arr[i+1]
	 * after finding arr[i] swap with arr[j] where arr[i]<arr[j]
	 * and then reverse(arr,i+1,length-1)
	 */
	public static int nextGreaterElement(int n) {
		char[] arr = String.valueOf(n).toCharArray();

		int i = arr.length - 2;
		while (i >= 0 && arr[i] >= arr[i + 1])
			i--;

		if (i < 0)
			return -1;

		int j = arr.length - 1;
		while (arr[j] <= arr[i])// 4450241
			j--;

		swap(arr, i, j);
		reverse(arr, i + 1, arr.length - 1);

		try {
			return Integer.valueOf(String.valueOf(arr));// I/P:1999999999:9199999999 outof range
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static void reverse(char[] arr, int i, int j) {
		int l = i, h = j;
		while (l < h)
			swap(arr, l++, h--);
	}
}
