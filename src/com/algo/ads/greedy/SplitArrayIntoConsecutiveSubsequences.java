package com.algo.ads.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums sorted in ascending order, return true if and only if you
 * can split it into 1 or more subsequences such that each subsequence consists
 * of consecutive integers and has length at least 3.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [1,2,3,3,4,5] Output: True Explanation: You can split them into two
 * consecutive subsequences : 1, 2, 3 3, 4, 5
 * 
 * Example 2:
 * 
 * Input: [1,2,3,3,4,4,5,5] Output: True Explanation: You can split them into
 * two consecutive subsequences : 1, 2, 3, 4, 5 3, 4, 5
 * 
 * Example 3:
 * 
 * Input: [1,2,3,4,4,5] Output: False
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 10000
 *
 * 
 */
public class SplitArrayIntoConsecutiveSubsequences {
	public static void main(String[] args) {

	}
	public boolean isPossible(int[] nums) {
	    Map<Integer, Integer> freq = new HashMap<>(), appendfreq = new HashMap<>();
	    for (int i : nums) freq.put(i, freq.getOrDefault(i,0) + 1);
	    for (int i : nums) {
	        if (freq.get(i) == 0) continue;
	        else if (appendfreq.getOrDefault(i,0) > 0) {
	            appendfreq.put(i, appendfreq.get(i) - 1);
	            appendfreq.put(i+1, appendfreq.getOrDefault(i+1,0) + 1);
	        }   
	        else if (freq.getOrDefault(i+1,0) > 0 && freq.getOrDefault(i+2,0) > 0) {
	            freq.put(i+1, freq.get(i+1) - 1);
	            freq.put(i+2, freq.get(i+2) - 1);
	            appendfreq.put(i+3, appendfreq.getOrDefault(i+3,0) + 1);
	        }
	        else return false;
	        freq.put(i, freq.get(i) - 1);
	    }
	    return true;
	}
}
