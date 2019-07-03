package com.ds.sorting;

public class SortArrayWithoutSecondLoop {
	//Given an array containing (0..n-1) but in random order, 
	//you can only loop through the array once and use swap operation, please sort the array.


	public static void main(String[] args) {

		int a[] = {3, 1, 2, 5, 7, 8, 4, 0, 9, 6,11,10};

		sortArray(a, a.length);

		for(int i = 0; i < a.length; i ++){
			System.out.println(a[i]+" ");
		}
	}

	static void sortArray(int a[], int len){
		for(int i = 0; i < len; ){
			if( a[i] != i){
				int t = a[a[i]];
				a[a[i]] = a[i];
				a[i] = t;
			}else{
				i++;
			}
		}
	}
}
