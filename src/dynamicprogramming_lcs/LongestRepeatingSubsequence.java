package dynamicprogramming_lcs;
//AABEBCDD //ABD twice

/**
 * Given a string S, find out the length of the longest repeating Subsequence.
 *
 * Input: "AABEBCDD" Output: ABD.
 */
public class LongestRepeatingSubsequence {
	public static void main(String[] args) {
		String s ="AABEBCDD";
		System.out.println(longestRepeatingSubsequence( s));
	}
	public static String longestRepeatingSubsequence(String s) {
		return LCS(s,s) ;

	}
	private static String LCS(String s1, String s2) { 
		int m=s1.length();
		int n=s2.length();
		int[][] dp = new int[m+1][n+1];

		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1) && i!=j) // this is the only extra condition
					dp[i][j]=1+dp[i-1][j-1];
				else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
			}
		}
		//only length needed return from here return dp[m][n];

		// THIS PART OF CODE FINDS THE RESULT STRING USING DP[][]
		StringBuilder res = new StringBuilder();
		// Traverse dp[][] from bottom right
		int i = n, j = n;
		while (i > 0 && j > 0){
			// If this cell is same as diagonally adjacent cell just above it, thensame characters 
			//are present at str[i-1] and str[j-1]. Append any of them to result.
			if (dp[i][j] == dp[i-1][j-1] + 1){
				res.append(s1.charAt(i-1));
				i--;
				j--;
			}
			// Otherwise we move to the side that that gave us maximum result
			else if (dp[i][j] == dp[i-1][j])
				i--;
			else
				j--;
		}

		// Since we traverse dp[][] from bottom, we get result in reverse order.
		res.reverse();

		return res.toString();
	}
}

