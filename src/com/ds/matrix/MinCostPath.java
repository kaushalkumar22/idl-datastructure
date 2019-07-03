package com.ds.matrix;

public class MinCostPath {


	/*public static int minimumCostPathRec(int[][] costMatrix, int m, int n) {
		if (m < 0 || n < 0)
			return Integer.MAX_VALUE;

		if (m == 0 && n == 0)
			return costMatrix[0][0];

		return costMatrix[m][n]
				+ minimum(minimumCostPathRec(costMatrix, m - 1, n - 1),
						minimumCostPathRec(costMatrix, m - 1, n),
						minimumCostPathRec(costMatrix, m, n - 1));
	}*/

	public static int minimumCostPathDP(int[][] costMatrix, int m, int n) {
		int[][] minimumCostPath = new int[m+1][n+1];
		minimumCostPath[0][0] = costMatrix[0][0];

		for (int i = 1; i <= m; i++) {
			minimumCostPath[i][0] = minimumCostPath[i - 1][0] + costMatrix[i][0];
		}

		for (int j = 1; j <= n; j++) {
			minimumCostPath[0][j] = minimumCostPath[0][j - 1] + costMatrix[0][j];
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				minimumCostPath[i][j] = costMatrix[i][j]+ Math.min(
						minimumCostPath[i - 1][j - 1],Math.min(
								minimumCostPath[i - 1][j],minimumCostPath[i][j - 1]));
				
			}
		}
		return minimumCostPath[m][n];
	}

	public static void main(String[] args) {
		int[][] costMatrix = {
				{ 3, 2, 8 }, 
				{ 1, 9, 7 }, 
				{ 0, 5, 2 }, 
				{ 6, 4, 3 } 
		};
		System.out.println("Minimum cost: " + minimumCostPathDP(costMatrix, 3, 2));
	}
}
