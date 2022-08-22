package com.algo.stack.pattern2;

import java.util.Stack;

/**
 * Given a non-negative integer num represented as a string, remove k digits
 * from the number so that the new number is the smallest possible.
 * 
 * The length of num is less than 10002 and will be ≥ k. The given num does not
 * contain any leading zero.
 * 
 * 
 * Input: num = "1432219", k = 3 Output: "1219" Explanation: Remove the three
 * digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * 
 * 
 * Input: num = "10200", k = 1 Output: "200" Explanation: Remove the leading 1
 * and the number is 200. Note that the output must not contain leading zeroes.
 * 
 * 
 * Input: num = "10", k = 2 Output: "0" Explanation: Remove all the digits from
 * the number and it is left with nothing which is 0.
 *
 */
public class RemoveKDigits {

	public static void main(String[] args) {
		String num ="112";
		int k=1;
		System.out.println(removeKdigits( num,  k));
	}
	public static String removeKdigits(String num, int k) {
		int len = num.length();
		//corner case
		if(k==len)        
			return "0";

		Stack<Character> stack = new Stack<>();
		int i =0;
		while(i<num.length()){
			//whenever meet a digit which is less than the previous digit, discard the previous one
			while(k>0 && !stack.isEmpty() && stack.peek()>num.charAt(i)){
				stack.pop();
				k--;
			}
			stack.push(num.charAt(i));
			i++;
		}

		// corner case like "1111"
		while(k>0){
			stack.pop();
			k--;            
		}

		//construct the number from the stack
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty())
			sb.append(stack.pop());
		sb.reverse();

		//remove all the 0 at the head
		while(sb.length()>1 && sb.charAt(0)=='0')
			sb.deleteCharAt(0);
		return sb.toString();
	}
}
