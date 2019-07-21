package com.ds.leetcode.problemset;
/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, 
 * which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. 
In this case, the max area of water (blue section) the container can contain is 49.

Input: [1,8,6,2,5,4,8,3,7]
Output: 49

 *
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] height= {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(height));
	}
	static int maxArea(int[] arr) {
		int water = 0;
		int left = 0, right = arr.length - 1;
		while (left < right) {
			int height = Math.min(arr[left], arr[right]);
			water = Math.max(water, (right - left) * height);
			while (left < right && arr[left] <= height) left++;
			while (left < right && arr[right] <= height) right--;
		}
		return water;
	}
}
