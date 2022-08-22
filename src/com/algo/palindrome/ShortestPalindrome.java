package com.algo.palindrome;

/**
 * Given a String s, you are allowed to convert it to a palindrome by adding
 * characters in front of it. Find and return the shortest palindrome you can
 * find by performing this transformation.
 * 
 * Example 1:
 * 
 * Input: "aacecaaa" Output: "aaacecaaa"
 * 
 * Input: "abcd" Output: "dcbabcd"
 * 
 * @author I339640
 *
 */
public class ShortestPalindrome {

	public static void main(String[] args) {
		System.out.println(shortestPalindrome("abcd"));
	}

	public static String shortestPalindrome(String s) {
		String temp = s + "#" + new StringBuilder(s).reverse().toString();
		int prifix = KMPPrefixTable(temp);
		return temp.substring(s.length()+1,temp.length()-prifix) + s;
	}
	static int KMPPrefixTable(String s) {
		int[] table = new int[s.length()];
		int j = 0;
		//skip index 0, we will not match a string with itself
		for (int i = 1; i <  s.length(); i++) {
			while (j > 0 && s.charAt(j)!= s.charAt(i))
				j = table[j-1];

			if (s.charAt(j)== s.charAt(i))
				j++;
			table[i] = j;
		}   
		return table[s.length()-1];
	}
}
