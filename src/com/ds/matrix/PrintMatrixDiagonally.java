package com.ds.matrix;

public class PrintMatrixDiagonally {

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

	public static void main(String[] args) {
		
		int[][] matrix = {
				{ 3, 2, 8 }, 
				{ 1, 9, 7 }, 
				{ 0, 5, 2 }, 
				{ 6, 4, 3 } 
		};
		System.out.println("\nPrinting Matrix Diagonally");
		printMatrixDiagonally(matrix);
	}

}
