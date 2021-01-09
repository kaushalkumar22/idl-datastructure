package com.algo.lds.heap;

public class KthLargestelement {

	public static void main(String[] args) {

		int ropes[] = {4, 3, 2, 6,13,9};
		
		printArray(ropes);
		maxHeap(ropes);
		System.out.println(getKthLargestelement(ropes,5));
		printArray(ropes);
	}

	private static int getKthLargestelement(int arr[],int k){
		
		for(int j=0,i=arr.length-1;i>=0&&j<k;i--,j++){
			swap(arr, i,0);
			heapify(arr, i, 0);
		}
		return arr[arr.length-k];
	}
	private static void maxHeap(int arr[]){

		int n= arr.length;
		for(int i=n/2-1;i>=0;i--){
			heapify(arr,n,i);
		}
	}
	private static void heapify(int arr[], int n, int i){

		int left = 2*i+1;
		int right = 2*i+2;
		int largest =i;

		if(left<n&&arr[left]>arr[largest]){
			largest = left;
		}
		if(right<n&&arr[right]>arr[largest]){
			largest=right;
		}
		if(largest!=i){
			swap(arr, largest, i);
			heapify(arr, n, largest);
		}
	}

	private static void swap(int arr[], int largest, int i){

		int temp =arr[i];
		arr[i] =arr[largest];
		arr[largest]=temp;
	}

	private static void printArray(int arr[]){

		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

}
