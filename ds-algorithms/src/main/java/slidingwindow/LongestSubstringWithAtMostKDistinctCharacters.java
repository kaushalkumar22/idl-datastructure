package slidingwindow;


/**
 * longest substring with at most k distinct characters
 * 
 * Given a string S, find the length of the longest substring T that contains at
 * most k distinct characters.
 * 
 * Input: S = "eceba" and k = 3 Output: 4 Explanation: T = "eceb" 
 * Input: s = "pqpqs", k = 2 Output: 4 
 * Input: S = "WORLD" and k = 4 Output: 4 Explanation: T = "WORL" or "ORLD"
 * 
 * Similar to 
 * Minimum Window Substring
 * Longest Substring at most 2 distinct characters
 */
public class LongestSubstringWithAtMostKDistinctCharacters {

	public static void main(String[] args) {
		String s = "eceba";
		int k = 3;
		System.out.println(lengthOfLongestSubstringKDistinct(s, k));
	}

	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
		int[] map = new int[128];

		int start = 0, maxLen =0, counter = 0;
		for (int end=0;end < s.length();end++) {
			char c1 = s.charAt(end);
			if (map[c1] == 0) counter++;
			map[c1]++;
			while (counter > k) {
				char c2 = s.charAt(start);
				if (map[c2] == 1) {
					counter--;
				}
				map[c2]--;
				start++;
			}
			maxLen = Math.max(maxLen, end - start+1);
		}

		return maxLen;
	}
}

