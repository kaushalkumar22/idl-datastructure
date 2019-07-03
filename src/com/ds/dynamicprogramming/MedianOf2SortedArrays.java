package com.ds.dynamicprogramming;

public class MedianOf2SortedArrays {

	public double findMedianSortedArrays(int arr1[], int arr2[]) {

		int x = arr1.length;
		int y = arr2.length;

		if(x>y) findMedianSortedArrays( arr2,  arr1);
		int start=0;
		int end = x;
		while(start<=end){
			int positionX = (start+end)/2;
			int positionY = (x+y+1)/2-positionX;

			int maxLeftX  = (positionX==0)?Integer.MIN_VALUE:arr1[positionX-1];
			int minRightX = (positionX==x)?Integer.MAX_VALUE:arr1[positionX];
			int maxLeftY  =	(positionY==0)?Integer.MIN_VALUE:arr2[positionY-1];	
			int minRightY = (positionY==y)?Integer.MAX_VALUE:arr2[positionY];

			if(maxLeftX<=minRightY&&maxLeftY<=minRightX){
				if((x+y)%2==0){
					return (double)(Math.max(maxLeftX,maxLeftY)+Math.max(minRightX,minRightY))/2;
				}else{
					return Math.max(maxLeftX,maxLeftY);
				}
			}else if(maxLeftY>minRightX){
				start=positionX+1;
			}else{
				start=positionX-1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] x = {1, 3, 8, 9, 15};
		int[] y = {7, 11, 19, 21, 18, 25};

		MedianOf2SortedArrays mm = new MedianOf2SortedArrays();
		System.out.println(mm.findMedianSortedArrays(x, y));
	}
}