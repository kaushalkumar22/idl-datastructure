package com.algo.string.common;

import java.util.Arrays;

public class FirstUniqueCharacterInAString {
	public static void main(String[] args) {

	}
	/* 
	 * Use index array for storing the index of the string elements.
	 * 
	 * 1. Create an index array.
	 * 2. Initialize the index of all index array elements to -1.
	 * 3. Traverse the string once and for element of the string, check the value of
	 *    index of that string element in index array.
	 * a. If index is -1, it is the first occurrence in the string. Set
	 *    index[string.charAt(i)] = i 
	 * b. Else, the element is repeating, set index[string.charAt(i)] = -2
	 * 4. Traverse the index array once, find the minimum value in the array which
	 * is non negative. If found, this is the index of the first non repeating
	 * character in the string. Else, return null.
	 *  
	 *  Time Complexity: O(N) 
	 */
	
	public static Character getFirstNonRepeatingCharOpt(String str) {

		if (str == null || str.isEmpty()) { 
			return null; 
		}
		int n = str.length();
		if (n == 1) {
			return str.charAt(0);
		}
		int[] charIdx = new int[256];
		// Initialize character index of all characters to -1
		Arrays.fill(charIdx, -1);

		for (int i = 0; i < n; i++) {
			if (charIdx[str.charAt(i)] == -1) {
				// character seen first time
				charIdx[str.charAt(i)] = i;
			} else {
				//If repeating, then index = -2
				charIdx[str.charAt(i)] = -2;
			}
		}

		int minIdx = 257; // Index of first non repeating character
		for (int i = 0; i < 256; i++) {
			if (charIdx[i] >= 0 && minIdx > charIdx[i]) {
				minIdx = charIdx[i];
			}
		}
		return (minIdx >= 0 && minIdx < n) ? str.charAt(minIdx) : null;
	}

	public int firstUniqChar(String s) {
		int[] freq =new int[26];
		char[] cArray =s.toCharArray();

		for(char c : cArray ){
			freq[c-'a']++;
		}
		
		for(int i=0;i<cArray.length;i++){
			if (freq[cArray[i]-'a']==1) return i;
		}

		return -1;
	}
}

