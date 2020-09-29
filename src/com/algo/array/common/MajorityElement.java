package com.algo.array.common;

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

	/**
	 * Given an integer array of size n, find all elements that appear more than
	 * [ n/3 ]times.
	 * 
	 * Note: The algorithm should run in linear time and in O(1) space.
	 * 
	 * Example 1:
	 * 
	 * Input: [3,2,3] Output: [3] Example 2:
	 * 
	 * Input: [1,1,1,3,3,2,2,2] Output: [1,2]
	 * 
	 * @param nums
	 * @return
	 */
	public List<Integer> majorityElement2(int[] nums) {
		Integer major1 = null, major2 = null, cnt1 = 0, cnt2 = 0;
		for (Integer num : nums) {
			if (num.equals(major1)) {
				cnt1++;
			} else if (num.equals(major2)) {
				cnt2++;
			} else if (cnt1 == 0) {
				major1 = num;
				cnt1 = 1;
			} else if (cnt2 == 0) {
				major2 = num;
				cnt2 = 1;
			} else {
				cnt1--;
				cnt2--;
			}
		}

		cnt1 = cnt2 = 0;
		for (Integer num : nums) {
			if (num.equals(major1)) cnt1++;
			else if (num.equals(major2)) cnt2++;
		}

		List<Integer> result = new ArrayList<>();
		if (cnt1 > nums.length / 3) result.add(major1);
		if (cnt2 > nums.length / 3) result.add(major2);
		return result;
	}
}
