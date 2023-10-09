package dynamicprogramming_decisionmaking;

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
		int[] prices= {1,2,3,4,5};
		System.out.println(maxProfit(prices));
		System.out.println(maxProfit1(prices));
		System.out.println(maxProfit2(prices));
	}

	public static int maxProfit(int prices[]) {
		int buy = Integer.MIN_VALUE;
		int sell = 0;
		for (int price :prices){
			buy  = Math.max(buy, sell-price);
			sell = Math.max(sell,price+buy);
		}
		return sell;
	}
	public static int maxProfit2(int[] prices) {

		int buy =Integer.MAX_VALUE;
		int sell = 0;
		for (int price :prices){
			buy  = Math.min(buy,  price-sell);
			sell = Math.max(sell, price-buy);
		}
		return sell;
	}
	private static int maxProfit1(int[] prices) {

		int maxProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			maxProfit += Math.max(0, prices[i] - prices[i - 1]);
		}
		return maxProfit;
	}
}
