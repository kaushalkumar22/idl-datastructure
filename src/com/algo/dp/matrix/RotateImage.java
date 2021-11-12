package com.algo.dp.matrix;

import java.util.Arrays;

/**
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Note:
 * 
 * You have to rotate the image in-place, which means you have to modify the
 * input 2D matrix directly. DO NOT allocate another 2D matrix and do the
 * rotation.
 * 
 * Given input matrix = { {1,2,3}, {4,5,6}, {7,8,9} },
 * 
 * rotate the input matrix in-place such that it becomes: { {7,4,1}, {8,5,2},
 * {9,6,3} } 
 * 
 * Given input matrix = { { 5, 1, 9,11}, { 2, 4, 8,10}, {13, 3, 6, 7},
 * {15,14,12,16} },
 * 
 * rotate the input matrix in-place such that it becomes: { {15,13, 2, 5}, {14,
 * 3, 4, 1}, {12, 6, 8, 9}, {16, 7,10,11} }
 * 
 * Intuition
 * 
 * The most elegant solution for rotating the matrix is to firstly reverse the
 * matrix around the main diagonal, and then reverse it from left to right.
 * These operations are called transpose and reflect in linear algebra.
 *
 * Complexity Analysis
 * 
 * Let M be the number of cells in the grid.
 * 
 * Time complexity : O(M).We perform two steps; transposing the matrix, and then
 * reversing each row. Transposing the matrix has a cost of O(M) because we're
 * moving the value of each cell once. Reversing each row also has a cost of
 * O(M), because again we're moving the value of each cell once.
 * 
 * Space complexity : O(1) because we do not use any other additional data
 * structures.
 * 
 * 
 */
public class RotateImage {
	
	public static void main(String[] args) {
		int[][] matrix ={ { 5, 1, 9,11}, { 2, 4, 8,10}, {13, 3, 6, 7},{15,14,12,16} };
		new RotateImage().rotate(matrix);
		System.out.println(Arrays.deepToString(matrix));
	}
	public void rotate(int[][] matrix) {
		transpose(matrix);
		reflect(matrix);
	}
	//reverse the matrix around the main diagonal
	public void transpose(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int tmp = matrix[j][i];
				matrix[j][i] = matrix[i][j];
				matrix[i][j] = tmp;
			}
		}
	}
	//reverse it from left to right
	public void reflect(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[i][n - j - 1];
				matrix[i][n - j - 1] = tmp;
			}
		}
	}
}

