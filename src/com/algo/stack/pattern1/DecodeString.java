package com.algo.stack.pattern1;

import java.util.Stack;

/**
 * Decode String
 * 
 * Given an encoded string, return its decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any
 * digits and that digits are only for those repeat numbers, k. For example,
 * there won't be input like 3a or 2[4].
 * 
 * Input: s = "3[a]2[bc]" Output: "aaabcbc"
 * 
 * Input: s = "3[a2[c]]" Output: "accaccacc"
 * 
 * Input: s = "2[abc]3[cd]ef" Output: "abcabccdcdcdef"
 * 
 * Input: s = "abc3[cd]xyz" Output: "abccdcdcdxyz"
 * 
 */
public class DecodeString {
	public static void main(String[] args) {
		String s = "abc3[cd]xyz";
		System.out.println(decodeString(s));
	}

	public static String decodeString(String s) {

		Stack<String> stringS = new Stack<String>();
		Stack<Integer> numS = new Stack<Integer>();
		char[] c = s.toCharArray();
		int curNum=0;
		String curString ="";
		for(int i=0;i<c.length;i++) {

			if( c[i] == '[') {
				stringS.push(curString);
				numS.push(curNum);
				curString = "";
				curNum = 0;
			}else if (c[i] == ']') {
				int num = numS.pop();
				String prevString = stringS.pop();
				for(int j=0;j<num;j++) {
					prevString=prevString+curString;
				}
				curString = prevString ;
			}else if( Character.isDigit(c[i]) ){
				curNum = curNum*10 + c[i]-'0';
			} else {
				curString += c[i];
			}
		}
		return curString;
	}
}