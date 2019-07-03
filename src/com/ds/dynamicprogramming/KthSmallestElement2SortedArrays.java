package com.ds.dynamicprogramming;

public class KthSmallestElement2SortedArrays {

	public static void main(String[] args) {
		int[] arr1 = {1, 3, 8, 9, 15};
		int[] arr2 = {7, 11, 19, 21, 18, 25};
		int k=5;
		int x = arr1.length;
		int y = arr2.length;
		KthSmallestElement2SortedArrays mm = new KthSmallestElement2SortedArrays();
		System.out.println(mm.kthSmallestElement2SortedArrays(arr1,x,arr2, y,k));
	}
	private  int kthSmallestElement2SortedArrays(int[] arr1,int x,int[] arr2,int y,int k){

		if(x==0&&y>0) return arr2[k-1];
		if(k==1) return Math.min(arr1[0], arr2[0]);

		if(x>y)  kthSmallestElement2SortedArrays(arr2,y,arr1,x,k);

		int positionX = Math.min(x, k/2);
		int positionY = Math.min(y, k/2);

		if(arr1[positionX]>arr2[positionY]){
			return kthSmallestElement2SortedArrays(arr1,x,arr2,y-positionY,k-positionY);
		}else{
			return kthSmallestElement2SortedArrays(arr1,x,arr2,y-positionY,k-positionX);
		}

	}
}