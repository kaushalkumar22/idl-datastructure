package com.algo.sort;
/**
 * First Pass:
 *( 5 1 4 2 8 ) \to ( 1 5 4 2 8 ), Here, algorithm compares the first two elements, and swaps them.
 *( 1 5 4 2 8 ) \to ( 1 4 5 2 8 ), Swap since 5 > 4
 *( 1 4 5 2 8 ) \to ( 1 4 2 5 8 ), Swap since 5 > 2
 *( 1 4 2 5 8 ) \to ( 1 4 2 5 8 ), Now, since these elements are already in order (8 > 5), algorithm does not swap them.
 *Second Pass:
 *( 1 4 2 5 8 ) \to ( 1 4 2 5 8 )
 *( 1 4 2 5 8 ) \to ( 1 2 4 5 8 ), Swap since 4 > 2
 *( 1 2 4 5 8 ) \to ( 1 2 4 5 8 )
 *( 1 2 4 5 8 ) \to ( 1 2 4 5 8 )
 *Now, the array is already sorted, but our algorithm does not know if it is completed. The algorithm needs one whole pass without any swap to know it is sorted.
 *Third Pass:
 *( 1 2 4 5 8 ) \to ( 1 2 4 5 8 )
 *( 1 2 4 5 8 ) \to ( 1 2 4 5 8 )
 *( 1 2 4 5 8 ) \to ( 1 2 4 5 8 )
 *( 1 2 4 5 8 ) \to ( 1 2 4 5 8 )
 *
 */
public class BubbleSort {
	public static void main(String[] args) {
		int arr[]={45,4,3,9,6,1,7,0,5,2,8,43,12};
		int arrSize = arr.length;
		bubbleSort(arr,arrSize);
		System.out.print("SortedArray :");
		for(int i=0;i<arrSize;i++){
			System.out.print(" "+arr[i]);
		}
	}
	static void bubbleSort(int[] array, int n){ 
		for(int i = 0; i < n; i++)
			for (int j = 0; j<n-i-1 ; j++)
				if(array[j]>array[j+1])
					swap(array, j, j+1); 		
	} 
	static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i]  = data[j];
		data[j]  = temp;
	}
}
