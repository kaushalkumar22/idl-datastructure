package com.algo.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * A string S of lowercase English letters is given. We want to partition this
 * string into as many parts as possible so that each letter appears in at most
 * one part, and return a list of integers representing the size of these parts.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: S = "ababcbacadefegdehijhklij" Output: [9,7,8] Explanation: The
 * partition is "ababcbaca", "defegde", "hijhklij". This is a partition so that
 * each letter appears in at most one part. A partition like "ababcbacadefegde",
 * "hijhklij" is incorrect, because it splits S into less parts.
 * 
 * @author IBM
 *
 */
public class PartitionLabels {

	public List<Integer> partitionLabels(String S) {
		List<Integer> res = new ArrayList<Integer>();

		int[] lastIndexMap = new int[26];
		//record the last index of each char in lastIndexMap
		for(int i=0;i<S.length();i++) {
			lastIndexMap[S.charAt(i)-'a']=i;
		}
		 // record the end index of the current sub stringintlast = 0;
		int start =0;
		int last=0;
		for(int i=0;i<S.length();i++) {
			last=Math.max(last, lastIndexMap[S.charAt(i)-'a']);
			if(last==i) {
				res.add(last-start+1);
				start =last+1;
			}
		}
		return res;
	}
}
