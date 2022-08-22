package com.algo.binarysearch;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted in ascending from left to right. Integers in
 * each column are sorted in ascending from top to bottom.
 * 
 * matrix={ 
 * {1, 4,  7, 11, 15}, 
 * {2, 5,  8, 12, 19}, 
 * {3, 6,  9, 16, 22}, 
 * {10,13, 14,17, 24},
 * {18,21, 23,26, 30} 
 * }
 * 
 * Given target = 5, return true.
 * 
 * Given target = 20, return false.
 *
 */
public class SearchA2DMatrixII {

	public static void main(String[] args) {
		int[][] matrix={ 
				{1, 4,  7,  11, 15}, 
				{2, 5,  8,  12, 19}, 
				{3, 6,  9,  16, 22}, 
				{10,13, 14, 17, 24},
				{18,21, 23, 26, 30} 
		};
		int target=90;
		System.out.println(searchMatrix(matrix,  target));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		int row=matrix.length;
		if(row==0) return false;
		int col= matrix[0].length;
		int i =0;
		int j=col-1;
		while(i<=j) {
			if(matrix[i][j]==target) {
				return true;
			}else if(matrix[i][j]<target) {
				int low =i+1;
				int high=row-1;
				while(low<=high) {
					int mid = low+(high-low)/2;
					if(matrix[mid][j]==target) {
						return true;
					}else if(matrix[mid][j]>target) {
						high=mid-1;
					}else {
						low=mid+1;
					}
					
				}
				j--;
			}else {
				j--;
			}
			
		}
		return false;
	}
}
