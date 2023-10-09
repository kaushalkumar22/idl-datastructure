package com.lld.calculator;

import java.util.*;

public class ReversePolishNotation {

    Map<String, ArithmeticOperator> arithmeticOperations = Map.of(
            "/", new Division(),
            "*", new Multiplication(),
            "+", new Addition(),
            "-", new Subtraction()
    );

    public Integer eval(final String[] notation) {
        Stack<Integer> operands = new Stack<Integer>();
        for (String token : notation) {
            if (arithmeticOperations.containsKey(token)) {
                var b = operands.pop();
                var a = operands.pop();
                operands.push(arithmeticOperations.get(token).eval(a, b));
            } else {
                operands.push(Integer.valueOf(token));
            }

        }
        return operands.pop();
    }
}
