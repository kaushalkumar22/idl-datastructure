package calculator;

public class SubtractionStrategy implements CalculationStrategy {
    @Override
    public int eval(int a, int b) {
        return a -b;
    }
}
