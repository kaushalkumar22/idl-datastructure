package dynamicprogramming_knapsackunbounded;

/**
 * You are given coins of different denominations and a total amount of money.
 * Write a function to compute the number of combinations that make up that
 * amount. You may assume that you have infinite number of each kind of coin.
 * Input: amount = 5, coins = [1, 2, 5] Output: 4 
 * 5=5 
 * 5=2+2+1 
 * 5=2+1+1+1
 * 5=1+1+1+1+1 
 * Example 2:
 *
 * Input: amount = 3, coins = [2] Output: 0
 *
 * This is a classic knapsack problem. dp[i][j] : the number of combinations to
 * make up amount j by using the first i types of coins not using the ith coin,
 * only using the first i-1 coins to make up amount j, then we have dp[i-1][j]
 * ways.using the ith coin, since we can use unlimited same coin, we need to
 * know how many ways to make up amount j - coins[i-1] by using first i
 * coins(including ith), which is dp[i][j-coins[i-1]]
 *
 * Initialization: dp[i][0] = 1
 *
 * Now we can see that dp[i][j] only rely on dp[i-1][j] and dp[i][j-coins[i]],
 * then we can optimize the space by only using one-dimension array.
 *
 */
public class CoinChangeII {
	public static void main(String[] args) {
		int amount = 5;
		int[] coins = { 1, 5, 2 };
		System.out.println(change(amount, coins));
		System.out.println(change1(amount, coins));
		System.out.println(change2(amount, coins));
	}
	public static int change(int amount, int[] coins) {
		int[] dp = new int[amount + 1];
		//Arrays.fill(dp, amount + 1);
		dp[0] = 1;
		for (int i = 1; i <= coins.length; i++) {
			for (int j = 1; j <=amount; j++) {
				if (coins[i-1] <= j) {
					dp[j] = dp[j]+dp[j - coins[i-1]];
				}
			}
		}
		return dp[amount];
	}
	/*
	 * This is a classic knapsack problem. Honestly, I'm not good at knapsack
	 * problem, it's really tough for me.
	 *
	 * dp[i][j] : the number of combinations to make up amount j by using the first
	 * i types of coins State transition:
	 *
	 * not using the ith coin, only using the first i-1 coins to make up amount j,
	 * then we have dp[i-1][j] ways. using the ith coin, since we can use unlimited
	 * same coin, we need to know how many ways to make up amount j - coins[i-1] by
	 * using first i coins(including ith), which is dp[i][j-coins[i-1]]
	 *
	 * Initialization: dp[i][0] = 1
	 *
	 * Once you figure out all these, it's easy to write out the code:
	 */
	public static int change1(int amount, int[] coins) {
		int[][] dp = new int[coins.length+1][amount+1];
		dp[0][0] = 1;

		for (int i = 1; i <= coins.length; i++) {
			dp[i][0] = 1;
			for (int j = 1; j <= amount; j++) {
				if( coins[i-1]<=j)
					dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
			}
		}
		return dp[coins.length][amount];
	}

	//Now we can see that dp[i][j] only rely on dp[i-1][j] and dp[i][j-coins[i]], 
	//then we can optimize the space by only using one-dimension array.

	public static int change2(int amount, int[] coins) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		for (int coin : coins) {
			for (int i = coin; i <= amount; i++) {
				dp[i] += dp[i-coin];
			}
		}
		return dp[amount];
	}

}
