package twopointers;

import java.util.Arrays;

/**
 * Given an array of integers A sorted in non-decreasing order, return an array
 * of the squares of each number, also in sorted non-decreasing order.
 * 
 * Input: [-4,-1,0,3,10] Output: [0,1,9,16,100]
 * 
 * Input: [-7,-3,2,3,11] Output: [4,9,9,49,121]
 *
 */
public class SquaresOfASortedArray {

	public static void main(String[] args) {
		int[] A = {-7,-3,2,3,11};
		System.out.println(Arrays.toString(sortedSquares(A)));
	}
	//take two pointer left and right  and compare values of both index
	//which one is greater put at the end of a new array repeat the same
	public static int[] sortedSquares(int[] A) {

		int left=0;
		int right = A.length-1;
		int[] result =new int[A.length];
		int c =A.length-1;
		while(left<=right) {
			if(Math.abs(A[left])>Math.abs(A[right])) {
				result[c--]=A[left]*A[left];
				left++;
			}else {
				result[c--]=A[right]*A[right];
				right--;
			}
		}
		return result;

	}
	public int maxArea(int[] height) {
		int left =0;
		int right = height.length-1;
		int leftMax = 0;
		int rightMax=0;
		int maxWater=0;
		while(left<right){
			leftMax=Math.max(leftMax,height[left]);
			rightMax=Math.max(rightMax,height[right]);
			maxWater=Math.max(maxWater,Math.min(leftMax,rightMax)*(right-left));
			if(leftMax<rightMax){
				left++;
			}else{
				right--;
			}

		}
		return maxWater;
	}
}

