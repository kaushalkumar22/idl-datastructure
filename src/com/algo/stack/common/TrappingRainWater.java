package com.algo.stack.common;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In
 * this case, 6 units of rain water are being trapped.
 * 
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6 Here is my idea: instead of
 * calculating area by height*width, we can think it in a cumulative way. In
 * other words, sum water amount of each bin(width=1). Search from left to right
 * and maintain a max height of left and right separately, which is like a
 * one-side wall of partial container. Fix the higher one and flow water from
 * the lower part. For example, if current height of left is lower, we fill
 * water in the left bin. Until left meets right, we filled the whole container.
 * 
 *
 */
public class TrappingRainWater {

	public static void main(String[] args) {
		int[] nums= {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(nums));
	}
	public static int trap(int[] nums) {
		int left=0;
		int right=nums.length-1;
		int trappedWater=0;
		int leftmax=0;
		int rightmax=0;
		while(left<=right){
			leftmax  = Math.max(leftmax,nums[left]);
			rightmax = Math.max(rightmax,nums[right]);
			
			/*
			 * rightmax will make sure there is a boundary from right side which is having
			 * max height and there is a boundary from left side leftmax so anything smaller
			 * fall between these means upto that height water can be trap.
			 */
			if(leftmax<=rightmax){// leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
				trappedWater= trappedWater + (leftmax-nums[left]);  
				left++;
			}else{
				trappedWater= trappedWater+(rightmax-nums[right]);
				right--;
			}
		}
		return trappedWater;
	}
}
