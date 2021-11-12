package com.algo.slidingwindow;

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
 *
 */
public class MinimumWindowSubstring {
	
	public static void main(String[] args) {
		String S = "ADOBECODEBANC", T = "ABC";
		System.out.println(minWindow(S,T));
	}
    public static String minWindow(String s, String t) {
    	
    	int[] map = new int[128];
    	for (char c : t.toCharArray()) {
			map[c]++;
		}
    	int left=0,right=0,counter =t.length(),minLen=Integer.MAX_VALUE,windStart=0;
    	
    	while(right<s.length()) {
    		
    		char c= s.charAt(right);
    		if(map[c]>0) {
    			counter--;
    		}  
    		map[c]--;
    		right++;
    		
    		while(counter==0) {
    			
    			if(minLen>right-left) {
    				minLen=right-left;
    				windStart=left;
    			}
    			char c2 = s.charAt(left);
    			map[c2]++;
    			if(map[c2]>0) {
    				counter++;
    			}
    			left++;
    		}
    	}
		return minLen==Integer.MAX_VALUE? "":s.substring(windStart,windStart+minLen)  ;   
     } 
}
