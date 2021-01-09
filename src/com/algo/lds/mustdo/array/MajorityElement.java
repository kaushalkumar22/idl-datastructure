package com.algo.lds.mustdo.array;

import java.util.ArrayList;
/*Given an array of size n, find the element which occurs more than n/2 times. 
 * This element is called Majority Element.
 */
import java.util.Arrays;
import java.util.List;
/**
 * Given an array of size n, find the majority element. The majority element
 * is the element that appears more than [ n/2 ] times.
 * 
 * You may assume that the array is non-empty and the majority element
 * always exist in the array.
 * 
 * Input: [3,2,3] Output: 3
 * 
 * Input: [2,2,1,1,1,2,2] Output: 2
 */
public class MajorityElement {
	
	public static void main(String[] args) {

		int[] array = { 2, 6, 2, 2, 6, 2, 2, 8, 2, 1 };
		System.out.println(Arrays.toString(array) + " \nMajority Element: " + majorityElement(array));
	}
	// Boyer-Moore Vote Algorithm
	public static int majorityElement(int[] num) {

		int major = num[0], count = 1;
		for (int i = 1; i < num.length; i++) {
			if (major == num[i]) {
				count++;	
			} else if (count == 0) {
				count++;
				major = num[i];
			} else
				count--;

		}
		return major;
	}
}