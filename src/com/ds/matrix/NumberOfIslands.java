package com.ds.matrix;

import java.util.Stack;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.

Input:
11110
11010
11000
00000

Output: 1

Input:
11000
11000
00100
00011
 * Output: 3
 * 
 * @author I339640
 *
 */
public class NumberOfIslands {

	private int n;
	private int m;

	public int numIslands(char[][] grid) {
	    int count = 0;
	    n = grid.length;
	    if (n == 0) return 0;
	    m = grid[0].length;
	    for (int i = 0; i < n; i++){
	        for (int j = 0; j < m; j++)
	            if (grid[i][j] == '1') {
	                DFSMarking(grid, i, j);
	                ++count;
	            }
	    }    
	    return count;
	}

	private void DFSMarking(char[][] grid, int i, int j) {
	    if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
	    grid[i][j] = '0';
	    DFSMarking(grid, i + 1, j);
	    DFSMarking(grid, i - 1, j);
	    DFSMarking(grid, i, j + 1);
	    DFSMarking(grid, i, j - 1);
	}
	private static int[][] matrix = { { 1, 0, 1, 0, 1 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1 } };
	final static int[] offsets = { -1, 0, +1 };
	// nextExpectedRow is for next value of x coordinate nextExpectedCol is for
	// next value of y coordinate
	private static int nextExpectedRow[] = { 1, 1, 1, -1, -1, -1, 0, 0 };
	private static int nextExpectedCol[] = { 1, 0, -1, -1, 0, 1, 1, -1 };

	private static class Cell { // Class to represent a cell. Cell => (x, y)
		protected int row;
		protected int column;

		public Cell(int row, int column) {
			this.row = row;
			this.column = column;
		}
	};

	private boolean isValidNeighbor(int i, int j) {

		if ((i >= 0) && (i < matrix.length) && (j >= 0) && (j < matrix[0].length) && (matrix[i][j] == 1)) {
			return true;
		}

		return false;
	}

	private void doDFS(int[][] matrix, int i, int j, boolean[][] visited) {

		Stack<Cell> stack = new Stack<Cell>();
		if (visited[i][j]) {
			return;
		}
		visited[i][j] = true;
		stack.push(new Cell(i, j));

		while (!stack.isEmpty()) {

			Cell cell = stack.pop();
			for (int nextIndex = 0; nextIndex < 8; nextIndex++) {

				int nextX = cell.row + nextExpectedRow[nextIndex];
				int nextY = cell.column + nextExpectedCol[nextIndex];

				if (isValidNeighbor(nextX, nextY) && visited[nextX][nextY] == false) {
					visited[nextX][nextY] = true;
					stack.push(new Cell(nextX, nextY));
				}
			}
		}

		/*
		 * if (visited[i][j]){ return; }
		 * 
		 * // mark this vertex as visited and visit all its neighbors in depth
		 * first manner visited[i][j] = true;
		 * 
		 * int xOffset, yOffset; for (int l = 0; l < offsets.length; l++) {
		 * xOffset = offsets[l]; for (int m = 0; m < offsets.length; m++) {
		 * yOffset = offsets[m];
		 * 
		 * // do not consider vertex[i][j] as its own neighbor if (xOffset == 0
		 * && yOffset == 0){ continue; }
		 * 
		 * // check if there exists a vertex at this offset and check if it is
		 * '1' if (neighborExists(matrix, i + xOffset, j + yOffset)){
		 * doDFS(matrix, i + xOffset, j + yOffset, visited); } } }
		 */
	}

	public int countNumberOfClusters(int[][] matrix) {

		int row = matrix.length;
		int colmun = matrix[0].length;
		boolean[][] visited = new boolean[row][colmun]; // JVM initializes all
		// values to false by
		// default.

		int count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < colmun; j++) {
				if ((matrix[i][j] == 1) && (!visited[i][j])) {
					// vertex [i][j] marks start of new a cluster. DFS then
					// visits all vertices of this cluster
					count += 1;
					doDFS(matrix, i, j, visited);
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {

		NumberOfIslands solution = new NumberOfIslands();

		System.out.println("Number of Islands: " + solution.countNumberOfClusters(matrix));
	}
}
