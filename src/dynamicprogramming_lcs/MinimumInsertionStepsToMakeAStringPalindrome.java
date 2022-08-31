package dynamicprogramming_lcs;

/**
 * Given a string s. In one step you can insert any character at any index of the string.
 * Return the minimum number of steps to make s palindrome.
 * A Palindrome String is one that reads the same backward as well as forward.
 *  Input: s = "zzazz" Output: 0
 * Explanation: The string "zzazz" is already palindrome we don't need any insertions.
 * Input: s = "mbadm" Output: 2
 * Explanation: String can be "mbdadbm" or "mdbabdm".
 * Input: s = "leetcode" Output: 5
 * Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 */
public class MinimumInsertionStepsToMakeAStringPalindrome {
    //based on LCS just need to reverse the string and treat this string as s2 and find LCS
    public static int minInsertions(String s) {
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
        return m-dp[m][m];

    }

    public int minInsertions1(String s) {
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
        return n-dp[n];
    }

}
