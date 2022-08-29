package dynamicprogramming_knapsackunbounded;

/**
 * 
 * Given a rod of length n inches and an array of prices that contains prices of
 * all pieces of size smaller than n. Determine the maximum value obtainable by
 * cutting up the rod and selling the pieces. For example, if length of the rod
 * is 8 and the values of different pieces are given as following, then the
 * maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 * 
 * 
 * length   | 1   2   3   4   5   6   7   8  
 *--------------------------------------------
 * price    | 1   5   8   9  10  17  17  20
 *
 * 
 */
public class RodCutting {

	public static void main(String args[]) {
		int length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
		int K = 8;

		System.out.println(knapsackRecursive(price, length, K, length.length));
		System.out.println(knapsackDP(price, length, K));

	}

	private static int knapsackRecursive(int[] price, int[] length, int K, int n) {

		if (n == 0 || K == 0) {
			return 0;
		}

		if (length[n - 1] <= K) {
			return Math.max(price[n - 1] + knapsackRecursive(price, length, K - length[n - 1], n),
					knapsackRecursive(price, length, K, n - 1));
		} else
			return knapsackRecursive(price, length, K, n - 1);

	}

	private static int knapsackDP(int[] price, int[] length, int K) {
		int n = price.length;
		int[][] T = new int[n + 1][K + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= K; j++) {

				if (length[i - 1] <= j) {
					T[i][j] = Math.max(price[i - 1] + T[i][j - length[i - 1]], T[i - 1][j]);
				} else {
					T[i][j] = T[i - 1][j];
				}
			}
		}
		return T[n][K];

	}
/*	private static int knapsackDPOpt(int[] price, int[] length, int K) {
		int n = price.length;
		int[] T = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= K; j++) {

				if (length[i - 1] <= j) {
					//T[i][j] = Math.max(price[i - 1] + T[i][j - length[i - 1]], T[i - 1][j]);
				} else {
				//	T[i][j] = T[i - 1][j];
				}
			}
		}
		return //T[n][K];*/

	}
