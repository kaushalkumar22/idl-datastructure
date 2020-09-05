package com.algo.twopointers;

/**
 * Reverse String Easy
 * 
 * Write a function that reverses a string. The input string is given as an
 * array of characters char[].
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * You may assume all the characters consist of printable ascii characters.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: ["h","e","l","l","o"] Output: ["o","l","l","e","h"]
 * 
 * Example 2:
 * 
 * Input: ["H","a","n","n","a","h"] Output: ["h","a","n","n","a","H"]
 *
 * 
 */
public class ReverseString {

	public static void main(String[] args) {
		char[] s = {'h','e','l','l','o'};
		reverseString(s);
		System.out.println(s);
	}

	public static void reverseString(char[] s) {
		int start =0;
		int end = s.length-1;
		while(start<=end) {
			swap(s,start,end);
			start++;
			end--;
		}
	}
 static void swap(char[] s,int i,int j) {
		char c=s[i];
		s[i]=s[j];
		s[j]=c;
	}
}
