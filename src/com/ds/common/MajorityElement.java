package com.ds.common;

/*Given an array of size n, find the element which occurs more than n/2 times. 
 * This element is called Majority Element.
*/
import java.util.Arrays;

public class MajorityElement {
	// Boyer-Moore Vote Algorithm
    public static Integer getMajorityElement(int[] array) {
 
        if (array == null || array.length == 0) {
            return null;
        }
 
        // Step 1: Find max element
        Integer candidate = null;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (count == 0) {
                candidate = array[i];
                count = 1;
                continue;
            } else {
                if (candidate == array[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
 
        if (count == 0) {
            return null;
        }
 
        // Step 2: Check if candidate is majority element
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (candidate == array[i]) {
                count++;
            }
        }
        return (count > array.length / 2) ? candidate : null;
    }
 
    // Naive Algorithm
    public static Integer getMajorityElementNaive(int[] array) {
 
        if (array == null || array.length == 0) {
            return null;
        }
 
        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j]) {
                    count++;
                }
            }
            if (count > array.length / 2) {
                return array[i];
            }
        }
        return null;
    }
 
    public static void main(String[] args) {
 
        int[] array = { 2, 6, 2, 2, 6, 2, 2, 8, 2, 1 };
        System.out.println(Arrays.toString(array) + " \nMajority Element: " + getMajorityElement(array));
 
    }
}