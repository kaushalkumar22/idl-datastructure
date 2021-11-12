package com.algo.dp.matrix;

/**
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square
 * containing only 1's and return its area.
 * 
 * Example:
 * 
 * Input:
 * 
 * matrix={{1 0 1 0 0 },{1 0 1 1 1 },{1 1 1 1 1},{1 0 0 1 0}}
 * 
 * Output: 4
 *
 * 
 */
public class MaximalSquare {

	public static void main(String[] args) {
		char[][] matrix={
				{'1','0', '1', '0', '0' },
				{'1','0', '1', '1', '1' },
				{'1','1', '1', '1', '1' },
				{'1','0', '0', '1', '0'}};
		System.out.println(maximalSquare(matrix));
	}
	public static int maximalSquare(char[][] matrix) {
		int res=0;
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if(matrix[i][j]=='1'&&i>0&&j>0) {
					matrix[i][j]=(char) (Math.min(matrix[i-1][j]-'0',Math.min(matrix[i][j-1]-'0',matrix[i-1][j-1]-'0'))+'1');
				}
				res=Math.max(res,matrix[i][j]-'0');
			}
		}
		return res*res;

	}
}
