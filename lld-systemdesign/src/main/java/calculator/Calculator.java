package calculator;

public class Calculator {

    private static Calculator calculator;
    private InfixToPostfixConverter converter;
    private EvaluateReversePolishNotation reversePolishNotation;
    private Calculator(){
        this.converter = new InfixToPostfixConverter();
        this.reversePolishNotation = new EvaluateReversePolishNotation();
    }

    public static Calculator getInstance(){
        if(calculator == null){
            synchronized (Calculator.class){
                if(calculator == null){
                    calculator = new Calculator();
                }
            }
        }
        return calculator;
    }

    public int calculate(String expression){
        String[] postfix =  converter.convert(expression);
        return reversePolishNotation.eval(postfix);
    }
}
