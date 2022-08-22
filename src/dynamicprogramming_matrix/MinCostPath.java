package dynamicprogramming_matrix;

import java.util.Arrays;

public class MinCostPath {

	/*
	 * public static int minimumCostPathRec(int[][] costMatrix, int m, int n) {
	 * if (m < 0 || n < 0) return Integer.MAX_VALUE;
	 * 
	 * if (m == 0 && n == 0) return costMatrix[0][0];
	 * 
	 * return costMatrix[m][n] + minimum(minimumCostPathRec(costMatrix, m - 1, n
	 * - 1), minimumCostPathRec(costMatrix, m - 1, n),
	 * minimumCostPathRec(costMatrix, m, n - 1)); }
	 */

	public static int minimumCostPathDP(int[][] costMatrix, int m, int n) {
		int[][] minimumCostPath = new int[m + 1][n + 1];
		minimumCostPath[0][0] = costMatrix[0][0];

		for (int i = 1; i <= m; i++) {
			minimumCostPath[i][0] = minimumCostPath[i - 1][0] + costMatrix[i][0];
		}

		for (int j = 1; j <= n; j++) {
			minimumCostPath[0][j] = minimumCostPath[0][j - 1] + costMatrix[0][j];
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				minimumCostPath[i][j] = costMatrix[i][j] + Math.min(minimumCostPath[i - 1][j - 1],
						Math.min(minimumCostPath[i - 1][j], minimumCostPath[i][j - 1]));

			}
		}
		return minimumCostPath[m][n];
	}

	/**
	 * Given a square array of integers A, we want the minimum sum of a falling
	 * path through A.
	 * 
	 * A falling path starts at any element in the first row, and chooses one
	 * element from each row. The next row's choice must be in a column that is
	 * different from the previous row's column by at most one.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: [[1,2,3],[4,5,6],[7,8,9]] Output: 12 Explanation: The possible
	 * falling paths are: [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9] [2,4,7],
	 * [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9] [3,5,7], [3,5,8],
	 * [3,5,9], [3,6,8], [3,6,9]F
	 * 
	 */
	public int minFallingPathSum(int[][] A) {
		for (int i = 1; i < A.length; ++i)
			for (int j = 0; j < A.length; ++j)
				A[i][j] += Math.min(A[i - 1][j],
						Math.min(A[i - 1][Math.max(0, j - 1)], A[i - 1][Math.min(A.length - 1, j + 1)]));
		return Arrays.stream(A[A.length - 1]).min().getAsInt();
	}

	public static void main(String[] args) {
		int[][] costMatrix = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		/*
		 * { 3, 2, 8 }, { 1, 9, 7 }, { 0, 5, 2 }, { 6, 4, 3 }
		 */

		System.out.println("Minimum cost: " + minimumCostPathDP(costMatrix, 2, 2));
	}
}
