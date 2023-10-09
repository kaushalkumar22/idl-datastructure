package com.lowlevelsystemdesign.calculator;

public class MultiplicationStrategy implements CalculationStrategy {
    @Override
    public int eval(int a, int b) {
        return a * b;
    }
}
