package com.ds.sorting;

public class KthLargestSmallestInSortedArray {

	public static void main(String[] args) {

		int arr[]= {1,1,1,2,2,2,4,4,4,6,6,6,7,8,8,9};
		int kthsmallest =kThSmallest(arr,5);
		int kthlarhest=kThLargest(arr, 6);
		System.out.println("kthsmallest::"+kthsmallest);
		System.out.println("kthlarhest ::"+kthlarhest);
	}
	public static int kThSmallest(int[] arr, int kth){
		int count =0;
		int kthSmall=0;
		for(int i=1;i<arr.length;i++){
			if(arr[i]==arr[i-1]) 
				continue;
			else 
			{
				count++;
				if (count==kth-1){
					kthSmall=arr[i];
					break;
				}
			}
		}
		System.out.println(Runtime.getRuntime());
		return kthSmall;
	}
	public static int kThLargest(int[] arr, int kth){
		int count =0;
		int kthlarhest=0;
		
		for(int i=arr.length-1;i>=0;i--){
			if(arr[i]==arr[i-1]){ 
				continue;
			}else{
				count++;
				if (count==kth){
					kthlarhest = arr[i];
					break;
				}
			}
		}
		return kthlarhest;
	}
}
