package com.ds.advance;
/**
 * Given a string, find the length of the longest substring without repeating characters.
Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcdbb"));
	}
	/**
	 * A sliding window is an abstract concept commonly used in array/string problems. 
	 * A window is a range of elements in the array/string which usually defined by the start 
	 * and end indices, i.e. [i,j)[i, j)[i,j) (left-closed, right-open). A sliding window is a 
	 * window "slides" its two boundaries to the certain direction. For example, if we slide 
	 * [i,j)[i, j)[i,j) to the right by 111 element, then it becomes [i+1,j+1)[i+1, j+1)[i+1,j+1) 
	 * (left-closed, right-open).
	 * The reason is that if s[j]s[j]s[j] have a duplicate in 
	 * the range [i,j)[i, j)[i,j) with index j j'j, we don't need to increase iii little by little.
	 *  We can skip all the elements in the range [i,j][i, j'][i,j] and let iii to be j'+1j' + 1j+1 directly.
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring(String s) {
		int result = 0;
		int[] cache = new int[26];	
		int left = 0;
		for (int i = 0; i < s.length(); i++) {	
			char c =s.charAt(i);
			if(cache[c-'a'] > 0) {
				left = Math.max(left, cache[c-'a']);
			}
			cache[c-'a'] = i + 1;
			result = Math.max(result, i - left + 1);
		}
		return result;
	}
}
