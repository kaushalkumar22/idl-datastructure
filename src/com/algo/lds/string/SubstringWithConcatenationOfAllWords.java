package com.algo.lds.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, s, and a list of words, words, that are all of the
 * same length. Find all starting indices of substring(s) in s that is a
 * concatenation of each word in words exactly once and without any intervening
 * characters.
 * 
 * Input: s = "barfoothefoobarman", words = ["foo","bar"] Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar"
 * respectively. The output order does not matter, returning [9,0] is fine too.
 * Example 2:
 * 
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * Output: []
 * 
 * @author I339640
 *
 */
public class SubstringWithConcatenationOfAllWords {

	public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || s.length() == 0 || words.length == 0) {
            return new ArrayList<>();
        }
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        
        List<Integer> r = new ArrayList<>();
        int sLen = s.length();
        int num = words.length;
        int wordLen = words[0].length();

        for (int i = 0; i < sLen - num * wordLen + 1; i++) {
            String sub = s.substring(i, i + num * wordLen);
            if (isConcat(sub, counts, wordLen)) {
                r.add(i);
            }
        }
        return r;
    }
    
    /**
     * */
    private boolean isConcat(String sub, Map<String, Integer> counts, int wordLen) {
        Map<String, Integer> seen = new HashMap<>();
        for (int i = 0; i < sub.length(); i += wordLen) {
            String sWord = sub.substring(i, i + wordLen);
            seen.put(sWord, seen.getOrDefault(sWord, 0) + 1);
        }
        return seen.equals(counts);
    }
}
