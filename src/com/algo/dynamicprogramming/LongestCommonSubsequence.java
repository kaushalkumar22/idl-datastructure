package com.algo.dynamicprogramming;

public class LongestCommonSubsequence {

	public static void main(String[] args) {

		String x = "AGGTABCZA";
		String y = "GXTXAYBCAZ";

		char X[] = x.toCharArray();
		char Y[] = y.toCharArray();
		int m = X.length;
		int n = Y.length;
		int length= LCSLength( X, Y, m, n );
		System.out.println("Length of LCS is:"+ length );	
	}
	public static int LCSLength(char X[], char Y[],int m,int n){

		int[][] LCS = new int[m+1][n+1];

		for(int i=0;i<m;i++){
			LCS[i][0] = 0;
			//System.out.println("Length of LCS is111:");	
		}
		for(int j=0;j<n;j++){
			LCS[0][j] = 0;
			//System.out.println("Length of LCS is222:");	
		}

		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){

				if( X[i-1] ==Y[j-1]){
					LCS[i][j] = LCS[i-1][j-1]+1;

				}else{
					if(LCS[i][j-1]>LCS[i-1][j]){
						LCS[i][j] = LCS[i][j-1];
					}else{
						LCS[i][j] = LCS[i-1][j];	
					}	
				}
			}
		}

		return LCS[m][n];

		/*int[][] C = new int[m+1][n+1];
		for(int i=0;i<=m;i++){
			C[i][n] = 0;
		//System.out.println("Length of LCS is111:");	
		}
		for(int j=0;j<=n;j++){
			C[m][j] = 0;
			//System.out.println("Length of LCS is222:");	
		}
		for(int i=m-1;i>=0;i--){
			for(int j=n-1;j>=0;j--){

				C[i][j] = C[i+1][j+1];
				if( X[i] ==Y[j]){
					C[i][j]++;
					System.out.println("Length of LCS is222:");	
				}
				if(C[i][j+1]>C[i][j]){
					C[i][j] = C[i][j+1];
				}
				if(C[i+1][j]>C[i][j]){
					C[i][j] = C[i+1][j];	
				}	
			}
		}
		return C[0][0];
		 */
	}

}
