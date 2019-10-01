package com.ds.problemset;

/**
 * Sample Input
 * 
 * 3
   3
   5 3 2
   3
   1 2 100
   buy  buy   sell

   4
   1 3 1 2
 * output
 * 0 
 * 197 
 * 3 
 */
public class StockMaximize {

	public static void main(String[] args) {

		int[] stockPrices = {6, 30, 10, 12,27,15,17,26};

		int maxProfit = calculateMaxProfit(stockPrices);
		System.out.println("Max Profit : "+maxProfit);
	}

	private static int calculateMaxProfit(int[] sPrices){

		boolean[] sellingDays = getSellingDays(sPrices);
		
		int profit =0;
		int buy=0;
		int noOfShare=0;
		for(int i=0;i<sellingDays.length;i++){
			if(sellingDays[i]==false){
				buy+=sPrices[i];
				noOfShare++;
			}else{
				profit += noOfShare*sPrices[i]-buy;
				 buy=0;
				 noOfShare=0;
			}
		}
		return profit;

	}
	 private static boolean[] getSellingDays(int[] sPrices){

		int n = sPrices.length;
		boolean[] sellingDays = new boolean[n];
		int sellOn = 0;
		for(int i=n-1;i>=0;i--){
			
			if(sPrices[i]>sellOn){
				sellingDays[i]=true;
				sellOn=sPrices[i];
			}	
		}
		return sellingDays;

	}
	/*private static boolean[] findSellingDays(int[] stockPrices, int days) {

		boolean[] sellOn = new boolean[days]; // an array to keep track on days on which we can sell
		Arrays.fill(sellOn, false); // fill with false

		int localMax = Integer.MIN_VALUE; // initialize the local max with minimum value possible

		// traverse the array from back and if there mark selling days for local maximum
		for (int i = days - 1; i >= 0; i--) {
			if (localMax < stockPrices[i]) { // found better local maximum
				localMax = stockPrices[i]; // update local maximum
				sellOn[i] = true; // sell all existing shares on this day
			}
		}
		return sellOn;
	}

	private static int calculateMaxProfit(int[] stockPrices, int days) {

		// pre-process the stock price array and find the days on which we should 
		// sell the shares for maximum profit
		boolean[] sellOn = findSellingDays(stockPrices, days);

		int totalCost = 0, totalProfit = 0;
		int numShares = 0;

		// go through all the array containing stock prices and do the transaction
		// if this is a buying day  i.e. sellOn[i] is false buy that share else if sellOn[i]
		// if true and we have something to sell then sell it else just stay put
		for (int i = 0; i < days; i++) {
			if (sellOn[i] == false) { // buy shares
				totalCost += stockPrices[i];
				numShares++;
			} else if (totalCost != 0) { // not a buying day and if we have something to sell then sell it
				totalProfit += numShares * stockPrices[i] - totalCost; // calculate the profit
				// we sold everything so reset these variables
				totalCost = 0;
				numShares = 0;
			}
		}
		return totalProfit;
	}
	 */

}
