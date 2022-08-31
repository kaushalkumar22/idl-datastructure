package dynamicprogramming_matrix;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * [ 
 * [1,3,1], 
 * [1,5,1], 
 * [4,2,1] 
 * ] 
 * Output: 7 
 * Explanation: Because the path 1->3->1->1->1 minimizes the sum.
 * 
 *
 */
public class MinimumPathSum {
	public static void main(String[] args) {
		int[][] grid = {
				{1,3,1},
				{1,5,1},
				{4,2,1}
		};
		System.out.println(minPathSum2( grid));
		System.out.println(minPathSum( grid));
	}
	//Share my O(1) space, O(m*n) time complexity solution.

	public static int minPathSum(int[][] grid) {			    
		int m = grid.length;
		int n = grid[0].length;
		int[] dp = new int[n];
		dp[0] = grid[0][0];
		for(int i=1;i<n;i++){
			dp[i]= dp[i-1]+grid[0][i];
		}
		for(int i=1;i<m;i++){
			dp[0]=dp[0]+grid[i][0];
			for(int j=1;j<n;j++){
				dp[j]=Math.min(dp[j-1],dp[j])+grid[i][j];
			}
		}
		return dp[n-1];
	}
	public static int minPathSum2(int[][] grid) {

		int m=grid.length-1;
		int n=grid[0].length-1; 
		int[][] minCostPath = new int[m+1][n+1];
		minCostPath[0][0] = grid[0][0];

		for (int i = 1; i <= m; i++) {
			minCostPath[i][0] = minCostPath[i - 1][0] + grid[i][0];
		}

		for (int j = 1; j <= n; j++) {
			minCostPath[0][j] = minCostPath[0][j - 1] + grid[0][j];
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				minCostPath[i][j] = grid[i][j]+ Math.min(
						minCostPath[i - 1][j],minCostPath[i][j - 1]);

			}
		}
		return minCostPath[m][n];
	}
}