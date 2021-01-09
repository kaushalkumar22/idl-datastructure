package com.algo.ads.backtracking.common;
/*
 A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e., 
 maze[0][0] and destination block is lower rightmost block i.e., maze[N-1][N-1]. A rat starts from 
 source and has to reach destination. The rat can move only in two directions: forward and down.
 In the maze matrix, 0 means the block is dead end and 1 means the block can be used in the path 
 from source to destination. Note that this is a simple version of the typical Maze problem. For example, 
 a more complex version can be that the rat can move in 4 directions and a more complex version can be with limited number of moves.
 */

public class RatMaze
{
	private static int ratMaze[][] = {
			{1, 0, 1, 0},
			{1, 1, 1, 0},
			{0, 1, 1, 1},
			{1, 1, 1, 1}
	};
	private static final int N = ratMaze.length;
	private static int movedMazeCells[][] = new int[N][N];	//java initialize array with default int value
	
	private	static class Cell {  // Class to represent  a cell. Cell => (x, y)
		protected int row;
		protected int column;
		public Cell(int row, int column) {  
			this.row = row;
			this.column = column;
		}
	};
	
	public static void main(String args[]){
		
		if (!solveRatMaze( new Cell(0, 0))){
			System.out.print("Solution doesn't exist");
		}else{
			printSolution();
		}
	}
	
	private static boolean solveRatMaze( Cell cell)
	{
		// if (x,y is goal) return true
		if (cell.row == N - 1 && cell.column == N - 1){
			movedMazeCells[cell.row][cell.column] = 1;
			return true;
		}
		if (isValidMove(cell)){
			
			movedMazeCells[cell.row][cell.column] = 1;

			if (solveRatMaze(new Cell(cell.row + 1, cell.column)))
				return true;
			
			if (solveRatMaze( new Cell(cell.row, cell.column + 1)))
				return true;

			movedMazeCells[cell.row][cell.column] = 0;
		}
		return false;
	}
	private static boolean isValidMove(Cell cell){
		return (cell.row >= 0 && cell.row < N && cell.column >= 0 
				&&cell.column < N && ratMaze[cell.row][cell.column] == 1);
	}
	private static void printSolution(){
		for (int i = 0; i < N; i++){
			for (int j = 0; j < N; j++)
				System.out.print(" " + movedMazeCells[i][j] +" ");
			System.out.println();
		}
	}

}