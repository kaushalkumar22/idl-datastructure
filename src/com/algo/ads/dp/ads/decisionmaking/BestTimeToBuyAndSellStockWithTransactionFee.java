package com.algo.ads.dp.ads.decisionmaking;

/**
 * Your are given an array of integers prices, for which the i-th element is the
 * price of a given stock on day i; and a non-negative integer fee representing
 * a transaction fee.
 * 
 * You may complete as many transactions as you like, but you need to pay the
 * transaction fee for each transaction. You may not buy more than 1 share of a
 * stock at a time (ie. you must sell the stock share before you buy again.)
 * 
 * Return the maximum profit you can make.
 * 
 * Input: prices = [1, 3, 2, 8, 4, 9], fee = 2 Output: 8
 * 
 * Explanation: The maximum profit can be achieved by: Buying at prices[0] = 1
 * Selling at prices[3] = 8 Buying at prices[4] = 4 Selling at prices[5] = 9 The
 * total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 *
 * 
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {
	public static void main(String[] args) {
		int[] prices = { 1, 3, 2, 8, 4, 9 };
		System.out.println(maxProfit(prices, 2));
		System.out.println(maxProfit2(prices, 2));
	}

	/*
	 * Given any day I, its max profit status boils down to one of the two status
	 * below:
	 * 
	 * (1) buy status: buy[i] represents the max profit at day i in buy status,
	 * given that the last action you took is a buy action at day K, where K<=i. And
	 * you have the right to sell at day i+1, or do nothing. (2) sell status:
	 * sell[i] represents the max profit at day i in sell status, given that the
	 * last action you took is a sell action at day K, where K<=i. And you have the
	 * right to buy at day i+1, or do nothing.
	 * 
	 * Let's walk through from base case.
	 * 
	 * Base case: We can start from buy status, which means we buy stock at day 0.
	 * buy[0]=-prices[0]; Or we can start from sell status, which means we sell
	 * stock at day 0. Given that we don't have any stock at hand in day 0, we set
	 * sell status to be 0. sell[0]=0;
	 * 
	 * Status transformation: At day i, we may buy stock (from previous sell status)
	 * or do nothing (from previous buy status): buy[i] = Math.max(buy[i - 1],
	 * sell[i - 1] - prices[i]); Or At day i, we may sell stock (from previous buy
	 * status) or keep holding (from previous sell status): sell[i] =
	 * Math.max(sell[i - 1], buy[i - 1] + prices[i]);
	 * 
	 * Finally: We will return sell[last_day] as our result, which represents the
	 * max profit at the last day, given that you took sell action at any day before
	 * the last day.
	 * 
	 * We can apply transaction fee at either buy status or sell status.
	 * 
	 */
	//pay the fee when buying the stock:
	public static int maxProfit(int[] prices, int fee) {

		int sell = 0;
		int buy =Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
			buy = Math.max(buy, sell - prices[i] - fee); // keep the same as day i-1, or buy from sell status at day i-1
			sell = Math.max(sell, buy + prices[i]); // keep the same as day i-1, or sell from buy status at day i-1
		}
		return sell;
	}
	//pay the fee when shelling the stock:
	public static int maxProfit2(int[] prices, int fee) {

		int sell = 0;
		int buy =Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
			buy = Math.max(buy, sell - prices[i] ); // keep the same as day i-1, or buy from sell status at day i-1
			sell = Math.max(sell, buy + prices[i]- fee); // keep the same as day i-1, or sell from buy status at day i-1
		}
		return sell;
	}
}
