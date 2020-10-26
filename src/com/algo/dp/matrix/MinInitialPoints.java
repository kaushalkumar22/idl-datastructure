package com.algo.dp.matrix;

import java.util.Arrays;

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

		int col = points.length;
		int row = points[0].length;
		int[][] dp = new int[row][col];


		//we will start from Destination with minimum point minPointTable[m-1][n] 
		dp[row-1][col-1] = points[row-1][col-1] > 0? 1: Math.abs(points[row-1][col-1]) + 1;

		//Fill last row and last column as base to fill entire table
		for (int i = row-2; i >= 0; i--)
			dp[i][col-1] = Math.max(dp[i+1][col-1] - points[i][col-1], 1);
		for (int j = col-2; j >= 0; j--)
			dp[row-1][j] = Math.max(dp[row-1][j+1] - points[row-1][j], 1);

		// fill the table in bottom-up fashion
		for (int i=row-2; i>=0; i--)
		{
			for (int j=col-2; j>=0; j--)
			{
				dp[i][j] = Math.max(Math.min(dp[i+1][j], dp[i][j+1]) - points[i][j], 1);
			}
		}

		return dp[0][0];
	}
	static int  calculateMinimumHP1(int[][] dungeon) {
		int row=dungeon.length;
		int	col=dungeon[0].length;
		int[] dp = new int[row+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[row-1]=1;
		for(int j=col-1;j>=0;j--){
			for(int i=row-1;i>=0;i--){
				dp[i]=Math.min(dp[i],dp[i+1])-dungeon[i][j];
				dp[i]=Math.max(1,dp[i]);
			}
		}
		return dp[0];
	}
	public static void main(String[] args) {
		int[][] points = {
				{-2, -3,   3}, 
				{-5, -10,  1}, 
				{10,  30, -5} 
		};
		System.out.println("Minimum Initial Points : " + calculateMinimumHP1(points));
	}
}