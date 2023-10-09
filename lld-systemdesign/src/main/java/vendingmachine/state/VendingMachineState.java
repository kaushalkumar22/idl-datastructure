package vendingmachine.state;


import vendingmachine.Coin;

public interface  VendingMachineState {

    default void insertCash(Coin cash) {
        throw new RuntimeException("Vending machine is unable to add the cash");
    }
    default void selectItem(int itemCode) {
        throw new RuntimeException("Vending machine is unable to select a product");
    }
    default void processRequest() {
        throw new RuntimeException("Vending machine is unable to process request");
    }
    default void dispenseItemAndCash() {
        throw new RuntimeException("Vending machine is unable to dispense");
    }
    default void cancelRequest() {
        throw new RuntimeException("Vending machine is unable to cancel the current request");
    }
}