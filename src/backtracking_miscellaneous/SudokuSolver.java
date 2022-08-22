
package backtracking_miscellaneous;

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
		 char[][] board ={ 
		    { '0' , '9' , '0' , '4' , '0' , '0' , '0' , '0' , '0' },
			{ '0' , '0' , '0' , '9' , '0' , '0' , '5' , '0' , '4' },
			{ '4' , '0' , '5' , '0' , '0' , '0' , '0' , '6' , '9' },
			{ '2' , '0' , '0' , '0' , '5' , '9' , '0' , '8' , '0' },
			{ '0' , '3' , '7' , '0' , '8' , '0' , '6' , '9' , '0' },
			{ '0' , '4' , '0' , '7' , '1' , '0' , '0' , '0' , '2' },
			{ '6' , '8' , '0' , '0' , '0' , '0' , '2' , '0' , '5' },
			{ '9' , '0' , '4' , '0' , '0' , '2' , '0' , '0' , '0' },
			{ '0' , '0' , '0' , '0' , '0' , '8' , '0' , '1' , '0' } };
		    solveSudoku(board);
		    printSudokuGrid(board);
	}
	private static void printSudokuGrid(char grid[][]) {
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col <grid.length; col++)
				System.out.print("  "+grid[row][col]);
			System.out.println(" ");
		}
	}
	public static void solveSudoku(char[][] board) {
		doSolve(board, 0, 0);
	}

	private static boolean doSolve(char[][] board, int row, int col) {
		for (int i = row; i < 9; i++, col = 0) { // note: must reset col here!
			for (int j = col; j < 9; j++) {
				if (board[i][j] != '.')
					continue;
				for (char num = '1'; num <= '9'; num++) {
					if (isValid(board, i, j, num)) {
						board[i][j] = num;
						if (doSolve(board, i, j + 1))
							return true;
						board[i][j] = '.';
					}
				}
				return false;
			}
		}
		return true;
	}

	private static boolean isValid(char[][] board, int row, int col, char num) {
		int blkrow = (row / 3) * 3, blkcol = (col / 3) * 3; // Block no. is i/3, first element is i/3*3
		for (int i = 0; i < 9; i++)
			if (board[i][col] == num || board[row][i] == num || board[blkrow + i / 3][blkcol + i % 3] == num)
				return false;
		return true;
	}
}
