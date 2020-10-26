package com.algo.twopointers;

import java.util.Arrays;

public class Sort0and1 {
	public static void main(String[] args) {

		int arr[] = {0,1,0,0,1,0,1,1,0};
		sort01(arr);
		System.out.println(Arrays.toString(arr));	
	}
	private static void sort01(int arr[]){
		int j=0;
		int n =  arr.length;
		for(int i=0;i<n;i++) {
			if(arr[i]==0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j++;
			}
		}
	}
}

