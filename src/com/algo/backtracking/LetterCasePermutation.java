package com.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S, we can transform every letter individually to be lowercase
 * or uppercase to create another string.
 * 
 * Return a list of all possible strings we could create. You can return the
 * output in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: S = "a1b2" Output: ["a1b2","a1B2","A1b2","A1B2"]
 * 
 * Example 2:
 * 
 * Input: S = "3z4" Output: ["3z4","3Z4"]
 * 
 * Example 3:
 * 
 * Input: S = "12345" Output: ["12345"]
 * 
 * Example 4:
 * 
 * Input: S = "0" Output: ["0"]
 * 
 * 
 * 
 * Constraints:
 * 
 * S will be a string with length between 1 and 12. S will consist only of
 * letters or digits.
 * 
 * 
 */
public class LetterCasePermutation {
	 public List<String> letterCasePermutation(String S) {
	        List<String> res = new ArrayList<>();
	        char[] a = S.toLowerCase().toCharArray();
	        helper(a, 0, res);
	        return res;
	    }
	    
	    void helper(char[] a, int pos, List<String> res){
	        if(pos==a.length){
	            res.add(new String(a));
	            return;
	        }
	        
	        helper(a, pos+1, res);
	        if(Character.isLetter(a[pos])) {
	            a[pos] = Character.toUpperCase(a[pos]);
	            helper(a, pos+1, res);
	            a[pos] = Character.toLowerCase(a[pos]);
	        }
	    }
}
