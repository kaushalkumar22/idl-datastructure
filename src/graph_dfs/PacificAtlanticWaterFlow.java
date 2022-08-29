package graph_dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches
 * the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
 *
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c]
 * represents the height above sea level of the cell at coordinate (r, c).
 *
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west
 * if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent
 * to an ocean into the ocean.
 *
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci)
 * to both the Pacific and Atlantic oceans.
 *
 *
 *
 * Example 1:
 *
 * Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 *
 * Example 2:
 *
 * Input: heights = [[2,1],[1,2]]
 * Output: [[0,0],[0,1],[1,0],[1,1]]
 */
public class PacificAtlanticWaterFlow {
	public static void main(String[] args) {
		
	}
	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> res = new ArrayList();
		int m = matrix.length;
		if(m == 0) return res;
		int n = matrix[0].length;
		boolean[][] pac = new boolean[m][n];
		boolean[][] atl = new boolean[m][n];
		int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
		for(int i = 0; i < m; i++){
			helper(matrix, dir, pac, i,  0);
			helper(matrix, dir, atl, i, n - 1);
		}

		for(int i = 0; i < n; i++){
			helper(matrix, dir, pac, 0,  i);
			helper(matrix, dir, atl, m - 1, i);
		}

		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(pac[i][j] && atl[i][j]) res.add(new int[]{i, j});
			}
		}
		return res;
	}

	void helper(int[][] matrix, int[][] dir, boolean[][] isVisited, int i, int j){
		int m = matrix.length, n = matrix[0].length;
		isVisited[i][j] = true;
		for(int[] d: dir){
			int x = i + d[0];
			int y = j + d[1];
			if(x < 0 || y < 0 || x >= m || y >= n || isVisited[x][y] || matrix[i][j] > matrix[x][y]){
				continue;
			}
			helper(matrix, dir, isVisited, x, y);
		}
	}
}

