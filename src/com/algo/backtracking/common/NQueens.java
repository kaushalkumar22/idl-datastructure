package com.algo.backtracking.common;

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
 * @author IBM
 *
 */
public class NQueens {
	public static void main(String[] args) {

	}
	 public List<List<String>> solveNQueens(int n) {
	        char[][] chess = new char[n][n];
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                chess[i][j] = '.';
	            }
	        }
	        List<List<String>> res = new ArrayList<List<String>>();

	        solve(res, chess, 0);
	        return res;
	    }
	    private void solve(List<List<String>> res, char[][] chess, int row) {
	        if (row == chess.length) {
	            res.add(construct(chess));
	            return;
	        }
	        for (int col = 0; col < chess.length; col++) {
	            if (valid(chess, row, col)) {
	                chess[row][col] = 'Q';
	                solve(res, chess, row + 1);
	                chess[row][col] = '.';
	            }
	        }
	    }
	    private boolean valid(char[][] chess, int row, int col) {
	        // check all cols
	        for (int i = 0; i < row; i++) {
	            if (chess[i][col] == 'Q') {
	                return false;
	            }
	        }
	        //check 45 degree
	        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
	            if (chess[i][j] == 'Q') {
	                return false;
	            }
	        }
	        //check 135
	        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
	            if (chess[i][j] == 'Q') {
	                return false;
	            }
	        }
	        return true;
	    }
	    private List<String> construct(char[][] chess) {
	        List<String> path = new ArrayList<>();
	        for (int i = 0; i < chess.length; i++) {
	            path.add(new String(chess[i]));
	        }
	        return path;
	    }
}
