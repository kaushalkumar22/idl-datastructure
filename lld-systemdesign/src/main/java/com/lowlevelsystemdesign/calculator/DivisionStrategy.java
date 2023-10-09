package com.lowlevelsystemdesign.calculator;

public class DivisionStrategy implements CalculationStrategy {
    @Override
    public int eval(int a, int b) {
        return a/b;
    }
}
