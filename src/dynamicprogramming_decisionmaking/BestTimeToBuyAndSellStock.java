package dynamicprogramming_decisionmaking;

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
		int[] prices = {1, 3, 2, 8, 4, 9};
		System.out.println(maxProfit(prices));
		System.out.println(maxProfit1(prices));
	}
	public static int maxProfit(int prices[]) {
		int buy = Integer.MIN_VALUE;
		int sell = 0;
		for (int price :prices){
			buy  = Math.max(buy,-price);
			sell = Math.max(sell,price+buy);
		}
		return sell;
	}
	public static int maxProfit1(int prices[]) {
		int buy = Integer.MAX_VALUE;
		int sell = 0;
		for (int price :prices){
			buy  = Math.min(buy,price);
			sell = Math.max(sell,price-buy);
		}
		return sell;
	}
}
