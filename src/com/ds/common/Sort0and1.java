package com.ds.common;

public class Sort0and1 {
	public static void main(String[] args) {

		int arr[] = {0,1,0,0,1,0,1,1,0};
		int j=0;
		int k =  arr.length-1;

		while(j<=k){
			if(arr[j]==0){
				j++;
			}else if(arr[j]==1){
				swap(arr,k,j);
				k--;
			}
		}
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	private static void swap(int arr[],int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

