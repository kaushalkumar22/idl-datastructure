package com.algo.ads.backtracking.common;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 * Example:
 * 
 * Input: 4 Output: [ [".Q..", // Solution 1 "...Q", "Q...", "..Q."],
 * 
 * ["..Q.", // Solution 2 "Q...", "...Q", ".Q.."] ] Explanation: There exist two
 * distinct solutions to the 4-queens puzzle as shown above.
 * 
 *
 */
public class NQueensOptimized {
	public static void main(String[] args) {
		System.out.println(solveNQueens( 4));
	}
	public static int solveNQueens(int n) {
		boolean[][] chess = new boolean[n][n];
	    List<Integer> res =new ArrayList<>();
		solve(res, chess, 0);
		return res.size();
	}
	static int count=0;
	private static void solve(List<Integer> res, boolean[][] chess, int row) {
		if (row == chess.length) {			
			res.add(1);
			return;
		}
		for (int col = 0; col < chess.length; col++) {
			if (valid(chess, row, col)) {
				chess[row][col] = true;
				solve(res, chess, row + 1);
				chess[row][col] = false;
			}
		}
	}
	private static boolean valid(boolean[][] chess, int row, int col) {
		// check all cols
		for (int i = 0; i < row; i++) {
			if (chess[i][col] == true) {
				return false;
			}
		}
		//check 45 degree
		for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
			if (chess[i][j] == true) {
				return false;
			}
		}
		//check 135
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (chess[i][j] == true) {
				return false;
			}
		}
		return true;
	}
}
