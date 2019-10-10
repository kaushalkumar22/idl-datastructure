package com.ds.twopointertechnique;
/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
    
    The main idea is based on greedy. Let's say the range of the current jump is [curBegin, curEnd], 
    curFarthest is the farthest point that all points in [curBegin, curEnd] can reach. Once the current point reaches curEnd, 
    then trigger another jump, and set the new curEnd with curFarthest, then keep the above steps, as the following:
 * @author I339640
 *
 */
public class JumpGame2 {

	public static void main(String[] args) {
		int arr[] ={2,3,4,2,1,1,4};
		System.out.println(jump(arr));
	}
	/**
	 * The main idea is,first we will identify the current range [curBegin(i), curEnd(nums[i])] let nums[0]=2 means we can 2 cell so  either at
	 * 3,4 because range is [0,2] then we chose from 3,4 which can make max jump so its 4 so my next range is  [curBegin(2), curEnd(nums[6])] 
	 */
	public static int jump(int[] nums) {
		int jumps = 0;
		int curEnd = 0; 
		int curFarthest = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			curFarthest = Math.max(curFarthest, i + nums[i]);
			if(curFarthest==nums.length - 1) return jumps+1;
			if (i == curEnd) {
				jumps++;
				curEnd = curFarthest;
			}
		}
		return jumps;
	}
}
