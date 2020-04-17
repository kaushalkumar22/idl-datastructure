package com.ds.kth;

/*Use index array for storing the index of the string elements.
 *1. Create an index array.
 *2. Initialize the index of all index array elements to -1.
 *3. Traverse the string once and for element of the string, check the value of index of that 
 *  string element in index array.
 *   a. If index is -1, it is the first occurrence in the string. Set index[string.charAt(i)] = i
 *   b. Else, the element is repeating, set index[string.charAt(i)] = -2
 *4. Traverse the index array once, find the minimum value in the array which is non negative. 
 *  If found, this is the index of the first non repeating character in the string.
 *  Else, return null.
 */
public class FirstNonRepeatingCharacter {

	public static Character getFirstNonRepeatingCharacterLinearOptimized(String string) {

		if(string == null || string.length() == 0) {
			return null;
		}

		int n = string.length();
		if(n == 1) {
			return string.charAt(0);
		} 
		int[] charIdx = new int[256];   
		// Index of non repeating characters. If repeating, then index = -2
		// Initialize character index of all characters to -1
		for(int i = 0; i < 256; i++) {
			charIdx[i] = -1;
		}

		for(int i = 0; i < n; i++) {
			if(charIdx[string.charAt(i)] == -1) {
				// character seen first time
				charIdx[string.charAt(i)] = i;
			} else {
				// Repeated character
				charIdx[string.charAt(i)] = -2;
			}
		}

		int minIdx = n; // Index of first non repeating character
		for(int i = 0; i < 256; i++) {
			if(charIdx[i] >= 0 && 
					minIdx > charIdx[i]) {
				minIdx = charIdx[i];
			}
		}
		return (minIdx >= 0 && minIdx < n) ? string.charAt(minIdx) : null;
	}

	public static void main(String[] args) {
		String string = "ADBCGHIEFKJLADTVDERFSWVGHQWCNOPENSMSJWIERTFB";
		System.out.println("Output: " + getFirstNonRepeatingCharacterLinearOptimized(string));
	}
}