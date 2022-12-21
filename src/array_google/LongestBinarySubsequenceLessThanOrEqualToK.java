package array_google;

/**
 * You are given a binary string s and a positive integer k.
 *
 * Return the length of the longest subsequence of s that makes up a binary number less than or equal to k.
 *
 * Note:
 *
 *     The subsequence can contain leading zeroes.
 *     The empty string is considered to be equal to 0.
 *     A subsequence is a string that can be derived from another string by deleting some or no characters without
 *     changing the order of the remaining characters.
 *
 * Example 1:
 *
 * Input: s = "1001010", k = 5
 * Output: 5
 * Explanation: The longest subsequence of s that makes up a binary number less than or equal to 5 is "00010", as this
 * number is equal to 2 in decimal.
 * Note that "00100" and "00101" are also possible, which are equal to 4 and 5 in decimal, respectively.
 * The length of this subsequence is 5, so 5 is returned.
 *
 * Example 2:
 *
 * Input: s = "00101001", k = 1
 * Output: 6
 * Explanation: "000001" is the longest subsequence of s that makes up a binary number less than or equal to 1,
 * as this number is equal to 1 in decimal.
 * The length of this subsequence is 6, so 6 is returned.
 *
 * Constraints:
 *
 *     1 <= s.length <= 1000
 *     s[i] is either '0' or '1'.
 *     1 <= k <= 109
 */
public class LongestBinarySubsequenceLessThanOrEqualToK {

    public static void main(String[] args) {
        // String s ="111100010000011101001110001111000000001011101111111110111000011111011000010101110100110110001111001001011001010011010000011111101001101000000101101001110110000111101011000101";
        //  int  k = 11713332;
        String  s = "100110111111000000010011101000111011000001000111010001010111100001111110110010100011100100111000011011000000100001011000000100110110001101011010011";
        int   k = 522399436;
        // String s = "00101001";
        //  int k = 1;
        System.out.println(longestSubsequence( s,k));
    }
    public static int longestSubsequence(String s, int k) {
        int n = s.length();
        int  res   = 0 ;
        int  power = 1 ;

        for(int i  = n-1;i>=0;i--){
            char c = s.charAt(i);
            k -= power*(c-'0');
            if(c=='0'||k>=0) {
                res++;
            }
           if(power<=k)
                power = power << 1;
        }
        return res;
    }

}
