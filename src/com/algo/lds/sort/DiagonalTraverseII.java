package com.algo.lds.sort;

/**
 * 
 * Given a list of lists of integers, nums, return all elements of nums in
 * diagonal order as shown in the below images.
 * 
 * Input: nums = [[1,2,3],[4,5,6],[7,8,9]] Output: [1,4,2,7,5,3,8,6,9]
 * 
 * Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]] Output:
 * [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
 *  
 * Input: nums = [[1,2,3],[4],[5,6,7],[8],[9,10,11]] Output:
 * [1,4,2,5,3,8,6,9,7,10,11]
 *  
 * Input: nums = [[1,2,3,4,5,6]] Output: [1,2,3,4,5,6]
 * 
 */
public class DiagonalTraverseII {
public static void main(String[] args) {
		
		int[][] matrix = {
				{ 1,2,3 }, 
				{ 4,5,6 }, 
				{ 7,8,9 } 
		};
		System.out.println("\nPrinting Matrix Diagonally");
		printMatrixDiagonally(matrix);
	}
	public static void printMatrixDiagonally(int[][] matrix) {

		int row, col;
		int rowCount = matrix.length;
		int columnCount = matrix[0].length;

		for (int k = 0; k < rowCount; k++) {
			for (row = k, col = 0; row >= 0 && col < columnCount; row--, col++) {
				System.out.print(matrix[row][col] + " ");
			}
			//System.out.println();
		}

		for (int k = 1; k < columnCount; k++) {
			for (row = rowCount - 1, col = k; row >= 0 && col < columnCount; row--, col++) {
				System.out.print(matrix[row][col] + " ");
			}
			
		}
	}

}
