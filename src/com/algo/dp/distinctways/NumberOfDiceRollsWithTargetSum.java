package com.algo.dp.distinctways;

import java.util.Arrays;

/**
 * 
 * Given an integer n, your task is to count how many strings of length n can be
 * formed under the following rules:
 * 
 * Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u') Each vowel 'a'
 * may only be followed by an 'e'. Each vowel 'e' may only be followed by an 'a'
 * or an 'i'. Each vowel 'i' may not be followed by another 'i'. Each vowel 'o'
 * may only be followed by an 'i' or a 'u'. Each vowel 'u' may only be followed
 * by an 'a'.
 * 
 * Since the answer may be too large, return it modulo 10^9 + 7.
 * 
 * Input: n = 1 Output: 5 Explanation: All possible strings are: "a", "e", "i" ,
 * "o" and "u".
 * 
 * Input: n = 2 Output: 10 Explanation: All possible strings are: "ae", "ea",
 * "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".
 * 
 * Input: n = 5 Output: 68
 *
 */
//This problem is like 518. Coin Change 2, with the difference that the total number of coins (dices) should be equal to d.
public class NumberOfDiceRollsWithTargetSum {

	public static void main(String[] args) {
		System.out.println(countVowelPermutation(144));
		System.out.println(countVowelPermutation1(144));
	}
	/*
	 * 0: a 1: e 2: i 3: o 4: u moves { a={1}, e={0, 2}, i={0, 1, 3, 4}, o={2, 4},
	 * u={ 0 } };
	 * 

	 */
	// time O(n) and space O(1)

	public static int countVowelPermutation1(int n) {
		int[] cur = new int[5], next = new int[5];
		Arrays.fill(cur, 1);
		int mod = 1_000_000_007;
		for (int i = 1; i < n; ++i) {
			next[0] = cur[1];
			next[1] = (cur[0] + cur[2]) % mod;
			next[2] = (((cur[0] + cur[1]) % mod + cur[3]) % mod + cur[4]) % mod;
			next[3] = (cur[2] + cur[4]) % mod;
			next[4] = cur[0];
			int[] tmp = cur;
			cur = next;
			next = tmp;
		}
		int res = 0;
		for (int c : cur) res = (res + c) % mod;
		return res;
	}
	
	//* time and space O(n)
	public static int countVowelPermutation(int n) {
		int MOD = (int) (1e9 + 7);// 1000000007 given in question
		long[][] dp = new long[n + 1][5];

		for (int i = 0; i < 5; i++) {
			dp[1][i] = 1;
		}

		for (int i = 1; i < n; i++) {
			dp[i + 1][0] = (dp[i][1]) % MOD;
			dp[i + 1][1] = (dp[i][0] + dp[i][2]) % MOD;
			dp[i + 1][2] = (dp[i][0] + dp[i][1] + dp[i][3] + dp[i][4]) % MOD;
			dp[i + 1][3] = (dp[i][2] + dp[i][4]) % MOD;
			dp[i + 1][4] = (dp[i][0]) % MOD;
		}

		int ans = 0;
		for (int i = 0; i < 5; i++)
			ans = (int) ((ans + dp[n][i]) % MOD);
		return ans;
	}

}
