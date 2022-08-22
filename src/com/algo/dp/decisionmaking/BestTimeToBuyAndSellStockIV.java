package com.algo.dp.decisionmaking;

import java.util.Arrays;

/**
 * You are given an integer array prices where prices[i] is the price of a given
 * stock on the ith day, and an integer k.
 * 
 * Find the maximum profit you can achieve. You may complete at most k
 * transactions.
 * 
 * Note: You may not engage in multiple transactions simultaneously (i.e., you
 * must sell the stock before you buy again).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: k = 2, prices = [2,4,1] Output: 2 Explanation: Buy on day 1 (price =
 * 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * 
 * Example 2:
 * 
 * Input: k = 2, prices = [3,2,6,5,0,3] Output: 7 Explanation: Buy on day 2
 * (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day
 * 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *
 */
public class BestTimeToBuyAndSellStockIV {
	public static void main(String[] args) {
		System.out.println(maxProfit(2, new int[] {3,2,6,5,0,3}));
		System.out.println(maxProfit2(2, new int[] {3,2,6,5,0,3}));
	}

	public static int maxProfit(int k, int[] prices) {

		int len = prices.length;
		if(k>len/2) return maxProfit(prices);

		int[] minPrice = new int[k+1];
		Arrays.fill(minPrice, Integer.MAX_VALUE);
		int[] maxProfit = new int[k+1];
		for (int i =0; i<prices.length; i++) {
			for (int j =1; j<=k; j++) {
				minPrice[j]  = Math.min(minPrice[j],  prices[i]-maxProfit[j-1]); 
				maxProfit[j] = Math.max(maxProfit[j], prices[i]-minPrice[j]);
			}
		}
		return maxProfit[k];

	}

	public static int maxProfit(int[] prices) {
		int buy =Integer.MAX_VALUE;
		int sell = 0;
		for (int i =0; i<prices.length; i++) {
			buy  = Math.min(buy,  prices[i]-sell); 
			sell = Math.max(sell, prices[i]-buy);
		}
		return sell;
	}
	
	public static int maxProfit2(int k, int[] prices) {
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
}
