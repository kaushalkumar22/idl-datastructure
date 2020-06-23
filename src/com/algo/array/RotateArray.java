package com.algo.array;

/**Given an array and a positive integer k, rotate the array k times.
Example:
Array:  1 2 3 4 5
k: 1
Output: 2 3 4 5 1
if k > n?
Example:
array: 1 2 3 4 5
k = 8
Then after 8 rotations, the array will be:
4 5 1 2 3
which is same as rotating the array 3 times (k%n = 8%5 = 3)
 */
public class RotateArray {

	// Rotate array by using reversing operation on the array
	// O(n) time, O(1) space
	public static void rotateArrayUsingReverse(int[] arr, int k) {

		if(k < 0) {
			throw new IllegalArgumentException("k cannot be negative!");
		}

		if(arr == null || arr.length < 2) {
			return;
		}
		System.out.println(k);
		int n = arr.length;
		if(k > n){
			k = k%n;
		}
		reverseArray(arr, 0, k-1);
		reverseArray(arr, k, n-1);
		reverseArray(arr, 0, n-1);
	}

	// Reverse an array between start (s) and end (e)
	private static void reverseArray(int[] array, int s, int e) {

		int mid = (e+s)/2;
		for(int i=s;i<=mid;i++){
			int tmp = array[i];
			array[i] = array[e-i+s];
			array[e-i+s] = tmp;
		}
	}

	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5,6}; 
		int k = 3;
		System.out.println("Original Array: "); 
		rotateArrayUsingReverse(arr, k);
		System.out.println("After Rotation " + k + " times using reversal: ");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}

}
