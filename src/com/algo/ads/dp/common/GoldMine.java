package com.algo.ads.dp.common;
/*
 *Given a gold mine of n*m dimensions. Each field in this mine contains an integer which is the amount of gold in tons. 
 *Initially the miner is in first column but can be at any row i. He can move only (right , right up , right down ) 
 *that is from a given cell, the miner can move to the cell diagonally up towards the right or right or diagonally 
 *down towards the right. Find out maximum amount of gold he can collect.
 */
public class GoldMine {

	private int[][] goldMine = null; // Gold mine field

	public GoldMine(int[][] goldMine) {
		this.goldMine = goldMine;
	}

	public int getMaxGold() {
		// null checks
		if (goldMine == null || goldMine.length == 0) {
			return 0;
		}
		int rowLength = goldMine.length;
		int colLength = goldMine[0].length;
		// Create table for storing intermediate results and initialize all cells to 0
		// The first row of goldMineTable will give the maximum gold that the miner can collect when he starts from that row
		int[][] goldMineTable = new int[rowLength][colLength];
		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < colLength; j++) {
				goldMineTable[i][j] = 0;
			}
		}
		for (int col = colLength - 1; col >= 0; col--) {
			for (int row = 0; row < rowLength; row++) {
				// Gold collected on going to the cell on the right (->)
				int right = col == colLength - 1 ? 0
						: goldMineTable[row][col + 1];
				// Gold collected on going to the cell to right up (/) i.e. diagonally up
				int rightUp = (row == 0 || col == colLength - 1 ? 0
						: goldMineTable[row - 1][col + 1]);
				// Gold collected on going to the cell to right down (\) i.e. diagonally down
				int rightDown = (row == rowLength - 1 || col == colLength - 1 ? 0
						: goldMineTable[row + 1][col + 1]);
				// Max gold collected from taking either of the above 3 paths
				goldMineTable[row][col] = goldMine[row][col]
						+ Math.max(rightUp, Math.max(right, rightDown));
			}
		}
		int max = 0;
		// The max amount of gold collected will be the max value in first column of all rows
		for (int i = 0; i < rowLength; i++) {
			max = max < goldMineTable[i][0] ? goldMineTable[i][0] : max;
		}
		return max;
	}

	public static void main(String[] args) {

		int[][] mine = { { 1, 3, 1, 5 }, 
				{ 2, 2, 4, 1 }, 
				{ 5, 0, 2, 3 },
				{ 0, 6, 1, 2 } };

		GoldMine goldMine = new GoldMine(mine);
		int maxGold = goldMine.getMaxGold();
		System.out.println(maxGold);
	}

}
