package dynamicprogramming_decisionmaking;

/**
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * 
 * Find the maximum profit you can achieve. You may complete as many
 * transactions as you like (i.e., buy one and sell one share of the stock
 * multiple times) with the following restrictions:
 * 
 * After you sell your stock, you cannot buy stock on the next day (i.e.,
 * cooldown one day).
 * 
 * Note: You may not engage in multiple transactions simultaneously (i.e., you
 * must sell the stock before you buy again).
 * 
 * Example 1:
 * 
 * Input: prices = [1,2,3,0,2] Output: 3 Explanation: transactions = [buy, sell,
 * cooldown, buy, sell]
 * 
 * Example 2:
 * 
 * Input: prices = [1] Output: 0
 * 
 * @author kaush
 *
 */
public class BestTimeToBuyAndSellStockWithCooldown {
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] {1,2,3,0,2}));
		System.out.println(maxProfit2(new int[] {1,2,3,0,2}));
	}
	public static int maxProfit(int[] prices) {

		int minPrice =Integer.MAX_VALUE;
		int maxProfit = 0;
		int maxProfitPrev=0;
		for (int i =0; i<prices.length; i++) {
			int maxProfitOld=maxProfit;
			minPrice  = Math.min(minPrice,  prices[i]-maxProfitPrev); 
			maxProfit = Math.max(maxProfit, prices[i]-minPrice);
			maxProfitPrev=maxProfitOld;
		}
		return maxProfit;
	}

	public static int maxProfit2(int[] prices) {
		int sellPrev = 0, sell = 0, buy = Integer.MIN_VALUE;
		for (int price : prices) {
			int sellOld = sell;
			buy = Math.max(buy, sellPrev - price);
			sell = Math.max(sell, buy + price);
			sellPrev = sellOld;
		}

		return sell;
	}


}
