package com.algo.dp.matrix;

/**
 * Given a matrix of M x N elements (M rows, N columns), return all elements of
 * the matrix in diagonal order as shown in the below image.
 * 
 * Example: Input: 
 * [ [ 1, 2, 3 ], 
 *   [ 4, 5, 6 ], 
 *   [ 7, 8, 9 ] ]
 * 
 * Output: [1,2,4,7,5,3,6,8,9]
 * 
 */
public class DiagonalTraverse {

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

	

	//method 2
	public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int r = 0, c = 0, m = matrix.length, n = matrix[0].length, arr[] = new int[m * n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = matrix[r][c];
            if ((r + c) % 2 == 0) { // moving up
                if      (c == n - 1) { r++; }
                else if (r == 0)     { c++; }
                else            { r--; c++; }
            } else {                // moving down
                if      (r == m - 1) { c++; }
                else if (c == 0)     { r++; }
                else            { r++; c--; }
            }   
        }   
        return arr;
    }
}
