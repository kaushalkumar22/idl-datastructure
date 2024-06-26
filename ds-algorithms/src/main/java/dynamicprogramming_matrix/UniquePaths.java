package dynamicprogramming_matrix;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * 
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * 
 * Input: m = 3, n = 2 Output: 3 Explanation: From the top-left corner, there
 * are a total of 3 ways to reach the bottom-right corner: 1. Right -> Right ->
 * Down 2. Right -> Down -> Right 3. Down -> Right -> Right
 * 
 * Input: m = 7, n = 3 Output: 28

 * Constraints:
 * 
 * 1 <= m, n <= 100 
 * It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9
 *
 */
public class UniquePaths {

	public static void main(String[] args) {
		System.out.println(uniquePaths(3,3));
		System.out.println(uniquePaths2(3,3));
		System.out.print(uniquePathsRecursive(3, 3)); 
	}
	public static int uniquePaths(int m, int n) {
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {		
				dp[j] +=  dp[j-1];
			}
		}
		return dp[n - 1];  
	}
	public static int uniquePaths2(int m, int n) {

		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}

		for (int i = 0; i < n; i++) {
			dp[0][i] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}

	public static int uniquePathsRecursive(int n, int m) {
		if (n == 1 || m == 1) {
			return 1;
		}
		return uniquePathsRecursive(n - 1, m) + uniquePathsRecursive(n, m - 1);
	}
}
