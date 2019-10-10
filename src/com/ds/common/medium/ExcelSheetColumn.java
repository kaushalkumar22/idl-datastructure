package com.ds.common.medium;

public class ExcelSheetColumn {

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
For example:
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
Example 1:
Input: "A"
Output: 1
Example 2:
Input: "AB"
Output: 28
Example 3:
Input: "ZY"
Output: 701	
 * @param s
 * @return
 */
	public int titleToNumber(String s) {
	    int result = 0;
	    for(int i = 0 ; i < s.length(); i++) {
	      result = result * 26 + (s.charAt(i) - 'A' + 1);
	    }
	    return result;
	  }
	/**
	 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
For example:
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
Example 1:
Input: 1
Output: "A"
Example 2:
Input: 28
Output: "AB"
Example 3:
Input: 701
Output: "ZY"
	 * @param n
	 * @return
	 */
	 public String convertToTitle(int n) {
		 return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
	    }
}
