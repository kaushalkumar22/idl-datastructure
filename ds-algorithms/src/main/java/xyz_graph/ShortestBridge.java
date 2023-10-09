package xyz_graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an n x n binary matrix grid where 1 represents land and 0 represents water.
 *
 * An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.
 *
 * You may change 0's to 1's to connect the two islands to form one island.
 *
 * Return the smallest number of 0's you must flip to connect the two islands.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[0,1],[1,0]]
 * Output: 1
 *
 * Example 2:
 *
 * Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 *
 * Example 3:
 *
 * Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 */
public class ShortestBridge {
	public static void main(String[] args) {

	}

	  public int shortestBridge(int[][] A) {
	        int m = A.length, n = A[0].length;
	        boolean[][] visited = new boolean[m][n];
	        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	        Queue<int[]> q = new LinkedList<>();
	        boolean found = false;
	        // 1. dfs to find an island, mark it in `visited`
	        for (int i = 0; i < m; i++) {
	            if (found) {
	                break;
	            }
	            for (int j = 0; j < n; j++) {
	                if (A[i][j] == 1) {
	                    dfs(A, visited, q, i, j, dirs);
	                    found = true;
	                    break;
	                }
	            }
	        }
	        // 2. bfs to expand this island
	        int step = 0;
	        while (!q.isEmpty()) {
	            int size = q.size();
	            while (size-- > 0) {
	                int[] cur = q.poll();
	                for (int[] dir : dirs) {
	                    int i = cur[0] + dir[0];
	                    int j = cur[1] + dir[1];
	                    if (i >= 0 && j >= 0 && i < m && j < n && !visited[i][j]) {
	                        if (A[i][j] == 1) {
	                            return step;
	                        }
	                        q.offer(new int[]{i, j});
	                        visited[i][j] = true;
	                    }
	                }
	            }
	            step++;
	        }
	        return -1;
	    }
	    private void dfs(int[][] A, boolean[][] visited, Queue<int[]> q, int i, int j, int[][] dirs) {
	        if (i < 0 || j < 0 || i >= A.length || j >= A[0].length || visited[i][j] || A[i][j] == 0) {
	            return;
	        }
	        visited[i][j] = true;
	        q.offer(new int[]{i, j});
	        for (int[] dir : dirs) {
	            dfs(A, visited, q, i + dir[0], j + dir[1], dirs);
	        }
	    }
}

