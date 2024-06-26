package binarysearch_miscellaneous;

/**
 * 
 * Given an integer array sorted in ascending order, write a function to search
 * target in nums. If target exists, then return its index, otherwise return -1.
 * However, the array size is unknown to you. You may only access the array
 * using an ArrayReader interface, where ArrayReader.get(k) returns the element
 * of the array at index k (0-indexed).
 * 
 * You may assume all integers in the array are less than 10000, and if you
 * access the array out of bounds, ArrayReader.get will return 2147483647.
 * 
 * Input: array = [-1,0,3,5,9,12], target = 9 Output: 4 Explanation: 9 exists in
 * nums and its index is 4
 * 
 * Input: array = [-1,0,3,5,9,12], target = 2 Output: -1 Explanation: 2 does not
 * exist in nums so return -1
 * Note:
 * 
 * You may assume that all elements in the array are unique. The value of each
 * element in the array will be in the range [-9999, 9999]
 *
 */
public class SearchInASortedArrayOfUnknownSize {

	public static void main(String[] args) {
		int[] nums = {-1,0,3,5,9,12};
		int target=9;
		System.out.println(search(nums,target));
	}

	private static int search(int[] A, int target) {

		int start =0;
		int end=1;
		while(target>A[end]) {
			start =end;
			end=2*end;
		}

		while(start<=end) {
			int mid = start+(end-start)/2;
			if(A[mid]==target) {
				return mid;
			}else if(A[mid]>target) {
				end =mid-1;
			}else {
				start=mid+1;
			}
		}
		return -1;
	}

}

