package calculator;

public class CalculationStrategyFactory {
    public static CalculationStrategy getCalculationStrategy(char x) {
        switch (x){
            case '+' :
                return (a,b)->a+b;
            case '-' :
                return (a,b)->a-b;
            case '*' :
                return (a,b)->a*b;
            case '/' :
                return (a,b)->a/b;
            default:
                throw new RuntimeException("Operation not supported");
        }
    }
}
