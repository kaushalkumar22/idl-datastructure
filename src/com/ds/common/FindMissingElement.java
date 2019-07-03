package com.ds.common;

public class FindMissingElement {

	public static void main(String[] args) {
		int[] arr={1,2,3,4,5,7};
		System.out.println(getMissingEle(arr));
	}

private static int getMissingEle(int arr[]){
	
	int i;
	int x1 = arr[0];
	int x2 = 1;
	int n =arr.length;
	for(i=1;i<n;i++){
		x1=x1^arr[i];
	}
	for(i=2;i<=n+1;i++){
		x2=x2^i;
	}
	
	return (x1^x2);
	
}
}