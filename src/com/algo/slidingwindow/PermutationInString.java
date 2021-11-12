package com.algo.slidingwindow;

/**
 * Given two strings s1 and s2, write a function to return true if s2 contains
 * the permutation of s1. In other words, one of the first string's permutations
 * is the substring of the second string.
 * 
 * Input: s1 = "ab" s2 = "eidbaooo" Output: True Explanation: s2 contains one
 * permutation of s1 ("ba").
 * 
 * Input:s1= "ab" s2 = "eidboaoo" Output: False
 *
 * 
 */
public class PermutationInString {

	public static void main(String[] args) {
		String s1 = "ab" ,s2 = "eidbaooo";
		System.out.println(checkInclusion( s1, s2));
	}
	/*
	 * first define the window of size s1,then put 1 at each char at index of s1
	 * then put s2 -1 at each char of window size
	 * then move the window ,if all value is zero means there is a permutation.
	 */
	public static boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;
        
        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (allZero(count)) return true;
        
        for (int i = len1; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - len1) - 'a']++;
            if (allZero(count)) return true;
        }
        
        return false;
    }
    
    private static boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}

