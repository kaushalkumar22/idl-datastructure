package com.ds.common;

public class MissingNumberInDuplicateArray {
	 
  
    private static void findMissingNumber(int[] array1, int[] array2) {
        int result = array1[0];
        for (int i = 1; i < array1.length ; i++) {
            result = result ^ array1[i];
            System.out.println(result);
        }
        for (int i = 0; i < array2.length ; i++) {
            result = result ^ array2[i];
        }
        System.out.println("Missing element = " + result);
    }
 
    public static void main(String[] args) {
        int[] array1 = {9, 7, 8, 5, 4, 6, 2, 3, 1};
        int[] array2 = {2, 3, 4, 9, 1, 8, 5, 6};
        findMissingNumber(array1, array2);
    }
}