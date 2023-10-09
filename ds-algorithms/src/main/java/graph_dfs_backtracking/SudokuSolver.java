
package graph_dfs_backtracking;

import java.util.Arrays;

/**
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A sudoku solution must satisfy all of the following rules:
 *
 * Each of the digits 1-9 must occur exactly once in each row. Each of the
 * digits 1-9 must occur exactly once in each column. Each of the the digits 1-9
 * must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 *
 * Empty cells are indicated by the character '.'.
 *
 *
 * A sudoku puzzle...
 *
 *
 * ...and its solution numbers marked in red.
 *
 * Note:
 *
 * The given board contain only digits 1-9 and the character '.'. You may assume
 * that the given Sudoku puzzle will have a single unique solution. The given
 * board size is always 9x9.
 *
 *
 */
public class SudokuSolver {

	public static void main(String[] args) {
		char[][] board = {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}};

		new SudokuSolver().solveSudoku(board);
		for (int row = 0; row < board.length; row++)
			System.out.println(Arrays.toString(board[row]));
	}
	public  void solveSudoku(char[][] board) {
		solve(board);
	}

	private  boolean solve(char[][] board) {
		for (int row = 0; row < 9; row++) { // note: must reset col here!
			for (int col = 0; col < 9; col++) {
				if (board[row][col] != '.') { // continue if board sell is prefilled
					continue;
				}
				for (char num = '1'; num <= '9'; num++) {
					if (!isValid(board, row, col, num)) {
						continue;// continue if sub board 3X3 having the same number ,or 9X9(row or column) is having same number
					}
					board[row][col] = num;
					if (solve(board)){
						return true;
					}
					board[row][col] = '.';
				}
				//return false;
			}
		}
		return false;
	}

	private  boolean isValid(char[][] board, int row, int col, char num) {
		for (int i = 0; i < 9; i++)
			if (board[i][col] == num
					|| board[row][i] == num
					|| board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == num)// Block no. is i/3, first element is i/3*3
				return false;
		return true;
	}
}
