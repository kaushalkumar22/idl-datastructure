package com.algo.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = k? 
 * Find all unique triplets in the array which gives the sum of k.
 * The solution set must not contain duplicate triplets.
 * Given array nums = [-1,0,1,2,-1,4], and target = 3.
 * output[[-1, 0, 4], [0, 1, 2]]
 *
 *
 */
public class TripletsSumK {
	public static void main (String[] args) { 
		int arr[] = {-1,0,1,2,-1,4}; 
		int k=3;
		System.out.println(threeSum(arr,k)); 
	} 
	public static List<List<Integer>> threeSum(int[] nums,int k) {

		Arrays.sort(nums); 
		List<List<Integer>> triplets = new ArrayList<List<Integer>>();

		for(int i = 0; i<nums.length-2; i++){

			if(i != 0 && nums[i] == nums[i-1]) continue;//if there are duplicate nums[i] then need to skip

			int low=i+1;
			int high=nums.length-1; 				

			while(low<high){	

				if(nums[i]+nums[low]+nums[high]==k){
					triplets.add(Arrays.asList(nums[i],nums[low],nums[high]));			
					while(low<high&&nums[low]==nums[low+1]) low++;//if there are duplicate need to skip and forward 
					while(low<high&&nums[high]==nums[high-1]) high--;//if there are duplicate need to skip and backward 

					low++;
					high--;
				}else if(nums[i]+nums[low]+nums[high]<k) {
					low++;
				}else
					high--;
			}                    
		}
		return triplets;
	}
}

