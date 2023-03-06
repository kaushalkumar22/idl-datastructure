package com.lld.calculator;

public class BasicCalculator {


    private final InfixToPostfixConverter infixToPostfixConverter
            = new InfixToPostfixConverter();
    private final ReversePolishNotation reversePolishNotation
            = new ReversePolishNotation();


    public int calculate(String infixExpression) {
        String postfix = infixToPostfixConverter.convert(infixExpression);
        System.out.println(infixToPostfixConverter);
        return reversePolishNotation.eval(postfix.split(" "));
    }
}

