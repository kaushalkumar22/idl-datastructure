package com.algo.dp.lcs;

/**
 * Given two words word1 and word2, find the minimum number of steps required to
 * make word1 and word2 the same, where in each step you can delete one
 * character in either string.
 * 
 * Example 1:
 * 
 * Input: "sea", "eat" Output: 2 Explanation: You need one step to make "sea" to
 * "ea" and another step to make "eat" to "ea".
 * 
 */
public class DeleteOperationForTwoStrings {
	public static void main(String[] args) {
		System.out.println(minDistance("sea", "eat"));
		System.out.println(minOperations("geeksforgeeks", "geeks"));
		System.out.println(minOperationsOpt("geeksforgeeks", "geeks"));

	}
	public static int minDistance(String word1, String word2) {
		int dp[][] = new int[word1.length()+1][word2.length()+1];
		for(int i = 0; i <= word1.length(); i++) {
			for(int j = 0; j <= word2.length(); j++) {
				if(i == 0 || j == 0) dp[i][j] = 0;
				else dp[i][j] = (word1.charAt(i-1) == word2.charAt(j-1)) ? dp[i-1][j-1] + 1
						: Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		int val =  dp[word1.length()][word2.length()];
		return word1.length() - val + word2.length() - val;
	}
	public static int minOperations(String str1, String str2) { 
		int m = str1.length();
		int n = str2.length();

		// LCS
		int[][]dp = new int[m+1][n+1];
		for(int i=1;i<dp.length;i++){
			for(int j=1;j<dp[0].length;j++){
				if(str1.charAt(i-1) == str2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1]+1;
				}
				else{
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}


		int lcs = dp[m][n];
		int insert = n - Math.abs(lcs);
		int delete = m - Math.abs(lcs);
		return insert + delete;
	} 

	public static int minOperationsOpt(String s1, String s2) { 
		int m = s1.length(), n = s2.length();
		if (m < n) {
			return minOperationsOpt(s2, s1);
		}
		int[] dp = new int[n + 1];
		for (int i = 0; i < s1.length(); ++i) {
			for (int j = 0, prevRow = 0, prevRowPrevCol = 0; j < s2.length(); ++j) {
				prevRowPrevCol = prevRow;
				prevRow = dp[j + 1];
				if(s1.charAt(i) == s2.charAt(j)) {
					dp[j + 1] = 1+prevRowPrevCol ;
				}else 
					dp[j + 1] =  Math.max(dp[j], prevRow);
			}
		}
		//  return dp[n];
		//}

		int lcs = dp[n];
		int insert = n - Math.abs(lcs);
		int delete = m - Math.abs(lcs);
		return insert + delete;
	} 
}
