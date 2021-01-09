package com.algo.lds.mustdo.binarysearch;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. The first integer of each
 * row is greater than the last integer of the previous row.
 * 
 * Input: matrix = 
 * [ 
 * [1,  3,  5,   7], 
 * [10, 11, 16, 20],
 * [23, 30, 34, 50] 
 * ] 
 * target = 3 Output: true
 * target = 13 Output: false
 */
public class SearchA2DMatrix {
	public static void main(String[] args) {
		int[][] matrix = {
				{1,   3,  5,  7},
				{10, 11, 16, 20},
				{23, 30, 34, 50}
		};
		int target=13;
		System.out.println(searchMatrix(matrix,  target));
	}
	public static boolean searchMatrix(int[][] matrix, int target) {
		int row = matrix.length;
		if(row==0) return false;
		int col =matrix[0].length;
		int low =0;
		int high= row*col-1;
		while(low<=high) {
			int mid =low+(high-low)/2;
			int midValue = matrix[mid/col][mid%col];
			if(midValue==target) {
				return true;
			}else if(midValue>target) {
				high=mid-1;
			}else {
				low=mid+1;
			}
		}
		return false;

		}


	}
