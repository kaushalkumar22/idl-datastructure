package slidingwindow;

/**
 * Given a string s consisting only of characters a, b and c.
 * 
 * Return the number of substrings containing at least one occurrence of all
 * these characters a, b and c.
 * 
 * Input: s = "abcabc" Output: 10 Explanation: The substrings containing at
 * least one occurrence of the characters a, b and c are "abc", "abca", "abcab",
 * "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
 * 
 * Input: s = "aaacb" Output: 3 Explanation: The substrings containing at least
 * one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
 * 
 * Input: s = "abc" Output: 1
 *
 */
public class NumberOfSubstringsContainingAllThreeCharacters {

	public static void main(String[] args) {
		String s = "abcabc";
		System.out.println(numberOfSubstrings(s));
	}

	/*
	 *1. Maintain a sliding window (lo, hi], where lower bound exclusively and upper
	 *   bound inclusively; 
	 *2. Traverse string s, use upper bound hi to count the number
	 *   of the 3 characters, a, b, & c; once the sliding window includes all of the
	 *   3, we find s.length() - hi substrings (lo, hi], (lo, hi + 1], ..., (lo,
	 *   s.length() - 1]; 
	 *3. Increase the lower bound lo by 1 (denote it as lo'),
	 *    decrease the count accordingly, if the sliding window still includes all of
	 *    the 3 characters, we count in substrings (lo', hi], (lo', hi + 1], ..., (lo',
	 *    s.length() - 1]; 
	 *4. Repeat 3 till the sliding window short of at least 1 of the
	 *    3 characters, go to step 2; 
	 *5.Repeat 2 - 4 till the end of the string s
	 *
	 *Time O(N)
     *Space O(1)
	 */
	public static int numberOfSubstrings(String s) {
        int[] count = new int[3]; 
        int result = 0;
        int left =0;
        int right = 0;
        int n =s.length();
        for (right = 0; right < n; ++right) {
            ++count[s.charAt(right) - 'a'];
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {   
            	--count[s.charAt(left++) - 'a'];  
            	// number of valid substrings all start from left, 
            	//but end at right, right + 1, ..., s.length() - 1, respectively.        	
            	result += s.length() - right;
            }
        } 
        return result;        
    }

}
