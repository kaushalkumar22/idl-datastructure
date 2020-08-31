package com.algo.dp.pattern.knapsackunbounded;

public class KnapsackUnbounded {
	
	public static void main(String args[]) {
		int wt[] =  {1,2,3,4,5,6,7,8 };
		int val[] = { 1 ,5,8,9,10,17,17,20};
		int w = 8;

		System.out.println(knapsackRecursive(val, wt, w, wt.length));
		System.out.println(knapsackDP(val, wt, w));

	}

	private static int knapsackRecursive(int[] val, int[] wt, int w, int n) {

		if (n == 0 || w == 0) {
			return 0;
		}

		if (wt[n - 1] <= w) {
			return Math.max(val[n - 1] + knapsackRecursive(val, wt, w - wt[n - 1], n),
					knapsackRecursive(val, wt, w, n - 1));
		} else
			return knapsackRecursive(val, wt, w, n - 1);

	}

	private static int knapsackDP(int[] val, int[] wt, int w) {
		int n = val.length;
		int[][] T = new int[n + 1][w + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= w; j++) {

				if (wt[i - 1] <= j) {
					T[i][j] = Math.max(val[i - 1] + T[i][j - wt[i - 1]], T[i - 1][j]);
				} else {
					T[i][j] = T[i - 1][j];
				}
			}
		}
		return T[n][w];

	}
}


