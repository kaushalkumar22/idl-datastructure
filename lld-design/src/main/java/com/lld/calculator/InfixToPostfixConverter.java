package com.lld.calculator;

import java.util.Stack;

public class InfixToPostfixConverter {

    public static final String SPACE = " ";
    public static final char OPEN = '(';
    public static final char CLOSE = ')';

    public String convert(String infixExpression) {
        String result = new String("");
        Stack<Character> stack = new Stack<>();
        for(char c : infixExpression.toCharArray()){
            if(Character.isDigit(c)){
                result += c;
            }else if(c==OPEN){
                stack.push(c);
            }else if(c ==CLOSE){
                while(!stack.isEmpty()&&stack.peek()!=OPEN){
                    result += stack.pop();
                }
                stack.pop();
            }else{
                while (!stack.isEmpty()&&precedence(c)<=precedence(stack.peek())){
                    result += stack.pop();
                }
                stack.push(c);
            }
            while (!stack.isEmpty()){
                result +=stack.pop();
            }
        }
        return result;
    }
    // A utility function to return precedence of a given operator
    // Higher returned value means higher precedence
    static int precedence(char ch)
    {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}

