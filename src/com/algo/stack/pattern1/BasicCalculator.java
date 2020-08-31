package com.algo.stack.pattern1;

import java.util.Stack;

/**
 * 
 * Basic Calculator Hard
 * 
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string may contain open ( and closing parentheses ), the plus
 * + or minus sign -, non-negative integers and empty spaces .
 * 
 * Example 1:
 * 
 * Input: "1 + 1" Output: 2
 * 
 * Example 2:
 * 
 * Input: " 2-1 + 2 " Output: 3
 * 
 * Example 3:
 * 
 * Input: "(1+(4+5+2)-3)+(6+8)" Output: 23
 * 
 * Note:
 * 
 * You may assume that the given expression is always valid. Do not use the eval
 * built-in library function.
 *
 * 
 * 
 */
public class BasicCalculator {
	public static void main(String[] args) {
		String s="(1+(4+5+2)-3)+(6+8)";
		System.out.println(calculate( s));
	}
	public static int calculate(String s) {
		 Stack<Integer> stack = new Stack<Integer>();
		    int result = 0;
		    int number = 0;
		    int sign = 1;
		    for(int i = 0; i < s.length(); i++){
		        char c = s.charAt(i);
		        if(Character.isDigit(c)){
		            number = 10 * number + (int)(c - '0');
		        }else if(c == '+'){
		            result += sign * number;
		            number = 0;
		            sign = 1;
		        }else if(c == '-'){
		            result += sign * number;
		            number = 0;
		            sign = -1;
		        }else if(c == '('){
		            //we push the result first, then sign;
		            stack.push(result);
		            stack.push(sign);
		            //reset the sign and result for the value in the parenthesis
		            sign = 1;   
		            result = 0;
		        }else if(c == ')'){
		            result += sign * number;  
		            number = 0;
		            result *= stack.pop();    //stack.pop() is the sign before the parenthesis
		            result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis
		            
		        }
		    }
		    if(number != 0) result += sign * number;
		    return result;
	}
}
