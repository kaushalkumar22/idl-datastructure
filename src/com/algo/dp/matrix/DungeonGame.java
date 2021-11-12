package com.algo.dp.matrix;

import java.util.Arrays;

/**
 * The demons had captured the princess (P) and imprisoned her in the
 * bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid
 * out in a 2D grid. Our valiant knight (K) was initially positioned in the
 * top-left room and must fight his way through the dungeon to rescue the
 * princess.
 * 
 * The knight has an initial health point represented by a positive integer. If
 * at any point his health point drops to 0 or below, he dies immediately.
 * 
 * Some of the rooms are guarded by demons, so the knight loses health (negative
 * integers) upon entering these rooms; other rooms are either empty (0's) or
 * contain magic orbs that increase the knight's health (positive integers).
 * 
 * In order to reach the princess as quickly as possible, the knight decides to
 * move only rightward or downward in each step.
 * 
 * Write a function to determine the knight's minimum initial health so that he
 * is able to rescue the princess.
 * 
 * For example, given the dungeon below, the initial health of the knight must
 * be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 * 
 * -2 (K) -3 3
 * -5    -10 1 
 * 10    30 -5 (P)
 * 
 * The knight's health has no upper bound. Any room can contain threats or
 * power-ups, even the first room the knight enters and the bottom-right room
 * where the princess is imprisoned.
 *
 */
public class DungeonGame {

	public static void main(String[] args) {
		int[][] points = {
				{-2, -3,   3}, 
				{-5, -10,  1}, 
				{10,  30, -5} 
		};
		System.out.println(calculateMinimumHP(points));
	}

	public static int calculateMinimumHP(int[][] dung) {
	        int row=dung.length;
	        int col=dung[0].length;
	        int[] dp = new int[col+1];
	        Arrays.fill(dp, Integer.MAX_VALUE);
	        dp[col-1]=1;
	        for(int i=row-1;i>=0;i--){
	            for(int j=col-1;j>=0;j--){
	                dp[j]=Math.max(1,Math.min(dp[j],dp[j+1])-dung[i][j]);
	            }
	        }
	        return dp[0];
	    
	    }
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
}
