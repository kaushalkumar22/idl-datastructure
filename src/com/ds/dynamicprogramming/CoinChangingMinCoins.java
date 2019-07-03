package com.ds.dynamicprogramming;

public class CoinChangingMinCoins {

	public static void main ( String args[] ) {
		int total = 15;
		int coins[] = {7, 3, 2, 6};
		CoinChangingMinCoins cc = new CoinChangingMinCoins();
		int bottomUpValue = cc.minCoin(total, coins);
		System.out.print(String.format("Bottom up and top down result %s", bottomUpValue));
	}

	private int minCoin(int total, int[] coins) {
		
		int[] T = new int[total+1];
		int[] R = new int[total+1];
		T[0] = 0;
		R[0] = 0;
		for(int i=1; i <= total; i++){
			T[i] = Integer.MAX_VALUE-1;
			R[i] = -1;
		}
		for(int i=0;i<coins.length;i++){
			for(int j=coins[i];j<=total;j++){
				if (T[j - coins[i]] + 1 < T[j]) {
			  		R[j] = i;
				}
				if(j>=coins[i]){
					T[j] = Math.min(T[j - coins[i]] + 1 , T[j]);
				
				}
				
				
			}
		}
		for(int i=0; i <= total; i++){
			System.out.print(" "+T[i]);
			System.out.print(" "+R[i]);
System.out.println();
		}
		
		printCoinCombination(R, coins);
		return T[total];
	}
	private void printCoinCombination(int R[], int coins[]) {
		if (R[R.length - 1] == -1) {
			System.out.print("No solution is possible");
			return;
		}
		int start = R.length - 1;
		System.out.print("Coins used to form total ");
		while ( start != 0 ) {
			int j = R[start];
			System.out.print(coins[j] + " ");
			start = start - coins[j];
		}
		System.out.print("\n");
	}

}
