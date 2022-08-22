package com.algo.array1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Given an array of integers, print the leaders in the array. A leader is an
 * element which is larger than all the elements in the array to its right.
 * 
 * For example: Input Array: { 98, 23, 54, 12, 20, 7, 27 } Output: Leaders- 27
 * 54 98
 */

public class LeaderElements {
	public static void main(String[] args) {
		int[] input = { 98, 23, 54, 12, 20, 7, 27 };
		System.out.println(leaders(input));
	}
	public static List<Integer> leaders(int[] nums) {
		List<Integer> res =new ArrayList<>();
		res.add(nums[nums.length-1]);
		int leader=nums[nums.length-1];
		for (int i =nums.length-2;i>=0;i--) {
			if(nums[i]>leader) {
				res.add(0,nums[i]);
				leader=nums[i];
			}
		}
		return res;
		
	}

	
}
