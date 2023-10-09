package lld_vendingmachine.vmmain;


import lld_vendingmachine.vmmodel.Coin;
import lld_vendingmachine.vmmodel.Item;
import lld_vendingmachine.vmservice.VendingMachine;

public class VendingMachineMain {
    public static void main(String[] args) {

        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.addItem(Item.CHOCOLATE);
        vendingMachine.addItem(Item.COKE);
        vendingMachine.addItem(Item.CAKE);

        vendingMachine.addCash(Coin.NICKEL);
        vendingMachine.addCash(Coin.QUARTER);
        vendingMachine.addCash(Coin.DIME);
        vendingMachine.addCash(Coin.PENNY);


        vendingMachine.insertCoin(Coin.NICKEL);
        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.selectItem(2);
       // vendingMachine.cancelRequest();
        //vendingMachine.processRequest();
    }
}
