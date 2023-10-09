package com.lowlevelsystemdesign.calculator;

import java.util.Stack;
public class InfixToPostfixConverter {
    public String[] convert(String exp){
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int number = 0;
        for(char c :exp.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                number = 10 * number + (int) (c - '0');
                continue;
            }
            // c is opeartor or () ,output prev num to output
            if (number != 0) {
                sb.append(number).append(" ");
                number = 0;
            }
            if (c == '(') {
                stack.push('(');
            } else if (c == ')') {
                while (stack.peek() != '(') {
                    sb.append(stack.pop()).append(" ");
                }
                stack.pop();
            } else {
                //pop all aperator with higher or equal rank in stack, until meet (
                while (!stack.isEmpty() && stack.peek() != '(' && precedence(stack.peek()) >= precedence(c)) {
                    sb.append(stack.pop()).append(" ");
                }
                //push cur operator
                stack.push(c);
            }
        }
        if (number !=0){
            sb.append(number).append(" ");
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        return sb.toString().split(" ");
    }
    private static int precedence(char x) {
        switch (x){
            case '+' ,'-' :
                return 1;
            case '*', '/':
                return 2;
            default:
                return 0;
        }
    }

}
