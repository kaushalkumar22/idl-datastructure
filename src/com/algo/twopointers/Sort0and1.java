package com.algo.twopointers;

import java.util.Arrays;

public class Sort0and1 {
	public static void main(String[] args) {

		int arr[] = {0,1,0,0,1,0,1,1,0};
		sort01s(arr);
		System.out.println(Arrays.toString(arr));	
		System.out.println(Arrays.toString(arr));	
	}
	public static void sort01s(int[] nums) {
        int i=0,j=0;
        int n =nums.length;
        while(i<n&&j<n){
            if(nums[i]==0){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
                j++;
            }else{
                i++;
            }
        }
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

