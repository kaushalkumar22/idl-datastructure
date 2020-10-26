package com.algo.heap;

public class IsMaxHeap {

	// Returns true if arr[i..n-1] represents a
	// max-heap
	static boolean isHeap(int arr[],  int n)
	{
		// Start from root and go till the last internal
		// node
		for (int i=0; i<(n-1)/2; i++)
		{
			// If left child is greater, return false
			if (arr[2*i +1] > arr[i])
				return false;

			// If right child is greater, return false
			if (arr[2*i+2] > arr[i])
				return false;
		}
		return true;
	}

	// Driver program
	public static void main(String[] args) {

		int arr[] = {90, 15, 10, 7, 12, 2, 7, 3};
		int n = arr.length;

		System.out.println(isHeap(arr, n)?"Yes":"No");

	}
}
