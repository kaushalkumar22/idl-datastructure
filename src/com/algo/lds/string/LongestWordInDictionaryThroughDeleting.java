package com.algo.lds.string;

import java.util.List;

/**
 * Given a string and a string dictionary, find the longest string in the
 * dictionary that can be formed by deleting some characters of the given
 * string. If there are more than one possible results, return the longest word
 * with the smallest lexicographical order. If there is no possible result,
 * return the empty string.
 * 
 * Example 1: Input: s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * 
 * Output: "apple" Example 2: Input: s = "abpcplea", d = ["a","b","c"]
 * 
 * Output: "a"
 * 
 * @author I339640
 *
 */
public class LongestWordInDictionaryThroughDeleting {

	public String findLongestWord(String s, List<String> d) {
        String res="";
        for (String c: d)
            if ((c.length()>res.length() || c.length()==res.length() && c.compareTo(res)<0) && isSubseq(c, s)) res=c;
        return res;
    }
    public boolean isSubseq(String a, String b){
        int i=-1, j=-1;
        while (++i<a.length()) if ((j=b.indexOf(a.charAt(i), j+1))==-1) return false;
        return true;
    }
    
}
