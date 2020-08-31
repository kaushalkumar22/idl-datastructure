package com.algo.dp.pattern.decisionmaking;

/**
 * Say you have an array prices for which the ith element is the price of a
 * given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (i.e., buy one and sell one share of the stock
 * multiple times).
 * 
 * Note: You may not engage in multiple transactions at the same time (i.e., you
 * must sell the stock before you buy again).
 * 
 * Input: [7,1,5,3,6,4] Output: 7 
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4. 
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * 
 * Input: [1,2,3,4,5] Output: 4 
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4. 
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging 
 * multiple transactions at the same time. You must sell before buying again.
 * 
 * Input: [7,6,4,3,1] Output: 0 
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 */
public class BestTimeToBuyAndSellStockII {
	public static void main(String[] args) {
		int[] prices= {7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
		System.out.println(maxProfit2(prices));
	}
	/*
	 * Iterate the array from index 1 calculate the selling price at i as sell =prices[i]-prices[i-1];
	 * if sell price is >0 add to maxProfit i.e maxProfit = maxProfit+Math.max(0, sell);
	 * 
	 */
	private static int maxProfit(int[] prices) {

		int maxProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			maxProfit += Math.max(0, prices[i] - prices[i - 1]);
		}
		return maxProfit;
	}
	public static int maxProfit2(int[] prices) {

		int sell = 0;
		int buy =Integer.MIN_VALUE;
		for (int i =0; i<prices.length; i++) {
			buy = Math.max(buy, sell - prices[i]); // keep the same as day i-1, or buy from sell status at day i-1
			sell = Math.max(sell, buy + prices[i]); // keep the same as day i-1, or sell from buy status at day i-1
		}
		return sell;
	}
}
