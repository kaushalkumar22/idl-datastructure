package com.algo.backtracking.common;

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

