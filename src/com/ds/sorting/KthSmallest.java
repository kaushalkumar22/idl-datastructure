package com.ds.sorting;
public class KthSmallest {

	public static void main(String[] args) {

		int arr[] = {55,5,3,8,2,9,12,76,13,1,7,23};
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+",");
		}
		System.out.println();
		int kthlargest = 7;
		//int kth =arr.length+1-kthlargest;
		quickSort(arr,0,arr.length-1,kthlargest);
		
	}
	public static void quickSort(int[] data, int bottom,int top,int kth){
		if (bottom <= top){
			
			int partitionPoint = partition(data, bottom, top);
			if(partitionPoint+1<kth){
				bottom = partitionPoint + 1;			
			}else{
				top = partitionPoint - 1;
			}
			quickSort(data, bottom, top,kth);
			if(partitionPoint+1==kth){
				System.out.println(kth + "th smallest :"+data[partitionPoint]);
				return;
			}
		}
	}
	protected static int partition(int[] data, int bottom, int top) {
		int pivot = data[top];				
		int midPtr = bottom;
		for (int i = bottom; i < top; i++) {
			if (data[i] <= pivot) {
				swap(data, midPtr, i);
				midPtr++;
			}
		}
		swap(data, midPtr, top);
		return midPtr;
	}
	protected static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i]  = data[j];
		data[j]  = temp;
	}
}



