package com.lld.calculator;


public class Addition implements ArithmeticOperator {


    @Override
    public Integer eval(Integer a, Integer b) {
        return a + b;
    }

}
