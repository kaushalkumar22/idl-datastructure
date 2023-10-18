package calculator;

public class AdditionStrategy implements CalculationStrategy {
    @Override
    public int eval(int a, int b) {
        return a + b;
    }
}
