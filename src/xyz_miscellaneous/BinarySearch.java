package xyz_miscellaneous;

/**
 * Given a sorted (in ascending order) integer array nums of n elements and a
 * target value, write a function to search target in nums. If target exists,
 * then return its index, otherwise return -1.
 * 
 * Input: nums = [-1,0,3,5,9,12], target = 9 Output: 4 
 * Explanation: 9 exists in nums and its index is 4
 * 
 * Input: nums = [-1,0,3,5,9,12], target = 2 Output: -1 
 * Explanation: 2 does not exist in nums so return -1
 * 
 */
public class BinarySearch {

	public static void main(String[] args) {
		int[] nums = {-1,0,3,5,9,12};
		int target=9;
		System.out.println(search(nums,  target));
	}
	public static int search(int[] nums, int target) {

		int st= 0;
		int end = nums.length-1;
		while(st<=end){
			int mid = st+(end-st)/2;
			if(nums[mid]==target){
				return mid;
			}else if(nums[mid]<target){
				st= mid+1;
			}else{
				end=mid-1;
			}
		}
		return -1;
	}
}
