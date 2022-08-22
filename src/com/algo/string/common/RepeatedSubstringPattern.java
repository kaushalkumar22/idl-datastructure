package com.algo.string.common;

public class RepeatedSubstringPattern {
	public static void main(String[] args) {
		System.out.println(repeatedSubstringPattern("abcdabcda"));
		String s ="abaaba";
		System.out.println(s.substring(1, s.length() - 1));
	}
	public static boolean repeatedSubstringPattern(String str) {
        String s = str + str;
        return s.substring(1, s.length() - 1).contains(str);
    }
}

