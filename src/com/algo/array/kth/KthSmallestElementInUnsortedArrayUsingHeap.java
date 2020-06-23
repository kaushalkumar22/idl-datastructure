package com.algo.array.kth;
//Time complexity of this solution is O(n + kLogn).
public class KthSmallestElementInUnsortedArrayUsingHeap {

	public static void main(String[] args) {
		int arr[] = {5,12, 3, 19, 7 };     
		int n = arr.length, k = 2; 
		printArray(arr);
		kthSmallest(arr,n,k);
		printArray(arr);
		System.out.println(k+"th smallest element is " + kthSmallest(arr, n, k));
	}

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

	private static void swap(int arr[], int min, int i){

		int temp =arr[i];
		arr[i] =arr[min];
		arr[min]=temp;
	}	
	private static void printArray(int arr[]){

		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+ " ");	
		}
		System.out.println();
	}
}


