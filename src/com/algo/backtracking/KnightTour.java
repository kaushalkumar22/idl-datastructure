package com.algo.backtracking;

import java.text.DecimalFormat;

public class KnightTour {

	private static int N = 8;
	private static int[][] knightMoveBoard = new int[N][N]; //in java array all index will get initialize with zero so no need to initialize

	private static int movedCells = 0; //while start considering first cell as moved one

	//nextExpectedRow is for next value of x coordinate nextExpectedCol is for next value of y coordinate
	private static int nextExpectedRow[] = {2, 1, -1, -2, -2, -1,  1,  2 };
	private static int nextExpectedCol[] = {1, 2,  2,  1, -1, -2, -2, -1 };

	public static void main(String[] args) {

		if (solveKnightTour( new Cell(0,0))){  //Cell => (x=0, y=0)
			printKnightTour();		
		}else{
			System.out.print("Solution does not exist");
		}
	}
	private static boolean solveKnightTour(Cell cell){

		if (knightMoveBoard[cell.row][cell.column] != 0) {
			return false;
		}
		knightMoveBoard[cell.row][cell.column] = ++movedCells;

		if (movedCells == N * N){
			return true;
		}

		for (int nextIndex = 0; nextIndex < 8; nextIndex++) 
		{
			int nextX = cell.row + nextExpectedRow[nextIndex];
			int nextY = cell.column + nextExpectedCol[nextIndex];
			Cell nextCell = new Cell(nextX,nextY);

			if (isValidMove(nextCell)&& solveKnightTour(nextCell)) {		
				return true;
			}
		}
		knightMoveBoard[cell.row][cell.column] = 0;
		movedCells --;

		return false;
	}

	private static boolean isValidMove(Cell cell) {
		return (cell.row >=0 && cell.column >=0&& cell.row< N 
				&& cell.column < N &&knightMoveBoard[cell.row][cell.column] == 0);
	}

	private static void printKnightTour() {
		DecimalFormat twodigits = new DecimalFormat("00");
		for (int i = 0; i < knightMoveBoard.length; i++) {
			for (int j = 0; j < knightMoveBoard.length; j++) {
				System.out.print("   " + twodigits.format(knightMoveBoard[i][j]));
			}
			System.out.println();
		}
	}
	private	static class Cell {  // Class to represent  a cell. Cell => (x, y)
		protected int row;
		protected int column;
		public Cell(int row, int column) {  
			this.row = row;
			this.column = column;
		}
	};
}