package com.lld.calculator;

public class Division implements ArithmeticOperator  {
    @Override
    public Integer eval(Integer a, Integer b) {
        return a / b;
    }
}
