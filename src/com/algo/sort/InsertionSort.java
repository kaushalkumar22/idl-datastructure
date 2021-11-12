package com.algo.sort;
/**
 * As in selection sort, the elements to the left of the current index are in sorted order 
 * during the sort, but they are not in their final position, as they may have to be moved 
 * to make room for smaller elements encountered later. 
 * we need to make space for the element being inserted by moving larger elements 
 * one position to the right, and then inserting the element into the vacated position. 
 * The array is, however,fully sorted when the index reaches the right end.
 * 
 * Original        34   8  64  51  32  21     Positions Moved
 *------------------------------------------------------------
 *pass  p
 *After p = 2      8  34  64  51  32  21             1
 *After p = 3      8  34  64  51  32  21             0
 *After p = 4      8  34  51  64  32  21             1
 *After p = 5      8  32  34  51  64  21             3
 *After p = 6      8  21  32  34  51  64             4
 *-----------------------------------------------------------
 * (n - 1) + (n - 2) + ... + 2 + 1 = n(n - 1) / 2 = O(n2)
 *
 *Worst case performance 	O(n2)
 *Best case performance 	O(n2)
 *Average case performance 	O(n2)
 *space complexity O(n+1)
 */
public class InsertionSort {
	public static void main(String[] args) {
		int arr[]={4,3,9,6,1,7,0,5,2,8};
		int arrSize = arr.length;
		insertionSort(arr,arrSize);
		System.out.print("SortedArray :");
		for(int i=0;i<arrSize;i++){
			System.out.print(" "+arr[i]);
		}
	}
	public static void insertionSort(int data[], int n){

		for (int i = 1; i < n; i++) {
			int target = data[i];
			int j;
			for (j = i - 1; (j >= 0) && (data[j] > target); j--) {
				data[j + 1] = data[j];
			}
			data[j + 1] = target;
		}
	}

}

