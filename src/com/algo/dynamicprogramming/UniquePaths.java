package com.algo.dynamicprogramming;

/**
 * http://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
 */
public class UniquePaths {

    public int countPathsRecursive(int n, int m){
        if(n == 1 || m == 1){
            return 1;
        }
        return countPathsRecursive(n-1, m) + countPathsRecursive(n, m-1);
    }
    
    public int countPaths(int n,int m){
        int T[][] = new int[n][m];
        for(int i=0; i < n; i++){
            T[i][0] = 1;
        }
        
        for(int i=0; i < m; i++){
            T[0][i] = 1;
        }
        for(int i=1; i < n; i++){
            for(int j=1; j < m; j++){
                T[i][j] = T[i-1][j] + T[i][j-1];
            }
        }
        return T[n-1][m-1];
    }
    
    public static void main(String args[]){
    	UniquePaths nop = new UniquePaths();
        System.out.print(nop.countPathsRecursive(3,3));
    }

	/**
	 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
	 * the diagram below). The robot can only move either down or right at any point
	 * in time. The robot is trying to reach the bottom-right corner of the grid
	 * (marked 'Finish' in the diagram below). Now consider if some obstacles are
	 * added to the grids. How many unique paths would there be?
	 * 
	 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
	 * Note: m and n will be at most 100. Example 1: 
	 * Input: [ 
	 * [0,0,0], 
	 * [0,1,0],
	 * [0,0,0] 
	 * ] 
	 * Output: 2 Explanation: There is one obstacle in the middle of the
	 * 3x3 grid above. There are two ways to reach the bottom-right corner: 1. Right
	 * -> Right -> Down -> Down 2. Down -> Down -> Right -> Right
	 * 
	 */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }
}
