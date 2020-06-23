package com.algo.string;

import java.util.HashMap;

/**
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * Example:
 * 
 * Input: S = "ADOBECODEBANC", T = "ABC" Output: "BANC"
 * 
 * Note:
 * 
 * If there is no such window in S that covers all characters in T, return the
 * empty string "". If there is such window, you are guaranteed that there will
 * always be only one unique minimum window in S. 1. Use two pointers: start and
 * end to represent a window. 2. Move end to find a valid window. 3. When a
 * valid window is found, move start to find a smaller window.
 * 
 * To check if a window is valid, we use a map to store (char, count) for chars
 * in t. And use counter for the number of chars of t to be found in s. The key
 * part is m[s[end]]--;. We decrease count for each char in s. If it does not
 * exist in t, the count will be negative.
 * 
 * To really understand this algorithm, please see my code which is much
 * clearer, because there is no code like if(map[s[end++]]++>0) counter++;.
 * 
 * https://leetcode.com/problems/minimum-window-substring/
 * 
 * @author I339640
 *
 */
public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		HashMap<Character,Integer> map = new HashMap<Character, Integer>();
		for(char c : s.toCharArray())
			map.put(c,0);
		for(char c : t.toCharArray())
		{
			if(map.containsKey(c))
				map.put(c,map.get(c)+1);
			else
				return "";
		}

		int start =0, end=0, minStart=0,minLen = Integer.MAX_VALUE, counter = t.length();
		while(end < s.length())
		{
			char c1 = s.charAt(end);
			if(map.get(c1) > 0)
				counter--;
			map.put(c1,map.get(c1)-1);

			end++;

			while(counter == 0)
			{
				if(minLen > end-start)
				{
					minLen = end-start;
					minStart = start;
				}

				char c2 = s.charAt(start);
				map.put(c2, map.get(c2)+1);

				if(map.get(c2) > 0)
					counter++;

				start++;
			}
		}
		return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart,minStart+minLen);
	}
}