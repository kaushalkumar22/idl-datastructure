package com.algo.lds.twopointers;

/**
 * Your friend is typing his name into a keyboard. Sometimes, when typing a
 * character c, the key might get long pressed, and the character will be typed
 * 1 or more times.
 * 
 * You examine the typed characters of the keyboard. Return True if it is
 * possible that it was your friends name, with some characters (possibly none)
 * being long pressed.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: name = "alex", typed = "aaleex" Output: true Explanation: 'a' and 'e'
 * in 'alex' were long pressed.
 * 
 * Input: name = "saeed", typed = "ssaaedd" Output: false Explanation: 'e' must
 * have been pressed twice, but it wasn't in the typed output.
 * 
 * Input: name = "leelee", typed = "lleeelee" Output: true
 * 
 * Input: name = "laiden", typed = "laiden" Output: true Explanation: It's not
 * necessary to long press any character.
 *
 */
public class LongPressedName {

	public static void main(String[] args) {
		String name = "alex", typed = "aaleex";
		System.out.println(isLongPressedName( name, typed));
//
	}
	public static boolean isLongPressedName(String name, String typed) {
		int i = 0, m = name.length(), n = typed.length();
		for (int j = 0; j < n; ++j) {
			if (i < m && name.charAt(i) == typed.charAt(j)) {
				++i;
			}else if (j==0||typed.charAt(j)!= typed.charAt(j - 1)) {
				 return false;
          }
		}    
		return i == m;
	}
}

