package com.algo.dp.decisionmaking;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (i.e., you
 * must sell the stock before you buy again).
 * 
 * 
 * Input: [3,3,5,0,0,3,1,4] Output: 6 Explanation: Buy on day 4 (price = 0) and
 * sell on day 6 (price = 3), profit = 3-0 = 3. Then buy on day 7 (price = 1)
 * and sell on day 8 (price = 4), profit = 4-1 = 3.
 * 
 * 
 * Input: [1,2,3,4,5] Output: 4 Explanation: Buy on day 1 (price = 1) and sell
 * on day 5 (price = 5), profit = 5-1 = 4. Note that you cannot buy on day 1,
 * buy on day 2 and sell them later, as you are engaging multiple transactions
 * at the same time. You must sell before buying again.
 * 
 * Example 3:
 * 
 * Input: [7,6,4,3,1] Output: 0 Explanation: In this case, no transaction is
 * done, i.e. max profit = 0.
 *
 * 
 * 
 */
public class BestTimeToBuyAndSellStockIII {
	public static void main(String[] args) {
		int[] prices= {3,3,5,0,0,3,1,4};
		System.out.println(maxProfit(prices));
		System.out.println(maxProfit2(prices));
	}
	public static int maxProfit(int[] prices) {
        int minPriceT1 = Integer.MAX_VALUE;
        int maxProfitT1 = 0;
        int minPriceT2 = Integer.MAX_VALUE;
        int maxProfitT2 = 0;
        for (int i = 0; i < prices.length; i++) {         
            minPriceT1  =  Math.min(minPriceT1,prices[i]);
            maxProfitT1 =  Math.max(maxProfitT1,prices[i]-minPriceT1);
            minPriceT2  = Math.min(minPriceT2,prices[i]-maxProfitT1);
            maxProfitT2 = Math.max(maxProfitT2,prices[i]-minPriceT2);
        }
        return maxProfitT2;
    }

	public static int maxProfit2(int[] prices) {

		int buy1 =Integer.MIN_VALUE;
		int sell1=0;
		int buy2 =Integer.MIN_VALUE;
		int sell2=0;

		for(int i=0;i<prices.length;i++) {
			buy1= Math.max(buy1, -prices[i]);
			sell1 = Math.max(sell1, prices[i]+buy1);
			buy2 = Math.max(buy2, sell1-prices[i]);
			sell2 = Math.max(sell2, prices[i]+buy2);
		}
		return sell2;

	}
	//buy = Math.max(buy, sell - prices[i]); // keep the same as day i-1, or buy from sell status at day i-1
	//sell = Math.max(sell, buy + prices[i]); // keep the same as day i-1, or sell from buy status at day i-1
}
