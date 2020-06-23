package com.algo.backtracking;

public class NQueenProblem{

	private static final int N = 8;

	public static void main(String args[]){

		int board[][] = new int[N][N];

		if (!solveNQueen(board, 0)){
			System.out.print("Solution does not exist");
		}else{
			printSolution(board);
		}
	}
	private static boolean solveNQueen(int board[][],int col){

		if (col == N)            // base case: If all queens are placed then return true 
			return true;
	
		for (int i = 0; i < N; i++){       //Consider this column and try placing this queen in all rows one by one 
			if (isSafePosition(board, i, col)){	  // Check if queen can be placed on board[i][col] 
				board[i][col] = 1;                    // Place this queen in board[i][col] 
				if (solveNQueen(board, col + 1)){      // recur to place rest of the queens 
					return true;
				}
				board[i][col] = 0; // BACKTRACK  If placing queen in board[i][col] doesn't lead to a solution then remove queen from board[i][col]
			}
		}	
		return false;
	}

	/* 
	 * this function is called when "col" queens are already placed in columns from 0 to col -1. 
	 * So we need to check only left side for attacking queens 
	 * */
	private static boolean isSafePosition(int board[][], int row, int column){

		// since we are filling one column at a time,
		// we will check if no queen is placed in that particular row
		for (int i = 0; i < column; i++) {         //Check this row on left side 
			if (board[row][i] == 1){
				return false;
			}
		}
		// we are filling one column at a time,so we need to check the upper and
		// diagonal as well
		// check upper diagonal
		for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}

		// check lower diagonal
		for (int i = row, j = column; i < board.length && j >= 0; i++, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		return true;
	}

	private static void printSolution(int board[][]){
		for (int i = 0; i < N; i++){
			for (int j = 0; j < N; j++)
				System.out.print(" " + board[i][j]+ " ");
			System.out.println();
		}
	}
}
