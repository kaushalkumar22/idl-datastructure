package com.algo.dp.matrix;

public class PrintSortedOrderMatrix {

	public static void main(String[] args) {

		int matrix[][] = { 
				{10, 20, 30, 40},
				{15, 25, 35, 45},
				{27, 29, 37, 48},
				{32, 41, 46, 50},
		};
		printSortedOrderMatrix(matrix);
	}

	private static void printSortedOrderMatrix(int matrix[][]){

		int row = matrix.length;
		int col = matrix[0].length;
		int rArr[] = new int[row];

		for(int i=0;i<row;i++){
			rArr[i]=matrix[i][0];
		}
		for(int i=1;i<col;i++){
			for(int j=0;j<row;j++){
				System.out.print(getMinValue(rArr,matrix[j][i])+" ");
			}
		}
		for(int i=0;i<row;i++){			
			System.out.print(getMinValue(rArr,Integer.MAX_VALUE)+" ");
		}
	}
	private static int  getMinValue(int arrK[], int value){

		int k = arrK[0];
		arrK[0]  = value;
		int n= arrK.length;
		for(int i= (n-1)/2;i>=0;i--){
			heapify(arrK,n,i);
		}
		return k;
	}
	private static void heapify(int arr[], int n, int i){

		int left = 2*i+1;
		int right = 2*i+2;
		int smalest =i;

		if(left<n&&arr[left]<arr[smalest]){
			smalest = left;
		}
		if(right<n&&arr[right]<arr[smalest]){
			smalest=right;
		}
		if(smalest!=i){
			swap(arr, smalest, i);
			heapify(arr, n, smalest);
		}
	}
	private static void swap(int arr[], int largest, int i){

		int temp =arr[i];
		arr[i] =arr[largest];
		arr[largest]=temp;
	}
}

