package com.algo.stack.pattern1;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression. Note: Division between two integers should truncate toward zero.
 * The given RPN expression is always valid. That means the expression would
 * always evaluate to a result and there won't be any divide by zero operation.
 * 
 *Input: ["2", "1", "+", "3", "*"] Output: 9 Explanation: ((2 + 1) * 3) = 9 
 *
 * Input: ["4", "13", "5", "/", "+"] Output: 6 Explanation: (4 + (13 / 5)) = 6 
 *  
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"] 
 * Output: 22 Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5 
 * = ((10 * (6 / (12 * -11))) + 17) + 5 
 * = ((10 * (6 / -132)) + 17) + 5 = ((10 * 0) + 17) + 5 
 * = (0 + 17) + 5 
 * = 17 + 5 
 * = 22
 * 
 * @author IBM
 *
 */
public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		String[] tokens= {"2", "1", "+", "3", "*"};
		System.out.println(evalRPN(tokens));
	}

	public static int evalRPN(String[] tokens) {
		Stack<Integer> st = new Stack<Integer>();
		for(int i=0;i<tokens.length;i++) {
			if(tokens[i].equals("/")) {
				int b =st.pop();
				int a =st.pop();
				st.push(a/b);
			}else if(tokens[i].equals("*")) {
				st.push(st.pop()*st.pop());
			}else if(tokens[i].equals("-")) {
				int b =st.pop();
				int a =st.pop();
				st.push(a-b);
			}else if(tokens[i].equals("+")){
				st.push(st.pop()+st.pop());
			}else {
				st.push(Integer.valueOf(tokens[i]));
			}
		}

		return st.pop();
	}
}