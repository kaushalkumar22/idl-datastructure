package com.lowlevelsystemdesign.vendingmachine.state;


import com.lowlevelsystemdesign.vendingmachine.Coin;
import com.lowlevelsystemdesign.vendingmachine.Item;
import com.lowlevelsystemdesign.vendingmachine.VendingMachine;

public class ReadyState  implements VendingMachineState {
    private VendingMachine vendingMachine;
    public ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void insertCash(Coin cash) {
        vendingMachine.addCash(cash);
    }
    @Override
    public void selectItem(int itemCode) {
        vendingMachine.setSelectedItem(getItemFromItemCode(itemCode));
    }
    @Override
    public void processRequest() {
        vendingMachine.setState(new ProcessingState(vendingMachine));
        vendingMachine.processRequest();
    }
    @Override
    public void cancelRequest() {
        vendingMachine.setState(new CancelingState(vendingMachine));
        vendingMachine.cancelRequest();
    }

    public Item getItemFromItemCode(int itemCode) {
        if(itemCode == 1) {
            return Item.CHOCOLATE;
        } else if(itemCode == 2) {
            return  Item.COKE;
        } else if (itemCode == 3) {
            return  Item.CAKE;
        }
        return null;
    }
}

