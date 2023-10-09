package com.lowlevelsystemdesign.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    private Map<Character, CalculationStrategy> calculationStrategies;
    public EvaluateReversePolishNotation(){
        calculationStrategies = new HashMap<>();
    }
    public int eval(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(String token :tokens){
            char c = token.charAt(0);
            if(Character.isDigit(c)){ //if first char is number
                stack.push(Integer.parseInt(token));
            }else{
                int right = stack.pop();
                int left  = stack.pop();
               if(!calculationStrategies.containsKey(c)) {
                   calculationStrategies.put(c, CalculationStrategyFactory.getCalculationStrategy(c));
               }
                stack.push(calculationStrategies.get(c).eval(left,right));
            }
        }
        return stack.pop();
    }

}
