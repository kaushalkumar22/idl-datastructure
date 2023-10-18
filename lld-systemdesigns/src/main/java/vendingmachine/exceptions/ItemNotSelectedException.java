package vendingmachine.exceptions;

public class ItemNotSelectedException extends RuntimeException {
    public ItemNotSelectedException(String message) {
        super(message);
    }
}