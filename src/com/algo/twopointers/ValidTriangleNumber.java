package com.algo.twopointers;

import java.util.Arrays;

public class ValidTriangleNumber {

	public static void main(String[] args) {
		int nums[] = {2,2,3,4};
		//int nums[] = {2,3,4,4};

		System.out.println(triangleNumber(nums));
	}
	
	public static int triangleNumber(int[] nums) {
		if(nums==null||nums.length<3) return 0;
		Arrays.sort(nums);
		int count=0;	 
		int n = nums.length;
		for (int i=n-1;i>=2;i--) {
			int low = 0, right = i-1;
			while (low < right) {
				if (nums[low] + nums[right] > nums[i]) {
					count += right-low;
					right--;
				}else {
					low++;
				}
			}
		}
		return count;
	}
}
