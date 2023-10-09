package dynamicprogramming_lcs;

/**
 * Given a string s, return the longest palindromic substring in s.
 *
 * Input: s = "babad" Output: "bab" Note: "aba" is also a valid answer.
 * 
 * Input: s = "cbbd" Output: "bb"
 * 
 * Input: s = "a" Output: "a"
 * 
 * Input: s = "ac" Output: "a"
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 1000 s consist of only digits and English letters
 * (lower-case and/or upper-case),
 * 
 */
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		String s = "aacdefcaa";
		System.out.println(longestPalindrome(s));
		System.out.println(longestPalindrome2(s));
		System.out.println(longestPalindromeManacher(s));

	}

	public static String longestPalindrome(String s) {
		if (s == null || s.length() < 1) return "";
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private static int expandAroundCenter(String s, int left, int right) {
		int L = left, R = right;
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}

	public static String longestPalindrome2(String s) {
		int n = s.length();
		int palindromeStartsAt = 0, maxLen = 0;
		boolean[][] dp = new boolean[n][n];// starting at index i and ending at j is palindrome
		for (int i = 0; i < n; i++) { // keep increasing the possible palindrome string
			for (int j = i; j >= 0; j--) { // find the max palindrome within this window of (i,j)
				// check if substring between (i,j) is palindrome
				dp[i][j] = (s.charAt(i) == s.charAt(j)) // chars at i and j should match
						&& (i - j < 3 // if window is less than or equal to 3, just end chars should match
								|| dp[i - 1][j + 1]); // if window is > 3, substring (i+1, j-1) should be palindrome too
				// update max palindrome string
				if (dp[i][j] && (i - j + 1 > maxLen)) {
					palindromeStartsAt = j;
					maxLen = i - j + 1;
				}
			}
		}
		return s.substring(palindromeStartsAt, palindromeStartsAt + maxLen);
	}



	private static String longestPalindromeManacher(String s) {
		String s1 = preprocess(s);
		char[] t = s1.toCharArray();
		int n = t.length;
		int[] p = new int[n];
		int C = 0, R = 0;
		// int center = 0;
		// int right = 0;

		for (int i = 1; i < t.length - 1; i++) {
			int mirror = 2 * C - i; // equals to i' = C - (i-C)

			if (R > i)
				p[i] = Math.min(R - i, p[mirror]);// becase min will fall
			// between C-R

			// attempt to expand palindrome centered at i
			while (t[i + (1 + p[i])] == t[i - (1 + p[i])])
				p[i]++;

			// if palindrome centered at i expands past right,
			// adjust center based on expanded palindrome.
			if (i + p[i] > R) {
				C = i;
				R = i + p[i];
			}
		}

		int length = 0; // length of longest palindromic substring
		C = 0; // center of longest palindromic substring
		for (int i = 1; i < p.length - 1; i++) {
			if (p[i] > length) {
				length = p[i];
				C = i;
			}
		}
		return s.substring((C - 1 - length) / 2, (C - 1 + length) / 2);
	}
	// Transform S into T. For example, S = "abba", T = "^#a#b#b#a#$".
	// ^ and $ signs are sentinels appended to each end to avoid bounds checking
	private static String preprocess(String s) {
		int n = s.length();
		if (n == 0)
			return "^$";
		String ret = "^";
		for (int i = 0; i < n; i++)
			ret += "#" + s.substring(i, i + 1);

		ret += "#$";
		return ret;
	}
}
