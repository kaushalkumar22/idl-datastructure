package com.algo.dp.pattern.knapshack01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 0/1 Knapsack Problem
 * 
 * Given weights and values of n items, put these items in a knapsack of
 * capacity W to get the maximum total value in the knapsack
 * 
 * Time complexity - O(W*total items)
 */
public class Knapsack01 {

	public static void main(String args[]) {
		int wt[] = { 3, 1, 5, 4 };
		int val[] = { 4, 1, 7, 5 };
		int w = 7;

		System.out.println(knapsackRecursive(val, wt, w, wt.length));
		System.out.println(knapsackDP(val, wt, w));

	}

	private static int knapsackRecursive(int[] val, int[] wt, int w, int n) {

		if (n == 0 || w == 0) {
			return 0;
		}

		if (wt[n - 1] <= w) {
			return Math.max(val[n - 1] + knapsackRecursive(val, wt, w - wt[n - 1], n - 1),
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
					T[i][j] = Math.max(val[i - 1] + T[n - 1][j - wt[i - 1]], T[i - 1][j]);
				} else {
					T[i][j] = T[i - 1][j];
				}
			}
		}
		return T[n][w];

	}

	private static int knapsackMemoization(int[] val, int[] wt, int w, int n, int T[][]) {
		return n;

	}

}