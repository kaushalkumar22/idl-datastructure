package com.algo.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * You have a list of words and a pattern, and you want to know which words in
 * words matches the pattern.
 * 
 * A word matches the pattern if there exists a permutation of letters p so that
 * after replacing every letter x in the pattern with p(x), we get the desired
 * word.
 * 
 * (Recall that a permutation of letters is a bijection from letters to letters:
 * every letter maps to another letter, and no two letters map to the same
 * letter.)
 * 
 * Return a list of the words in words that match the given pattern.
 * 
 * You may return the answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb" Output:
 * ["mee","aqq"] Explanation: "mee" matches the pattern because there is a
 * permutation {a -> m, b -> e, ...}. "ccc" does not match the pattern because
 * {a -> c, b -> c, ...} is not a permutation, since a and b map to the same
 * letter.
 *
 */
public class FindAndReplacePattern {
	 public List<String> findAndReplacePattern(String[] words, String pattern) {
	        List<String> res= new LinkedList<>();
	        for (String w: words){
	            int[] p= new int[26], s= new int[26];
	            boolean same=true;
	            for (int i=0; i<w.length(); i++){
	                if (s[w.charAt(i)-'a']!=p[pattern.charAt(i)-'a']){
	                    same=false;
	                    break;
	                }else{
	                    s[w.charAt(i)-'a']=p[pattern.charAt(i)-'a']=i+1;
	                }
	            }
	            if (same) res.add(w);
	        }
	        return res;
	    }
	 
	 
	 public List<String> findAndReplacePattern2(String[] words, String pattern) {
	        int[] p = F(pattern);
	        List<String> res = new ArrayList<String>();
	        for (String w : words)
	            if (Arrays.equals(F(w), p)) res.add(w);
	        return res;
	    }

	    public int[] F(String w) {
	        HashMap<Character, Integer> m = new HashMap<>();
	        int n = w.length();
	        int[] res = new int[n];
	        for (int i = 0; i < n; i++) {
	            m.putIfAbsent(w.charAt(i), m.size());
	            res[i] = m.get(w.charAt(i));
	        }
	        return res;
	    }
}
