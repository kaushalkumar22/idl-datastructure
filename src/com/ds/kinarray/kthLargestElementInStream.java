package com.ds.kinarray;

public class kthLargestElementInStream {

	public static void main(String[] args) {
		int stream[] = {23,10,15,70,5,80,100};   
		int k = 3; 
		kthLargest(stream, k);	
	}
	private static void  kthLargest(int[] stream,int k) { 
		int count = 0;  
		int[] arr = new int[k]; 
		
		for(int i=0;i<stream.length;i++) {
			int x =stream[i];
			// Nothing much to do for first k-1 elements 
			if (count < k-1) { 
				arr[count] = x; 
				
			} else{ 
				// If this is k'th element, then store it and build the heap created above 
				if (count == k-1) { 
					arr[count] = x; 
					minHeap(arr);
				} else if (x > arr[0]) { // If next element is greater than k'th largest, then replace the root 
					arr[0]=x;
					minHeap(arr);
				} 
				System.out.println(k+"th largest element is "+arr[0]);					
			}
			count++; 
		} 
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
}