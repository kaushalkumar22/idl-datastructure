package dynamicprogramming_lcs;

/**
 * Given a string s, find the longest palindromic subsequence's length in s. You
 * may assume that the maximum length of s is 1000.
 * 
 * Input:"bbbab" Output: 4  One possible longest palindromic subsequence is "bbbb".
 * Input: "cbbd" Output: 2
 * 
 *
 */
public class LongestPalindromicSubsequence {
	public static void main(String args[]) {
		String s = "agbdba";
		//System.out.println(longestPalindromeSubseq( s));
		System.out.println(longestPalindromeSubseq( s));
		System.out.println(longestPalindromeSubseq1( s));

	}
	//based on LCS just need to reverse the string and treat this string as s2 and find LCS
	public static int longestPalindromeSubseq(String s) {
		int m=s.length();
		int[][] dp = new int[m+1][m+1];
		for (int i = 1; i <m+1; i++) {
			for (int j = 1; j <m+1; j++) {
				if(s.charAt(i-1)==s.charAt(m-j)) {
					dp[i][j]=1+dp[i-1][j-1];
				}else {
					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		return dp[m][m];

	}
	//based on LCS just need to reverse the string and treat this string as s2 and find LCS
	public static int longestPalindromeSubseq1(String s) {
		int n = s.length();
		int[] dp = new int[n + 1];
		for (int i = 1; i <=n; ++i) {
			for (int j = 1, prevRow = 0, prevRowPrevCol = 0; j <=n; ++j) {
				prevRowPrevCol = prevRow;
				prevRow = dp[j];
				if(s.charAt(i-1) == s.charAt(n-(j-1)-1)) {
					dp[j] = 1+prevRowPrevCol ;
				}else 
					dp[j] =  Math.max(dp[j-1], prevRow);
			}
		}
		return dp[n];
	}
}