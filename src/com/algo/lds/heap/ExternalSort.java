package com.algo.lds.heap;

public class ExternalSort {

	public static void main(String[] args) {

		int M1[] = {30, 40, 50};
		int M2[] = {35, 45} ;
		int M3[] = {60, 10, 70, 80, 100};
		heapSort(M3);
		printArray(M3);
	}
	private static void heapSort(int arr[]){

		int n= arr.length;
		for(int i=n/2-1;i>=0;i--){
			heapify(arr,n,i);
		}
		//extractRoot(arr, n);

	}
	private static void heapify(int arr[], int n, int i){

		int left = 2*i+1;
		int right = 2*i+2;
		int smalest =i;

		if(left<n&&arr[left]<arr[smalest]){
			smalest = left;
		}
		if(right<n&&arr[right]<arr[smalest]){
			smalest=right;
		}
		if(smalest!=i){
			swap(arr, smalest, i);
			heapify(arr, n, smalest);
		}

	}
	private static void extractMin(int arr[],int n){

		for(int i=n-1;i>=0;i--){
			swap(arr, i,0);
			heapify(arr, i, 0);
		}
	}

	private static void swap(int arr[], int largest, int i){

		int temp = arr[i];
		arr[i] = arr[largest];
		arr[largest] = temp;
	}

	private static void printArray(int arr[]){

		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+ " ");	
		}
		System.out.println();
	}
}
