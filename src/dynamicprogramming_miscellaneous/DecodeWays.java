package dynamicprogramming_miscellaneous;

/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26
 * 
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 * 
 * Example 1:
 * 
 * Input: "12" Output: 2 Explanation: It could be decoded as "AB" (1 2) or "L"
 * (12).
 * 
 * Example 2:
 * 
 * Input: "226" Output: 3 Explanation: It could be decoded as "BZ" (2 26), "VF"
 * (22 6), or "BBF" (2 2 6).
 *
 * 
 * 
 */
public class DecodeWays {

	public int numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int n = s.length();
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = s.charAt(0) != '0' ? 1 : 0;
		for (int i = 2; i <= n; i++) {
			int first = Integer.valueOf(s.substring(i - 1, i));
			int second = Integer.valueOf(s.substring(i - 2, i));
			if (first >= 1 && first <= 9) {
				dp[i] += dp[i-1];  
			}
			if (second >= 10 && second <= 26) {
				dp[i] += dp[i-2];
			}
		}
		return dp[n];
	}

	/** Explanation
	 Drop eggs is a very classical problem.
	 Some people may come up with idea O(KN^2)
	 where dp[K][N] = 1 + max(dp[K - 1][i - 1], dp[K][N - i]) for i in 1...N.
	 However this idea is very brute force, for the reason that you check all possiblity.
	 So I consider this problem in a different way:
	 dp[M][K]means that, given K eggs and M moves,
	 what is the maximum number of floor that we can check.
	 The dp equation is:
	 dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1,
	 which means we take 1 move to a floor,
	 if egg breaks, then we can check dp[m - 1][k - 1] floors.
	 if egg doesn't breaks, then we can check dp[m - 1][k] floors.
	 dp[m][k] is the number of combinations and it increase exponentially to N
	 Complexity
	 For time, O(NK) decalre the space, O(KlogN) running,
	 For space, O(NK).
	 */
	public int superEggDrop2(int K, int N) {
		int[][] dp = new int[N + 1][K + 1];
		int m = 0;
		while (dp[m][K] < N) {
			++m;
			for (int k = 1; k <= K; ++k)
				dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1;
		}
		return m;
	}

	//Optimized to 1D DP
	//Complexity:
	//	O(KlogN) Time, O(K) Space
		public int superEggDrop(int K, int N) {
		int dp[] = new int[K + 1], m = 0;
		for (m = 0; dp[K] < N; ++m)
			for (int k = K; k > 0; --k)
				dp[k] += dp[k - 1] + 1;
		return m;
	}


}
