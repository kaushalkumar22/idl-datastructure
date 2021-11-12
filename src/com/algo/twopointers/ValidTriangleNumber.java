package com.algo.twopointers;

import java.util.Arrays;

public class ValidTriangleNumber {

	public static void main(String[] args) {
		int nums[] = {2,2,3,4};
		System.out.println(triangleNumber(nums));
	}
	public static int triangleNumber(int[] nums) {
	       if(nums==null||nums.length<3) return 0;
	       Arrays.sort(nums);
		   int count=0;
		   for(int i=0;i<nums.length-2;i++){
		       
			   int left =i+1;
			   int right =nums.length-1;
			   while(left<right){
				 if(nums[i]+nums[left]>nums[right]){
	                count+=right-left;  
	                right--;
				 }else{
				   left++;
				 }
			   }  
		   }
		   return count;
	    }
}
