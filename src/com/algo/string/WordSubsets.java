package com.algo.string;

import java.util.ArrayList;
import java.util.List;

/**
 * We are given two arrays A and B of words. Each word is a string of lowercase
 * letters. Now, say that word b is a subset of word a if every letter in b
 * occurs in a, including multiplicity. For example, "wrr" is a subset of
 * "warrior", but is not a subset of "world". Now say a word a from A is
 * universal if for every b in B, b is a subset of a. Return a list of all
 * universal words in A. You can return the words in any order.
 * 
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
 * Output: ["facebook","google","leetcode"] Input: A =
 * ["amazon","apple","facebook","google","leetcode"], B = ["l","e"] Output:
 * ["apple","google","leetcode"] Input: A =
 * ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"] Output:
 * ["facebook","google"] Input: A =
 * ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"] Output:
 * ["google","leetcode"] Input: A =
 * ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","ceo"]
 * Output: ["facebook","leetcode"]
 * 
 *
 */
public class WordSubsets {
	
	public static void main(String[] args) {
		String[] A = {"amazon","apple","facebook","google","leetcode"};
		String[] B = {"e","o"};
		System.out.println(wordSubsets(A,B));
	}

	 public static  List<String> wordSubsets(String[] A, String[] B) {
			
			List<String> res = new ArrayList<>();
			int[] count = new int[26];
			for (String b : B) {
				int[]   tmp = counter(b);
	            for (int i = 0; i < 26; ++i)
	                count[i] = Math.max(count[i], tmp[i]);
	        }
			for (String a : A) {
				int[]  tmp = counter(a);
				for ( int i = 0; i < 26; i++){
					if (count[i]>tmp[i] )
						break;
					if (i == 25) res.add(a);
				}
			}
			return res;
		}

		static  int[] counter(String word) {
			int[] count = new int[26];
			for (char c : word.toCharArray()) count[c - 'a']++;
			return count;
		}
}
