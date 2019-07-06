package com.ds.kinarray;
//Time complexity of this solution is O(n + kLogn).
public class KthLargestElementInUnsortedArrayUsingHeap {

	public static void main(String[] args) {
		int arr[] = {5,12, 3, 19, 7 };     
		int n = arr.length, k = 3;    
		kthLargest(arr,n,k);
		System.out.println(k+"th largest element is " + kthLargest(arr, n, k));
	}
	private static int kthLargest(int[] arr, int n, int k) {    
		maxHeap(arr);	 // Build a heap of n elements: O(n) time 	     
		for(int i=n-1;i>n-k;i--){ // Do extract max (k-1) times 
			swap(arr,i,0);
			maxHeapify(arr, i, 0);		
		}
		return arr[0];//return root
	} 

	private static void maxHeap(int arr[]){

		int n= arr.length;
		for(int i=n/2-1;i>=0;i--){
			maxHeapify(arr,n,i);
		}
	}

	private static void maxHeapify(int[] arr,int n,int i) { 
		int l = 2*i+1; 
		int r = 2*i+2; 
		int max = i; 
		if (l < n && arr[l]>arr[max]) 
			max = l; 
		if (r < n && arr[r] > arr[max]) 
			max = r; 
		if (max != i) { 
			swap(arr,i, max); 
			maxHeapify(arr,n,max); 
		} 
	}

	private static void swap(int arr[], int largest, int i){

		int temp =arr[i];
		arr[i] =arr[largest];
		arr[largest]=temp;
	}	
}
