package com.algo.backtracking.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, add spaces in s to construct a sentence where each word is a
 * valid dictionary word. Return all such possible sentences.
 * 
 * Note:
 * 
 * The same word in the dictionary may be reused multiple times in the
 * segmentation. You may assume the dictionary does not contain duplicate words.
 * 
 * Example 1:
 * 
 * Input: s = "catsanddog" wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output: [ "cats and dog", "cat sand dog" ]
 * 
 * Example 2:
 * 
 * Input: s = "pineapplepenapple" wordDict = ["apple", "pen", "applepen",
 * "pine", "pineapple"] Output: [ "pine apple pen apple", "pineapple pen apple",
 * "pine applepen apple" ] Explanation: Note that you are allowed to reuse a
 * dictionary word.
 * 
 * Example 3:
 * 
 * Input: s = "catsandog" wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: []
 *
 * 
 * 
 */
public class WordBreakII {

	public List<String> wordBreak(String s, List<String> wordDict) {
		return backtrack(s,wordDict,new HashMap<String, List<String>>());
	}
	// backtrack returns an array including all substrings derived from s.
	public List<String> backtrack(String s, List<String> wordDict, Map<String,List<String>> mem){
		if(mem.containsKey(s)) return mem.get(s);
		List<String> result = new ArrayList<String>();
		for(String word: wordDict)
			if(s.startsWith(word)) {
				String next = s.substring(word.length());
				if(next.length()==0) result.add(word);
				else for(String sub: backtrack(next, wordDict, mem)) result.add(word+" "+sub);
			}
		mem.put(s, result);
		return result;
	}
}
