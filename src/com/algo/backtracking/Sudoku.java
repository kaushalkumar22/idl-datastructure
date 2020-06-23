package com.algo.backtracking;

/*
 * //http://codefordummies.blogspot.in/2014/01/backtracking-solve-sudoku-in-java.html
 * */

public class Sudoku {

	private static int N = 9;

	private static int grid[][] = { 

		{ 0, 9, 0, 4, 0, 0, 0, 0, 0 }, 
		{ 0, 0, 0, 9, 0, 0, 5, 0, 4 }, 
		{ 4, 0, 5, 0, 0, 0, 0, 6, 9 }, 
		{ 2, 0, 0, 0, 5, 9, 0, 8, 0 }, 
		{ 0, 3, 7, 0, 8, 0, 6, 9, 0 }, 
		{ 0, 4, 0, 7, 1, 0, 0, 0, 2 }, 
		{ 6, 8, 0, 0, 0, 0, 2, 0, 5 }, 
		{ 9, 0, 4, 0, 0, 2, 0, 0, 0 }, 
		{ 0, 0, 0, 0, 0, 8, 0, 1, 0 } 
	};

	public static void main(String[] args) {

		if (!solveSudoku(new Cell(0, 0))) {
			System.out.println("SUDOKU cannot be solved.");
		}else{
			System.out.println("SOLUTION");
			printSudokuGrid(grid);
		}
	}
	/**
	 * Find row, col of an unassigned cell
	 * if the cell is null, we have reached the end
	 * For digits from 1 to 9
	 *   this is where each possible value(1-9) is being assigned to the cell, and checked if a solutions could be arrived at.
	 *  if grid[row,col] doesn't have a value try each possible value
	 * a) if grid[row,col] already has a value, there is nothing to do, continue on to next cell
	 *    else there is no conflict for digit at row,col assign value to row,col and recursively try fill in rest of grid
	 * b) If recursion successful, return true
	 * c) Else, remove digit and try another
	 * If all digits have been tried and nothing worked, return false
	 * 
	 */
	private	static boolean solveSudoku(Cell cur) {

		if (cur == null)
			return true;

		if (grid[cur.row][cur.col] != 0) {
			return solveSudoku(getNextCell(cur));
		}

		for (int value = 1; value <= 9; value++){

			if (isValid(cur, value)){ 
				grid[cur.row][cur.col] = value;
			}else{
				continue; 
			}

			if (solveSudoku(getNextCell(cur))){
				return true;
			}else{
				grid[cur.row][cur.col] = 0;
			}
		}
		return false;
	}

	/**
	 * Utility function to check whether value is valid for current cell or not
	 * 1. if value present in selected cell's row, of grid, return false
	 * 2. if value present in selected cell's col ,of grid, return false
	 * 3. if value present in selected cell's row and col ,of sub-grid (3X3), return false
	 * 4  if value not present in row, col and bounding box, return true
	 */
	private static boolean isValid(Cell cell, int value) {

		for (int col = 0; col < 9; col++) {
			if (grid[cell.row][col] == value)
				return false;
		}

		for (int row = 0; row < 9; row++) {
			if (grid[row][cell.col] == value)
				return false;
		}

		int x1 = 3 * (cell.row / 3);
		int y1 = 3 * (cell.col / 3);
		int x2 = x1 + 2;
		int y2 = y1 + 2;

		for (int x = x1; x <= x2; x++)
			for (int y = y1; y <= y2; y++)
				if (grid[x][y] == value)
					return false;

		return true;
	}



	private	static Cell getNextCell(Cell cur) {

		int row = cur.row;
		int col = cur.col;

		col++; // next cell => col++

		if (col > 8) {	 // if col > 8, then col = 0, row++  reached end of row, got to next row
			col = 0;     // goto next line
			row++;
		}

		if (row > 8)    // reached end of matrix, return null
			return null; // reached end

		Cell next = new Cell(row, col);

		return next;
	}

	private static void printSudokuGrid(int grid[][]) {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++)
				System.out.print("  "+grid[row][col]);
			System.out.println(" ");
		}
	}
	/**
	 * Class to represent  a cell. Cell => (x, y)
	 */
	static class Cell {

		int row, col;
		public Cell(int row, int col) {  
			this.row = row;
			this.col = col;
		}

	};
}