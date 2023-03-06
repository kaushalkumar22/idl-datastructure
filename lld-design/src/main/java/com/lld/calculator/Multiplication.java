package com.lld.calculator;

public class Multiplication implements ArithmeticOperator{
    @Override
    public Integer eval(Integer a, Integer b) {
        return a * b;
    }

}
