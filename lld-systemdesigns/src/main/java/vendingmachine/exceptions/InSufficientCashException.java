package vendingmachine.exceptions;

public class InSufficientCashException extends RuntimeException{

    public InSufficientCashException(String message) {
        super(message);
    }
}