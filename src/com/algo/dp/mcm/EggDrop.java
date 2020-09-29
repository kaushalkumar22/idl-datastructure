package com.algo.dp.mcm;

//http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/
public class EggDrop {

	// A utility function to get maximum of two integers
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	/*
	 * Function to get minimum number of trails needed in worst case with n eggs
	 * and k floors
	 */
	static int eggDrop(int n, int k) {
		/*
		 * A 2D table where entery eggFloor[i][j] will represent minimum number
		 * of trials needed for i eggs and j floors.
		 */
		int eggFloor[][] = new int[n + 1][k + 1];
		int res;
		int i, j, x;

		// We need one trial for one floor and0 trials for 0 floors
		for (i = 1; i <= n; i++) {
			eggFloor[i][1] = 1;
			eggFloor[i][0] = 0;
		}

		// We always need j trials for one egg and j floors.
		for (j = 1; j <= k; j++)
			eggFloor[1][j] = j;

		// Fill rest of the entries in table using optimal substructure
		// property
		for (i = 2; i <= n; i++) {
			for (j = 2; j <= k; j++) {
				eggFloor[i][j] = Integer.MAX_VALUE;
				for (x = 1; x <= j; x++) {
					eggFloor[i][j] = Math.min(eggFloor[i][j],
							(1 + Math.max(eggFloor[i - 1][x - 1], eggFloor[i][j - x])));
					// if (res < eggFloor[i][j])
					// eggFloor[i][j] = res;
				}
			}
		}

		// eggFloor[n][k] holds the result
		return eggFloor[n][k];

	}

	public int calculateRecursive(int eggs, int floors) {
		if (eggs == 1) {
			return floors;
		}
		if (floors == 0) {
			return 0;
		}
		int min = 1000;
		for (int i = 1; i <= floors; i++) {
			int val = 1 + Math.max(calculateRecursive(eggs - 1, i - 1), calculateRecursive(eggs, floors - i));
			if (val < min) {
				min = val;
			}
		}
		return min;
	}

	public static void main(String args[]) {
		EggDrop ed = new EggDrop();
		int r = ed.eggDrop(2, 6);
		System.out.println(r);
	}

	/**
	 * You are given K eggs, and you have access to a building with N floors
	 * from 1 to N.
	 * 
	 * Each egg is identical in function, and if an egg breaks, you cannot drop
	 * it again.
	 * 
	 * You know that there exists a floor F with 0 <= F <= N such that any egg
	 * dropped at a floor higher than F will break, and any egg dropped at or
	 * below floor F will not break.
	 * 
	 * Each move, you may take an egg (if you have an unbroken one) and drop it
	 * from any floor X (with 1 <= X <= N).
	 * 
	 * Your goal is to know with certainty what the value of F is.
	 * 
	 * What is the minimum number of moves that you need to know with certainty
	 * what F is, regardless of the initial value of F?
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: K = 1, N = 2 Output: 2 Explanation: Drop the egg from floor 1. If
	 * it breaks, we know with certainty that F = 0. Otherwise, drop the egg
	 * from floor 2. If it breaks, we know with certainty that F = 1. If it
	 * didn't break, then we know with certainty F = 2. Hence, we needed 2 moves
	 * in the worst case to know what F is with certainty. Example 2:
	 * 
	 * Input: K = 2, N = 6 Output: 3 Example 3:
	 * 
	 * Input: K = 3, N = 14 Output: 4
	 */
	/*
	 * Explanation Drop eggs is a very classical problem. Some people may come
	 * up with idea O(KN^2) where dp[K][N] = 1 + max(dp[K - 1][i - 1], dp[K][N -
	 * i]) for i in 1...N. However this idea is very brute force, for the reason
	 * that you check all possiblity.
	 * 
	 * So I consider this problem in a different way: dp[M][K]means that, given
	 * K eggs and M moves, what is the maximum number of floor that we can
	 * check.
	 * 
	 * The dp equation is: dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1, which
	 * means we take 1 move to a floor, if egg breaks, then we can check dp[m -
	 * 1][k - 1] floors. if egg doesn't breaks, then we can check dp[m - 1][k]
	 * floors.
	 * 
	 * dp[m][k] is the number of combinations and it increase exponentially to N
	 * 
	 * 
	 * Complexity For time, O(NK) decalre the space, O(KlogN) running, For
	 * space, O(NK).
	 */

	public int superEggDrop(int K, int N) {
		int[][] dp = new int[N + 1][K + 1];
		int m = 0;
		while (dp[m][K] < N) {
			++m;
			for (int k = 1; k <= K; ++k)
				dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1;
		}
		return m;
	}
}