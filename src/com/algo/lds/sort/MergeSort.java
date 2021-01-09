package com.algo.lds.sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String a[]){
		int i;
		int array[] = {12,9,4,99,120,1,3,5};

		System.out.println("Values Before the sort:\n");
		for(i = 0; i < array.length; i++)
			System.out.print( array[i]+"  ");
		System.out.println();
		mergeSort(array);
		System.out.print("Values after the sort:\n");
		for(i = 0; i <array.length; i++)
			System.out.print(array[i]+"  ");
	}
	public static void mergeSort(int arr[]){

		int length=arr.length;

		if(length<2) return;

		int mid = length/2;
		int arrL[] = new int[mid] ;
		int arrR[] = new int[length-mid] ;
		for(int i=0;i<mid;i++){		
			arrL[i]=arr[i];
		}
		for(int i=mid;i<length;i++){
			arrR[i-mid]=arr[i];
		}
		mergeSort(arrL);
		mergeSort(arrR);
		merge(arr,arrL,arrR);
	}
	public static void merge(int arr[],int arrL[], int arrR[]){

		int i=0,j=0,k=0;
		int left = arrL.length;
		int right = arrR.length;
		while(i<left&&j<right){
			if(arrL[i]<=arrR[j]){
				arr[k]=arrL[i];
				i++;
			}else{
				arr[k]=arrR[j];
				j++;

			}
			k++;
		}
		while(i<left){
			arr[k]=arrL[i];
			i++;
			k++;
		}
		while(j<right){
			arr[k]=arrR[j];
			j++;
			k++;
		}		
	}
	/*public static void mergeSort_srt(int array[],int lo, int n){
		int low = lo;
		int high = n;
		if (low >= high) {
			return;
		}
		int middle = (low + high) / 2;
		mergeSort_srt(array, low, middle);
		mergeSort_srt(array, middle + 1, high);
		int end_low = middle;
		int start_high = middle + 1;
		while ((lo <= end_low) && (start_high <= high)) {
			if (array[low] < array[start_high]) {
				low++;
			} else {
				int Temp = array[start_high];
				for (int k = start_high- 1; k >= low; k--) {
					array[k+1] = array[k];
				}
				array[low] = Temp;
				low++;
				end_low++;
				start_high++;
			}
		}
	}  */
}
