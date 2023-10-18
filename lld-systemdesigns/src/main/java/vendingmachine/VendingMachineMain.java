package vendingmachine;

public class VendingMachineMain {
    public static void main(String[] args) {

        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.addItem(Item.CHOCOLATE);
        vendingMachine.addItem(Item.COKE);
        vendingMachine.addItem(Item.CAKE);

        vendingMachine.insertCash(Coin.NICKEL);
        vendingMachine.insertCash(Coin.QUARTER);
        vendingMachine.selectItem(1);
       // vendingMachine.cancelRequest();
        vendingMachine.processRequest();
    }
}
