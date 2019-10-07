package com.ds.binarysearch;

public class FindElementSortedRotatedArrayWithoutPivot {
    
    // Find an element in a sorted rotated array without finding pivot
    public static int findElementUsingBinarySearch(int[] array, int num) {
        if(array == null || array.length == 0) {
            return -1;
        }
         
        int start = 0;
        int end = array.length-1;
         
        while(start <= end) {
             
            int mid = (start + end)/2;
            if(num == array[mid]) {
                return mid;
            } 
             
            if(array[start] <= array[mid]) {  // array[start...mid] is sorted
 
                if(array[start] <= num && num <= array[mid]) { // num lies between array[start...mid]
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            } else {   // array[mid...end] is sorted
                 
                if(array[mid] <= num && num <= array[end]) { // num lies between array[mid...end]
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
        }
         
        return -1;
    }
     
    public static void main(String[] args) {
        {
            int array[] = { 56, 58, 67, 76, 21, 32, 37, 40, 45, 49 };
            findElementUsingBinarySearchTest(array, 45);
        }
    }
 
    private static void findElementUsingBinarySearchTest(int[] array, int num) {
        System.out.println("Element " + num + " found at = " + findElementUsingBinarySearch(array, num));
    }
 
}
