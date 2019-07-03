package com.ds.common;

public class PivotInSortedRotatedArr {
	// O(n) solution - Linear Search
    public static int findPivotLinear(int[] array) {
        int pivot = -1;
 
        if (array != null && array.length > 0) {
 
            pivot = 0;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    pivot = i + 1;
                    break;
                }
            }
        }
        return pivot;
    }
 
    // O(log n) solution - Binary Search
    public static int findPivotBinarySearch(int[] arr) {
 
       int len = arr.length;
       if(arr==null||len==0){
    	   return -1;
       }
       if(len==1||arr[0]<arr[len-1]){
    	   return arr[0];
       }
       int start =0;
       int end = len-1;
       
       while(start<=end){
    	   int mid = (start+end)/2;
    	   if (mid < len-1 && arr[mid] > arr[mid+1]) {
               return (mid + 1);
           }else  if(arr[start]<arr[mid]){
    		   start =mid+1;
    	   }else{
    		   end =  mid-1;
    	   }
    	  
       }
        return 0;
    }
 
    public static void main(String[] args) {
 
        int array[] = {40,50,60,70,80,10,20,30 };
        findPivotLinearTest(array);
        findPivotBinarySearchTest(array);
       
       
    }
 
    public static void findPivotLinearTest(int array[]) {
        int index = findPivotLinear(array);
        System.out.println("Pivot "
                + (index >= 0 ? (" found at index " + array[index]) : " not found!"));
    }
 
    public static void findPivotBinarySearchTest(int array[]) {
        int index = findPivotBinarySearch(array);
        System.out.println("Pivot "
                + (index >= 0 ? (" found at index " + array[index]) : " not found!"));
    }
}
        
