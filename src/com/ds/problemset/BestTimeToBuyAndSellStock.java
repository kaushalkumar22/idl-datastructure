package com.ds.problemset;
/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Selling price needs to be larger than buying,
 * Note that you cannot sell a stock before you buy one.
 *
 */
public class BestTimeToBuyAndSellStock {
	/**
	 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), 
	 * design an algorithm to find the maximum profit.
	 * Input: [7,1,5,3,6,4]
	 * Output: 5
	 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
	 * 
	 * The logic to solve this problem is same as "max subarray problem" using Kadane's Algorithm. 
	 * Since no body has mentioned this so far, I thought it's a good thing for everybody to know.
	 * @param prices
	 * @return
	 */
	public static int maxProfitI(int[] prices) {
		int maxCur = 0, maxSoFar = 0;
		for(int i = 1; i < prices.length; i++) {
			maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
			maxSoFar = Math.max(maxCur, maxSoFar);
		}
		return maxSoFar;

	}
	/**
	 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
	 * (i.e., buy one and sell one share of the stock multiple times).
	 *Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
	 *Input: [7,1,5,3,6,4]
	 *Output: 7
	 *Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
	 *Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.

	 * @param prices
	 * @return
	 */
	public static int maxProfitII(int[] prices) {

		int total = 0;
		for (int i=0; i< prices.length-1; i++) {
			if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
		}

		return total;

	}
	/**
	 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
	 *Note: You may not engage in multiple transactions at the same time (i.e., you must sell the 
	 *stock before you buy again).
	 *Input: [3,3,5,0,0,3,1,4]
	 *Output: 6
	 *Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
	 *Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
	 *
	 *
	 * @param prices
	 * @return
	 */
	public static int maxProfitIII(int[] prices) {
		int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
		int release1 = 0, release2 = 0;
		for(int i:prices){                              // Assume we only have 0 money at first
			release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
			hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
			release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
			hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far. 
		}
		return release2; ///Since release1 is init 

	}
	/**
	 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
	 *You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
	 *Input: [2,4,1], k = 2
	 *Output: 2
	 *Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.

	 * @param prices
	 * @return
	 */
	public static int maxProfitIV(int k,int[] prices) {
		if ( k < 1 ){
			return 0; 
		}

		if ( prices == null || prices.length <= 1 ){
			return 0; 
		}

		//fix for memory problem in frequent trades 
		if ( k >= prices.length/2 ){
			int profit = 0; 
			for (int i = 1; i < prices.length; i++){
				if (prices[i] > prices[i-1] ){
					profit += prices[i] - prices[i-1];
				}
			}
			return profit; 
		}

		//DP for at most k trades
		int[] buy = new int[k+1]; 
		int[] sell = new int[k+1]; 

		for (int i = 0; i <= k; i++){
			buy[i] = Integer.MIN_VALUE;
			sell[i] = 0;
		}

		for (int i = 0; i < prices.length; i++){
			for (int j = k; j > 0; j--){
				sell[j] = Math.max(sell[j], prices[i] + buy[j]);
				buy[j] = Math.max(buy[j], sell[j-1] - prices[i]);
			}
		}

		return sell[k];

	}
	/**
	 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

	    You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
	    After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

	Input: [1,2,3,0,2]
	Output: 3 
	Explanation: transactions = [buy, sell, cooldown, buy, sell]
	 */
	public static int maxProfitV(int[] prices) {
		int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
		for (int price : prices) {
			prev_buy = buy;
			buy = Math.max(prev_sell - price, prev_buy);
			prev_sell = sell;
			sell = Math.max(prev_buy + price, prev_sell);
		}
		return sell;
	}
	/**
	 * /**
	 * Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; 
	 * and a non-negative integer fee representing a transaction fee.
*You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. 
*You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)

Return the maximum profit you can make.
Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
Buying at prices[0] = 1
Selling at prices[3] = 8
Buying at prices[4] = 4
Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
	 */
	public static int maxProfitVI(int[] prices, int fee) {
		int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

		for (int price : prices) {
			int T_ik0_old = T_ik0;
			T_ik0 = Math.max(T_ik0, T_ik1 + price);
			T_ik1 = Math.max(T_ik1, T_ik0_old - price - fee);
		}

		return T_ik0;
	}
	public static void main(String[] args) {
		int[] price1 = {7,1,5,3,6,4};
		int[] price2 = {3,3,5,0,0,3,1,4};
		int[] price3 = {3,3,5,0,0,3,1,4};
		int[] price4 = {2,4,1};
		int[] price5 = {1,2,3,0,2};
		int[] price6 = {1, 3, 2, 8, 4, 9};
		System.out.println(maxProfitI(price1));
		System.out.println(maxProfitII(price2));
		System.out.println(maxProfitIII(price3));
		System.out.println(maxProfitIV(2,price4));
		System.out.println(maxProfitV(price5));
		System.out.println(maxProfitVI(price6,2));
	}

}
