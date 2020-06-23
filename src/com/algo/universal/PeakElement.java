package com.algo.universal;

/**
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array nums, where nums[i] != nums[i+1], find a peak element and
 * return its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 * 
 * You may imagine that nums[-1] = nums[n] = -9999999999999999.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,1] Output: 2 Explanation: 3 is a peak element and your
 * function should return the index number 2. Example 2:
 * 
 * Input: nums = [1,2,1,3,5,6,4] Output: 1 or 5 Explanation: Your function can
 * return either index number 1 where the peak element is 2, or index number 5
 * where the peak element is 6.
 *
 */
public class PeakElement {

	//recurcive
	int findPeakElement(int[] num) {
		return Helper(num, 0, num.length-1);
	}

	int Helper(int[] num, int low, int high)
	{
		if(low == high)
			return low;
		else
		{
			int mid1 = (low+high)/2;
			int mid2 = mid1+1;
			if(num[mid1] > num[mid2])
				return Helper(num, low, mid1);
			else
				return Helper(num, mid2, high);
		}
	}

	//Binary Search: iteration

	int findPeakElement2(int[] num) 
	{
		int low = 0;
		int high = num.length-1;

		while(low < high)
		{
			int mid1 = (low+high)/2;
			int mid2 = mid1+1;
			if(num[mid1] < num[mid2])
				low = mid2;
			else
				high = mid1;
		}
		return low;
	}

	//Sequential Search:
	static int findPeakElement3(int[] num) {
		for(int i = 1; i < num.length; i ++)
		{
			if(num[i] < num[i-1])
			{// <
				return i-1;
			}
		}
		return num.length-1;
	}


	public static void main(String[] args) {
		int[] array = { 15, 20, 25, 35, 45, 20, 60 };
		Integer peak = findPeakElement3(array);
		System.out.println(peak != null ? "Peak Element is " + peak : "No peak element!");
	}
}