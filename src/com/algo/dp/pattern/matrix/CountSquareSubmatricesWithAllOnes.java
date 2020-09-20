package com.algo.dp.pattern.matrix;

/**
 * 
 * Given a m * n matrix of ones and zeros, return how many square submatrices
 * have all ones.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: matrix = { {0,1,1,1}, {1,1,1,1}, {0,1,1,1} } Output: 15 Explanation:
 * There are 10 squares of side 1. There are 4 squares of side 2. There is 1
 * square of side 3. Total number of squares = 10 + 4 + 1 = 15.
 * 
 * Example 2:
 * 
 * Input: matrix = { {1,0,1}, {1,1,0}, {1,1,0} } Output: 7 Explanation: There
 * are 6 squares of side 1. There is 1 square of side 2. Total number of squares
 * = 6 + 1 = 7.
 *
 * 
 */
public class CountSquareSubmatricesWithAllOnes {

	public static void main(String[] args) {
		int[][] matrix = { {1,0,1}, {1,1,0}, {1,1,0} };
		System.out.println(countSquares( matrix));
	}
	public static int countSquares(int[][] matrix) {
		
		int res=0;
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if(matrix[i][j]==1&&i>0&&j>0) {
					matrix[i][j]=Math.min(matrix[i-1][j],Math.min(matrix[i][j-1],matrix[i-1][j-1]))+matrix[i][j];
				}
				res+=matrix[i][j];
			}
		}
		return res;
	}
}
