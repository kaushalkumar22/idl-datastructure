package com.algo.ads.backtracking.common;

import java.text.DecimalFormat;

public class KnightTour2 {

	private static int N = 8;
	private static int[][] knightMove = new int[N][N];
	private static int path = 0;

	public static void main(String[] args) {

		if (findPath(0, 0, 0)) {
			print();
		} else {
			System.out.println("NO PATH FOUND");
		}
	}

	private static boolean findPath(int row, int column, int index) {
		// check if current is not used already
		if (knightMove[row][column] != 0) {
			return false;
		}
		// mark the current cell is as used
		knightMove[row][column] = path++;
		// if (index == 50) {
		if (index == N * N - 1) {
			// if we are here means we have solved the problem
			return true;
		}
		// try to solve the rest of the problem recursively

		// go down and right
		if (canMove(row + 2, column + 1, N)&& findPath(row + 2, column + 1, index + 1)) {
			return true;
		}
		// go right and down
		if (canMove(row + 1, column + 2, N)&& findPath(row + 1, column + 2, index + 1)) {
			return true;
		}
		// go right and up
		if (canMove(row - 1, column + 2, N)&& findPath(row - 1, column + 2, index + 1)) {
			return true;
		}
		// go up and right
		if (canMove(row - 2, column + 1, N)&& findPath(row - 2, column + 1, index + 1)) {
			return true;
		}
		// go up and left
		if (canMove(row - 2, column - 1, N)&& findPath(row - 2, column - 1, index + 1)) {
			return true;
		}
		// go left and up
		if (canMove(row - 1, column - 2, N)&& findPath(row - 1, column - 2, index + 1)) {
			return true;
		}
		// go left and down
		if (canMove(row + 1, column - 2, N)&& findPath(row + 1, column - 2, index + 1)) {
			return true;
		}
		// go down and left
		if (canMove(row + 2, column - 1, N)&& findPath(row + 2, column - 1, index + 1)) {
			return true;
		}
		// if we are here means nothing has worked , backtrack
		knightMove[row][column] = 0;
		path--;
		return false;

	}

	private static boolean canMove(int row, int col, int N) {
		if (row >= 0 && col >= 0 && row < N && col < N) {
			return true;
		}
		return false;
	}

	private static void print() {
		DecimalFormat twodigits = new DecimalFormat("00");
		for (int i = 0; i < knightMove.length; i++) {
			for (int j = 0; j < knightMove.length; j++) {
				System.out.print("   " + twodigits.format(knightMove[i][j]));
			}
			System.out.println();
		}
	}
}


/*package com.dstc.backtracking;

class KnightTour 
{
	private static int N = 8;
	
	public static void main(String args[]) {
		solveKnightTour();
	}

	 This function solves the Knight Tour problem using Backtracking.  
	 * This  function mainly uses solveKnightTourUtil() to solve the problem. It returns false 
	 * if no complete tour is possible, otherwise return true and prints the tour.
	 * Please note that there may be more than one solutions, this function prints one of the feasible solutions. 
	 
	private static boolean solveKnightTour() {
		
		int knightMove[][] = new int[8][8];

		 Initialization of solution matrix 
		for (int x = 0; x < N; x++)
			for (int y = 0; y < N; y++)
				knightMove[x][y] = -1;
		 
		 * xMove[] and yMove[] define next move of Knight.
		 * xMove[] is for next value of x coordinate yMove[] is for next value of y coordinate
		 
		int xMove[] = {2, 1, -1, -2, -2, -1,  1,  2 };
		int yMove[] = {1, 2,  2,  1, -1, -2, -2, -1 };


		// Since the Knight is initially at the first block
		knightMove[0][0] = 0;

		 Start from 0,0 and explore all tours using solveKTUtil() 
		if (!solveKnightTourUtil(0, 0, 1, knightMove, xMove, yMove)) {
			System.out.println("Solution does not exist");
			return false;
		} else
			printKnightTour(knightMove);

		return true;
	}

	 A recursive utility function to solve Knight Tour problem 
	static boolean solveKnightTourUtil(int x, int y, int movei,int sol[][], int xMove[],int yMove[]) {
		
		int k, nextX, nextY;

		if (movei == N * N)
			return true;

		 Try all next moves from the current coordinate x, y 
		for (k = 0; k < 8; k++) {
			nextX = x + xMove[k];
			nextY = y + yMove[k];
			if (isValidMove(nextX, nextY, sol)) 
			{
				sol[nextX][nextY] = movei;
				if (solveKnightTourUtil(nextX, nextY, movei + 1,sol, xMove, yMove))
					return true;
				else
					sol[nextX][nextY] = -1;// backtracking
			}
		}

		return false;
	}
	 A utility function to check if i,j are valid indexes for N*N chess board 
	static boolean isValidMove(int x, int y, int sol[][]) {
		return (x >=0 && x < N && y >=0 && y < N && sol[x][y] == -1);
	}
	private static void printKnightTour(int path[][]) {
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++)
				System.out.print(path[x][y] + "  ");
			System.out.println();
		}
	}
	
}*/
