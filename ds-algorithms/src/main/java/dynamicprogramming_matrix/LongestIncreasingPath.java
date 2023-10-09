package dynamicprogramming_matrix;

import java.util.PriorityQueue;

/**
 Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT
move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

Input: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
Output: 4 
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:

Input: nums = 
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
] 
Output: 4 
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */
public class LongestIncreasingPath {

	private static int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	private int maxLen = 0;

	public int longestIncreasingPathDP(int[][] matrix) {
	    
	    // Algo thinking: reverse thinking
	    //      (1) Use a maxPQ
	    //      (2) DP
	    // time = O(N*M*lg(N*M)), space = O(N*M)
	    
	    if (matrix == null || matrix.length == 0) return 0;
	    
	    int n = matrix.length;
	    int m = matrix[0].length;
	    
	    PriorityQueue<int[]> maxPQ = new PriorityQueue<>((a, b) -> b[2] - a[2]);
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < m; j++) {
	            maxPQ.offer(new int[]{i, j, matrix[i][j]});
	        }
	    }
	    
	    int[][] dp = new int[n][m];
	    while (!maxPQ.isEmpty()) {
	        int[] cell = maxPQ.poll();
	        int i = cell[0], j = cell[1];
	        dp[i][j] = 1;
	        for (int[] d: dir) {
	            int newI = i + d[0], newJ = j + d[1];
	            if (newI < 0 || newI >= n || newJ < 0 || newJ >= m || matrix[i][j] >= matrix[newI][newJ]) continue;
	            dp[i][j] = Math.max(dp[i][j], dp[newI][newJ] + 1);
	        }
	        
	        maxLen = Math.max(maxLen, dp[i][j]);
	    }
	    
	    return maxLen;
	}
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] distance = new int[matrix.length][matrix[0].length];
        int max = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int r = dfs(matrix, i, j, distance, Integer.MIN_VALUE);
                if (r > max) {
                    max = r;
                }
            }
        }
        return max;
    }

    int dfs(int[][] matrix, int i, int j, int[][] distance, int prev) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length) {
            return 0;
        }

        if (matrix[i][j] <= prev) {
            return 0;
        }

        if (distance[i][j] != 0) {
            return distance[i][j];
        }

        int v1 = dfs(matrix, i - 1, j, distance, matrix[i][j]);
        int v2 = dfs(matrix, i, j - 1, distance, matrix[i][j]);
        int v3 = dfs(matrix, i + 1, j, distance, matrix[i][j]);
        int v4 = dfs(matrix, i, j + 1, distance, matrix[i][j]);
        distance[i][j] = 1 + Math.max(Math.max(v1, v2), Math.max(v3, v4));
        return distance[i][j];
    }

    public static void main(String args[]) {
        LongestIncreasingPath lip = new LongestIncreasingPath();
        int[][] input = {{9, 9, 4},{6, 6, 8},{2, 1, 1}};
        int[][] input1 = {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
        System.out.println(lip.longestIncreasingPath(input));
    }
}