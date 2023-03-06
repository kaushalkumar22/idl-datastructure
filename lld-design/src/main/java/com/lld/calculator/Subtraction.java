package com.lld.calculator;

public class Subtraction implements ArithmeticOperator{
    @Override
    public Integer eval(Integer a, Integer b) {
        return a - b;
    }

}
