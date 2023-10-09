package calculator;
public class CalculatorMain {
    public static void main(String[] args) {
        Calculator cal = Calculator.getInstance();
        System.out.println(cal.calculate("(10*12)"));
    }
}
