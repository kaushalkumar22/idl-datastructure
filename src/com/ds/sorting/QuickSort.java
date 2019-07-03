package com.ds.sorting;

public class QuickSort {

	public static void main(String[] args) {

		int arr[] = {5,3,8,2,9,12,76,13,1,7,23};
		quickSort(arr, 0,arr.length-1);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+",");
		}
	}
	static void quickSort(int[] arr, int start,int end){

		if(start>=end) return;
		int pIndex = partition( arr,start,end);
		quickSort(arr,start,pIndex-1);
		quickSort(arr,pIndex+1,end);

	}
	public static int partition(int[] arr,int start,int end) {

		int pIndex =start;
		int pivot = arr[end];
		for(int i=start;i<=end;i++){
			if(arr[i]<pivot){
				swap(arr,i,pIndex);
				pIndex++;
			}
		}
		swap(arr,pIndex,end);
		return pIndex;

	}
	public static void swap(int[] arr,int index,int pIndex){

		int temp =arr[index];
		arr[index]=arr[pIndex];
		arr[pIndex]= temp;
	}
}



