package com.algo.dp.decisionmaking;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (i.e., buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * Note that you cannot sell a stock before you buy one.
 * 
 * Input: [7,1,5,3,6,4] Output: 5 
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5. 
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 * 
 * Input: [7,6,4,3,1] Output: 0 Explanation: In this case, no transaction is
 * done, i.e. max profit = 0.
 *
 * 
 */
public class BestTimeToBuyAndSellStock {


	public static void main(String[] args) {
		int[] prices= {1, 3, 2, 8, 4, 9};
		System.out.println(maxProfit(prices));
		System.out.println(maxProfit1(prices));
		System.out.println(maxProfit2(prices));

	}
	/*
	 * 1. Iterate the array from left and track the min price at i ,
	 *    if prices[i] less than min update the min=prices[i]
	 * 2. calculate the selling price at i as sell =prices[i]-min,
	 *    if selling is grater than max update the max=sell
	 * 
	 */
	public static int maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE, maxProfit = 0;
		for (int i=0;i<prices.length;i++) {
			min = Math.min(prices[i], min);
			maxProfit = Math.max(maxProfit, prices[i] - min);
		}
		return maxProfit;
	}
	public static int maxProfit1(int[] prices) {

		int buy1 =Integer.MAX_VALUE;
		int sell1=0;


		for(int i=0;i<prices.length;i++) {
			buy1= Math.min(buy1, prices[i]);
			sell1 = Math.max(sell1, prices[i]-buy1);		
		}
		return sell1;

	}
	
	public static int maxProfit2(int[] prices) {

		int sell = 0;
		int buy =Integer.MIN_VALUE;
		for (int i =0; i<prices.length; i++) {
			buy = Math.max(buy,  - prices[i]); 
			sell = Math.max(sell, buy + prices[i]);

		}
		return sell;
	}
}
