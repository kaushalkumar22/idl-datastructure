package com.algo.dynamicprogramming;

/**
 * We have two types of tiles: a 2x1 domino shape, and an "L" tromino shape.
 * These shapes may be rotated. XX <- domino
 * 
 * XX <- "L" tromino X Given N, how many ways are there to tile a 2 x N board?
 * Return your answer modulo 10^9 + 7. (In a tiling, every square must be
 * covered by a tile. Two tilings are different if and only if there are two
 * 4-directionally adjacent cells on the board such that exactly one of the
 * tilings has both squares occupied by a tile.) Example: Input: 3 Output: 5
 * Explanation: The five different ways are listed below, different letters
 * indicates different tiles: XYZ XXZ XYY XXY XYY XYZ YYZ XZZ XYY XXY
 * 
 *
 */
public class DominoAndTrominoTiling {

	/*
	 * when N==0, we need return 0, but in dp , we need make dp[0]=1 for easy to
	 * construct formula dp[n]=dp[n-1]+dp[n-2]+ 2*(dp[n-3]+...+d[0])
	 * =dp[n-1]+dp[n-2]+dp[n-3]+dp[n-3]+2*(dp[n-4]+...+d[0])
	 * =dp[n-1]+dp[n-3]+(dp[n-2]+dp[n-3]+2*(dp[n-4]+...+d[0]))
	 * =dp[n-1]+dp[n-3]+dp[n-1] =2*dp[n-1]+dp[n-3]
	 */	
	 int numTilings(int N) {
		    int md=1e9;
		    md+=7;
		    vector<long long> v(1001,0);
		    v[1]=1;
		    v[2]=2;
		    v[3]=5;
		    if(N<=3)
		        return v[N];
		    for(int i=4;i<=N;++i){
		        v[i]=2*v[i-1]+v[i-3]; 
		        v[i]%=md;
		    }
		    return v[N];
		    
		}
}
