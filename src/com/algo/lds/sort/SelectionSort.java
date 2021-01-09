package com.algo.lds.sort;
/**
 * First, find the smallest element in the array, and exchange it with the element in the 
 * first position. Then, find the second smallest element and exchange it with the element
 * in the second position. Continue in this way until the entire array is sorted. 
 * This method is called selection sort because it works by repeatedly selecting the 
 * smallest remaining element
 * 
 * index	0	1	2	3	4	5	6	comments
 *--------------------------------------------------
 *    |	4	3	9	6	1	7	0	initial
 *i=0 |	0	3	9	6	1	7	4	swap 0,4
 *i=1 |	0	1	9	6	3	7	4	swap 1,3
 *i=2 |	0	1	3	6	9	7	4	swap 3, 9
 *i=3 |	0	1	3	4	9	7	6	swap 6, 4
 *i=4 |	0	1	3	4	6	7	9	swap 9, 6
 *i=5 |	0	1	3	4	6	7	9	(done)
 *--------------------------------------------------
 * (n - 1) + (n - 2) + ... + 2 + 1 = n(n - 1) / 2 = O(n2)
 *
 *Worst case performance 	O(n2)
 *Best case performance 	O(n2)
 *Average case performance 	O(n2)
 *space complexity O(n+1)
 */
public class SelectionSort {

	public static void main(String[] args) {
		int arr[]={4,3,9,6,1,7,0,5,2,8};
		int arrSize = arr.length;
		selectionSort(arr,arrSize);
		System.out.print("SortedArray :");
		for(int i=0;i<arr.length;i++){
			System.out.print(" "+arr[i]);
		}
	}
	public static void selectionSort(int array[], int n){
		for(int i=0; i<n; i++){
			int minIndex = i;
			for(int j=i+1; j<n; j++){
				if(array[minIndex]>array[j]){
					minIndex = j;
				}
			}
			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
	}

}
