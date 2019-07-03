package com.ds.matrix;
/**
 * Given a grid with each cell consisting of positive, negative or no points i.e, zero points. 
 * We can move across a cell only if we have positive points ( > 0 ). 
 * Whenever we pass through a cell, points in that cell are added to our overall points. 
 * We need to find minimum initial points to reach cell (m-1, n-1) from (0, 0).
 * 
 * Constraints : 
 *  From a cell (i, j) we can move to (i+1, j) or (i, j+1). 
 *  We cannot move from (i, j) if your overall points at (i, j) is <= 0. 
 *  We have to reach at (n-1, m-1) with minimum positive points i.e., > 0. in a matrix
 *  
 * @author Kaushal.Kumar
 *
 */
public class MinInitialPoints{
	
	private static int  getMinInitialPoints(int points[][]){
		
		int c = points.length;
		int r = points[0].length;
		int[][] minPointTable = new int[r][c];
		int m = r, n = c;

		//we will start from Destination with minimum point minPointTable[m-1][n] 
		minPointTable[m-1][n-1] = points[m-1][n-1] > 0? 1: Math.abs(points[m-1][n-1]) + 1;

		//Fill last row and last column as base to fill entire table
		for (int i = m-2; i >= 0; i--)
			minPointTable[i][n-1] = Math.max(minPointTable[i+1][n-1] - points[i][n-1], 1);
		for (int j = n-2; j >= 0; j--)
			minPointTable[m-1][j] = Math.max(minPointTable[m-1][j+1] - points[m-1][j], 1);

		// fill the table in bottom-up fashion
		for (int i=m-2; i>=0; i--)
		{
			for (int j=n-2; j>=0; j--)
			{
				minPointTable[i][j] = Math.max(Math.min(minPointTable[i+1][j], minPointTable[i][j+1]) - points[i][j], 1);
			}
		}

		return minPointTable[0][0];
	}
	public static void main(String[] args) {
		int[][] points = {
				{-2, -3,   3}, 
				{-5, -10,  1}, 
				{10,  30, -5} 
		};
		System.out.println("Minimum Initial Points : " + getMinInitialPoints(points));
	}
}