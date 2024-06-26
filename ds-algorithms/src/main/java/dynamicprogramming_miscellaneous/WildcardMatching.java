package dynamicprogramming_miscellaneous;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
 * 	• '?' Matches any single character.
 * 	• '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *  Input: s = "aa", p = "a"
 * Output: false Explanation: "a" does not match the entire string "aa".
 * Input: s = "aa", p = "*"
 * Output: true Explanation: '*' matches any sequence.
 * Input: s = "cb", p = "?a"
 * Output: false Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 */
public class WildcardMatching {
    private boolean wildcardMatchingLinearLime(String str, String pattern) {

        int sIndex = 0, pIndex = 0,match = 0,starIdx = -1;
        // String s="acdcb"; String p="a*c?b";
        while (sIndex < str.length()) {
            if (pIndex < pattern.length()
                    && (pattern.charAt(pIndex) == '?' || str.charAt(sIndex) == pattern.charAt(pIndex))) {
                sIndex++;// advancing both pointers
                pIndex++;
            } else if (pIndex < pattern.length() && pattern.charAt(pIndex) == '*') {//found, only advancing pattern
                // pointer
                starIdx = pIndex;
                match = sIndex;
                pIndex++;
            } else if (starIdx != -1) {// last pattern pointer was *, advancing string pointer
                pIndex = starIdx + 1;
                match++;
                sIndex = match;
            } else // current pattern pointer is not star, last patter pointer was not * characters
                // do not match
                return false;
        }
        while (pIndex < pattern.length() && pattern.charAt(pIndex) == '*')// check for remaining characters in pattern
            pIndex++;
        return pIndex == pattern.length();
    }


    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int j = 1; j < n + 1; j++){
            if(p.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 1];
        }
        for(int i = 1; i <= m ; i++){
            for(int j = 1; j <= n; j++){
                if(p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?'){
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(p.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }
}

