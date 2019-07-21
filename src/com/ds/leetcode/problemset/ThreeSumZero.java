package com.ds.leetcode.problemset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * The solution set must not contain duplicate triplets.
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
time complexity O(nlon(n))
 * @author IBM
 *
 */
public class ThreeSumZero {
	public static void main (String[] args) { 
		int arr[] = {-1,0,1,2,-1,-4}; 
		System.out.println(threeSum(arr)); 
	} 
	//25 ms	48.3 MB
	public static List<List<Integer>> threeSum(int[] nums) {

		Arrays.sort(nums); 
		List<List<Integer>> triplets = new ArrayList<List<Integer>>();

		for(int i = 0; i<nums.length-2; i++){

			if(nums[i]>0) break;//no need to move further if nums[i] is not -ve array is sorted so x+y+z>0

			if(i != 0 && nums[i] == nums[i-1]) continue;//if there are duplicate nums[i] then need to skip
			
			int low=i+1;
			int high=nums.length-1; 				

			while(low<high){	

				if(nums[i]+nums[low]+nums[high]==0){
					triplets.add(Arrays.asList(nums[i],nums[low],nums[high]));			
					while(low<high&&nums[low]==nums[low+1]) low++;//if there are duplicate need to skip and forward 
					while(low<high&&nums[high]==nums[high-1]) high--;//if there are duplicate need to skip and backward 

					low++;
					high--;
				}else if(nums[i]+nums[low]+nums[high]<0) {
					low++;
				}else
					high--;
			}                    
		}
		return triplets;
	}
}
