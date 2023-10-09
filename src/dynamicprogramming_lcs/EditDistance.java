package dynamicprogramming_lcs;

import java.util.TreeMap;

/**
 * 
 * Given two words word1 and word2, find the minimum number of operations
 * required to convert word1 to word2.
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * Insert a character Delete a character Replace a character
 * 
 * Input: word1 = "horse", word2 = "ros" Output: 3 Explanation: horse -> rorse
 * (replace 'h' with 'r') rorse -> rose (remove 'r') rose -> ros (remove 'e')
 * 
 * Input: word1 = "intention", word2 = "execution" Output: 5 
 * Explanation:
 * intention -> inention (remove 't') 
 * inention -> enention (replace 'i' with 'e') 
 * enention -> exention (replace 'n' with 'x') 
 * exention -> exection (replace 'n' with 'c') 
 * exection -> execution (insert 'u')
 *
 */
public class EditDistance {

	public static void main(String args[]) {
		TreeMap<Integer,Integer> map;
		String str1 = "azced";
		String str2 = "abcdef";
		int result = minDistance1(str1, str2);
		System.out.println("Minimum Edit Distance: " + result);
		System.out.println(minDistance(str1, str2));
		System.out.println(minDistanceRec(str1, str2));
	}
	public static int minDistanceRec(String s1, String s2) {
		return dfs(s1,s2,0,0);
	}

	private static int dfs(String s1, String s2, int i, int j) {
		if(s1.length()==0) return s2.length();
		if(s2.length()==0) return s1.length();
		if (s1.length() == i) {
			return s2.length() - j;
		}
		if (s2.length() == j) {
			return s1.length() - i;
		}
		int res;
		if(s1.charAt(i)==s2.charAt(j)){
			res = dfs(s1,s2,i+1,j+1);
		}else {
			int insert = dfs(s1,s2,i,j+1);
			int delete = dfs(s1,s2,i+1,j);
			int replace = dfs(s1,s2,i+1,j+1);
			res = Math.min(insert, Math.min(delete,replace))+1;
		}
		return res;
	}

	/**
	 * Uses bottom up DP to find the edit distance
	 */
	public static int minDistance1(String str1, String str2) {
		int dp[][] = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = i;
		}
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = i;
		}
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
				}
			}
		}
		return dp[str1.length()][str2.length()];
	} 

	public static int minDistance(String word1, String word2) {
		int m = word1.length(), n = word2.length(), pre;
		int[] dp= new int[n+1];
		for (int j = 1; j <= n; j++) {
			dp[j] = j;
		}
		for (int i = 1; i <= m; i++) {
			pre = dp[0];
			dp[0] = i;
			for (int j = 1; j <= n; j++) {
				int temp = dp[j];
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[j] = pre;
				} else {
					dp[j] = Math.min(pre, Math.min(dp[j - 1], dp[j])) + 1;
				}
				pre = temp;
			}
		}
		return dp[n];
	}



}
