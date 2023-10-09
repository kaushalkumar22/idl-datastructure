package graph_dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an m x n integers matrix, return the length of the longest increasing path in matrix.
 *
 * From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally
 * or move outside the boundary (i.e., wrap-around is not allowed).
 *
 * Example 1:
 *
 * Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 *
 * Example 2:
 *
 * Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
 * Output: 4
 * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 *
 * Example 3:
 *
 * Input: matrix = [[1]]
 * Output: 1
 * [7,8,9],
 * [9,7,6],
 * [7,2,3]]
 */
public class LongestIncreasingPathInAMatrix {
	public static void main(String[] args) {
		int[][] matrix = {{7,8,9},{9,7,6},{7,2,3}};
		System.out.println(new LongestIncreasingPathInAMatrix().longestIncreasingPath( matrix));
	}

	public int longestIncreasingPath(int[][] matrix) {
		if(matrix.length == 0) return 0;
		int m = matrix.length, n = matrix[0].length;
		int max = 1;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				int len = bfs(matrix, i, j);
				max = Math.max(max, len);
			}
		}
		return max;
	}

	public int bfs(int[][] matrix, int i, int j) {

		Queue<int[]> que = new LinkedList<>();
		que.add(new int[]{i,j});
		int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		int count = 0;
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		while(!que.isEmpty()){
			count++;
			int n = que.size();
			for(int k =0 ;k<n;k++){
				int[] curr = que.poll();
				for(int[] dir: dirs) {
					int x = curr[0] + dir[0], y = curr[1] + dir[1];
					if(!isValid(matrix,curr[0],curr[1],x,y)) continue;
					//visited[x][y] = true;
					que.add(new int[]{x,y});
				}
			}
		}
		return count;
	}
	private boolean isValid(int[][] matrix, int i, int j, int x, int y){
		if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= matrix[i][j]) {
			return false;
		}

		return true;
	}
}