package slidingwindow;

/**
 * 
 * Given a string, find the length of the longest substring T that contains at
 * most 2 distinct characters.
 * 
 * Input: �eceba� Output: 3 Explanation: T is "ece" which its length is 3.
 * 
 * Input: �aaa� Output: 3
 *
 * 
 * 
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {

	public static void main(String[] args) {
		String s = "WORLDL";
		System.out.println(lengthOfLongestSubstringTwoDistinct(s));
	}

	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		return lengthOfLongestSubstringKDistinct(s, 2);
	}
	public static  int lengthOfLongestSubstringKDistinct(String s, int k) {
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
