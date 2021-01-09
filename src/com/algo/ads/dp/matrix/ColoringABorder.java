package com.algo.ads.dp.matrix;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given a 2-dimensional grid of integers, each value in the grid represents the
 * color of the grid square at that location. Two squares belong to the same
 * connected component if and only if they have the same color and are next to
 * each other in any of the 4 directions. The border of a connected component is
 * all the squares in the connected component that are either 4-directionally
 * adjacent to a square not in the component, or on the boundary of the grid
 * (the first or last row or column). Given a square at location (r0, c0) in the
 * grid and a color, color the border of the connected component of that square
 * with the given color, and return the final grid.
 * 
 * Example 1: Input: grid = [[1,1],[1,2]], r0 = 0, c0 = 0, color = 3 Output:[[3, 3], [3, 2]] 
 * Example 2: Input: grid = [[1,2,2],[2,3,2]], r0 = 0, c0 = 1,color = 3 Output: [[1, 3, 3], [2, 3, 3]] 
 * Example 3: Input: grid =[[1,1,1],[1,1,1],[1,1,1]], r0 = 1, c0 = 1, color = 2 
 * Output: [[2, 2, 2], [2,1, 2], [2, 2, 2]]
 *
 */
public class ColoringABorder {
	/*Method 1:

		BFS

		Let m = grid.length, n = grid[0].length, use the number
		from 0 to m * n - 1 to identify the cells to avoid duplicates;
		e.g., grid[x][y]'s cell number is x * n + y;
		put the initial cell [r0, c0] into the Queue then poll it out,
		then check if it is on the grid bounday; If yes, color the cell;
		Traverse the cell's 4 neighbors:
		a) if its neighbor is of different color, the cell is on the
		component border;
		b) if same color, put the neighbor into Queue;
		repeat the above 2 and 3 till Queue is empty.*/
	private static final int[] d = { 0, 1, 0, -1, 0 }; // neighbors' relative displacements.
	public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
		int clr = grid[r0][c0], m = grid.length, n = grid[0].length;
		Set<Integer> component = new HashSet<>(); // put the cell number into Set to avoid visiting again.
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{ r0, c0 }); // add initial cell.
		component.add(r0 * n + c0); // add initial cell number.
		while (!q.isEmpty()) { // BFS starts.
			int r = q.peek()[0], c = q.poll()[1];
			if (r == 0 || r == m - 1 || c == 0 || c == n - 1) { grid[r][c] = color; } // on grid boundary.
			for (int k = 0; k < 4; ++k) { // travers its 4 neighbors.
				int i = r + d[k], j = c + d[k + 1]; // neighbor coordinates.
				if (i >= 0 && i < m && j >= 0 && j < n && !component.contains(i * n + j)) { // not visited before.
					if (grid[i][j] == clr) { // its neighbor is of same color, put it into Queue. 
						component.add(i * n + j); // avoid visiting again.
						q.offer(new int[]{ i, j }); // put it into Queue. 
					}else { // its neighbor is of different color, hence it is on component boundary.
						grid[r][c] = color; 
					}
				}
			}
		}
		return grid;
	}


	/*
	 * Method 2:
	 * 
	 * DFS
	 * 
	 * Use DFS to explore the cell (r0, c0)'s component, and negate the visited
	 * cell, traverse its 4 neighbors. After the traversal, change back from the
	 * negative if the component cell is at inner part.
	 */
	public int[][] colorBorder1(int[][] grid, int r0, int c0, int color) {
		negateBorder(grid, r0, c0, grid[r0][c0]);
		for (int[] g : grid) {
			for (int i = 0; i < g.length; ++i) {
				if (g[i] < 0) { g[i] = color; }
			}
		}
		return grid;
	}
	private void negateBorder(int[][] grid, int r, int c, int clr) {
		grid[r][c] = -clr; // mark as visited.
		int cnt = 0; // use to count grid[r][c]'s component neighbors (same color as it).
		for (int k = 0; k < 4; ++k) { // traverse 4 neighbors.
			int i = r + d[k], j = c + d[k + 1]; // nieghbor's coordinates.
			if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || Math.abs(grid[i][j]) != clr) { continue; } // out of grid or not same component.
			++cnt; // only if the 4 neighbors of grid[r][c] are all have same color as it, it is on inner part.
			if (grid[i][j] == clr) { negateBorder(grid, i, j, clr); } // recurse with respect to unvisited component neighbor.
		}
		if (cnt == 4) { grid[r][c] = clr; } // inner part, change back.
	}

}
