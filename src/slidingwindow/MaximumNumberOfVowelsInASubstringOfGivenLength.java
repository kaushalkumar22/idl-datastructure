package slidingwindow;

import java.util.Arrays;
import java.util.List;

/**
 * Given a string s and an integer k.
 * 
 * Return the maximum number of vowel letters in any substring of s with length
 * k.
 * 
 * Vowel letters in English are (a, e, i, o, u).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abciiidef", k = 3 Output: 3 Explanation: The substring "iii"
 * contains 3 vowel letters.
 * 
 * Example 2:
 * 
 * Input: s = "aeiou", k = 2 Output: 2 Explanation: Any substring of length 2
 * contains 2 vowels.
 * 
 * Example 3:
 * 
 * Input: s = "leetcode", k = 3 Output: 2 Explanation: "lee", "eet" and "ode"
 * contain 2 vowels.
 * 
 * Example 4:
 * 
 * Input: s = "rhythms", k = 4 Output: 0 Explanation: We can see that s doesn't
 * have any vowel letters.
 * 
 * Example 5:
 * 
 * Input: s = "tryhard", k = 4 Output: 1
 * 
 * @author IBM
 *
 */
public class MaximumNumberOfVowelsInASubstringOfGivenLength {
	public static void main(String[] args) {
		String s = "abciiidef";
		int k = 3;
		System.out.println(maxVowels( s,  k));
	}
	public static int maxVowels(String s, int k) {
        int ans = 0;
        // Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u'); // Java 11 Collection factory method, credit to @Sithis
        for (int i = 0, winCnt = 0; i < s.length(); ++i) {
            if (vowels.contains(s.charAt(i))) {
                ++winCnt; 
            }
            if (i >= k && vowels.contains(s.charAt(i - k))) {
                --winCnt;
            }
            ans = Math.max(winCnt, ans);
        }
        return ans;
    }
}
