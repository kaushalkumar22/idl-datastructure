package org.example;

import com.lld.calculator.BasicCalculator;

public class Test {

    public static void main(String[] args) {
        BasicCalculator calculator = new BasicCalculator();
        String s = "((1 + 2) – 3 * (4 / 5)) + 6";

        System.out.println(calculator.calculate(s));

    }

}
