package com.algo.universal;

//Dutch National Flag Algorithm
public class Sort0s1s2s {

	public static void main(String[] args) {

		int arr[] = {0,1,0,2,2,0,1,1,0};
		int i=0,j=0;
		int k =  arr.length-1;

		while(j<=k){
			if(arr[j]==0){
				if(i!=j){
					swap(arr,i,j);
				}
				i++;
				j++;
			}else if(arr[j]==1){
				j++;
			}else if(arr[j]==2){
				swap(arr,j,k);
				k--;
			}
		}
		for(i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	private static void swap(int arr[],int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
