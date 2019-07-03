package com.ds.sorting;
public class sortBinaryNo {
	public static void main(String[] args) {
		int arr[] = {0,1,1,1,0,0,1,1,0,0,0,1};
		binaryDigiteSort(arr,0,arr.length-1);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+",");
		}
	}
	private static void binaryDigiteSort(int[] data, int bottom, int top) {
		int pivot = top;				
		for (int i = top; i >=0; i--){
			if (data[i] != 0) {
				swap(data, pivot, i);
				pivot--;
			}
		}
	}
	private static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i]  = data[j];
		data[j]  = temp;
	}
}
