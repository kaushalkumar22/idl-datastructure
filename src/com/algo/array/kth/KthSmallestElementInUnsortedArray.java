package com.algo.array.kth;

import java.util.Arrays;

/**
 * 1) Divide arr[] into n/5 groups where size of each group is 5 except possibly
 * the last group which may have less than 5 elements.
 * 
 * 2) Sort the above created n/5 groups and find median of all groups. Create an
 * auxiliary array 'median[]' and store medians of all n/5 groups in this median
 * array. 
 * // Recursively call this method to find median of median[0..n/5-1]
 * 3)medOfMed = kthSmallest(median[0..n/5-1], n/10) 
 * 4) Partition arr[] around medOfMed and obtain its position. pos = partition(arr, n, medOfMed) 
 * 5) If pos == k return medOfMed 
 * 6) If pos > k return kthSmallest(arr[l..pos-1], k) 7) If pos < k return kthSmallest(arr[pos+1..r], k-pos+l-1)
 * 
 * @author IBM
 * for kth largest just replace the k with n-k
 */
public class KthSmallestElementInUnsortedArray {

	public static void main(String[] args) {
		int arr[] = { 12, 3, 5, 7, 4, 19, 26 };
		int n = arr.length, k = 5;
		System.out.println(k+"th smallest element is " + kthSmallest(arr, 0, n - 1, k-1));
		System.out.println(k+"th smallest element is " + kthSmallest(arr, n, k));

	}

	private static int kthSmallest(int[] arr, int start, int end,int k) {
		if(start<=end) {
			int pIndex = partioning(arr,start,end);
			if(pIndex>k) {
				return kthSmallest(arr, start,pIndex-1,k );
			}else if(pIndex<k) {
				return kthSmallest(arr, pIndex+1,end,k );
			}else
				return arr[pIndex];
		}
		return arr[0];
	}
	private static int partioning(int[] arr, int start, int end) {

		int pIndex=start;
		int pivot =arr[end];
		for(int i=start;i<=end;i++) {
			if(arr[i]<pivot) {
				swap(arr,i,pIndex);
				pIndex++;
			}
		}
		swap(arr,pIndex,end);
		return pIndex;
	}

	private static void swap(int[] arr, int i, int pIndex) {
		int temp=arr[i];
		arr[i]=arr[pIndex];
		arr[pIndex]=temp;
	}
	
	//Time complexity of this solution is O(n + kLogn).
	private static int kthSmallest(int[] arr, int n, int k) { 

			minHeap(arr);	// Build a heap of n elements: O(n) time 	  		
			for(int i=n-1;i>n-k;i--){ // Do extract min (k-1) times 
				swap(arr,i,0);
				minHeapify(arr, i, 0);		
			}
			return arr[0];// Return root 
		} 
		private static void minHeap(int arr[]){

			int n= arr.length;
			for(int i=n/2-1;i>=0;i--){
				minHeapify(arr,n,i);
			}
		}
		private static void minHeapify(int[] arr,int n,int i) 
		{ 
			int l = 2*i+1; 
			int r = 2*i+2; 
			int min = i; 
			if (l < n && arr[l]<arr[min]) 
				min = l; 
			if (r < n && arr[r]<arr[min]) 
				min = r; 
			if (min != i) { 
				swap(arr,i, min); 
				minHeapify(arr,n,min); 
			} 
		}

}
